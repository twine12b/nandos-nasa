package com.example.nandosnasa.service;

import com.example.nandosnasa.entity.RoverPos;
import com.example.nandosnasa.entity.RoverRoute;
import org.springframework.stereotype.Service;

@Service
public class RoverRouteService {

    //Default Constructor
    public RoverRouteService() {
    }

    /**
     * Combine Rover positions with rover moves
     *
     * @param roverPos
     * @param moves
     * @return
     */
    public RoverRoute getRoverRoute(RoverPos roverPos, String moves) {
        return new RoverRoute(roverPos, moves.toCharArray());
    }

}
