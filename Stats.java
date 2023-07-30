/* Name: Philip Chen
Teacher: Mr. Guglielmi
Date: November 14, 2020
Description: Displays game stats
*/
import hsa.Console;
import java.awt.*;

// Stats class
public class Stats extends Thread
{
    // declaration statement
    // c; instance variable for Console object
    // p; instance variable for Player object
    // t; instance variable for Clock object
    // display; stores boolean value for stats method loop control
    private Console c;
    private Player p;
    private Clock t;
    private boolean display = true;
    
    // Stats class constructor; initializes c to pre-instantiated Console object, p to pre-instantiated Player object, and t to pre-instantiated Clock object in parameters
    public Stats(Console c, Player p, Clock t)
    {
	this.c = c;
	this.p = p;
	this.t = t;
    }
    
    
    // stats method; displays stats
    public void stats()
    {
	// health; stores player health
	// time; stores time remaining
	int health = p.health;
	int time = t.time;
	
	// colour variable
	Color green = new Color(106, 168, 79);
	
	while(display)
	{
	    c.setFont(new Font("Arial", 1, 24));
	    c.setColor(Color.black);
	    c.drawString("HP: " + health, 10, 35);
	    c.setFont(new Font("Arial", 1, 24));
	    c.setColor(Color.black);
	    c.drawString("Time Remaining: " + time, 10, 60);
	    c.setFont(new Font("Arial", 1, 24));
	    c.setColor(Color.black);
	    c.drawString("Round " + t.round, 525, 480);
	    
	    // redraws health stat when player health changes
	    if(health != p.health)
	    {
		c.setFont(new Font("Arial", 1, 24));
		c.setColor(green);
		c.drawString("HP: " + health, 10, 35);
		
		health = p.health;
		
		c.setFont(new Font("Arial", 1, 24));
		c.setColor(Color.black);
		c.drawString("HP: " + health, 10, 35);
	    }
	    
	    // redraws time remaining when time remaining changes
	    if(time != t.time)
	    {
		c.setFont(new Font("Arial", 1, 24));
		c.setColor(green);
		c.drawString("Time Remaining: " + time, 10, 60);
		
		time = t.time;
		
		c.setFont(new Font("Arial", 1, 24));
		c.setColor(Color.black);
		c.drawString("Time Remaining: " + time, 10, 60);
	    }
	}
    }
    
    
    // end method; stops displaying stats
    public void end()
    {
	display = false;
    }
    
    
    // run method; calls stats method when Stats object is started
    public void run()
    {
	stats();
    }
}
