package dnd_gui;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import java.awt.GridLayout;

public class DetailsSheet extends Sheet
{

	public JFrame frame;
	private JTextField txt_Age;
	private JTextField txt_Height;
	private JTextField txtLbs;
	private JTextField txtBulbous;
	private JTextField txtDamp;
	private JTextField txtBowlCut;

	/**
	 * Create the application.
	 */
	public DetailsSheet()
	{
		initialize();
		frame.setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\_BULK\\Image Resources\\dnd\\dnd_beyond.png"));
		frame.setBounds(100, 100, 800, 808);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[255.00][grow]"));
		
		JPanel panel_Header = new JPanel();
		frame.getContentPane().add(panel_Header, "cell 0 0,growx,aligny top");
		panel_Header.setLayout(new MigLayout("", "[][][][]", "[][]"));
		
		JLabel lbl_PFP = new JLabel("");
		lbl_PFP.setIcon(new ImageIcon("G:\\repos\\tools\\_Ideas\\DnD\\Morel, The Myconid\\morchella.png"));
		lbl_PFP.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Header.add(lbl_PFP, "cell 0 0 2 2,alignx center,aligny center");
		
		JPanel panel_NameClass = new JPanel();
		panel_Header.add(panel_NameClass, "flowx,cell 2 0,alignx left,aligny center");
		
		JLabel lbl_Name = new JLabel("Morchella, The Sovereign");
		lbl_Name.setHorizontalAlignment(SwingConstants.CENTER);
		panel_NameClass.add(lbl_Name);
		
		JLabel lbl_Class = new JLabel(":: Evocation Wizard");
		lbl_Class.setHorizontalAlignment(SwingConstants.CENTER);
		panel_NameClass.add(lbl_Class);
		
		JLabel lbl_Online = new JLabel("~ Online Now ~");
		lbl_Online.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Online.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		lbl_Online.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Header.add(lbl_Online, "cell 3 0,alignx center,aligny center");
		
		JPanel panel_Description = new JPanel();
		panel_Header.add(panel_Description, "cell 2 1,grow");
		panel_Description.setLayout(new MigLayout("", "[grow][grow]", "[][][][][][][grow]"));
		
		JLabel lbl_Age = new JLabel("Age:");
		panel_Description.add(lbl_Age, "cell 0 0,alignx trailing");
		
		txt_Age = new JTextField();
		txt_Age.setText("419");
		txt_Age.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Description.add(txt_Age, "cell 1 0,alignx center,aligny center");
		txt_Age.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Height:");
		panel_Description.add(lblNewLabel_2, "cell 0 1,alignx trailing");
		
		txt_Height = new JTextField();
		txt_Height.setText("7' 10\"");
		txt_Height.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Height.setColumns(10);
		panel_Description.add(txt_Height, "cell 1 1,alignx center");
		
		JLabel lbl_Weight = new JLabel("Weight:");
		panel_Description.add(lbl_Weight, "cell 0 2,alignx trailing,aligny bottom");
		
		txtLbs = new JTextField();
		txtLbs.setText("250 lbs");
		txtLbs.setHorizontalAlignment(SwingConstants.CENTER);
		txtLbs.setColumns(10);
		panel_Description.add(txtLbs, "cell 1 2,alignx center");
		
		JLabel lbl_Eyes = new JLabel("Eyes:");
		panel_Description.add(lbl_Eyes, "cell 0 3,alignx trailing");
		
		txtBulbous = new JTextField();
		txtBulbous.setText("Bulbous");
		txtBulbous.setHorizontalAlignment(SwingConstants.CENTER);
		txtBulbous.setColumns(10);
		panel_Description.add(txtBulbous, "cell 1 3,alignx center");
		
		JLabel lbl_Skin = new JLabel("Skin:");
		panel_Description.add(lbl_Skin, "cell 0 4,alignx trailing");
		
		txtDamp = new JTextField();
		txtDamp.setText("Damp");
		txtDamp.setHorizontalAlignment(SwingConstants.CENTER);
		txtDamp.setColumns(10);
		panel_Description.add(txtDamp, "cell 1 4,alignx center");
		
		JLabel lbl_Hair = new JLabel("Hair:");
		panel_Description.add(lbl_Hair, "cell 0 5,alignx trailing");
		
		txtBowlCut = new JTextField();
		txtBowlCut.setText("Bald");
		txtBowlCut.setHorizontalAlignment(SwingConstants.CENTER);
		txtBowlCut.setColumns(10);
		panel_Description.add(txtBowlCut, "cell 1 5,alignx center");
		
		JPanel panel = new JPanel();
		panel_Description.add(panel, "cell 0 6 2 1,grow");
		
		JLabel lbl_Good = new JLabel("Good: 40%");
		panel.add(lbl_Good);
		
		JLabel lbl_Neutral = new JLabel("Neutral: 40%");
		panel.add(lbl_Neutral);
		
		JLabel lbl_Evil = new JLabel("Racist: 20%");
		panel.add(lbl_Evil);
		
		JTextArea txtrShortAndSweet = new JTextArea();
		txtrShortAndSweet.setText("        Short and Sweet\r\n  ========================== \r\nOur spores collide\r\nand in sweet ecstasy \r\nwe meld,\r\nlooking deep in eachother's eyes.\r\n\r\nOur circle of two,\r\neven when death is due,\r\nwill meld onwards into life.\r\n--Psilofyr, 2:20");
		panel_Header.add(txtrShortAndSweet, "cell 3 1,grow");
		
		JTabbedPane tabs_Details = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabs_Details, "cell 0 1,grow");
		
		JTextArea area_AboutMe = new JTextArea();
		area_AboutMe.setText("== Personality ==\r\n- Easy-going, mute.\r\n\r\nLikes:\r\n\t- Long melds in the swamps.\r\n\t- The circle.\r\nDislikes:\r\n\t- Most underdark inhabitants\r\n\t- Violence\r\n\r\n== Ideals ==\r\n- The pursuit of self-deification is the only valid path for any magically-inclined being.\r\n- Meld is life.\r\n\r\n== Bonds ==\r\n- My circle <3\r\n- Praise Psilofyr\r\n\r\n== Flaws ==\r\n- Slight xenophobia\r\n- PTSD");
		tabs_Details.addTab("About Me", null, area_AboutMe, null);
		
		JTextArea area_Goals = new JTextArea();
		area_Goals.setText("The only thing I wish for is to unite all fellow Myconids under a single, grand\r\ncircle in order to meld, commune with Psilofyr, and ultimately ascend\r\nto Godhood.");
		tabs_Details.addTab("Goals", null, area_Goals, null);
		
		JTextArea area_Backstory = new JTextArea();
		tabs_Details.addTab("Backstory", null, area_Backstory, null);
		
		JPanel panel_XXX = new JPanel();
		tabs_Details.addTab("XXX Photos", null, panel_XXX, null);
		panel_XXX.setLayout(new MigLayout("", "[]", "[][]"));
		
		JLabel lbl_PayWall = new JLabel("");
		lbl_PayWall.setIcon(new ImageIcon("F:\\_BULK\\Image Resources\\dnd\\120x181_PayWall.png"));
		panel_XXX.add(lbl_PayWall, "cell 0 0,alignx center");
		
		JLabel lbl_PayPlease = new JLabel("To access explicit content, please consider donating [ Link ]");
		lbl_PayPlease.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_PayPlease.setHorizontalAlignment(SwingConstants.CENTER);
		panel_XXX.add(lbl_PayPlease, "cell 0 1");
	}
	
	
}
