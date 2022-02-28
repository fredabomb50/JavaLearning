package core;


//======================AWT
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;


//======================SWING
import javax.swing.*;
import javax.swing.ImageIcon;


//format is: Grid -> grid.add(GridConstraint())
public class Gui extends JPanel implements ActionListener
{
	// . . .
	final static long serialVersionUID = 0;
	
	
	//======================CONSTRUCTOR
	public Gui()
	{
		//do nothing yet
	} // end of constructor


	//======================Graphics
	public void createAndShowGUI()
	{	
		//create and set frame
		FrameDesigner frame = new FrameDesigner();
		
		
		//create and set grid
		GridDesigner grid = new GridDesigner();
		
		
		//assign grid to frame
		
	}
	
	public static Image loadImage(String path)
	{
		return Toolkit.getDefaultToolkit().getImage(path);
	}	
	
	
	public Image loadRescaleImage(String path, int x, int y)
	{
		Image i = Toolkit.getDefaultToolkit().getImage(path);
		return i.getScaledInstance(x, y, Image.SCALE_FAST);
	}
	

	
	//======================awt.event methods
	public void actionPerformed(ActionEvent e)
	{
		//do nothing for now	
	} // end of action performed method
} // end of Gui class