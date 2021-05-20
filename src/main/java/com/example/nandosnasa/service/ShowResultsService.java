package com.example.nandosnasa.service;

import com.example.nandosnasa.entity.RoverInstruction;
import com.example.nandosnasa.entity.RoverRoute;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class ShowResultsService {

    private final RoverInstructionService roverInstructionService = new RoverInstructionService();
    private final RoverMovesService roverMovesService = new RoverMovesService();
    private final RoverPositionService roverPositionService = new RoverPositionService();
    private final RoverRouteService roverRouteService = new RoverRouteService();

    public String getResults(String input) {
        input = input.toUpperCase(Locale.ROOT);
        RoverInstruction ri = roverInstructionService.makeRoverInstructionFromString(input);

        // Validate start positions
        validateRoverPosition(ri);

        //Validate navigation instructions
        validateNavigation(ri);

        // get new position
        ri.setRoverRouteList(getEndPosition(ri));

        //vaidate end positions
        validateEndPosition(ri);

        // creates output string
        String tt = formatResults(ri).toString();
        System.out.println(tt);


        return formatResults(ri).toString();
    }

    private void validateEndPosition(RoverInstruction ri) {
        for (RoverRoute route : ri.getRoverRouteList()) {
            roverPositionService.isValid(
                    ri.getPlateauX(), ri.getPlateauY(),
                    route.getRoverPosition()
            );
        }
    }

    private StringBuilder formatResults(RoverInstruction ri) {
        StringBuilder resultStr = new StringBuilder();

        for (RoverRoute route : ri.getRoverRouteList()) {
            resultStr.append(route.getRoverPosition().getXCord() + " ");
            resultStr.append(route.getRoverPosition().getYCord() + " ");
            resultStr.append(route.getRoverPosition().getDirection() + "\n");

        }

        return resultStr;
    }

    private List<RoverRoute> getEndPosition(RoverInstruction ri) {
        List<RoverRoute> routes = new ArrayList<>();

        for (RoverRoute route : ri.getRoverRouteList()) {
            routes.add(roverRouteService.getRoverRoute(
                    roverInstructionService.getNewPosition(route),
                    "" + route.getNavigation())
            );
        }
        return routes;
    }

    /**
     * Validates navigation instructions
     *
     * @param ri
     */
    private void validateNavigation(RoverInstruction ri) {
        for (RoverRoute routes : ri.getRoverRouteList()) {
            for (char c : routes.getNavigation()) {
                roverMovesService.isValid("" + c);
            }
        }
    }

    /**
     * Throws Exception should input contain errors
     *
     * @param ri
     */
    private void validateRoverPosition(RoverInstruction ri) {
        for (RoverRoute routes : ri.getRoverRouteList()) {
            roverPositionService.isValid(
                    ri.getPlateauX(), ri.getPlateauY(),
                    routes.getRoverPosition()

            );
        }
    }
}
