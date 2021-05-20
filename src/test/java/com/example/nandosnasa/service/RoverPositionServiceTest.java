package com.example.nandosnasa.service;

import com.example.nandosnasa.entity.RoverDirection;
import com.example.nandosnasa.entity.RoverPos;
import com.example.nandosnasa.util.exception.ILLegalPositionException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class RoverPositionServiceTest {

    private final RoverPos roverPos1 = new RoverPos(1, 2, RoverDirection.N);
    private final RoverPos roverPos2 = new RoverPos(3, 3, RoverDirection.E);
    private final RoverPos errorPos1 = new RoverPos(-2, 3, RoverDirection.E);
    private final RoverPos errorPos2 = new RoverPos(4, 9, RoverDirection.S);
    private final RoverPos errorPos3 = new RoverPos(12, 3, RoverDirection.W);

    @Mock
    private RoverPositionService roverPositionService;

    @Before
    public void setUp() throws Exception {
        roverPositionService = new RoverPositionService();
    }

    @Test
    public void test_checkValidPosition_return_boolean() throws ILLegalPositionException {
        int plateauX = 5;
        int plateauY = 5;

        assertThat(roverPositionService.isValid(plateauX, plateauY, roverPos1)).isTrue();
        assertThat(roverPositionService.isValid(plateauX, plateauY, roverPos2)).isTrue();

//        assertThat(roverPositionService.isValid(plateauX, plateauY, errorPos1)).isFalse();
//        assertThat(roverPositionService.isValid(plateauX, plateauY, errorPos2)).isFalse();
    }

    @Test
    public void test_position_of_rover_withinBoundaries_of_plateau_throw_IllegalPositionException()
            throws ILLegalPositionException {
        int plateauX = 5;
        int plateauY = 5;

        Throwable exception = assertThrows(ILLegalPositionException.class, () -> {
            roverPositionService.isValid(plateauX, plateauY, errorPos1);
        });
        assertEquals("Illegal start position", exception.getMessage());

        exception = assertThrows(ILLegalPositionException.class, () -> {
            roverPositionService.isValid(plateauX, plateauY, errorPos2);
        });
        assertEquals("Rover (y)cord out of bounds", exception.getMessage());

        exception = assertThrows(ILLegalPositionException.class, () -> {
            roverPositionService.isValid(plateauX, plateauY, errorPos3);
        });
        assertEquals("Rover (x)cord out of bounds", exception.getMessage());
    }
}
