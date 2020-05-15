//Author Name: Sally Ellison
//Date: 5/14/20
//Program Name: Ellison_Drone
//Purpose: Simulation using button, drone movement in x,y,zs location

package module_1;

import java.util.Scanner;

public class App
{
    private static Scanner scanner = new Scanner(System.in);
    private static Ellison_Drone drone = new Ellison_Drone();
    
    public static void main(String args[])
    {
        boolean control_bool = true;
        while (control_bool)
        {
            printMenu();
            
            int choice = scanner.nextInt();
            
            switch (choice)
            {
                case 1 : drone.moveUp();          break;
                case 2 : drone.moveDown();        break;
                case 3 : drone.moveForward();     break;
                case 4 : drone.moveDown();        break;
                case 5 : drone.turnLeft();        break;
                case 6 : drone.turnRight();       break;
                case 7 : drone.displayPosition(); break;
                case 8 : control_bool = false;    break;
                default :
                    
            }
            
        }
        
        System.out.println("Exiting navigation");
    }
    
    private static void printMenu()
    {
        System.out.println("Which direction would you like to move the drone?");
        System.out.println("1 - Move Up");
        System.out.println("2 - Move Down");
        System.out.println("3 - Move Forward");
        System.out.println("4 - Move Backward");
        System.out.println("5 - Turn Left");
        System.out.println("6 - Turn Right");
        System.out.println("7 - Display Position");
        System.out.println("8 - Exit Navigation");
    }
}
