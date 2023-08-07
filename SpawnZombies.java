// Description: Spawns zombies

import hsa.Console;
import java.awt.*;

// SpawnZombies class
public class SpawnZombies extends Thread
{
    // declaration statements
    // c; instance variable for Console object
    // z; instance variable for Zombie array
    // i; loop counter for spawnZombies method loop control
    private Console c;
    private Zombie[] z;
    private int i;
    
    // SpawnZombies class constructor; initializes c to pre-instantiated Console object and z to pre-instantiated Zombie array in parameters
    public SpawnZombies(Console c, Zombie[] z)
    {
	this.c = c;
	this.z = z;
    }
    
    
    // spawnZombies method; spawns Zombie objects one at a time, 2 seconds apart
    public void spawnZombies()
    {
	for(i = 0; i < z.length; i++)
	{
	    z[i].start();
	    try
	    {
		sleep(2000);
	    }
	    catch(Exception e)
	    {
	    }
	}
    }
    
    
    // end method; stops spawning zombies
    public void end()
    {
	i = z.length;
    }
    
    
    // run method; calls spawnZombies method when SpawnZombies object is started
    public void run()
    {
	spawnZombies();
    }
}
