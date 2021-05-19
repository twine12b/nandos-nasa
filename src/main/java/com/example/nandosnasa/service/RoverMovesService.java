/**
 * @Author Richard Renaud
 * <p>
 * This service contains all the methods that are responsible for making
 * sure the rover navigation instructions are legitimate.
 */
package com.example.nandosnasa.service;

import com.example.nandosnasa.util.IllegalDirectionException;
import com.example.nandosnasa.util.NoDirectionFoundException;
import org.jvnet.hk2.annotations.Service;

import java.util.regex.Pattern;

@Service
public class RoverMovesService {

    //Default constructor
    public RoverMovesService() {
    }

    /**
     * Checks that the Move param only contains [L, R, M]
     *
     * @param moves
     * @return
     * @throws NoDirectionFoundException
     */
    public Boolean isValid(String moves) throws NoDirectionFoundException {
        boolean valid = true;
        moves = moves.toUpperCase();  // fixes bug with case sensitivity

        // Validate no rover moves
        if (moves.isEmpty()) {
            throw new NoDirectionFoundException("No Moves Found");
        }

        // Validates only LRM characters as input
        for (char c : moves.toCharArray()) {
            if (!(Pattern.compile("[LRM]").matcher("" + c).matches())) {  //needs a string not a char to match
                valid = false;
                throw new IllegalDirectionException("Illegal instruction");
            }
        }

        return valid;
    }
}
