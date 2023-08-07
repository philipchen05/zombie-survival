// Description: Calculates player health

import hsa.Console;
import java.awt.*;

// Health class
public class Health extends Thread
{
    // declaration statements
    // p; instance variable for Player object
    // z; instance variable for Zombie array
    // calculate; stores boolean value for health method loop control
    private Player p;
    private Zombie[] z;
    private boolean calculate = true;
    
    // Health class constructor; initializes p to pre-instantiated Player object and z to pre-instantiated Zombie array in parameters
    public Health(Player p, Zombie[] z)
    {
	this.p = p;
	this.z = z;
    }
    
    
    // health method; calculates health
    public void health()
    {
	// hit; stores boolean value for whether or not a zombie has collided with player
	boolean hit;
	
	while(calculate)
	{
	    hit = false;
	    
	    // detects zombie collision with player and makes necessary changes to player health
	    for(int i = 0; i < z.length; i++)
	    {
		if(z[i].detectCollision())
		{
		    hit = true;
		    p.health -= 50;
		    if(p.health < 0)
		    {
			p.health = 0;
		    }
		}
	    }
	    
	    // makes player invincible for 1 second after being hit by zombie
	    if(hit)
	    {
		try
		{
		    sleep(1000);
		}
		catch(Exception e)
		{
		}
	    }
	}
    }
    
    
    // end method; stops calculating player health
    public void end()
    {
	calculate = false;
    }
    
    
    // run method; calls health method when Health object is started
    public void run()
    {
	health();
    }
}
