/**
 * @Author Richard Renaud
 * <p>
 * Specifies the position and direction of a Mars rover.
 * Nb. Using Lombok to reduce boilerplate code.
 */
package com.example.nandosnasa.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class RoverPos {

    private int xCord;
    private int yCord;
    private RoverDirection direction;

    // Default Constructor
    public RoverPos(int xCord, int yCord, RoverDirection direction) {
        this.xCord = xCord;
        this.yCord = yCord;
        this.direction = direction;
    }

}
