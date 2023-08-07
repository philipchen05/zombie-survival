// Creating a zombie survival video game using all of the concepts I have learned

import hsa.Console;
import java.awt.*;
import java.io.*;
import javax.swing.*;

// ZombieSurvival class
public class ZombieSurvival
{
    // declaration statements
    // c; instance variable for Console object
    // input; instance variable for BufferedReader object to read files
    // output; instance variable for PrintWriter object to write to files
    // j; instance variable for JFrame object
    // a; instance variable for Animation object
    // round; stores round number
    // play; stores boolean value for gameplay loop control
    // valid; stores boolean value for whether or not player started from round 1
    // name; stores player name
    // names; String array to store names of top ten highest-scoring players
    // scores; integer array to store top ten highest scores
    // green; background green colour
    private Console c;
    private BufferedReader input;
    private PrintWriter output;
    private JFrame j = new JFrame();
    private Animation a;
    private int round = 1;
    private boolean play;
    private boolean valid;
    private String name;
    private String[] names = new String[10];
    private int[] scores = new int[10];
    private Color green = new Color(106, 168, 79);
    
    // ZombieSurvival class constructor; creates Console object for output display
    public ZombieSurvival()
    {
	c = new Console("Zombie Survival");
	a = new Animation(c);
    }
    
    
    // wipeScreen method; wipes screen from top to bottom in red to clear screen
    private void wipeScreen()
    {
	for(int i = 0; i < 500; i++)
	{
	    c.setColor(Color.red);
	    c.fillRect(0, i, 640, 1);
	    try
	    {
		Thread.sleep(1);
	    }
	    catch(Exception e)
	    {
	    }
	}
	c.clear();
    }
    
    
    // displayRound method; displays the round number
    private void displayRound()
    {
	wipeScreen();
	
	c.setFont(new Font("Arial",1,80));
	c.setColor(Color.red);
	c.drawString("Round " + round, 157, 278);
	c.setColor(Color.black);
	c.drawString("Round " + round, 160, 275);
	c.setColor(Color.red);
	c.drawString("Round " + round, 163, 272);
	try
	{
	    Thread.sleep(3000);
	}
	catch(Exception e)
	{
	}
    }
    
    
    // highScore method; displays new high score screen and gets user name
    private void highScore()
    {
	wipeScreen();
	
	// draws "New High Score!" sign
	c.setFont(new Font("Arial", 1, 50));
	c.setColor(Color.red);
	c.drawString("New High Score!", 123, 262);
	c.setColor(Color.black);
	c.drawString("New High Score!", 125, 260);
	c.setColor(Color.red);
	c.drawString("New High Score!", 127, 258);
	c.setFont(new Font("Arial", 4, 20));
	c.setColor(Color.black);
	
	// prompts for user name
	c.drawString("What's your name?", 240, 300);
	c.setCursor(17, 31);
	name = c.readLine();
    }
    
    
    // splashScreen method; draws and animates program splash screen
    public void splashScreen()
    {
	a.splashScreen();
    }
    
    
    // fileCheck method; creates a new empty high scores file if it does not exist already
    public void fileCheck()
    {
	try
	{
	    input = new BufferedReader(new FileReader("HighScores.txt"));
	}
	catch(IOException e)
	{
	    try
	    {
		output = new PrintWriter(new FileWriter("HighScores.txt"));
		for(int i = 0; i < 10; i++)
		{
		    output.println("null");
		    output.println(0);
		}
		output.close();
	    }
	    catch(IOException x)
	    {
	    }
	}
    }
    
    
    // mainMenu method; displays program main menu screen and performs function based on user key input
    public void mainMenu()
    {
	// choice; stores character value of user choice
	// ask; stores boolean value for local loop control
	char choice;
	boolean ask;
	
	// colour variables
	Color red = new Color(224, 102, 102);
	Color lightRed = new Color(234, 153, 153);
	
	while(true)
	{
	    choice = ' ';
	    ask = true;
	    round = 1;
	    play = true;
	    valid = false;
	    
	    wipeScreen();
	    
	    // draws program title
	    c.setFont(new Font("Arial",1,60));
	    c.setColor(Color.red);
	    c.drawString("Zombie Survival", 96, 228);
	    c.setColor(Color.black);
	    c.drawString("Zombie Survival", 99, 225);
	    c.setColor(Color.red);
	    c.drawString("Zombie Survival", 102, 222);
	    c.setFont(new Font("Arial",1,20));
	    c.setColor(Color.black);
	    c.drawString("Philip Chen", 270, 260);
	
	    // draws spacebar
	    c.setColor(red);
	    c.fillRect(143, 331, 350, 70);
	    c.setColor(red);
	    c.fillRect(157, 317, 350, 70);
	    c.setColor(lightRed);
	    c.fillRect(150, 324, 350, 70);
	    c.setFont(new Font("Arial",4,25));
	    c.setColor(Color.black);
	    c.drawString("START", 280, 360);
	    c.fillRect(200, 370, 250, 5);
	    c.fillRect(200, 345, 5, 25);
	    c.fillRect(445, 345, 5, 25);
	
	    // displays user options
	    c.setFont(new Font("Arial",4,18));
	    c.setColor(Color.black);
	    c.drawString("Press the spacebar to start", 217, 300);
	    c.setFont(new Font("Arial",4,14));
	    c.drawString("Press 'i' for instructions", 255, 425);
	    c.drawString("Press 's' to select starting round", 225, 445);
	    c.drawString("Press 'h' to view highscores", 242, 465);
	    c.drawString("Press 'q' to quit", 278, 485);
	
	    // prompts for user key input and performs function based on input
	    while(ask)
	    {
		choice = c.getChar();
		switch(choice)
		{
		    case ' ':
			ask = false;
			valid = true;
			gameplay();
			break;
		    case 'i':
			ask = false;
			instructions();
			break;
		    case 's':
			ask = false;
			selectRound();
			break;
		    case 'h':
			ask = false;
			getScores();
			break;
		    case 'q':
			ask = false;
			goodbye();
		}
	    }
	}
    }

    
    // gameplay method; starts game and controls gameplay
    public void gameplay()
    {
	while(play)
	{
	    displayRound();
	    wipeScreen();
	    a.gameplay(round);
	    try
	    {
		Thread.sleep(1000);
	    }
	    catch(Exception e)
	    {
	    }
	    if(!a.alive)
	    {
		gameOver();
	    }
	    else
	    {
		round++;
	    }
	}
    }
    
    
    // instructions method; displays program instructions
    public void instructions()
    {
	wipeScreen();
	
	c.print(' ',33);
	c.println("Instructions");
	c.println();
	c.println("Survive endless waves of zombies for as long as you can. Avoid the zombies ");
	c.println("and make sure to not let any of them crawl on you!");
	c.println();
	c.println("You begin each round with 100 health points. You lose 50 health points if a");
	c.println("zombie crawls completely over you.");
	c.println();
	c.println("Controls");
	c.print(' ',3);
	c.print('w');
	c.print(' ',29);
	c.println("move up");
	c.print(' ',3);
	c.print('a');
	c.print(' ',29);
	c.println("move left");
	c.print(' ',3);
	c.print('s');
	c.print(' ',29);
	c.println("move down");
	c.print(' ',3);
	c.print('d');
	c.print(' ',29);
	c.println("move right");
	c.println();
	c.println("(Press any key to continue)");
	c.getChar();
    }
    
    
    // selectRound method; prompts user for which round they wish to start on
    public void selectRound()
    {
	// ask; stores boolean value for local error handling loop control
	// roundStr; stores user String input that is parsed into type int for valid integer input check
	String roundStr;
	boolean ask = true;
    
	wipeScreen();
	
	while(ask)
	{
	    try
	    {
		c.print(' ',31);
		c.println("Round Selection");
		c.println();
		c.println("What round do you want to start on?");
		roundStr = c.readLine();
		round = Integer.parseInt(roundStr);
		if(round < 1)
		{
		    JOptionPane.showMessageDialog(j, "Invalid round number. Round number must be greater than 0.");
		    c.clear();
		}
		else
		{
		    if(round == 1)
		    {
			valid = true;
		    }
		    ask = false;
		}
	    }
	    catch(NumberFormatException e)
	    {
		JOptionPane.showMessageDialog(j, "Invalid round number. Please enter a valid round number.");
		c.clear();
	    }
	}
	
	gameplay();
    }
    
    
    // getScores method; displays high scores
    public void getScores()
    {
	// choice; stores user character input for user choice
	// ask; stores boolean value for local loop control
	char choice;
	boolean ask = true;
	
	wipeScreen();
	
	try
	{
	    // opens high scores file
	    input = new BufferedReader(new FileReader("HighScores.txt"));
		
	    // reads file data into names and scores arrays
	    for(int i = 0; i < 10; i++)
	    {
		names[i] = input.readLine();
		scores[i] = Integer.parseInt(input.readLine());
	    }
		
	    // prints high scores onto screen
	    c.print(' ',33);
	    c.println("High Scores");
	    c.println();
	    c.print(' ',17);
	    c.print("Name");
	    c.print(' ',34);
	    c.println("Round");
	    for(int i = 0; i < 10; i++)
	    {
		c.print(' ',17);
		if(scores[i] != 0)
		{
		    c.print(names[i]);
		    if(scores[i] < 10)
		    {
			c.setCursor(i + 4,59);
		    }
		    else
		    {
			c.setCursor(i + 4,58);
		    }
		    c.println(scores[i]);
		}
		else
		{
		    c.print('-');
		    c.setCursor(i + 4,59);
		    c.println('-');
		}
	    }
	
	    c.println();
	    c.print(' ',23);
	    c.println("(Press the spacebar to continue)");
	    c.setCursor(24,26);
	    c.println("Press 'c' to clear high scores");
		
	    // performs function based on user choice
	    while(ask)
	    {
		choice = c.getChar();
		if(choice == 'c')
		{
		    try
		    {
			// clears high scores arrays
			names = new String[10];
			scores = new int[10];
			
			// clears high scores file
			output = new PrintWriter(new FileWriter("HighScores.txt"));
			for(int i = 0; i < 10; i++)
			{
			    output.println(names[i]);
			    output.println(scores[i]);
			}
			output.close();
			
			JOptionPane.showMessageDialog(j, "Cleared high scores.");
			ask = false;
		    }
		    catch(IOException e)
		    {
		    }
		}
		else if(choice == ' ')
		{
		    ask = false;
		}
	    }
	}
	catch(IOException e)
	{
	}
    }
    
    
    // updateScores method; updates high scores
    public void updateScores()
    {
	// min; stores lowest score out of highest scores
	// index; stores index location of new high score in scores array
	int min;
	int index = 9;
	
	// opens high scores file and reads file data into names and scores arrays
	try
	{
	    input = new BufferedReader(new FileReader("HighScores.txt"));
	    for(int i = 0; i < 10; i++)
	    {
		names[i] = input.readLine();
		scores[i] = Integer.parseInt(input.readLine());
	    }
	}
	catch(IOException e)
	{
	}
	
	min = scores[9];
	
	// checks to see if user started on round one
	if(valid)
	{
	    // checks to see if round is a high score
	    if(round > min)
	    {
		highScore();
	    
		scores[9] = round;
		
		// determines rank of new high score
		for(int i = 0; i < 10; i++)
		{
		    if(round > scores[i])
		    {
			index = i;
			i = 10;
		    }
		}
	    
		// moves down high scores below new high score
		for(int i = 9; i > index; i--)
		{
		    names[i] = names[i - 1];
		    scores[i] = scores[i - 1];
		}
	    
		// inserts new high score into scores array at correct ranking
		names[index] = name;
		scores[index] = round;
	    
		// saves new data to high scores file
		try
		{
		    output = new PrintWriter(new FileWriter("HighScores.txt"));
		    for(int i = 0; i < 10; i++)
		    {
			output.println(names[i]);
			output.println(scores[i]);
		    }
		    output.close();
		}
		catch(IOException e)
		{
		}
	    }
	}
    }
    
    
    // gameOver method; displays game over screen
    private void gameOver()
    {
	// again; stores user String value for whether or not they wish to play again
	// ask; stores boolean value for local error handling loop control
	String again;
	boolean ask = true;
	
	updateScores();
	wipeScreen();
	
	while(ask)
	{
	    // draws "Game Over" sign
	    c.setFont(new Font("Arial",1,80));
	    c.setColor(Color.red);
	    c.drawString("Game Over", 102, 278);
	    c.setColor(Color.black);
	    c.drawString("Game Over", 105, 275);
	    c.setColor(Color.red);
	    c.drawString("Game Over", 108, 272);
	    
	    // prompts user for whether or not they wish to play again
	    c.setFont(new Font("Arial",4,20));
	    c.setColor(Color.black);
	    c.drawString("Do you want to play again?", 205, 320);
	    c.drawString("Enter \"yes\" or \"no\".", 240, 350);
	    c.setCursor(19,31);
	    again = c.readLine();
	    
	    // performs function based on user response
	    if(again.toLowerCase().equals("yes"))
	    {
		play = false;
		ask = false;
	    }
	    else if(again.toLowerCase().equals("no"))
	    {
		goodbye();
	    }
	    else
	    {
		JOptionPane.showMessageDialog(j, "Invalid response. Please enter \"yes\" or \"no\".");
		c.clear();
	    }
	}
    }
    
    
    // goodbye method; displays program exit screen and exits program
    public void goodbye()
    {
	// colour variable
	Color red = new Color(222, 35, 35);
    
	wipeScreen();
	
	c.setFont(new Font("Arial",1,60));
	c.setColor(Color.red);
	c.drawString("Zombie Survival", 96, 228);
	c.setColor(Color.black);
	c.drawString("Zombie Survival", 99, 225);
	c.setColor(Color.red);
	c.drawString("Zombie Survival", 102, 222);
	c.setFont(new Font("Arial",1,20));
	c.setColor(Color.black);
	c.drawString("Philip Chen", 270, 260);
	c.setFont(new Font("Arial",1,30));
	c.setColor(Color.red);
	c.drawString("Exited Game", 235, 300);
	c.setFont(new Font("Arial",4,18));
	c.setColor(Color.black);
	c.drawString("Thank you for for playing Zombie Survival.",155,340);
	c.drawString("Goodbye!",280,370);
	c.setFont(new Font("Arial",4,16));
	c.drawString("© 2020 Zombie Survival. All Rights Reserved", 172, 400);        
	c.setFont(new Font("Arial",4,20));
	c.drawString("(Press any key to continue)", 210, 440);
	c.getChar();
	System.exit(0);
    }
    
    
    // main method; executes program
    public static void main(String[] args)
    {
	ZombieSurvival z = new ZombieSurvival();
	z.splashScreen();
	z.fileCheck();
	z.mainMenu();
    }
}
