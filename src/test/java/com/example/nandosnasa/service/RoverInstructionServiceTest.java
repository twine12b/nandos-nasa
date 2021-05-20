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

    @Before
    public void setUp() throws Exception {
//        roverInstructionService = mock(RoverInstructionService.class);

        roverInstructionService = new RoverInstructionService();
        //##############################################

//        char[] tst = {'L','M','L','M','L','M','L','M','M'};
//        RoverPos rPos1 = new RoverPos(1, 2, RoverDirection.N);
//        RoverRoute rRoute1 = new RoverRoute(rPos1, "MMRMMRMRRM".toCharArray());
//        roverRouteList.add(rRoute1);

        //##############################################


        roverRouteList.add(new RoverRoute(new RoverPos(1, 2, RoverDirection.N), "LMLMLMLMM".toCharArray()));
        roverRouteList.add(new RoverRoute(new RoverPos(3, 3, RoverDirection.E), "MMRMMRMRRM".toCharArray()));
//
        instructionList.add(new RoverInstruction(5, 5, roverRouteList));

        input1 = "5 5\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM";

    }

    @Test
    public void test_createRoverInstructionFromString_shouldReturn_RoverInstruction() throws IllegalArgumentException {
        System.out.println(input1);
        RoverInstruction iBuilder = roverInstructionService.makeRoverInstructionFromString(input1);

        assertThat(iBuilder.getPlateauX()).isEqualTo(5);
        assertThat(iBuilder.getPlateauY()).isEqualTo(5);
        assertThat(iBuilder.getRoverRouteList().size()).isEqualTo(2);
        assertThat(iBuilder.getRoverRouteList().get(0).getNavigation().length).isEqualTo(9);
        assertThat(iBuilder.getRoverRouteList().get(0).getNavigation()).isEqualTo("LMLMLMLMM".toCharArray());
        assertThat(iBuilder.getRoverRouteList().get(0).getRoverPosition()).isEqualTo(new RoverPos(1, 2, RoverDirection.N));

    }

// test plateau not < 0  or  Null

    //Test roverstart pos

    //Test rover moves  - [use raw data NOT OBJECTS]

    // Test moves calculator

    // test rover end Pos (same as start pos)

    //Test new position after successful move

    // Test Exceptions

    // Test random instruction input

    //TODO - update README.md with assumptions
    //TODO - update README.md with instructions


}


/**
 * @Test public void test_roverRouteIsValid_shouldReturn_boolean()
 * throws NoDirectionFoundException, IllegalDirectionException,
 */