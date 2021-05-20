package com.example.nandosnasa.service;

import com.example.nandosnasa.entity.RoverPos;
import com.example.nandosnasa.util.exception.ILLegalPositionException;
import org.springframework.stereotype.Service;

@Service
public class RoverPositionService {

    //Default Constructor
    public RoverPositionService() {
    }

    /**
     * Returns true if test conditions are valid else throw meaningful exceptions
     *
     * @param plateauX
     * @param plateauY
     * @param roverPos
     * @return
     * @throws ILLegalPositionException
     */
    public boolean isValid(int plateauX, int plateauY, RoverPos roverPos) throws ILLegalPositionException {
        boolean valid = true;

        // if RPX > pX false
        if (roverPos.getXCord() > plateauX || roverPos.getXCord() < plateauX) {
            valid = false;
            throw new ILLegalPositionException("Rover (x)cord out of bounds");
        }

        // if RPY > py false
        if (roverPos.getYCord() > plateauY || roverPos.getYCord() < plateauY) {
            valid = false;
            throw new ILLegalPositionException("Rover (y)cord out of bounds");
        }

//        // if RPX <0 false
//        if (roverPos.getXCord() < plateauX) {
//            valid = false;
//            throw new ILLegalPositionException("Rover has moved out of bounds in [X] direction");
//        }
//
//        // if RPy <0 false
//        if (roverPos.getYCord() < plateauY) {
//            valid = false;
//            throw new ILLegalPositionException("Rover has moved out of bounds in [Y] direction");
//        }

        // if RPX <0 || RPY <0 false
        if (roverPos.getXCord() < 0 || roverPos.getYCord() < 0) {
            valid = false;
            throw new ILLegalPositionException("Illegal start position");
        }

        return valid;
    }
}
