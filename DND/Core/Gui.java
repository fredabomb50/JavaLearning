package Core;

//======================AWT
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.GridBagLayout;

//======================SWING
import javax.swing.*;

//format is: Grid -> grid.add(GridConstraint())
public class Gui extends JPanel implements ActionListener
{
	// . . .
	final static long serialVersionUID = 0;
	
	
	//styling components
	Font buttonFont = new Font(Font.SERIF, Font.PLAIN, 12);
	
	
	//core components and frames
	private JPanel grid = new JPanel(new GridBagLayout());
	private JFrame frame = new JFrame("Character Randomizer");
	private JButton test_button = new JButton("test");
	
	//======================CONSTRUCTOR
	public Gui()
	{
		//set GridLayout
		
		
		//set frame
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(test_button);
		
		//set buttons
		test_button.setFont(buttonFont);
		
		
		grid.setVisible(false);
	} // end of constructor

	
	//======================GET METHODS
	
	
	//======================SET METHODS
	public void setVisibility(boolean IsVisible)
	{
		
		grid.setVisible(IsVisible);
	}
	
	
	//======================awt.event methods
	public void actionPerformed(ActionEvent e)
	{
		
	} // end of action performed method
	
	
} // end of Gui class
