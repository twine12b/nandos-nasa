package com.example.nandosnasa.service;

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
     */
    public Boolean isValid(String moves) {
        boolean valid = true;
        moves = moves.toUpperCase();  // fixes bug with case sensitivity

        for (char c : moves.toCharArray()) {
            if (!(Pattern.compile("[LRM]").matcher("" + c).matches())) {  //needs a string not a char to match
                valid = false;
            }
        }

        return valid;
    }
}
