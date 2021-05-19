package com.example.nandosnasa.service;

import com.example.nandosnasa.entity.RoverDirection;
import com.example.nandosnasa.entity.RoverPos;
import com.example.nandosnasa.entity.RoverRoute;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RoverRouteServiceTest {

    private final RoverPos roverPos1 = new RoverPos(1, 2, RoverDirection.N);
    private final RoverPos roverPos2 = new RoverPos(3, 3, RoverDirection.E);
    private final RoverPos errorPos1 = new RoverPos(-2, 3, RoverDirection.E);
    private final RoverPos errorPos2 = new RoverPos(4, 9, RoverDirection.S);
    private final RoverPos errorPos3 = new RoverPos(12, 3, RoverDirection.W);
    // Test moves - taken from code challenge
    private final String R1moves = "LMLMLMLMM";
    private final String R2moves = "MMRMMRMRRM";
    private RoverRouteService roverRouteService;

    @Before
    public void setUp() throws Exception {
        roverRouteService = mock(RoverRouteService.class);
    }

    @Test
    public void test_getRoverRoute_shouldReturn_RoverRoute() throws Exception {
        when(roverRouteService.getRoverRoute(roverPos2, R1moves)).thenReturn(
                new RoverRoute(roverPos2, R1moves.toCharArray()));

        assertEquals(roverRouteService.getRoverRoute(roverPos2, R1moves), new RoverRoute(roverPos2, R1moves.toCharArray()));
    }

}
