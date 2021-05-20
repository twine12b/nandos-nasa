/**
 * @Author Tracks valid rover positions in relation to a plateau.
 * throws ILLegalPositionException.
 */
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

        // if RPX > pX false
        if (roverPos.getXCord() > plateauX) {
            throw new ILLegalPositionException("Rover (x)cord out of bounds");
        } else if (roverPos.getYCord() > plateauY) {  // if RPY > py false
            throw new ILLegalPositionException("Rover (y)cord out of bounds");
        } else if (roverPos.getXCord() < 0 || roverPos.getYCord() < 0) { // if RPX <0 || RPY <0 false
            throw new ILLegalPositionException("Illegal start position");
        }

        return true;
    }
}
