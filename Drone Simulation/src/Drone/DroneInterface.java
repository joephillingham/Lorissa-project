package Drone;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

// Week 5 Demo Tested
// Author: Lorissa Lunn

/*DroneInterface class creates a means by which the user can interact with the drone simulation system.
  The options in this interface include creating a new arena, adding drones, moving drones, saving
  and loading files */

public class DroneInterface {
    private Scanner s;                    // scanner used for input from user
    private DroneArena myArena;                // arena in which drones are shown
    private int dCounter = 1;

    public DroneInterface() {
        s = new Scanner(System.in);                // set up scanner for user input
        myArena = new DroneArena(0, 0);        // create arena of size 20*6
        int inputX = 0;
        int inputY = 0;

        // Menu is set up for the user and creates a scanner to obtain user inputs and carries out tasks ordered by user

        // User can't use the other options until a arena is created.

        char ch = ' ';
        System.out.println("\n  Drone Sim ");
        do {
            System.out.print("\n\nPlease select one of the following options: " 
                    + "\nAdd drone - A " 
            		+ "\nGet info - I "
                    + "\nShow Arena - D "
                    + "\nNew Arena - N " 
                    + "\nMove drones - M "
                    + "\nMove drones more than once - K"
                    + "\nExit - X " + "\n\n> ");
            
            ch = s.next().charAt(0);
            s.nextLine();
            switch (ch) {
                case 'A':
                case 'a':
                    // Adds drone to arena
                    if (myArena.aHeight == 0 || myArena.aWidth == 0) {
                        System.err.println("You must create an arena to start\n");
                    } else {
                        myArena.addDrone();
                        System.out.println("\nSuccess!");
                        System.out.println("Drones in arena = " + myArena.arenaDroneNum());
                        /* arenaDroneNum method is called from DroneArena class each time user adds a drone*/
                    }
                    break;
                case 'I':
                case 'i':
                    // Prints arena dimensions and included drones
                    if (myArena.aHeight == 0 || myArena.aWidth == 0) {
                        System.err.println("You must create an arena to start\n");
                    } else if (myArena.numDrone.isEmpty() == true) {
                        System.err.println("You must insert a drone to move");
                        System.out.println("\nArena height and width " + inputX + " * " + inputY + ".");
                    } else {
                        System.out.print("\n" + myArena.toString() + "\n");
                    }
                    break;
                case 'd':
                case 'D':
                    //Displays arena with drones
                    if (myArena.aHeight == 0 || myArena.aWidth == 0) {
                        System.err.println("You must create an arena to start\n");
                    } else {
                        System.out.println("\n");
                        doDisplay();
                    }
                    break;
                case 'm':
                case 'M':
                    //Moves all drones once and displays new arena with moved drones, along with the updated information
                    if (inputX == 0 || inputY == 0) {
                        System.err.println("You must create an arena to start\n");
                    } else {
                        if (!myArena.numDrone.isEmpty()) {
                            System.out.println("\n");
                            myArena.moveAllDrones(myArena);
                            doDisplay();
                        } else {
                            System.err.println("You must insert a drone to move\n");
                        }
                    }
                    break;
                case 't':
                case 'T':

                    if (myArena.aHeight == 0 || myArena.aWidth == 0) {
                        System.err.println("You must create an arena to start\n");
                    } else {
                        int numtimes;
                        System.out.println("How many times should the drone move ");
                        numtimes = s.nextInt();
                        if (!myArena.numDrone.isEmpty()) {
                            for (int i = 0; i < numtimes; i++) {
                                System.out.println("-------------------------------------");
                                myArena.moveAllDrones(myArena);
                                doDisplay();
                                //System.out.println(myArena.toString());
                                try {
                                    TimeUnit.MILLISECONDS.sleep(200); // Delays each updated drone arena by 200ms
                                } catch (InterruptedException e) {
                                    System.err.format("IOException: %s%n", e);
                                }
                            }
                        } else {
                            System.err.println("You must insert a drone to move\n");
                        }
                    }
                    break;
                case 'n':
                case 'N':
                    /*
                     * Allows user to input the arena dimensions manually to create a new arena. Deals with all invalid
                     * inputs including characters and negative numbers
                     */
                    System.out.print("\n Input arena dimensions: ");
                    System.out.print("\n X = ");
                    try {
                        inputX = s.nextInt();
                        while (inputX < 0) {
                            System.err.println("The arena cannot be negative in size.");
                            System.out.print("\n\nX = ");
                            inputX = s.nextInt();
                        }
                    } catch (Exception a) {
                        System.err.println("Please define arena size using whole numbers only.");
                        System.out.print("\n\n X = ");
                        s.nextLine();
                        inputX = s.nextInt();
                    }
                    System.out.print(" Y = ");
                    try {
                        inputY = s.nextInt();
                        while (inputY < 0) {
                            System.err.println("YThe arena cannot be negative in size");
                            System.out.print("\n\nY = ");
                            inputY = s.nextInt();
                        }
                    } catch (Exception b) {
                        System.err.println("Please define arena size using whole numbers only.");
                        System.out.print("\n\n Y = ");
                        s.nextLine();
                        inputY = s.nextInt();
                    }
                    myArena = new DroneArena(inputX, inputY);
                    System.out.println("Arena created, Size: " + inputX + " * " + inputY + ".");
                    break;
                case 'f':
                case 'F':
                  
          
                default:
                    System.err.println("Invalid input! Please try again.");
                    break;
                case 'x':
                    ch = 'X';                // when X detected program ends
                    break;
            }
        } while (ch != 'X');                        // test if end

        s.close();                                    // close scanner
    }

    // Displays arena and drones within the canvas
    void doDisplay() {
        ConsoleCanvas field = new ConsoleCanvas(myArena.aWidth + 2, myArena.aHeight + 2);
        myArena.showDrones(field);
        System.out.println(field.toString());
    } 

    public static void main(String[] args) {
        DroneInterface r = new DroneInterface();    // just call the interface
    }
}




