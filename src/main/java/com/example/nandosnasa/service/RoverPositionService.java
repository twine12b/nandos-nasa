package com.example.nandosnasa.service;

import com.example.nandosnasa.entity.RoverPos;
import org.jvnet.hk2.annotations.Service;

@Service
public class RoverPositionService {

    //Default Constructor
    public RoverPositionService() {
    }

    public boolean isValid(int plateauX, int plateauY, RoverPos roverPos) {
        boolean valid = roverPos.getXCord() >= 0 && roverPos.getYCord() >= 0;

        // if RPX <0 || RPY <0 false

        // if RPX > pX false
        if (roverPos.getXCord() > plateauX) {
            valid = false;
        }

        // if RPY > py false
        if (roverPos.getYCord() > plateauY) {
            valid = false;
        }

        return valid;
    }
}
