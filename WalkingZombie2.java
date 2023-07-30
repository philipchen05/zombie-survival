/* Name: Philip Chen
Teacher: Mr. Guglielmi
Date: November 10, 2020
Description: Creates walking zombie animation for program splash screen
*/
import hsa.Console;
import java.awt.*;
import java.lang.*;

// WalkingZombie2 class
public class WalkingZombie2 extends Thread
{
    // declaration statements
    // c; instance variable for Console object
    // done; stores boolean value for animation loop control
    private Console c;
    private boolean done = false;
    
    // WalkingZombie2 class constructor; initializes c to pre-instantiated Console object in parameter
    public WalkingZombie2(Console c)
    {
	this.c = c;
    }
    
    
    // walkingZombie2 method; draws walking zombie animation
    public void walkingZombie2()
    {
	// i; stores integer value to determine where to draw zombie sprite throughout animation
	int i = 670;
	
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
		c.fillOval(i + 9, 10, 30, 30);
		c.setColor(green);
		c.fillRoundRect(i + 11, 39, 25, 40, 15, 15);
		c.setColor(green);
		c.fillRoundRect(i - 19, 42, 35, 15, 5, 5);
		c.setColor(green);
		c.fillRoundRect(i + 16, 75, 15,33, 5, 5);

		c.setColor(darkGreen);
		c.fillOval(i - 1, 10, 30, 30);
		c.setColor(darkGreen);
		c.fillRoundRect(i + 1, 39, 25, 40, 15, 15);
		c.setColor(darkGreen);
		c.fillRoundRect(i - 31, 42, 35, 15, 5, 5);
		c.setColor(darkGreen);
		c.setFont(new Font("Courier New", 1, 130));
		c.setColor(darkGreen);
		c.drawString("^", i - 24, 150);
	    }
	    // draws standing sprite
	    else
	    {
		// erases previous walking sprite
		c.setColor(green);
		c.fillOval(i + 9, 10, 30, 30);
		c.setColor(green);
		c.fillRoundRect(i + 11, 39, 25, 40, 15, 15);
		c.setColor(green);
		c.fillRoundRect(i - 21, 42, 35, 15, 5, 5);
		c.setFont(new Font("Courier New", 1, 130));
		c.setColor(green);
		c.drawString("^", i - 14, 150);
		
		c.setColor(darkGreen);
		c.fillOval(i - 1, 10, 30, 30);
		c.setColor(darkGreen);
		c.fillRoundRect(i + 1, 39, 25, 40, 15, 15);
		c.setColor(darkGreen);
		c.fillRoundRect(i - 31, 42, 35, 15, 5, 5);
		c.setColor(darkGreen);
		c.setFont(new Font("Courier New", 1, 130));
		c.setColor(darkGreen);
		c.fillRoundRect(i + 6, 75, 15, 33, 5, 5);
	    }
	    try
	    {
		sleep(250);
	    }
	    catch(Exception e)
	    {
	    }
	    
	    i -= 10;
	    
	    // makes zombie enter screen from right side again after exiting screen from left side
	    if(i == -60)
	    {
		i = 670;
	    }
	}
    }
    
    
    // end method; ends animation loop
    public void end()
    {
	done = true;
    }
    
    
    // run method; calls walkingZombie2 method when WalkingZombie2 object is started
    public void run()
    {
	walkingZombie2();
    }
}
