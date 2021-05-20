/**
 * @Author Richard Renaud
 * <p>
 * This service builds RoverInstructions from an input string.
 * The string is 'space' delimited with each set of instructions on a new line.
 * <p>
 * This service assumes that a string will always be given in this format and therefore
 * does not validate the input string format.
 * <p>
 * e.g.
 * 5 5
 * 1 2 N
 * LMLMLMLMM
 * 3 3 E
 * MMRMMRMRRM
 */
package com.example.nandosnasa.service;

import com.example.nandosnasa.entity.RoverDirection;
import com.example.nandosnasa.entity.RoverInstruction;
import com.example.nandosnasa.entity.RoverPos;
import com.example.nandosnasa.entity.RoverRoute;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoverInstructionService {

    //Default Constructor
    public RoverInstructionService() {
    }

    /**
     * Create RoverInstructions from values taken from input string
     *
     * @param input
     * @return
     */
    public RoverInstruction makeRoverInstructionFromString(String input) {

        String[] lines = input.split("\\r?\\n");
        RoverInstruction myInstructions = new RoverInstruction();

        myInstructions = setPlateau(myInstructions, lines[0]);

        List<RoverRoute> rRoute = makeRoutes(lines);
        myInstructions.setRoverRouteList(rRoute);

        return myInstructions;
    }

    /**
     * Sets Plateau [X], [Y] co-ordinates.
     *
     * @param myInstructions
     * @param line
     * @return
     */
    private RoverInstruction setPlateau(RoverInstruction myInstructions, String line) {
        String[] arr = line.split(" "); //remove space delimiter

        myInstructions.setPlateauX(Integer.parseInt(arr[0]));
        myInstructions.setPlateauY(Integer.parseInt(arr[1]));

        return myInstructions;
    }

    /**
     * set Rover routes with values taken from input string
     *
     * @param lines
     * @return
     */
    private List<RoverRoute> makeRoutes(String[] lines) {
        List<RoverRoute> routes = new ArrayList<>();
        RoverPos roverPos = new RoverPos();

        for (int i = 1; i < lines.length; i++) { // ignore first line
            if (!(i % 2 == 0)) {  // odd = position
                roverPos = makePosition(lines[i]);
            } else {
                routes.add(new RoverRoute(roverPos, lines[i].toCharArray()));
            }
        }
        return routes;
    }

    /**
     * Create RoverPos with values taken from input string
     *
     * @param line
     * @return
     */
    private RoverPos makePosition(String line) {
        String[] arr = line.split(" "); //remove space delimiter
        RoverPos pos = new RoverPos();

        pos.setXCord(Integer.parseInt(arr[0]));
        pos.setYCord(Integer.parseInt(arr[1]));
        pos.setDirection(setDirectionFromStr(arr[2]));

        return pos;
    }

    /**
     * Set directions with values taken from input string
     *
     * @param direction
     * @return
     */
    private RoverDirection setDirectionFromStr(String direction) {
        RoverDirection dir;
        switch (direction) {
            case "N":
                dir = RoverDirection.N;
                break;
            case "E":
                dir = RoverDirection.E;
                break;
            case "S":
                dir = RoverDirection.S;
                break;
            case "W":
                dir = RoverDirection.W;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + direction);
        }

        return dir;
    }
}
