package Core;


//======================AWT
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;

//======================SWING
import javax.swing.*;
import javax.swing.ImageIcon;


//format is: Grid -> grid.add(GridConstraint())
public class Gui extends JPanel implements ActionListener
{
	// . . .
	final static long serialVersionUID = 0;
	
	
	//Fonts
	final private static Font font_GenericButton = new Font(Font.SERIF, Font.PLAIN, 12);
	final private static Font font_LargeHeader = new Font(Font.SERIF, Font.BOLD, 36);
	final private static Font font_MediumHeader = new Font(Font.SERIF, Font.BOLD, 24);
	final private static Font font_SmallHeader = new Font(Font.SERIF, Font.BOLD, 12);
	final private static Font font_MenuHeader = new Font(Font.SERIF, Font.ITALIC, 12);
	
	//Colors
	final private static Color color_PanelBackdrop = new Color(191, 179, 148);	// BFB394
	final private static Color color_PanelBorder = new Color(228, 222, 197);	// E4DEC5
	final private static Color color_GenericText = new Color(0, 0, 0);	
	final private static Color color_LogoText = new Color(146, 9, 9);			// 920909
	final private static Color color_LightBackdrop = new Color(241, 235, 228);	// F1EBE4
	
	
	//Defaults
	int button_DefaultGridWidth = 1;
	int button_DefaultGridHeight = 1;
	int label_DefaultSize = 1;
	
	
	//Resources
	final private static String path_AvatarImage = "Resources/avatar.png";
	final private static String path_WindowIcon = "Resources/window_icon.png";
	
	
	//Core components and frame
	private JFrame frame = new JFrame("Character Randomizer");
	private Image icon_Window = Toolkit.getDefaultToolkit().getImage(path_WindowIcon);
	
	
	//======================CONSTRUCTOR
	public Gui()
	{
		//nothing yet
	} // end of constructor

	

	//======================Graphics
	public void createAndShowGUI()
	{	
		// set constraints
		GridBagConstraints cClassLabel, cLevelLabel, cAlignBGPanel, cAvatarPanel, cCharacterDetailsButton;
		
		
		cAvatarPanel = new GridBagConstraints();
		setConstraintValues(cAvatarPanel, 1, 1, 1, 1, 0, 0, 0, 0, GridBagConstraints.NONE, GridBagConstraints.EAST);

		
		cClassLabel = new GridBagConstraints();
		setConstraintValues(cClassLabel, cAvatarPanel.gridx, (cAvatarPanel.gridy - 1), 1, 1, 0, 0, 0, 0, GridBagConstraints.NONE, GridBagConstraints.SOUTH);
		//cClassLabel.gridx = cAvatarPanel.gridx;
		//cClassLabel.gridy = cAvatarPanel.gridy - 1;		
		//cClassLabel.gridheight = 1;
		//cClassLabel.gridwidth = 1;
		//cClassLabel.anchor = GridBagConstraints.SOUTH;
		
		cLevelLabel = new GridBagConstraints();
		cLevelLabel.gridx = cAvatarPanel.gridx - 1;
		cLevelLabel.gridy = cAvatarPanel.gridy;		
		cLevelLabel.gridheight = 1;
		cLevelLabel.gridwidth = 1;
		cLevelLabel.anchor = GridBagConstraints.NORTH;
		
		cAlignBGPanel = new GridBagConstraints();
		cAlignBGPanel.gridx = cAvatarPanel.gridx;
		cAlignBGPanel.gridy = cAvatarPanel.gridy + 1;		
		cAlignBGPanel.gridheight = 1;
		cAlignBGPanel.gridwidth = 1;
		cAlignBGPanel.anchor = GridBagConstraints.NORTH;
		
		cCharacterDetailsButton = new GridBagConstraints();
		cCharacterDetailsButton.fill = GridBagConstraints.NONE;
		cCharacterDetailsButton.weightx = 0.5;
		cCharacterDetailsButton.gridx = cAvatarPanel.gridx + 1;
		cCharacterDetailsButton.gridy = cAvatarPanel.gridy;
		cCharacterDetailsButton.ipady = 60;
		cCharacterDetailsButton.gridheight = cAvatarPanel.gridheight;
		cCharacterDetailsButton.gridwidth = 1;
		cCharacterDetailsButton.anchor = GridBagConstraints.WEST;
			
			
		// set frame and add layout
		frame.setLayout(new GridBagLayout());
		frame.setIconImage(icon_Window);
		frame.setBackground(color_LightBackdrop);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		
		
		// set menus and bar
		JMenu newRandomMenu, newSemiMenu, fileMenu, printMenu;
		
		newRandomMenu = new JMenu("New Character (Random)");
		newSemiMenu = new JMenu("New Character (Configurable)");
		fileMenu = new JMenu("File");
		fileMenu.add(newRandomMenu);
		fileMenu.add(newSemiMenu);
		printMenu = new JMenu("Print");
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		menuBar.add(printMenu);
		
		
		// declare panels
		JPanel avatarPanel, AlignBGPanel;
		
		// declare buttons
		JButton bttn_CharacterDetails;
		
		// declare labels
		JLabel ClassLabel, LevelLabel, alignmentLabel, backgroundLabel, avatarImage;
		
		
		// SECTION: Character details
		bttn_CharacterDetails = new JButton(">");
		bttn_CharacterDetails.setFont(font_GenericButton);
		bttn_CharacterDetails.setRolloverEnabled(false);
		bttn_CharacterDetails.setToolTipText("click for deets");
		bttn_CharacterDetails.setBackground(color_PanelBackdrop);
		
		
		// SECTION: Character Avatar
		avatarPanel = new JPanel();
		avatarImage = new JLabel(new ImageIcon(loadRescaleImage(path_AvatarImage, 100, 100)));
		avatarPanel.add(avatarImage);
		avatarPanel.setBackground(color_PanelBackdrop);
		
		ClassLabel = new JLabel("Barbarian");
		ClassLabel.setFont(font_LargeHeader);
		ClassLabel.setForeground(color_GenericText);
		
		LevelLabel = new JLabel("9");
		LevelLabel.setFont(font_LargeHeader);
		LevelLabel.setForeground(color_GenericText);
		
		alignmentLabel = new JLabel("Chaotic Good");
		alignmentLabel.setFont(font_MediumHeader);
		alignmentLabel.setForeground(color_GenericText);
		backgroundLabel = new JLabel("Hermit");
		backgroundLabel.setFont(font_MediumHeader);
		backgroundLabel.setForeground(color_GenericText);
		
		AlignBGPanel = new JPanel();
		AlignBGPanel.add(alignmentLabel);
		AlignBGPanel.add(backgroundLabel);
		AlignBGPanel.setBackground(color_PanelBackdrop);
		
		//add all to frame
		frame.setJMenuBar(menuBar);
		frame.add(bttn_CharacterDetails, cCharacterDetailsButton);
		frame.add(avatarPanel, cAvatarPanel);
		frame.add(AlignBGPanel, cAlignBGPanel);
		frame.add(LevelLabel, cLevelLabel);
		frame.add(ClassLabel, cClassLabel);
		
		// Finalize options
		setVisibility(true);
	}
	
	
	

	public Image loadRescaleImage(String path, int x, int y)
	{
		Image i = Toolkit.getDefaultToolkit().getImage(path);
		return i.getScaledInstance(x, y, Image.SCALE_FAST);
	}
	
	
	//======================GET METHODS
	
	
	//======================SET METHODS
	public void setVisibility(boolean IsVisible)
	{
		frame.setVisible(IsVisible);
	}
	
	
	//LOOK INTO USING BUILDER OBJECT PATTERNING FOR THIS;
	public void setConstraintValues (GridBagConstraints constraint, int gX, int gY, int gWidth, int gHeight, int xPad, int yPad, double xWeight, double yWeight, int gFill, int gAnchor)
	{
		constraint.gridx = gX;
		constraint.gridy = gY;
		constraint.gridwidth = gWidth;
		constraint.gridheight = gHeight;
		constraint.ipadx = xPad;
		constraint.ipady = yPad;
		constraint.weightx = xWeight;
		constraint.weighty = yWeight;
		constraint.fill = gFill;
		constraint.anchor = gAnchor;
	}
	
	
	//======================awt.event methods
	public void actionPerformed(ActionEvent e)
	{
		//do nothing for now
		
	} // end of action performed method
	
	
} // end of Gui class
