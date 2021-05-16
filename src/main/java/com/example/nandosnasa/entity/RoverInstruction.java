/**
 * @Autor Richard Renaud
 * <p>
 * Rover Instructions contain
 * - upper right corordinate of plateau - (pleateu size)
 * - List of RoverRoutes.  [1 to n start points plus navigation to an end position]
 */
package com.example.nandosnasa.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class RoverInstruction {

    List<RoverRoute> roverRouteList;
    private int plateauX;
    private int plateauY;

    public RoverInstruction(int plateauX, int plateauY, List<RoverRoute> roverRouteList) {
        this.plateauX = plateauX;
        this.plateauY = plateauY;
        this.roverRouteList = roverRouteList;
    }
}
