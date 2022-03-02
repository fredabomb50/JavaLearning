package core;

//AWT
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.GridBagConstraints;

//SWING
import javax.swing.*;
import javax.swing.border.Border;


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
	
	//Borders
	final private static Border border_GenericPanel= BorderFactory.createEtchedBorder();
	
	//Icons
	final private static Image icon_Window = Toolkit.getDefaultToolkit().getImage("Resources/window_icon.png");
	
	
	//======================Variables
	private static Image icon_Avatar = loadImage("Resources/avatar.png");
	
	
	//JComponents
	JMenu menu_NewFullRandom, menu_NewSemiRandom, menu_File, menu_Print;
	
	JMenuBar menuBar;
	
	JPanel panel_Avatar, panel_CharacterDetails, panel_CharacterStatus, panel_AbilityScores, panel_Skills,
	panel_SavingThrows, panel_ArmorClass, panel_Inspiration, panel_Initiative;

	JLabel lbl_Class, lbl_Level, lbl_Alignment, lbl_Background, lbl_Avatar, lbl_Name, lbl_Age, lbl_Weight, lbl_Height, lbl_Race, lbl_Faction,
	lbl_Exp, lbl_MaxHealth, lbl_CurrentHealth, lbl_TempHealth, lbl_HitDie, lbl_CurrentHitDie;

	//Core
	public JFrame frame = new JFrame("Character Randomizer");
	private GridDesigner grid = new GridDesigner();
	
	
	//======================Constructor
	public FrameDesigner()
	{
		// build frame
		frame.setIconImage(icon_Window);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setBackground(color_LightBackdrop);
		setLayoutManager(grid.grid);
		
		// build sections
		buildMenus();
		buildAvatar();
		buildCharacterDetails();
		buildCharacterStatus();
		
		// assign constraints and display GUI
		addConstraints();
		frame.setVisible(true);
	}
	
	
	//======================Layout
	public void setLayoutManager(GridBagLayout grid)
	{
		frame.setLayout(grid);
	}
	
	
	private void addConstraints()
	{
		frame.add(panel_Avatar, grid.panel_Avatar);
		frame.add(panel_CharacterDetails, grid.panel_CharacterDetails);
		frame.add(panel_CharacterStatus, grid.panel_CharacterStatus);
	}
	
	
	//======================Section Builders
	private void buildAvatar()
	{
		lbl_Avatar = new JLabel(new ImageIcon(rescaleImage(icon_Avatar, 100, 100)));	
		
		panel_Avatar = new JPanel();
		setPanel(panel_Avatar, 100, 100);
		panel_Avatar.setBorder(border_GenericPanel);
		panel_Avatar.add(lbl_Avatar);	
	}
	
	
	private void buildMenus()
	{
		menu_File = new JMenu("File");
		menu_NewFullRandom = new JMenu("New Character (Random)");
		menu_NewSemiRandom = new JMenu("New Character (Configurable)");
		menu_File.add(menu_NewFullRandom);
		menu_File.add(menu_NewSemiRandom);
		
		
		menu_Print = new JMenu("Print");
		
		
		menuBar = new JMenuBar();
		menuBar.add(menu_File);
		menuBar.add(menu_Print);
		
		
		frame.setJMenuBar(menuBar);
	}
	
	
	private void buildCharacterDetails()
	{
		GridLayout grid = new GridLayout(3, 3);
		
		lbl_Name = new JLabel("Name: Little Shell");
		setLabel(lbl_Name, font_SmallHeader, color_GenericText);
		
		lbl_Alignment = new JLabel("Alignment: Chaotic Good");
		setLabel(lbl_Alignment, font_SmallHeader, color_GenericText);
		
		lbl_Class = new JLabel("Class: Barbarian");
		setLabel(lbl_Class, font_SmallHeader, color_GenericText);
		
		lbl_Level = new JLabel("Level: 9");
		setLabel(lbl_Level, font_SmallHeader, color_GenericText);
		
		lbl_Background = new JLabel("Background: Hermit");
		setLabel(lbl_Background, font_SmallHeader, color_GenericText);
		
		panel_CharacterDetails = new JPanel();
		panel_CharacterDetails.setLayout(grid);
		panel_CharacterDetails.setBorder(border_GenericPanel);
		setPanel(panel_CharacterDetails, 250, 50);
		
		panel_CharacterDetails.add(lbl_Name);
		panel_CharacterDetails.add(lbl_Alignment);
		panel_CharacterDetails.add(lbl_Class);
		panel_CharacterDetails.add(lbl_Level);
		panel_CharacterDetails.add(lbl_Background);
		
		
	}

	
	private void buildCharacterStatus()
	{
		GridLayout grid = new GridLayout(3, 3);
		
		
		panel_CharacterStatus = new JPanel();
		panel_CharacterStatus.setLayout(grid);
		panel_CharacterStatus.setBorder(border_GenericPanel);
		setPanel(panel_CharacterStatus, 250, 50);
	}
	
	
	//======================Component builders
	private void setLabel(JLabel label, Font font, Color color)
	{
		label.setFont(font);
		label.setForeground(color);
	}
	
	
	private void setPanel(JPanel panel, int x, int y)
	{
		panel.setBackground(color_PanelBackdrop);
		panel.setSize(x, y);
	}
	
	
	//======================Designers
	public void setAvatarLogo(String newPath)
	{
		icon_Avatar = Toolkit.getDefaultToolkit().getImage(newPath);
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
