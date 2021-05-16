/**
 * @Author Richard Renaud
 * <p>
 * This class describes a single rovers start position with instructions
 * to navigate to an end postion.
 */
package com.example.nandosnasa.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class RoverRoute {
    private RoverPos roverPosition;
    private char[] navigation;

    public RoverRoute(RoverPos roverPosition, char[] navigation) {
        this.roverPosition = roverPosition;
        this.navigation = navigation;
    }

    //TODO - Validate navigation commands
}
