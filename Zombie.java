/* Name: Philip Chen
Teacher: Mr. Guglielmi
Date: November 12, 2020
Description: Creates a zombie
*/
import hsa.Console;
import java.awt.*;

// Zombie class
public class Zombie extends Thread
{
    // declaration statement
    // c; instance variable for Console object
    // p; instance variable for Player object
    // x; stores x coordinate of zombie centre location
    // y; stores y coordinate of zombie centre location
    // alive; stores boolean value for zombie status
    private Console c;
    private Player p;    
    private int x = 0;
    private int y = 0;
    private boolean alive = true;
    
    // Zombie class constructor; initializes c to pre-instantiated Console object and p to pre-instantiated Player object in parameters
    public Zombie(Console c, Player p)
    {
	this.c = c;
	this.p = p;
    }
    
    
    // zombie method; creates a zombie
    public void zombie()
    {
	// valid; stores boolean value for local loop control
	boolean valid = false;
    
	// colour variables
	Color darkGreen = new Color(56, 118, 29);
	Color green = new Color(106, 168, 79);
	
	// initializes a valid spawn location
	while(!valid)
	{
	    x = (int) (Math.random() * 640 + 1);
	    y = (int) (Math.random() * 500 + 1);
	    if(x > 599 || x < 39 || y > 459 || y < 39)
	    {
		valid = true;
	    }
	}
	
	// draws zombie in original position
	c.setColor(darkGreen);
	c.fillOval(x, y, 40, 40);
	
	// follows player
	while(alive)
	{
	    if(x > p.x && y > p.y)
	    {
		c.setColor(green);
		c.fillOval(x, y, 40, 40);
		x--;
		y--;
		c.setColor(darkGreen);
		c.fillOval(x, y, 40, 40);
	    }
	    else if(x > p.x && y < p.y)
	    {
		c.setColor(green);
		c.fillOval(x, y, 40, 40);
		x--;
		y++;
		c.setColor(darkGreen);
		c.fillOval(x, y, 40, 40);
	    }
	    else if(x < p.x && y > p.y)
	    {
		c.setColor(green);
		c.fillOval(x, y, 40, 40);
		x++;
		y--;
		c.setColor(darkGreen);
		c.fillOval(x, y, 40, 40);
	    }
	    else if(x < p.x && y < p.y)
	    {
		c.setColor(green);
		c.fillOval(x, y, 40, 40);
		x++;
		y++;
		c.setColor(darkGreen);
		c.fillOval(x, y, 40, 40);
	    }
	    else if(x > p.x)
	    {
		c.setColor(green);
		c.fillOval(x, y, 40, 40);
		x--;
		c.setColor(darkGreen);
		c.fillOval(x, y, 40, 40);
	    }
	    else if(x < p.x)
	    {
		c.setColor(green);
		c.fillOval(x, y, 40, 40);
		x++;
		c.setColor(darkGreen);
		c.fillOval(x, y, 40, 40);
	    }
	    else if(y > p.y)
	    {
		c.setColor(green);
		c.fillOval(x, y, 40, 40);
		y--;
		c.setColor(darkGreen);
		c.fillOval(x, y, 40, 40);
	    }
	    else if(y < p.y)
	    {
		c.setColor(green);
		c.fillOval(x, y, 40, 40);
		y++;
		c.setColor(darkGreen);
		c.fillOval(x, y, 40, 40);
	    }
	    try
	    {
		sleep(75);
	    }
	    catch(Exception e)
	    {
	    }
	}
    }
    
    
    // detectCollision method; determines if zombie has collided with player
    public boolean detectCollision()
    {
	// collided; stores boolean value for whether or not zombie has collided with player
	boolean collided = false;
	
	if(x == p.x && y == p.y)
	{
	    collided = true;
	}
	
	return collided;
    }
    
    
    // end method; deletes zombie
    public void end()
    {
	alive = false;   
    }
    
    
    // run method; calls zombie method when Zombie object is started
    public void run()
    {
	zombie();
    }
}
