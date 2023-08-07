// Description: Draws player and controls player movement

import hsa.Console;
import java.awt.*;

// Player class
public class Player extends Thread
{
    // declaration statement
    // c; instance variable for Console object
    // alive; stores boolean value for player status
    // x; stores x coordinate of player centre location
    // y; stores y coordinate of player centre location
    // health; stores player health
    private Console c;
    private boolean alive = true;
    public int x = 305;
    public int y = 230;
    public int health = 100;
    
    // Player class constructor; initializes c to pre-instantiated Console object in parameter
    public Player(Console c)
    {
	this.c = c;
    }
    
    
    // player method; draws player
    public void player()
    {
	// choice; stores user character input for player movement direction
	char choice = ' ';
    
	// colour variables
	Color skin = new Color(255, 242, 204);
	Color green = new Color(106, 168, 79);
	
	// draws player in original position
	c.setColor(skin);
	c.fillOval(x, y, 40, 40);
	
	// controls player movement
	while(alive)
	{
	    switch(choice)
	    {
		case 'w':
		    c.setColor(green);
		    c.fillOval(x, y, 40, 40);
		    y -= 5;
		    if(y <= 0)
		    {
			y += 5;
		    }
		    c.setColor(skin);
		    c.fillOval(x, y, 40, 40);
		    break;
		case 'a':
		    c.setColor(green);
		    c.fillOval(x, y, 40, 40);
		    x -= 5;
		    if(x <= 0)
		    {
			x += 5;
		    }
		    c.setColor(skin);
		    c.fillOval(x, y, 40, 40);
		    break;
		case 's':
		    c.setColor(green);
		    c.fillOval(x, y, 40, 40);
		    y += 5;
		    if(y >= 459)
		    {
			y -= 5;
		    }
		    c.setColor(skin);
		    c.fillOval(x, y, 40, 40);
		    break;
		case 'd':
		    c.setColor(green);
		    c.fillOval(x, y, 40, 40);
		    x += 5;
		    if(x >= 600)
		    {
			x -= 5;
		    }
		    c.setColor(skin);
		    c.fillOval(x, y, 40, 40);
	    }
	    choice = c.getChar();
	}
    }
    
    
    // end method; deletes player
    public void end()
    {
	alive = false;
    }
    
    
    // run method; calls player method when Player object is started
    public void run()
    {
	player();
    }
}
