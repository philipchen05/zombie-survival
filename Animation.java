// Description: Controls program animations
import hsa.Console;
import java.lang.*;

// Animation class
public class Animation extends Thread
{
    // declaration statements
    // c; instance variable for Console object
    // done; stores boolean value for gameplay loop control
    // alive; stores boolean value for player status
    private Console c;
    public boolean done;
    public boolean alive;
    
    // Animation class constructor; initializes c to pre-instantiated Console object in parameter
    public Animation(Console c)
    {
	this.c = c;
    }
    
    
    // splashScreen method; starts program splash screen animation
    public void splashScreen()
    {
	// s; instance variable for SplashScreen object
	// w1; instance variable for WalkingZombie1 object
	// w2; instance variable for WalkingZombie2 object
	SplashScreen s = new SplashScreen(c);
	WalkingZombie1 w1 = new WalkingZombie1(c);
	WalkingZombie2 w2 = new WalkingZombie2(c);
	
	// starts animations
	s.start();
	w1.start();
	w2.start();
	
	// waits for loading bar to finish
	try
	{
	    sleep(46500);
	}
	catch(Exception e)
	{
	}
	
	// ends animations
	w1.end();
	w2.end();
    }
    
    
    // gameplay method; controls gameplay animations
    public void gameplay(int i)
    {
	// p; instance variable for Player object
	// z; instance variable for Zombie array
	// t; instance variable for Clock object
	// s; instance variable for Stats object
	// h; instance variable for Health object
	// sz; instance variable for SpawnZombies object
	Player p = new Player(c);
	Zombie[] z = new Zombie[i * 2 + 8];
	Clock t = new Clock(i);
	Stats s = new Stats(c, p, t);
	Health h;
	SpawnZombies sz;
	
	// instantiates Zombie objects in z
	for(int x = 0; x < z.length; x++)
	{
	    z[x] = new Zombie(c, p);
	}
	
	h = new Health(p, z);
	sz = new SpawnZombies(c, z);
	
	done = false;
	alive = true;
	
	// starts all Threads
	p.start();
	t.start();
	s.start();
	h.start();
	sz.start();
	
	// continues round until timer has expired or player health is 0
	while(!done)
	{
	    if(t.time == 0)
	    {
		p.end();
		s.end();
		h.end();
		sz.end();
		for(int a = 0; a < z.length; a++)
		{
		    z[a].end();
		}
		done = true;
	    }
	    else if(p.health == 0)
	    {
		p.end();
		s.end();
		h.end();
		sz.end();
		for(int a = 0; a < z.length; a++)
		{
		    z[a].end();
		}
		done = true;
		alive = false;
	    }
	}
    }
}
