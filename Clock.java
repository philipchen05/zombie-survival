/* Name: Philip Chen
Teacher: Mr. Guglielmi
Date: November 15, 2020
Description: Creates timer for gameplay
*/

// Clock class
public class Clock extends Thread
{
    // declaration statements
    // round; stores round number
    // time; stores time remaining
    public int round;
    public int time = 1;
    
    // Clock class constructor; initializes round to i in parameter
    public Clock(int i)
    {
	round = i;
    }
    
    
    // timer method; starts timer
    public void timer()
    {
	// first round is 60 seconds, with each subsequent round increasing by 10 seconds
	time = round * 10 + 50;
	while(time > 0)
	{
	    try
	    {
		sleep(1000);
	    }
	    catch(Exception e)
	    {
	    }
	    time--;
	}
    }
    
    
    // run method; calls timer method when Clock object is started
    public void run()
    {
	timer();
    }
}
