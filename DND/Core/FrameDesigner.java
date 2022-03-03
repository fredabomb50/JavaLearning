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
import javax.swing.JRadioButton;

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
	//Core
	public JFrame frame = new JFrame("Character Randomizer");
	private GridDesigner grid = new GridDesigner();
	
	
	// Menu
	JMenu menu_NewFullRandom, menu_NewSemiRandom, menu_File, menu_Print;
	JMenuBar menuBar;
	
	// Avatar
	JPanel panel_Avatar;
	JLabel lbl_Avatar;
	Image icon_Avatar = loadImage("Resources/avatar.png");
	
	// Character Details
	JPanel panel_CharacterDetails;
	JLabel lbl_Class, lbl_Level, lbl_Alignment, lbl_Background, lbl_Name, lbl_Age, lbl_Weight, lbl_Height, lbl_Race, lbl_Faction;
	
	// Character Status
	JPanel panel_CharacterStatus;
	JLabel lbl_CurrentHealth, lbl_MaxHealth, lbl_TempHealth, lbl_HitDie, lbl_CurrentHitDie;
	
	// Ability Scores
	JPanel panel_AbilityScores;
	JLabel lbl_Strength, lbl_Dexterity, lbl_Consitution, lbl_Wisdom, lbl_Intelligence, lbl_Charisma;
	
	// Skills
	JPanel panel_Skills;
	JLabel lbl_Acrobatics, lbl_AnimalHandling, lbl_Arcana, lbl_Athletics, lbl_Deception, lbl_History, lbl_Insight, lbl_Intimidation,
		lbl_Investigation, lbl_Medicine, lbl_Nature, lbl_Perception, lbl_Performance, lbl_Persuasion, lbl_Religion, lbl_SleightOfHand, lbl_Stealth, lbl_Survival;
	JRadioButton rb_test;
	
	
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
		buildAbilityScores();
		buildSkills();
		
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
		frame.add(panel_AbilityScores, grid.panel_AbilityScores);
		frame.add(panel_Skills, grid.panel_Skills);
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
		GridLayout grid = new GridLayout(2, 5);
		
		lbl_Name = new JLabel("Name: Little Shell");
		setLabel(lbl_Name);
		
		lbl_Alignment = new JLabel("Aligned: C-G");
		setLabel(lbl_Alignment);
		
		lbl_Class = new JLabel("Class: Barbarian");
		setLabel(lbl_Class);
		
		lbl_Level = new JLabel("Level: 9");
		setLabel(lbl_Level);
		
		lbl_Background = new JLabel("Background: Hermit");
		setLabel(lbl_Background);
		
		lbl_Race = new JLabel("Race: Tortle");
		setLabel(lbl_Race);
		
		lbl_Age = new JLabel("Age: 22");
		setLabel(lbl_Age);
		
		lbl_Height = new JLabel("Height: 6ft 5in");
		setLabel(lbl_Height);
		
		lbl_Weight = new JLabel("Weight: 550lbs");
		setLabel(lbl_Weight);
		
		lbl_Faction = new JLabel("Faction: Free Blades");
		setLabel(lbl_Faction);
		
		panel_CharacterDetails = new JPanel();
		panel_CharacterDetails.setLayout(grid);
		panel_CharacterDetails.setBorder(border_GenericPanel);
		setPanel(panel_CharacterDetails, 250, 50);
		
		
		// first row
		panel_CharacterDetails.add(lbl_Level);
		panel_CharacterDetails.add(lbl_Class);
		panel_CharacterDetails.add(lbl_Name);
		panel_CharacterDetails.add(lbl_Alignment);
		panel_CharacterDetails.add(lbl_Background);
		
		// second row
		panel_CharacterDetails.add(lbl_Race);
		panel_CharacterDetails.add(lbl_Age);
		panel_CharacterDetails.add(lbl_Height);
		panel_CharacterDetails.add(lbl_Weight);
		panel_CharacterDetails.add(lbl_Faction);
	}

	
	private void buildCharacterStatus()
	{
		GridLayout grid = new GridLayout(2, 5);
		panel_CharacterStatus = new JPanel();
		panel_CharacterStatus.setLayout(grid);
		panel_CharacterStatus.setBorder(border_GenericPanel);
		setPanel(panel_CharacterStatus, 250, 50);
		
		lbl_CurrentHealth = new JLabel ("HP: 140");
		setLabel(lbl_CurrentHealth);
		
		lbl_MaxHealth = new JLabel ("Max HP: 110");
		setLabel(lbl_MaxHealth);
		
		lbl_TempHealth = new JLabel ("Temp HP: 30");
		setLabel(lbl_TempHealth);
		
		lbl_HitDie = new JLabel ("Hit Die: 9D12");
		setLabel(lbl_HitDie);
		
		panel_CharacterStatus.add(lbl_CurrentHealth);
		panel_CharacterStatus.add(lbl_MaxHealth);
		panel_CharacterStatus.add(lbl_TempHealth);
		panel_CharacterStatus.add(lbl_HitDie);
	}
	
	
	private void buildAbilityScores()
	{
		// initialize panel and grid
		GridLayout grid = new GridLayout(6, 1);		
		panel_AbilityScores = new JPanel();
		panel_AbilityScores.setLayout(grid);
		panel_AbilityScores.setBorder(border_GenericPanel);
		setPanel(panel_AbilityScores, 50, 250);
		
		// initialize labels
		lbl_Strength = new JLabel("STR: +5 (20)");
		setLabel(lbl_Strength);
		
		lbl_Dexterity = new JLabel("DEX: +5 (20)");
		setLabel(lbl_Dexterity);
		
		lbl_Consitution = new JLabel("CON: +5 (20)");
		setLabel(lbl_Consitution);
		
		lbl_Wisdom = new JLabel("WIS: +5 (20)");
		setLabel(lbl_Wisdom);
		
		lbl_Intelligence = new JLabel("INT: +5 (20)");
		setLabel(lbl_Intelligence);
		
		lbl_Charisma = new JLabel("CHR: +5 (20)");
		setLabel(lbl_Charisma);
		
		// add labels
		panel_AbilityScores.add(lbl_Strength);
		panel_AbilityScores.add(lbl_Dexterity);
		panel_AbilityScores.add(lbl_Consitution);
		panel_AbilityScores.add(lbl_Wisdom);
		panel_AbilityScores.add(lbl_Intelligence);
		panel_AbilityScores.add(lbl_Charisma);
	}
	
	
	private void buildSkills()
	{
		// initialize panel and grid
		GridLayout grid = new GridLayout(9, 2);		
		panel_Skills = new JPanel();
		panel_Skills.setLayout(grid);
		panel_Skills.setBorder(border_GenericPanel);
		setPanel(panel_Skills, 50, 250);
		
		// initialize labels + buttons
		lbl_Acrobatics = new JLabel("Acrobatics");
		rb_test = new JRadioButton();
		rb_test.setBackground(color_PanelBackdrop);
		
		// add components to panel
		panel_Skills.add(lbl_Acrobatics);
		panel_Skills.add(rb_test);
	}
	
	
	//COPY THIS METHOD FOR CONSISTENT CODE FORMAT
	private void build()
	{
		// initialize panel and grid
		
		// initialize labels
		
		// add labels
	}
	
	
	//======================Component builders
	private void setLabel(JLabel label)
	{
		label.setFont(font_SmallHeader);
		label.setForeground(color_GenericText);
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
	

}
