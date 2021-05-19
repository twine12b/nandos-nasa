package com.example.nandosnasa.service;

import com.example.nandosnasa.entity.RoverDirection;
import com.example.nandosnasa.entity.RoverPos;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class RoverPositionTest {

    private final RoverPos roverPos1 = new RoverPos(1, 2, RoverDirection.N);
    private final RoverPos roverPos2 = new RoverPos(3, 3, RoverDirection.E);
    @Mock
    private RoverPositionService roverPositionService;

    @Before
    public void setUp() throws Exception {
        roverPositionService = new RoverPositionService();
    }

    @Test
    public void test_checkValidPosition_return_boolean() throws Exception {
        int plateauX = 5;
        int plateauY = 5;
        RoverPos errorPos1 = new RoverPos(-2, 3, RoverDirection.E);
        RoverPos errorPos2 = new RoverPos(4, 9, RoverDirection.S);

        assertThat(roverPositionService.isValid(plateauX, plateauY, roverPos1)).isTrue();
        assertThat(roverPositionService.isValid(plateauX, plateauY, roverPos2)).isTrue();

        assertThat(roverPositionService.isValid(plateauX, plateauY, errorPos1)).isFalse();
        assertThat(roverPositionService.isValid(plateauX, plateauY, errorPos2)).isFalse();
    }
}
