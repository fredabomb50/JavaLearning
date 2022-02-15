package core;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class MapGenerator 
{
	Random color_seed = new Random();
	Color BlockColors[][];
	public int map[][];
	public int brickWidth;
	public int brickHeight;
	
	
	public MapGenerator (int row, int col)
	{
		map = new int[row][col];
		BlockColors = new Color[row][col];
		
		for(int i = 0; i <map.length; i++)
		{
			for(int j =0; j <map[0].length; j++)
			{
				Color random_color = new Color(color_seed.nextInt(0, 254), color_seed.nextInt(0, 254), color_seed.nextInt(0, 254));
				BlockColors[i][j] = random_color;
				map[i][j] = 1;
			}			
		}
		
		brickWidth = 540/col;
		brickHeight = 150/row;
	}	
	
	
	public void draw(Graphics2D g)
	{
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[0].length; j++)
			{
				if(map[i][j] > 0)
				{
					g.setColor(BlockColors[i][j]);
					g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
					
					
					// sets boundary around blocks; currently set to .brighter version of itself
					g.setStroke(new BasicStroke(3));
					g.setColor(BlockColors[i][j].brighter());
					g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
				}
			}
		}
	}
	
	public void setBrickValue(int value, int row, int col)
	{
		map[row][col] = value;
	}
}
