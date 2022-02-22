package Core;


//======================AWT
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;


//======================SWING
import javax.swing.*;
import javax.swing.ImageIcon;


//format is: Grid -> grid.add(GridConstraint())
public class Gui extends JPanel implements ActionListener
{
	// . . .
	final static long serialVersionUID = 0;
	
	
	//styling components
	Font buttonFont = new Font(Font.SERIF, Font.PLAIN, 12);
	int button_DefaultGridWidth = 1;
	int button_DefaultGridHeight = 1;
	int label_DefaultSize = 1;
	
	
	//resources
	final private static String avatar_Path = "Resources/avatar.png";
	
	
	//core components and frame
	private JFrame frame = new JFrame("Character Randomizer");
	private Image icon_Window = Toolkit.getDefaultToolkit().getImage("Resources/window_icon.png");
	
	
	//======================CONSTRUCTOR
	public Gui()
	{
		//nothing yet
	} // end of constructor

	
	//TO START OFF, WE'LL USE A 9X9 GRID; just for core character details (name, age, race, level, etc.)
	//======================Graphics
	public void createAndShowGUI()
	{	
		// set constraints
		GridBagConstraints bttn1, bttn2, bttn3, bttn4, bttn5, f1;
		bttn1 = new GridBagConstraints();
			bttn1.gridx = 0;
			bttn1.gridy = 0;
			
		f1 = new GridBagConstraints();
			f1.gridx = 1;
			f1.gridy = 1;
			
		bttn3 = new GridBagConstraints();
			bttn3.gridx = 2;
			bttn3.gridy = 2;
			bttn3.ipady = 50;			
			
		bttn4 = new GridBagConstraints();
			bttn4.gridx = 3;
			bttn4.gridy = 2;
			
		bttn5 = new GridBagConstraints();
			bttn5.gridx = 4;
			bttn5.gridy = 4;
		
			
		GridBagConstraints constraint_CharacterDetails = new GridBagConstraints();
			constraint_CharacterDetails.fill = GridBagConstraints.NONE;
			constraint_CharacterDetails.weightx = 0.5;
			constraint_CharacterDetails.gridx = 4;
			constraint_CharacterDetails.gridy = 3;
			constraint_CharacterDetails.ipady = 60;
			constraint_CharacterDetails.gridheight = 2;
			constraint_CharacterDetails.gridwidth= 1;
		
		GridBagConstraints constraint_Avatar = new GridBagConstraints();
			constraint_Avatar.fill = GridBagConstraints.BOTH;
			constraint_Avatar.weightx = 0.5;
			constraint_Avatar.weighty = 0.5;
			constraint_Avatar.gridx = 2;
			constraint_Avatar.gridy = 2;
			constraint_Avatar.gridheight = 2;
			constraint_Avatar.gridwidth= 2;
			
			
		// set frame and add layout
		frame.setLayout(new GridBagLayout());
		frame.setIconImage(icon_Window);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		
		
		// set menu bar
		JMenu fileMenu = new JMenu("File");
		JMenu printMenu = new JMenu("Print");
		JMenuBar menuBar = new JMenuBar();
			menuBar.add(fileMenu);
			menuBar.add(printMenu);
		
		
		// set buttons
		JButton button1, button2, button3, button4, button5, bttn_CharacterDetails;
		button1 = new JButton("button1");
		button2 = new JButton("button2");
		button3 = new JButton("button3");
		button4 = new JButton("button4");
		button5 = new JButton("button5");
		
		
		// SECTION: Character details
		bttn_CharacterDetails = new JButton("->");
			bttn_CharacterDetails.setFont(buttonFont);
		
			
		// SECTION: Character Avatar
		JFrame avatarFrame = new JFrame();
			avatarFrame.setIconImage(loadImage(avatar_Path));
			
		//add all to frame
		frame.setJMenuBar(menuBar);
		frame.add(button1, bttn1);
		frame.add(avatarFrame, f1);
		frame.add(button3, bttn3);
		frame.add(button4, bttn4);
		frame.add(button5, bttn5);
		
		
		//frame.add(bttn_CharacterDetails, constraint_CharacterDetails);
		//frame.add(avatarPanel, constraint_Avatar);
		
		
		// Finalize options
		setVisibility(true);
	}
	
	
	public Image loadImage(String path)
	{
		Image i = Toolkit.getDefaultToolkit().getImage(path);
		return i.getScaledInstance(100, 100, Image.SCALE_FAST);
	}
	
	
	//======================GET METHODS
	
	
	//======================SET METHODS
	public void setVisibility(boolean IsVisible)
	{
		frame.setVisible(IsVisible);
	}
	
	
	//======================awt.event methods
	public void actionPerformed(ActionEvent e)
	{
		//do nothing for now
	} // end of action performed method
	
	
} // end of Gui class
