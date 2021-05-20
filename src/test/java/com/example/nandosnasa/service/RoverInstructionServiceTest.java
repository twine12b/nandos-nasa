package com.example.nandosnasa.service;

import com.example.nandosnasa.entity.RoverDirection;
import com.example.nandosnasa.entity.RoverInstruction;
import com.example.nandosnasa.entity.RoverPos;
import com.example.nandosnasa.entity.RoverRoute;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class RoverInstructionServiceTest {


    private final List<RoverInstruction> instructionList = new ArrayList<RoverInstruction>();
    private final List<RoverRoute> roverRouteList = new ArrayList<RoverRoute>();
    private RoverInstructionService roverInstructionService;
    private String input1;
    private String result_In1;

    @Before
    public void setUp() throws Exception {

        roverInstructionService = new RoverInstructionService();

        roverRouteList.add(new RoverRoute(new RoverPos(1, 2, RoverDirection.N), "LMLMLMLMM".toCharArray()));
        roverRouteList.add(new RoverRoute(new RoverPos(3, 3, RoverDirection.E), "MMRMMRMRRM".toCharArray()));

        instructionList.add(new RoverInstruction(5, 5, roverRouteList));

        input1 = "5 5\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM";
        result_In1 = "1 2 N\n3 3 E\n";
    }

    @Test
    public void test_createRoverInstructionFromString_shouldReturn_RoverInstruction() throws IllegalArgumentException {
        RoverInstruction iBuilder = roverInstructionService.makeRoverInstructionFromString(input1);

        assertThat(iBuilder.getPlateauX()).isEqualTo(5);
        assertThat(iBuilder.getPlateauY()).isEqualTo(5);
        assertThat(iBuilder.getRoverRouteList().size()).isEqualTo(2);
        assertThat(iBuilder.getRoverRouteList().get(0).getNavigation().length).isEqualTo(9);
        assertThat(iBuilder.getRoverRouteList().get(0).getNavigation()).isEqualTo("LMLMLMLMM".toCharArray());
        assertThat(iBuilder.getRoverRouteList().get(0).getRoverPosition()).isEqualTo(new RoverPos(1, 2, RoverDirection.N));

    }

    @Test
    public void test_roverMovesCalculator_shouldReturn_roverPosition() throws Exception {
        RoverInstruction iBuilder = roverInstructionService.makeRoverInstructionFromString(input1);
        RoverPos newPos = roverInstructionService.getNewPosition(iBuilder.getRoverRouteList().get(0));
        RoverPos newPos1 = roverInstructionService.getNewPosition(iBuilder.getRoverRouteList().get(1));

        assertThat(newPos).isEqualTo(new RoverPos(1, 3, RoverDirection.N));
        assertThat(newPos1).isEqualTo(new RoverPos(5, 1, RoverDirection.E));

    }
}