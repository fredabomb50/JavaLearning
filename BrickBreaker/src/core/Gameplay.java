package core;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import java.util.Random;


public class Gameplay extends JPanel implements KeyListener, ActionListener 
{
	private Timer timer;
	private MapGenerator map;
	
	Random ballXCoord = new Random();
	
	private boolean IsPlaying = false;
	private int score = 0;
	private int delay = 1;
	private int playerX = 300;
	private int ballposX = ballXCoord.nextInt(100, 600);
	private int ballposY = 350;
	private int ballXdir = -3;
	private int ballYdir = ballXdir * 2;
	private int mapYLimit = 12;
	private int mapXLimit = 4;
	private int totalBricks = mapYLimit * mapXLimit;
	
	
	//======================Game Initialization
	public Gameplay()
	{		
		map = new MapGenerator(mapXLimit, mapYLimit);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
		timer.start();
	}
	
	
	//======================Graphics updating
	public void paint(Graphics g)
	{    		
		// background
		g.setColor(Color.black);
		g.fillRect(1, 1, 692, 592);
		
		// drawing map
		map.draw((Graphics2D) g);

		// borders
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		
		// the scores 		
		g.setColor(Color.white);
		g.setFont(new Font("serif",Font.BOLD, 25));
		g.drawString(""+score, 590,30);
		
		// the paddle
		g.setColor(Color.green);
		g.fillRect(playerX, 550, 100, 8);
		
		// the ball
		g.setColor(Color.yellow);
		g.fillOval(ballposX, ballposY, 20, 20);
	
		// when you won the game
		if(totalBricks <= 0)
		{
			 IsPlaying = false;
             ballXdir = 0;
     		 ballYdir = 0;
             g.setColor(Color.GREEN);
             g.setFont(new Font("serif",Font.BOLD, 30));
             g.drawString("You Won", 260,300);
             
             g.setColor(Color.RED);
             g.setFont(new Font("serif",Font.BOLD, 20));           
             g.drawString("Press (Enter) to Restart", 230,350);  
		}
		
		// when you lose the game
		if(ballposY > 570)
        {
			 IsPlaying = false;
             ballXdir = 0;
     		 ballYdir = 0;
             g.setColor(Color.RED);
             g.setFont(new Font("serif",Font.BOLD, 30));
             g.drawString("Game Over, Scores: "+score, 190,300);
             
             g.setColor(Color.RED);
             g.setFont(new Font("serif",Font.BOLD, 20));           
             g.drawString("Press (Enter) to Restart", 230,350);        
        }
		
		g.dispose();
	}	

	
	//======================Input processing
	public void keyPressed(KeyEvent e) 
	{
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_RIGHT:
			{
				if(playerX >= 600)
				{
					playerX = 600;
				}
				else
				{
					moveRight();
				}
			}break;
			
			case KeyEvent.VK_LEFT:
			{
				if(playerX < 10)
				{
					playerX = 10;
				}
				else
				{
					moveLeft();
				}
			}break;
			
			case KeyEvent.VK_ENTER:
			{
				if(!IsPlaying)
				{
					IsPlaying = true;
					ballposX = ballXCoord.nextInt(50, 550);
					ballposY = 350;
					ballXdir = -3;
					ballYdir = -6;
					playerX = 300;
					score = 0;
					totalBricks = 48;
					map = new MapGenerator(mapXLimit, mapYLimit);
					

					repaint();
				}
			}break;
			
			case KeyEvent.VK_ESCAPE:
			{
				IsPlaying = false;
				System.exit(0);
				
			}break;
			
		} //end of getKeyCode switch
	}
	
	public void moveRight()
	{
		IsPlaying = true;
		playerX+=60;	
	}
	public void moveLeft()
	

	{
		IsPlaying = true;
		playerX-=60;	 	
	}
	
	
	//======================Game updates
	public void actionPerformed(ActionEvent e) 
	{
		//timer.start();
		if(IsPlaying)
		{			
			if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 30, 8)))
			{
				ballYdir = -ballYdir;
				ballXdir = -2;
			}
			else if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX + 70, 550, 30, 8)))
			{
				ballYdir = -ballYdir;
				ballXdir = ballXdir + 1;
			}
			else if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX + 30, 550, 40, 8)))
			{
				ballYdir = -ballYdir;
			}
			
			// check map collision with the ball		
			A: for(int i = 0; i<map.map.length; i++)
			{
				for(int j =0; j<map.map[0].length; j++)
				{				
					if(map.map[i][j] > 0)
					{
						//scores++;
						int brickX = j * map.brickWidth + 80;
						int brickY = i * map.brickHeight + 50;
						int brickWidth = map.brickWidth;
						int brickHeight = map.brickHeight;
						
						Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);					
						Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20);
						Rectangle brickRect = rect;
						
						if(ballRect.intersects(brickRect))
						{					
							map.setBrickValue(0, i, j);
							score+=5;	
							totalBricks--;
							
							// when ball hit right or left of brick
							if(ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width)	
							{
								ballXdir = -ballXdir;
							}
							// when ball hits top or bottom of brick
							else
							{
								ballYdir = -ballYdir;				
							}
							
							break A;
						}
					}
				}
			}
			
			ballposX += ballXdir;
			ballposY += ballYdir;
			
			if(ballposX < 0)
			{
				ballXdir = -ballXdir;
			}
			if(ballposY < 0)
			{
				ballYdir = -ballYdir;
			}
			if(ballposX > 670)
			{
				ballXdir = -ballXdir;
			}		
			
			repaint();		
		}
	}
	
	
	//======================Stub methods
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
}
