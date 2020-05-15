//Author Name: Sally Ellison
//Date: 5/14/20
//Program Name: Ellison_Drone
//Purpose: Simulation using button, drone movement in x,y,z location

package module_1;

public class Ellison_Drone
{
    public enum Orientation { NORTH, SOUTH, EAST, WEST }
    
    private int x = 0;
    private int y = 0;
    private int z = 0;
    private Orientation orientation = Orientation.NORTH;
    
    public void moveUp()
    {
        z++;
        System.out.println("You have moved up");
    }
    
    public void moveDown()
    {
        z--;
        System.out.println("You have moved down");
    }
    
    public void moveForward()
    {
        switch(orientation)
        {
          case NORTH : y++; break;
          case SOUTH : y--; break;
          case EAST  : x++; break;
          case WEST  : x--; break;
          default : 
        }
        System.out.println("You have moved forward");
    }
    
    public void moveBackward()
    {
        switch(orientation)
        {
          case NORTH : y--; break;
          case SOUTH : y++; break;
          case EAST  : x--; break;
          case WEST  : x++; break;
          default : 
        }
        
        System.out.println("You have moved backward");
    }
    
    public void turnLeft()
    {
        switch(orientation)
        {
          case NORTH : orientation = Orientation.WEST; break;
          case SOUTH : orientation = Orientation.EAST; break;
          case EAST  : orientation = Orientation.NORTH; break;
          case WEST  : orientation = Orientation.SOUTH; break;
          default : 
        }
        
        System.out.println("You have turned left");
    }
    
    public void turnRight()
    {
        switch(orientation)
        {
          case NORTH : orientation = Orientation.EAST; break;
          case SOUTH : orientation = Orientation.WEST; break;
          case EAST  : orientation = Orientation.SOUTH; break;
          case WEST  : orientation = Orientation.NORTH; break;
          default : 
        }
        
        System.out.println("You have turned right");
    } 
    
    public void displayPosition()
    {
        String positionInfo = String.format("Ellison_Drone [x_pos=%d, y_pos=%d, z_pos=%d, orientation=%s]", x, y, z, orientation);
        System.out.println(positionInfo);
    }
    
    
    
    
}
