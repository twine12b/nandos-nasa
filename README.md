# Coding challenge

> #### Mars Rover technical Challenge
>#### MARS ROVERS
>#### Input:
>#### Output:
>#### Test Input:
>#### Expected Output:

## Mars Rover technical Challenge

> The problem below requires some kind of input. You are free to implement any mechanism for feeding input into your solution (for example, using hard coded data within a unit test). You should provide sufficient evidence that your solution is complete by, as a minimum, indicating that it works correctly against the supplied test data. We highly recommend using a unit testing framework. Even if you have not used it before, it is simple to learn and incredibly useful. The code you write should be of production quality, and most importantly, it should be code you are proud of.
>

## MARS ROVERS

> A squad of robotic rovers are to be landed by NASA on a plateau on Mars. This plateau, which is curiously rectangular, must be navigated by the rovers so that their on board cameras can get a complete view of the surrounding terrain to send back to Earth. A rover's position is represented by a combination of an **x and y co-ordinates and a letter** representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be __0, 0, N__, which means the rover is in the bottom left corner and facing North. In order to control a rover, NASA sends a simple string of letters. The possible letters are __'L', 'R' and 'M'__. 'L' and 'R' makes the rover spin 90 degrees left or right respectively, without moving from its current spot.
'M' means move forward one grid point, and maintain the same heading. Assume that the square directly North from **(x, y) is (x, y+1)**.

## Input:

> The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0. The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input. The first line gives the rover's position, and the second line is a series of instructions telling the rover how to explore the plateau. The position is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates and the rover's orientation. Each rover will be finished sequentially, which means that the second rover won't start to move until the first one has finished moving.

## Output:

`The output for each rover should be its final co-ordinates and heading.`

#### Test Input:

> #### **5 5**
> ___
>#### **1 2 N**
>###### **LMLMLMLMM**
>___
>#### **3 3 E**
>###### **MMRMMRMRRM**

## Expected Output:

> #### 1 3 N
> ___
>#### 5 1 E

___

## Approach

Entities
> #### Moves
>A valid set of moves is a string that only contains `[L, R, M]`
> an `illegalDirectionException` is thrown if any other character is found in the moves string.
> If no moves are given a `NoDirectionsFoundException` is thrown.
> `PlateauBoundaryException`

#### RoverPosition

> A `RoverPosition` contains co-ordinates that must be within a `plateau`. If the co-ordinates
> of a rover are out-side of the `plateau` then a `IllegalPositionException` is thrown. A rover faces in a single
> 'direction'. A direction is either North(N), East(E), South(S) or West(W). If a direction is indicated other
> than `N, E, S, W` then throw `IllegalDirectionException`.

#### RoverRoute

> A `RoverRoute` contains a `RoverPosition` and a set of `Moves`.

#### RoverInstruction

> A `RoverInstruction` has the size of a `plateau` and a list of `RoverRoute`. If the plateau size is not larger than
> (1, 1), then an `IllegalPlateauException` is thrown. If the list of `RoverRoute` is empty then an  `NoRoutingException`
> is thrown.

___

## Logic

```
The 'plateau' grid position can be calculated using the rovers direction.
       * North facing - y +1
       * South facing - y -1
       * East facing  - x +1
       * West facing  - x -1 
```

#### Assumptions/Validation

```
Assumptiions are made as they are not implicitly specified in the task.

    * A plateau size of less than 1 x 1 (Whoops forgot to code this - but it was a consideration)
    * A rover position outside of plateau throws ILLegalPositionException
    * A command other than [L,R,M] throws IllegalDirectionException
    * No directional commands throws NoDirectionFoundException

If legal command strings are received which move the rover beyond the boundary of 
a plateau.  The rover remains in its original position and an exception is thrown.

The 'ShowResultsSerrvice' is not exposed via an EndPoint as this is outside of the scope of 
this task. n.b.[a Rest API could easily be created within the SprinBoot project if required.]
```

#### instructions

```
Unit tests have beed created for all the services used in this project.  

  - To run: use the 'ShowResultsServiceTest'
  - To test with your own input string use: ShowResultsService.getResults(YOUR-INPUT-HERE)

Expected Output will be displayed in the (console) or returned as a (String).
```

### Thank You for the opportunity

