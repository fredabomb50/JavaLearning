package core;

//AWT
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.GridBagConstraints;

//SWING
import javax.swing.*;


public class FrameDesigner extends Gui
{
	//======================Constants; ultimately needs to be removed once a final design is made, to avoid memory hogging
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
	
	//Icons
	final private static Image icon_Window = Toolkit.getDefaultToolkit().getImage("Resources/window_icon.png");
	
	
	//======================Variables
	//JCompnents
	JMenu newRandomMenu, newSemiMenu, fileMenu, printMenu;
	JMenuBar menuBar;
	
	
	
	//Core
	public JFrame frame = new JFrame("Character Randomizer");
	public static Image icon_Avatar = Toolkit.getDefaultToolkit().getImage("Resources/avatar.png");
	
	
	//======================Constructor
	public FrameDesigner()
	{
		frame.setIconImage(icon_Window);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setBackground(color_LightBackdrop);
		
		
		buildAddMenu();
		
		
		frame.setVisible(true);
	}
	
	
	public void setLayoutManager(GridBagLayout grid)
	{
		frame.setLayout(grid);
	}
	
	
	public void setAvatarLogo(String newPath)
	{
		icon_Avatar = Toolkit.getDefaultToolkit().getImage(newPath);
	}
	
	
	//======================JComponent Builders
	private void buildAddMenu()
	{
		fileMenu = new JMenu("File");
		newRandomMenu = new JMenu("New Character (Random)");
		newSemiMenu = new JMenu("New Character (Configurable)");
		fileMenu.add(newRandomMenu);
		fileMenu.add(newSemiMenu);
		
		
		printMenu = new JMenu("Print");
		
		
		menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		menuBar.add(printMenu);
		
		
		frame.add(menuBar);
	}

	
	//======================Stubs
	// contains old constraint settings from gui class; to be splintered as methods
	public void stub1()
	{
		/*
		  		// set frame and add layout
		frame.setLayout(new GridBagLayout());
		frame.setIconImage(icon_Window);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		
	
		
		
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
		 
		*/
	}
}
