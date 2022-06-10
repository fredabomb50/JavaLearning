package dnd_gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.UIManager;
import java.util.HashMap;

public class CharacterSheet
{
	private final static int MAX_INSPIRATION = 10;
	
	// Utility Classes
	Math general_tools = new Math();
	Dice dice_tools = new Dice();
	
	// xp table for reference
	int[][] xp_table =
	{
		{0, 2}, 		// level 1
		{300, 2},		// level 2
		{900, 2},		// level 3
		{2700, 2},
		{6500, 3},
		{14000, 3},
		{23000, 3},
		{34000, 3},
		{48000, 4},
		{64000, 4},
		{85000, 4},
		{100000, 4},
		{120000, 5},
		{140000, 5},
		{165000, 5},
		{195000, 5},
		{225000, 6},
		{265000, 6},
		{305000, 6},
		{355000, 6}
	};
	
	
	private JFrame frmCharacterSheet;
	private JTextField txt_Experience;
	private JTextField txt_STR;
	private JTextField txt_DEX;
	private JTextField txt_CON;
	private JTextField txt_INT;
	private JTextField txt_WIS;
	private JTextField txt_CHR;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField txt_AC;
	private JTextField txt_Initiative;
	private JTextField txt_Speed;
	private JTextField txt_SwimSpeed;
	private JTextField txtDig;
	private JTextField txt_FlySpeed;
	private JTextField txt_Inspiration;
	private JTextField txt_Level;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CharacterSheet window = new CharacterSheet();
					window.frmCharacterSheet.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// SET UP A HASH MAP, OR SOME KIND OF STRUCTURE, FOR KEEPING PLAYER LEVEL, XP, AND PROFICIENCY VALUES TIED TOGETHER
	/**
	 * Create the application.
	 */
	public CharacterSheet() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCharacterSheet = new JFrame();
		frmCharacterSheet.setTitle("Character Sheet");
		frmCharacterSheet.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\_BULK\\Image Resources\\dnd\\dnd_beyond.png"));
		frmCharacterSheet.setBounds(100, 100, 765, 729);
		frmCharacterSheet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCharacterSheet.getContentPane().setLayout(new MigLayout("", "[center][center][]", "[center][center][grow,center]"));
		
		JPanel panel_Header = new JPanel();
		frmCharacterSheet.getContentPane().add(panel_Header, "cell 0 0,alignx center,growy");
		panel_Header.setLayout(new MigLayout("", "[center][grow,center][center][grow,center]", "[][center][][][][]"));
		
		JLabel lbl_Level = new JLabel("Level:");
		lbl_Level.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Header.add(lbl_Level, "cell 0 0,alignx center,aligny center");
		
		txt_Level = new JTextField();
		txt_Level.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Level.setText("1");
		txt_Level.setBackground(UIManager.getColor("CheckBoxMenuItem.background"));
		txt_Level.setEditable(false);
		panel_Header.add(txt_Level, "cell 1 0,alignx center,aligny center");
		txt_Level.setColumns(10);
		
		JLabel lbl_Proficiency = new JLabel("Proficiency Bonus:");
		panel_Header.add(lbl_Proficiency, "cell 2 0,alignx center,aligny center");
		
		textField_1 = new JTextField();
		textField_1.setText("2");
		textField_1.setBackground(UIManager.getColor("CheckBoxMenuItem.background"));
		textField_1.setEditable(false);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Header.add(textField_1, "cell 3 0,growx");
		textField_1.setColumns(10);
		
		JLabel lbl_Experience = new JLabel("Experience:");
		lbl_Experience.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Header.add(lbl_Experience, "cell 0 1,alignx center,aligny center");
		
		txt_Experience = new JTextField();
		txt_Experience.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Experience.setText("0");
		txt_Experience.setEditable(false);
		panel_Header.add(txt_Experience, "cell 1 1,grow");
		txt_Experience.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Inspiration:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Header.add(lblNewLabel, "cell 2 1,alignx center,aligny center");
		
		txt_Inspiration = new JTextField();
		txt_Inspiration.setEditable(false);
		txt_Inspiration.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Inspiration.setText("2");
		txt_Inspiration.setBackground(UIManager.getColor("CheckBoxMenuItem.background"));
		panel_Header.add(txt_Inspiration, "cell 3 1,growx");
		txt_Inspiration.setColumns(10);
		
		JLabel lbl_AC = new JLabel("Armor Class:");
		panel_Header.add(lbl_AC, "cell 0 2,alignx center,aligny center");
		
		txt_AC = new JTextField();
		txt_AC.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Header.add(txt_AC, "cell 1 2,growx");
		txt_AC.setColumns(10);
		
		JLabel lbl_SwimSpeed = new JLabel("Swim");
		panel_Header.add(lbl_SwimSpeed, "cell 2 2,alignx center,aligny center");
		
		txt_SwimSpeed = new JTextField();
		txt_SwimSpeed.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Header.add(txt_SwimSpeed, "cell 3 2,growx");
		txt_SwimSpeed.setColumns(10);
		
		JLabel lbl_Initiative = new JLabel("Initiative:");
		lbl_Initiative.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Header.add(lbl_Initiative, "cell 0 3,alignx center,aligny center");
		
		txt_Initiative = new JTextField();
		txt_Initiative.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Header.add(txt_Initiative, "cell 1 3,growx");
		txt_Initiative.setColumns(10);
		
		JLabel lbl_DigSpeed = new JLabel("Dig");
		panel_Header.add(lbl_DigSpeed, "cell 2 3,alignx center,aligny center");
		
		txtDig = new JTextField();
		txtDig.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Header.add(txtDig, "cell 3 3,growx");
		txtDig.setColumns(10);
		
		JLabel lbl_Speed = new JLabel("Speed:");
		lbl_Speed.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Header.add(lbl_Speed, "flowx,cell 0 4,alignx center,aligny center");
		
		txt_Speed = new JTextField();
		txt_Speed.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Header.add(txt_Speed, "cell 1 4,growx");
		txt_Speed.setColumns(10);
		
		JLabel lbl_FlySpeed = new JLabel("Fly");
		panel_Header.add(lbl_FlySpeed, "cell 2 4,alignx center,aligny center");
		
		txt_FlySpeed = new JTextField();
		txt_FlySpeed.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Header.add(txt_FlySpeed, "cell 3 4,growx");
		txt_FlySpeed.setColumns(10);
		
		JButton bttn_AddXP = new JButton("Add XP");
		panel_Header.add(bttn_AddXP, "cell 0 5,alignx center,aligny center");
		
		JButton bttn_AddInsp = new JButton("Add Insp.");
		bttn_AddInsp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				int val = Integer.parseInt( txt_Inspiration.getText() );
				val++;
				val = general_tools.ClampInt( val, 0, MAX_INSPIRATION );
				txt_Inspiration.setText( Integer.toString(val) );
			}
		});
		panel_Header.add(bttn_AddInsp, "cell 2 5,alignx center,aligny center");
		
		JButton bttn_BurnInsp = new JButton("Burn Insp.");
		bttn_BurnInsp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				int val = Integer.parseInt( txt_Inspiration.getText() );
				val--;
				val = general_tools.ClampInt( val, 0, MAX_INSPIRATION );
				txt_Inspiration.setText( Integer.toString(val) );
			}
		});
		panel_Header.add(bttn_BurnInsp, "cell 3 5,alignx center,aligny center");
		
		JPanel panel_Health = new JPanel();
		frmCharacterSheet.getContentPane().add(panel_Health, "cell 1 0,alignx center,growy");
		panel_Health.setLayout(new MigLayout("", "[center][grow][][]", "[][][][grow]"));
		
		JLabel lbl_CHealth = new JLabel("Current Health:");
		lbl_CHealth.setHorizontalAlignment(SwingConstants.LEFT);
		panel_Health.add(lbl_CHealth, "cell 0 0,alignx trailing");
		
		textField = new JTextField();
		textField.setText("100");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBackground(UIManager.getColor("ColorChooser.background"));
		textField.setEditable(false);
		panel_Health.add(textField, "cell 1 0,growx");
		textField.setColumns(10);
		
		JButton bttn_AddCurrentHealth = new JButton("+");
		panel_Health.add(bttn_AddCurrentHealth, "flowy,cell 2 0,alignx center");
		
		JButton bttn_SubCurrentHealth = new JButton("-");
		panel_Health.add(bttn_SubCurrentHealth, "cell 3 0,alignx center");
		
		JLabel lbl_MHealth = new JLabel("Max Health:");
		panel_Health.add(lbl_MHealth, "cell 0 1,alignx trailing");
		
		textField_2 = new JTextField();
		textField_2.setText("100");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setBackground(UIManager.getColor("ColorChooser.background"));
		textField_2.setEditable(false);
		panel_Health.add(textField_2, "cell 1 1,growx");
		textField_2.setColumns(10);
		
		JButton bttn_AddMaxHealth = new JButton("+");
		panel_Health.add(bttn_AddMaxHealth, "cell 2 1,alignx center");
		
		JButton bttn_SubMaxHealth = new JButton("-");
		panel_Health.add(bttn_SubMaxHealth, "cell 3 1,alignx center");
		
		JLabel lbl_THealth = new JLabel("Temp Health:");
		panel_Health.add(lbl_THealth, "cell 0 2,alignx trailing");
		
		textField_3 = new JTextField();
		textField_3.setText("10");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setBackground(UIManager.getColor("ColorChooser.background"));
		textField_3.setEditable(false);
		panel_Health.add(textField_3, "cell 1 2,growx");
		textField_3.setColumns(10);
		
		JButton bttn_AddTempHealth = new JButton("+");
		panel_Health.add(bttn_AddTempHealth, "cell 2 2,alignx center");
		
		JButton bttn_SubTempHealth = new JButton("-");
		panel_Health.add(bttn_SubTempHealth, "cell 3 2,alignx center");
		
		JLabel lbl_HDie = new JLabel("Hit Die:");
		panel_Health.add(lbl_HDie, "cell 0 3");
		
		JLabel lbl_HitDieLeft = new JLabel("5");
		lbl_HitDieLeft.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Health.add(lbl_HitDieLeft, "cell 1 3,alignx center");
		
		JButton bttn_ConsumeHitDie = new JButton("Use");
		panel_Health.add(bttn_ConsumeHitDie, "cell 2 3 2 1,alignx center,aligny center");
		
		JPanel panel_Stats = new JPanel();
		frmCharacterSheet.getContentPane().add(panel_Stats, "cell 2 0");
		panel_Stats.setLayout(new MigLayout("", "[center][][][][]", "[][][][][][][]"));
		
		JLabel lblNewLabel_3 = new JLabel("Stats");
		panel_Stats.add(lblNewLabel_3, "cell 0 0 2 1");
		
		JLabel lblNewLabel_2 = new JLabel("Saves");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lblNewLabel_2, "cell 3 0 2 1");
		
		JLabel lbl_Strength = new JLabel("Strength:");
		lbl_Strength.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lbl_Strength, "cell 0 1,grow");
		
		txt_STR = new JTextField();
		txt_STR.setHorizontalAlignment(SwingConstants.CENTER);
		txt_STR.setText("20");
		panel_Stats.add(txt_STR, "cell 1 1,grow");
		txt_STR.setColumns(10);
		
		JLabel lbl_STR = new JLabel("+5");
		lbl_STR.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lbl_STR, "cell 2 1,grow");
		
		JRadioButton rdbtnNewRadioButton_15 = new JRadioButton("");
		panel_Stats.add(rdbtnNewRadioButton_15, "cell 3 1");
		
		JLabel lbl_SaveCHR = new JLabel("+5");
		panel_Stats.add(lbl_SaveCHR, "cell 4 1");
		lbl_SaveCHR.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lbl_Dexterity = new JLabel("Dexterity:");
		lbl_Dexterity.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lbl_Dexterity, "cell 0 2,grow");
		
		txt_DEX = new JTextField();
		txt_DEX.setHorizontalAlignment(SwingConstants.CENTER);
		txt_DEX.setText("20");
		panel_Stats.add(txt_DEX, "cell 1 2,grow");
		txt_DEX.setColumns(10);
		
		JLabel lbl_DEX = new JLabel("+5");
		lbl_DEX.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lbl_DEX, "cell 2 2,grow");
		
		JRadioButton radio_Dexterity = new JRadioButton("");
		panel_Stats.add(radio_Dexterity, "flowx,cell 3 2");
		
		JLabel lbl_SaveCON = new JLabel("+5");
		panel_Stats.add(lbl_SaveCON, "cell 4 2");
		lbl_SaveCON.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lbl_Constitution = new JLabel("Constitution:");
		lbl_Constitution.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lbl_Constitution, "cell 0 3,grow");
		
		txt_CON = new JTextField();
		txt_CON.setHorizontalAlignment(SwingConstants.CENTER);
		txt_CON.setText("20");
		panel_Stats.add(txt_CON, "cell 1 3,grow");
		txt_CON.setColumns(10);
		
		JLabel lbl_CON = new JLabel("+5");
		lbl_CON.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lbl_CON, "cell 2 3,grow");
		
		JRadioButton radio_Constitution = new JRadioButton("");
		panel_Stats.add(radio_Constitution, "flowx,cell 3 3");
		
		JLabel lbl_SaveINT = new JLabel("+5");
		panel_Stats.add(lbl_SaveINT, "cell 4 3");
		lbl_SaveINT.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lbl_Intelligence = new JLabel("Intelligence:");
		lbl_Intelligence.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lbl_Intelligence, "cell 0 4,grow");
		
		txt_INT = new JTextField();
		txt_INT.setHorizontalAlignment(SwingConstants.CENTER);
		txt_INT.setText("20");
		panel_Stats.add(txt_INT, "cell 1 4,grow");
		txt_INT.setColumns(10);
		
		JLabel lbl_INT = new JLabel("+5");
		lbl_INT.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lbl_INT, "cell 2 4,grow");
		
		JRadioButton radio_Intelligence = new JRadioButton("");
		panel_Stats.add(radio_Intelligence, "flowx,cell 3 4");
		
		JLabel lbl_SaveWIS = new JLabel("+5");
		panel_Stats.add(lbl_SaveWIS, "cell 4 4");
		lbl_SaveWIS.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lbl_Wisdom = new JLabel("Wisdom:");
		lbl_Wisdom.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lbl_Wisdom, "cell 0 5,grow");
		
		txt_WIS = new JTextField();
		txt_WIS.setHorizontalAlignment(SwingConstants.CENTER);
		txt_WIS.setText("20");
		panel_Stats.add(txt_WIS, "cell 1 5,grow");
		txt_WIS.setColumns(10);
		
		JLabel lbl_WIS = new JLabel("+5");
		lbl_WIS.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lbl_WIS, "cell 2 5,grow");
		
		JRadioButton radio_Wisdom = new JRadioButton("");
		panel_Stats.add(radio_Wisdom, "flowx,cell 3 5");
		
		JLabel lbl_SaveDEX = new JLabel("+5");
		panel_Stats.add(lbl_SaveDEX, "cell 4 5");
		lbl_SaveDEX.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lbl_Charisma = new JLabel("Charisma:");
		lbl_Charisma.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lbl_Charisma, "cell 0 6,grow");
		
		txt_CHR = new JTextField();
		txt_CHR.setHorizontalAlignment(SwingConstants.CENTER);
		txt_CHR.setText("20");
		panel_Stats.add(txt_CHR, "cell 1 6,grow");
		txt_CHR.setColumns(10);
		
		JLabel lbl_CHR = new JLabel("+5");
		lbl_CHR.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lbl_CHR, "cell 2 6,grow");
		
		JRadioButton radio_Charisma = new JRadioButton("");
		panel_Stats.add(radio_Charisma, "flowx,cell 3 6");
		
		JLabel lbl_SaveDEX_1 = new JLabel("+5");
		lbl_SaveDEX_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lbl_SaveDEX_1, "cell 4 6");
		
		JPanel panel_Skills = new JPanel();
		frmCharacterSheet.getContentPane().add(panel_Skills, "cell 0 1 1 2,grow");
		panel_Skills.setLayout(new MigLayout("", "[left][]", "[][][][][][][][][][][][][][][][][][]"));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("(DEX) Acrobatics");
		panel_Skills.add(rdbtnNewRadioButton, "cell 0 0");
		
		textField_7 = new JTextField();
		textField_7.setText("5");
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(textField_7, "cell 1 0,alignx center");
		textField_7.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("(WIS) Insight");
		panel_Skills.add(rdbtnNewRadioButton_5, "cell 0 6");
		
		textField_13 = new JTextField();
		textField_13.setText("5");
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(textField_13, "cell 1 6,growx");
		textField_13.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("(INT) Animal Handling");
		panel_Skills.add(rdbtnNewRadioButton_1, "cell 0 1");
		
		textField_8 = new JTextField();
		textField_8.setText("5");
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(textField_8, "cell 1 1,growx");
		textField_8.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton_12_3 = new JRadioButton("(INT) Arcana");
		panel_Skills.add(rdbtnNewRadioButton_12_3, "flowy,cell 0 2");
		
		textField_9 = new JTextField();
		textField_9.setText("5");
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(textField_9, "cell 1 2,growx");
		textField_9.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("(CHR) Intimidation");
		panel_Skills.add(rdbtnNewRadioButton_6, "cell 0 7");
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("(STR) Athletics");
		panel_Skills.add(rdbtnNewRadioButton_2, "cell 0 3");
		
		textField_10 = new JTextField();
		textField_10.setText("5");
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(textField_10, "cell 1 3,growx");
		textField_10.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setText("5");
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setColumns(10);
		panel_Skills.add(textField_15, "cell 1 7,growx");
		
		JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("(INT) Investigation");
		panel_Skills.add(rdbtnNewRadioButton_7, "cell 0 8");
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("(CHR) Deception");
		panel_Skills.add(rdbtnNewRadioButton_3, "cell 0 4");
		
		textField_11 = new JTextField();
		textField_11.setText("5");
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(textField_11, "cell 1 4,growx");
		textField_11.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("(INT) History");
		panel_Skills.add(rdbtnNewRadioButton_4, "cell 0 5");
		
		textField_12 = new JTextField();
		textField_12.setText("5");
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(textField_12, "cell 1 5,growx");
		textField_12.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setText("5");
		textField_16.setHorizontalAlignment(SwingConstants.CENTER);
		textField_16.setColumns(10);
		panel_Skills.add(textField_16, "cell 1 8,growx");
		
		JRadioButton rdbtnNewRadioButton_8 = new JRadioButton("(WIS) Medicine");
		panel_Skills.add(rdbtnNewRadioButton_8, "cell 0 9");
		
		textField_17 = new JTextField();
		textField_17.setText("5");
		textField_17.setHorizontalAlignment(SwingConstants.CENTER);
		textField_17.setColumns(10);
		panel_Skills.add(textField_17, "cell 1 9,growx");
		
		JRadioButton rdbtnNewRadioButton_9 = new JRadioButton("(INT) Nature");
		panel_Skills.add(rdbtnNewRadioButton_9, "cell 0 10");
		
		textField_18 = new JTextField();
		textField_18.setText("5");
		textField_18.setHorizontalAlignment(SwingConstants.CENTER);
		textField_18.setColumns(10);
		panel_Skills.add(textField_18, "cell 1 10,growx");
		
		JRadioButton rdbtnNewRadioButton_10 = new JRadioButton("(WIS) Perception");
		panel_Skills.add(rdbtnNewRadioButton_10, "cell 0 11");
		
		textField_19 = new JTextField();
		textField_19.setText("5");
		textField_19.setHorizontalAlignment(SwingConstants.CENTER);
		textField_19.setColumns(10);
		panel_Skills.add(textField_19, "cell 1 11,growx");
		
		JRadioButton rdbtnNewRadioButton_11 = new JRadioButton("(CHR) Performance");
		panel_Skills.add(rdbtnNewRadioButton_11, "cell 0 12");
		
		textField_14 = new JTextField();
		textField_14.setText("5");
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(textField_14, "cell 1 12,growx");
		textField_14.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton_12 = new JRadioButton("(CHR) Persuasion");
		panel_Skills.add(rdbtnNewRadioButton_12, "cell 0 13");
		
		textField_20 = new JTextField();
		textField_20.setText("5");
		textField_20.setHorizontalAlignment(SwingConstants.CENTER);
		textField_20.setColumns(10);
		panel_Skills.add(textField_20, "cell 1 13,growx");
		
		JRadioButton rdbtnNewRadioButton_12_1 = new JRadioButton("(INT) Religion");
		panel_Skills.add(rdbtnNewRadioButton_12_1, "cell 0 14");
		
		textField_21 = new JTextField();
		textField_21.setText("5");
		textField_21.setHorizontalAlignment(SwingConstants.CENTER);
		textField_21.setColumns(10);
		panel_Skills.add(textField_21, "cell 1 14,growx");
		
		JRadioButton rdbtnNewRadioButton_12_2 = new JRadioButton("(DEX) Sleight of Hand");
		panel_Skills.add(rdbtnNewRadioButton_12_2, "cell 0 15");
		
		textField_22 = new JTextField();
		textField_22.setHorizontalAlignment(SwingConstants.CENTER);
		textField_22.setText("5");
		textField_22.setColumns(10);
		panel_Skills.add(textField_22, "cell 1 15,growx");
		
		JRadioButton rdbtnNewRadioButton_13 = new JRadioButton("(DEX) Stealth");
		panel_Skills.add(rdbtnNewRadioButton_13, "cell 0 16");
		
		textField_23 = new JTextField();
		textField_23.setText("5");
		textField_23.setHorizontalAlignment(SwingConstants.CENTER);
		textField_23.setColumns(10);
		panel_Skills.add(textField_23, "cell 1 16,growx");
		
		JRadioButton rdbtnNewRadioButton_14 = new JRadioButton("(WIS) Survival");
		panel_Skills.add(rdbtnNewRadioButton_14, "cell 0 17");
		
		textField_24 = new JTextField();
		textField_24.setText("5");
		textField_24.setHorizontalAlignment(SwingConstants.CENTER);
		textField_24.setColumns(10);
		panel_Skills.add(textField_24, "cell 1 17,growx");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmCharacterSheet.getContentPane().add(tabbedPane, "cell 1 1 2 2,grow");
		
		JPanel panel_ActionsTab = new JPanel();
		tabbedPane.addTab("Actions", null, panel_ActionsTab, null);
		panel_ActionsTab.setLayout(new MigLayout("", "[]", "[]"));
		
		JPanel panel_Proficiences = new JPanel();
		tabbedPane.addTab("Proficiencies", null, panel_Proficiences, null);
		panel_Proficiences.setLayout(new MigLayout("", "[]", "[]"));
	}
	
	
	public int GetIntFromTxt( JTextField txt_box)
	{
		int result = 0;
		
		Integer.parseInt( txt_box.getText() );
		
		return result;
	}
}

