/* Name: Philip Chen
Teacher: Mr. Guglielmi
Date: November 9, 2020
Description: Creates walking zombie animation for program splash screen
*/
import hsa.Console;
import java.awt.*;
import java.lang.*;

// WalkingZombie1 class
public class WalkingZombie1 extends Thread
{
    // declaration statements
    // c; instance variable for Console object
    // done; stores boolean value for animation loop control
    private Console c;
    private boolean done = false;
    
    // WalkingZombie1 class constructor; initializes c to pre-instantiated Console object in parameter
    public WalkingZombie1(Console c)
    {
	this.c = c;
    }
    
    
    // walkingZombie1 method; draws walking zombie animation
    public void walkingZombie1()
    {
	// i; stores integer value to determine where to draw zombie sprite throughout animation
	int i = -70;
	
	// colour variables
	Color green = new Color(106, 168, 79);
	Color darkGreen = new Color(56, 118, 29);
	
	while(!done)
	{
	    // draws walking sprite
	    if(i / 10 % 2 == 0)
	    {
		// erases previous standing sprite
		c.setColor(green);
		c.fillOval(i - 9, 110, 30, 30);
		c.setColor(green);
		c.fillRoundRect(i - 7, 139, 25, 40, 15, 15);
		c.setColor(green);
		c.fillRoundRect(i - 16, 142, 35, 15, 5, 5);
		c.setColor(green);
		c.fillRoundRect(i - 1, 175, 15,33, 5, 5);

		c.setColor(darkGreen);
		c.fillOval(i + 1, 110, 30, 30);
		c.setColor(darkGreen);
		c.fillRoundRect(i + 4, 139, 25, 40, 15, 15);
		c.setColor(darkGreen);
		c.fillRoundRect(i + 27, 142, 35, 15, 5, 5);
		c.setFont(new Font("Courier New", 1, 130));
		c.setColor(darkGreen);
		c.drawString("^", i - 22, 250);
	    }
	    // draws standing sprite
	    else
	    {
		// erases previous walking sprite
		c.setColor(green);
		c.fillOval(i - 9, 110, 30, 30);
		c.setColor(green);
		c.fillRoundRect(i - 7, 139, 25, 40, 15, 15);
		c.setColor(green);
		c.fillRoundRect(i - 16, 142, 35, 15, 5, 5);
		c.setFont(new Font("Courier New", 1, 130));
		c.setColor(green);
		c.drawString("^", i - 32, 250);
		
		c.setColor(darkGreen);
		c.fillOval(i + 1, 110, 30, 30);
		c.setColor(darkGreen);
		c.fillRoundRect(i + 4, 139, 25, 40, 15, 15);
		c.setColor(darkGreen);
		c.fillRoundRect(i + 27, 142, 35, 15, 5, 5);
		c.setColor(darkGreen);
		c.fillRoundRect(i + 9, 175, 15, 33, 5, 5);
	    }
	    try
	    {
		sleep(250);
	    }
	    catch(Exception e)
	    {
	    }
	    
	    i += 10;
	    
	    // makes zombie enter screen from left side again after exiting screen from right side
	    if(i == 660)
	    {
		i = -70;
	    }
	}
    }
    
    
    // end method; ends animation loop
    public void end()
    {
	done = true;
    }
    
    
    // run method; calls walkingZombie1 method when WalkingZombie1 object is started
    public void run()
    {
	walkingZombie1();
    }
}
