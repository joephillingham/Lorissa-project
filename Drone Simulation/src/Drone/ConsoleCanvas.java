package Drone;

public class ConsoleCanvas {
    public int blockX;
    public int blockY;
    public char[][] block;

    // Be chilling in dronelow
    // Author: Lorissa (I forgot your second name sorry Lunn?)
    // Explain the visual display of the arena mode in your own words using comments

    /* Change the stuff below no one is gonna believe that you made this
     * 
     *  ConsoleCanvas constructor initialises a canvas for the arena, based of the
    dimension inputs made by the user in DroneInterface, by indicating the #
    as the barriers of the arena and the spaces as the movable area for the drone to move */

    public ConsoleCanvas(int x, int y) {

        blockX = x;
        
        blockY = y;
        
        block = new char[x][y];
        
        for (int i = 0; i < blockX; i++) {
            for (int p = 0; p < blockY; p++) {
            	
                if (i == 0 || i == blockX - 1) {
                    block[i][p] = '#';
                    
                } else if (p == 0 || p == blockY - 1) {
                    block[i][p] = '#';
                    
               } else {
                    block[i][p] = ' ';
                }
            }
        }
    }

    public void showIt(int directx, int directy, char chara) { 
        block[directx + 1]
           	 [directy + 1] = chara;
    }

    public String toString() { 
        String print = "";
         for (int i = 0; i < blockX; i++) {
        	
            for (int p = 0; p < blockY; p++) {
            	
              print += block[i][p] + " ";
            }
            print += "\n";
        }
        return print;
    }

}
