package core;
import java.awt.event.*;
import java.awt.*;
//import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.Random;




public class Gameplay extends JPanel implements ActionListener
{
	//game data
	Random randomNum = new Random();
	private boolean IsPlaying = false;
	private int score = 0;
	private int startDelay = 3;
	private Timer timer;
	private MapGenerator map;
	
	
	//map data
	private int mapYLimit = 12;
	private int mapXLimit = 4;
	private int totalBricks = mapYLimit * mapXLimit;
	
	
	//ball data
	Color ballColor = new Color(255, 255, 255);
	private int ballposX = randomNum.nextInt(100, 600);
	private int ballposY = 350;
	private int ballXdir = -2;
	private int ballYdir = ballXdir * 2;
	
	
	//paddle data
	private int playerX = 300;
	Color playerColor = ballColor;
	

	//======================Game Initialization
	public Gameplay()
	{	
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		newGame();	
	}
	
	public void newGame()
	{
		map = new MapGenerator(mapXLimit, mapYLimit);
		timer = new Timer(startDelay, this);
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
		g.setColor(playerColor);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		
		// the scores 		
		g.setColor(Color.white);
		g.setFont(new Font("serif",Font.BOLD, 25));
		g.drawString(""+score, 590,30);
		
		// the paddle
		g.setColor(playerColor);
		g.fillRect(playerX, 550, 100, 8);
		
		// the ball
		g.setColor(ballColor);
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

	
	public void paintPlayer(Graphics g)
	{
		Color temp_color = new Color(randomNum.nextInt(0, 254), randomNum.nextInt(0, 254), randomNum.nextInt(0, 254));
		
		// the paddle
		g.setColor(temp_color);
		g.fillRect(playerX, 550, 100, 8);
		
		// the ball
		g.setColor(temp_color);
		g.fillOval(ballposX, ballposY, 20, 20);
	}
	//======================Input processing
	public void KeysHandler(String key) 
	{
		switch (key)
		{
			case "Right":
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
			
			case "Left":
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
			
			case "Enter":
			{
				if(!IsPlaying)
				{
					IsPlaying = true;
					newGame();
					repaint();
				}
				else
				{
					System.out.println("Cannot start new game with one running.");
				}
			}break;
			
			case "Escape":
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
		if(IsPlaying)
		{		
			System.out.println("game is playing");
			
			
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
		} //end of "is playing" check
	} // end of method
	
	
	//======================Stub methods
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
}
