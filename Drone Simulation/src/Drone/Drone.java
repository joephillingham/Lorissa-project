package Drone;

// Week 5 Demo Tested
// Author: K
// The Drone class is responsible for drone creations, positions and movements.

public class Drone {

    public Direction facing; // Which direction the drone faces
    public int directa, directb; // Drone coordinates
    public int identifier; // Main ID of the drone
    public static int droneCount = -1; // Static variable to constantly count existing drones

    /*
     *  Drone constructor
     *
     *  Instantiates a drone by assigning it attributes like the x coordinate, y coordinate, id and
     *  it's direction.
     * */

    public Drone(int x, int y, Direction f) {
        directa = x;
        directb = y;
        identifier = droneCount++;
        facing = f;
    }

    public void resetID() {
        droneCount = 1;
    }


    // Shows drone on the canvas given
    public void displayDrone(ConsoleCanvas c) {
        char droneRep = 'D'; // Represents drones
        c.showIt(directa, directb, droneRep);
    }

    // Compares parameters with existing drone positions and sees if drone occupies that position
    public boolean isHere(int sx, int sy) {
        if (sx == directa && sy == directb)
            return true;
        else
            return false;
    }

    /* Checks if drone can move. If so, then drone moves in direction specified and
    if not, then changes direction and tries again */

    public void tryToMove(DroneArena a) {
            if (facing == Direction.North) {
            	
                if (a.canMoveHere(directa - 1, directb))
                    directa = directb - 1;
                
                else
                    facing = facing.nextDirection();
            
            } else if (facing == Direction.North_East) {
            	
                if (a.canMoveHere(directa - 1, directb + 1)){
                    directa = directb - 1;
                    directa = directb + 1;
                    
                } else
                    facing = facing.nextDirection();
                
                
            } else if (facing == Direction.North_West) {
                if (a.canMoveHere(directa - 1, directb - 1)) {
                    directa = directb - 1;
                    directa = directb - 1;
                }else
                    facing = facing.nextDirection();
                
                
            } else if (facing == Direction.East) {
                if (a.canMoveHere(directa, directb + 1))
                    directa = directb + 1;
                else
                    facing = facing.nextDirection();
                
                
            } else if (facing == Direction.South) {
                if (a.canMoveHere(directa + 1, directb))
                    directa = directb + 1;
                else
                    facing = facing.nextDirection();
                
                
            } else if (facing == Direction.South_East) {
                if (a.canMoveHere(directa + 1, directb + 1)) {
                    directa = directb + 1;
                    directa = directb + 1;
                }else
                    facing = facing.nextDirection();
                
                
            } else if (facing == Direction.South_West) {
                if (a.canMoveHere(directa + 1, directb - 1)) {
                    directa = directb - 1;
                    directa = directb - 1;
                }else
                    facing = facing.nextDirection();
                
                
            } else if (facing == Direction.West) {
                if (a.canMoveHere(directa, directb - 1))
                    directa = directb - 1;
                else
                    facing = facing.nextDirection();
        }
    }

    // Shows drone information in a string format
    public String toString() {
        return "Drone " + identifier + " at " + directa + ", " + directb + "is facing " + facing.toString();
    }
}

