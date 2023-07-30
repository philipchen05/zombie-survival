/* Name: Philip Chen
Teacher: Mr. Guglielmi
Date: November 9, 2020
Description: Displays program splash screen with loading bar
*/
import hsa.Console;
import java.awt.*;
import java.lang.*;

// SplashScreen class
public class SplashScreen extends Thread
{
    // declaration statement
    // c; instance variable for Console object
    private Console c;
    
    // SplashScreen class constructor; initializes c to pre-instantiated Console object in parameter
    public SplashScreen(Console c)
    {
	this.c = c;
    }
    
    
    // splashScreen method; draws program splash screen
    public void splashScreen()
    {
	// colour variables
	Color green = new Color(106, 168, 79);
	Color darkGreen = new Color(56, 118, 29);
	
	c.setTextBackgroundColor(green);
	c.clear();
	
	// title
	c.setFont(new Font("Arial",1,60));
	c.setColor(Color.red);
	c.drawString("Zombie Survival", 87, 268);
	c.setFont(new Font("Arial",1,60));
	c.setColor(Color.black);
	c.drawString("Zombie Survival", 90, 265);
	c.setFont(new Font("Arial",1,60));
	c.setColor(Color.red);
	c.drawString("Zombie Survival", 93, 262);
	
	// blood
	c.setColor(Color.red);
	c.fillOval(560,350,70,70);
	c.setColor(Color.red);
	c.fillOval(510,400,30,30);
	c.setColor(Color.red);
	c.fillOval(450,430,50,50);
	c.setColor(Color.red);
	c.fillOval(585,295,35,35);
	
	// loading bar
	c.setColor(darkGreen);
	c.fillRect(90, 360, 465, 10);
	for(int i = 90; i < 555; i++)
	{
	    c.setColor(Color.red);
	    c.fillRect(i, 360, 1, 10);
	    try
	    {
		sleep(100);
	    }
	    catch(Exception e)
	    {
	    }
	}
    }
    
    
    // run method; calls splashScreen method when SplashScreen object is started
    public void run()
    {
	splashScreen();
    }
}
