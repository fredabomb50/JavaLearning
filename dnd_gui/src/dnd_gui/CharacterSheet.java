package dnd_gui;

import java.awt.EventQueue;
import java.lang.Math; 
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.DefaultComboBoxModel;
import dnd_gui.Dice.eDice;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.ScrollPaneConstants;

public class CharacterSheet extends Sheet implements Sheet_Generics
{
	private final static int MAX_INSPIRATION = 10;
	@SuppressWarnings("rawtypes")
	JComboBox combo_DieSelector = null;
	
	
	
	// GUI
	public JFrame frame;
	private JScrollPane scroll_Proficiences;
	private JTextArea area_Proficiences;
	private JScrollPane scroll_Adv;
	private JScrollPane scroll_Disadv;
	private JLabel lbl_Adv;
	private JLabel lbl_Disadv;
	private JTextArea area_Disadv;
	private JTextArea area_Adv;
	private JScrollPane scroll_Bonuses;
	private JTextArea area_Bonuses;
	private JLabel lbl_Acrobatics;
	private JLabel lbl_AcrobaticsProf;
	private JLabel lbl_AcrobaticsExpert;
	private JLabel lbl_AcrobaticsVal;
	private JLabel lbl_AnimalHandlingVal;
	private JLabel lbl_AnimalHandling;
	private JLabel lbl_Arcana;
	private JLabel lbl_Athletics;
	private JLabel lbl_Deception;
	private JLabel lbl_History;
	private JLabel lbl_Insight;
	private JLabel lbl_Intimidation;
	private JLabel lbl_Investigation;
	private JLabel lbl_Medicine;
	private JLabel lbl_Survival;
	private JLabel lbl_Stealth;
	private JLabel lbl_SleightOfHand;
	private JLabel lbl_Religion;
	private JLabel lbl_Persuasion;
	private JLabel lbl_Performance;
	private JLabel lbl_Perception;
	private JLabel lbl_Nature;
	private JLabel lbl_ArcanaVal;
	private JLabel lbl_AthleticsVal;
	private JLabel lbl_DeceptionVal;
	private JLabel lbl_HistoryVal;
	private JLabel lbl_InsightVal;
	private JLabel lbl_IntimidationVal;
	private JLabel lbl_InvestigationVal;
	private JLabel lbl_MedicineVal;
	private JLabel lbl_NatureVal;
	private JLabel lbl_PerceptionVal;
	private JLabel lbl_PerformanceVal;
	private JLabel lbl_PersuasionVal;
	private JLabel lbl_ReligionVal;
	private JLabel lbl_SleightOfHandVal;
	private JLabel lbl_StealthVal;
	private JLabel lbl_SurvivalVal;
	private JLabel lbl_AnimalHandlingProf;
	private JLabel lbl_ArcanaProf;
	private JLabel lbl_AthleticsProf;
	private JLabel lbl_DeceptionProf;
	private JLabel lbl_HistoryProf;
	private JLabel lbl_InsightProf;
	private JLabel lbl_IntimidationProf;
	private JLabel lbl_InvestigationProf;
	private JLabel lbl_MedicineProf;
	private JLabel lbl_NatureProf;
	private JLabel lbl_PerceptionProf;
	private JLabel lbl_PerformanceProf;
	private JLabel lbl_PersuasionProf;
	private JLabel lbl_ReligionProf;
	private JLabel lbl_SleightOfHandProf;
	private JLabel lbl_StealthProf;
	private JLabel lbl_SurvivalProf;
	private JLabel lbl_AnimalHandlingExpert;
	private JLabel lbl_ArcanaExpert;
	private JLabel lbl_AthleticsExpert;
	private JLabel lbl_DeceptionExpert;
	private JLabel lbl_HistoryExpert;
	private JLabel lbl_InsightExpert;
	private JLabel lbl_IntimidationExpert;
	private JLabel lbl_InvestigationExpert;
	private JLabel lbl_MedicineExpert;
	private JLabel lbl_NatureExpert;
	private JLabel lbl_PerceptionExpert;
	private JLabel lbl_PerformanceExpert;
	private JLabel lbl_PersuasionExpert;
	private JLabel lbl_ReligionExpert;
	private JLabel lbl_SleightOfHandExpert;
	private JLabel lbl_StealthExpert;
	private JLabel lbl_SurvivalExpert;
	private JTabbedPane tabs_Header;
	private JPanel panel_Stats;
	private JPanel panel_Health;
	private JLabel lbl_CurrentHealth;
	private static JLabel lbl_CurrentHealthVal;
	private JLabel lbl_MaxHealth;
	private static JLabel lbl_MaxHealthVal;
	private JLabel lbl_TempHealth;
	private static JLabel lbl_TempHealthVal;
	private JLabel lbl_HitDie;
	private static JLabel lbl_HitDieValue;
	private static JLabel lbl_DeathSaves;
	private JLabel lbl_SuccessfulDeathSaves;
	private JLabel lbl_FailedDeathSaves;
	private JRadioButton radio_sSave1;
	private JRadioButton radio_sSave2;
	private JRadioButton radio_sSave3;
	private JRadioButton radio_fSave1;
	private JRadioButton radio_fSave2;
	private JRadioButton radio_fSave3;
	private JLabel lblNewLabel;
	private JLabel lblStrSave;
	private JLabel lblConSave;
	private JLabel lblChrsave;
	private JLabel lblWisSave;
	private JLabel lbl_Int;
	private JLabel lbl_DexSave;
	private JLabel lbl_StrSave;
	private JLabel lbl_ConSave;
	private JLabel lbl_ChrSave;
	private JLabel lbl_WisSave;
	private JLabel lbl_IntSave;
	private JLabel lbl_DexSaveProf;
	private JLabel lbl_StrSaveProf;
	private JLabel lbl_ConSaveProf;
	private JLabel lbl_ChrSaveProf;
	private JLabel lbl_WisSaveProf;
	private JLabel lbl_IntSaveProf;
	private JLabel lblNewLabel_1;
	private JLabel lbl_Level;
	private JLabel lblNewLabel_2;
	private JLabel lbl_XP;
	private JLabel lblNewLabel_3;
	private JLabel lbl_AC;
	private JLabel lblNewLabel_4;
	private JLabel lbl_Initiative;
	private JLabel lblNewLabel_5;
	private JLabel lbl_ProfBonus;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lbl_DexMod;
	private JLabel lbl_StrMod;
	private JLabel lbl_ConMod;
	private JLabel lbl_WisMod;
	private JLabel lbl_IntMod;
	private JLabel lbl_ChrMod;
	private JLabel lbl_DexStat;
	private JLabel lbl_StrStat;
	private JLabel lbl_ConStat;
	private JLabel lbl_WisStat;
	private JLabel lbl_IntStat;
	private JLabel lbl_ChrStat;
	private JLabel lblNewLabel_12;
	private JLabel lbl_GroundSpeed;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_17;
	private JLabel lblNewLabel_18;
	private JLabel lbl_FlySpeed;
	private JLabel lblNewLabel_19;
	private JLabel lbl_SwimSpeed;
	private JLabel lblNewLabel_20;
	private JLabel lbl_DigSpeed;
	private JLabel lblNewLabel_21;
	private JLabel lbl_ClimbSpeed;
	private JTextArea area_Actions;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JTextArea textArea_2;
	private JTextArea textArea_3;
	private JLabel lblNewLabel_22;
	private JTextArea textArea_4;
	private JLabel lblNewLabel_23;
	private JTextArea textArea_5;
	private JLabel lbl_HitDieType;


	/**
	 * Create the application.
	 */
	public CharacterSheet()
	{
		initialize();
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Character Sheet");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\_BULK\\Image Resources\\dnd\\dnd_beyond.png"));
		frame.setBounds(100, 100, 830, 724);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[left][grow]", "[grow][]"));
		
		tabs_Header = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabs_Header, "cell 0 0,grow");
		
		panel_Stats = new JPanel();
		tabs_Header.addTab("Stats", null, panel_Stats, null);
		panel_Stats.setLayout(new MigLayout("", "[][][][][]", "[][][][][][][][][][][][][]"));
		
		lblNewLabel_1 = new JLabel("Level:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lblNewLabel_1, "cell 0 0");
		
		lbl_Level = new JLabel("5");
		lbl_Level.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lbl_Level, "cell 1 0,alignx center");
		
		lblNewLabel_2 = new JLabel("XP:");
		panel_Stats.add(lblNewLabel_2, "cell 3 0");
		
		lbl_XP = new JLabel("6500");
		panel_Stats.add(lbl_XP, "cell 4 0");
		
		lblNewLabel_3 = new JLabel("AC:");
		panel_Stats.add(lblNewLabel_3, "cell 0 1");
		
		lbl_AC = new JLabel("15");
		lbl_AC.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lbl_AC, "cell 1 1,alignx center");
		
		lblNewLabel_4 = new JLabel("Initiative:");
		panel_Stats.add(lblNewLabel_4, "cell 3 1");
		
		lbl_Initiative = new JLabel("2");
		panel_Stats.add(lbl_Initiative, "cell 4 1,alignx center");
		
		lblNewLabel_5 = new JLabel("Prof:");
		panel_Stats.add(lblNewLabel_5, "cell 0 2");
		
		lbl_ProfBonus = new JLabel("3");
		lbl_ProfBonus.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lbl_ProfBonus, "cell 1 2,alignx center");
		
		lblNewLabel_6 = new JLabel("Dexterity");
		panel_Stats.add(lblNewLabel_6, "cell 0 3");
		
		lbl_DexMod = new JLabel("500");
		lbl_DexMod.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lbl_DexMod, "cell 1 3,alignx center");
		
		lbl_DexStat = new JLabel("( 20 )");
		panel_Stats.add(lbl_DexStat, "cell 2 3,alignx center");
		
		lblNewLabel_7 = new JLabel("Strength");
		panel_Stats.add(lblNewLabel_7, "cell 0 4");
		
		lbl_StrMod = new JLabel("5");
		lbl_StrMod.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lbl_StrMod, "cell 1 4,alignx center");
		
		lbl_StrStat = new JLabel("( 20 )");
		panel_Stats.add(lbl_StrStat, "cell 2 4,alignx center");
		
		lblNewLabel_8 = new JLabel("Consitution");
		panel_Stats.add(lblNewLabel_8, "cell 0 5");
		
		lbl_ConMod = new JLabel("5");
		lbl_ConMod.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lbl_ConMod, "cell 1 5,alignx center");
		
		lbl_ConStat = new JLabel("( 20 )");
		panel_Stats.add(lbl_ConStat, "cell 2 5,alignx center");
		
		lblNewLabel_9 = new JLabel("Wisdom");
		panel_Stats.add(lblNewLabel_9, "cell 0 6");
		
		lbl_WisMod = new JLabel("5");
		lbl_WisMod.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lbl_WisMod, "cell 1 6,alignx center");
		
		lbl_WisStat = new JLabel("( 20 )");
		panel_Stats.add(lbl_WisStat, "cell 2 6,alignx center");
		
		lblNewLabel_10 = new JLabel("Intelligence");
		panel_Stats.add(lblNewLabel_10, "cell 0 7");
		
		lbl_IntMod = new JLabel("5");
		lbl_IntMod.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lbl_IntMod, "cell 1 7,alignx center");
		
		lbl_IntStat = new JLabel("( 20 )");
		panel_Stats.add(lbl_IntStat, "cell 2 7,alignx center");
		
		lblNewLabel_11 = new JLabel("Charisma");
		panel_Stats.add(lblNewLabel_11, "cell 0 8");
		
		lbl_ChrMod = new JLabel("5");
		lbl_ChrMod.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lbl_ChrMod, "cell 1 8,alignx center");
		
		lbl_ChrStat = new JLabel("( 20 )");
		panel_Stats.add(lbl_ChrStat, "cell 2 8,alignx center");
		
		lblNewLabel_12 = new JLabel("Walk:");
		panel_Stats.add(lblNewLabel_12, "cell 0 10");
		
		lbl_GroundSpeed = new JLabel("30");
		panel_Stats.add(lbl_GroundSpeed, "cell 1 10");
		
		lblNewLabel_13 = new JLabel("Fly:");
		panel_Stats.add(lblNewLabel_13, "cell 3 10");
		
		lbl_FlySpeed = new JLabel("30");
		panel_Stats.add(lbl_FlySpeed, "cell 4 10");
		
		lblNewLabel_19 = new JLabel("Swim: ");
		panel_Stats.add(lblNewLabel_19, "cell 0 11");
		
		lbl_SwimSpeed = new JLabel("30");
		panel_Stats.add(lbl_SwimSpeed, "cell 1 11");
		
		lblNewLabel_20 = new JLabel("Dig: ");
		panel_Stats.add(lblNewLabel_20, "cell 3 11");
		
		lbl_DigSpeed = new JLabel("30");
		panel_Stats.add(lbl_DigSpeed, "cell 4 11");
		
		lblNewLabel_21 = new JLabel("Climb:");
		panel_Stats.add(lblNewLabel_21, "cell 0 12");
		
		lbl_ClimbSpeed = new JLabel("30");
		panel_Stats.add(lbl_ClimbSpeed, "cell 1 12");
		
		panel_Health = new JPanel();
		tabs_Header.addTab("Health", null, panel_Health, null);
		panel_Health.setLayout(new MigLayout("", "[][][][]", "[][][][][][][][][][][][][][][]"));
		
		lbl_CurrentHealth = new JLabel("Current Health:");
		panel_Health.add(lbl_CurrentHealth, "cell 0 0,alignx center,aligny center");
		
		lbl_CurrentHealthVal = new JLabel("100");
		panel_Health.add(lbl_CurrentHealthVal, "cell 2 0,alignx center");
		
		lbl_MaxHealth = new JLabel("Max Health:");
		panel_Health.add(lbl_MaxHealth, "cell 0 1,alignx center,aligny center");
		
		lbl_MaxHealthVal = new JLabel("100");
		panel_Health.add(lbl_MaxHealthVal, "cell 2 1,alignx center");
		
		lbl_TempHealth = new JLabel("Temp Health:");
		lbl_TempHealth.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Health.add(lbl_TempHealth, "cell 0 2,alignx center,aligny center");
		
		lbl_TempHealthVal = new JLabel("10");
		panel_Health.add(lbl_TempHealthVal, "cell 2 2,alignx center");
		
		lbl_HitDie = new JLabel("Hit Die:");
		panel_Health.add(lbl_HitDie, "cell 0 3,alignx center,aligny center");
		
		lbl_HitDieValue = new JLabel("5/5");
		lbl_HitDieValue.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Health.add(lbl_HitDieValue, "cell 2 3,alignx center");
		
		lbl_HitDieType = new JLabel("(D6)");
		panel_Health.add(lbl_HitDieType, "cell 3 3");
		
		lbl_DeathSaves = new JLabel("--- Death Saving Throws ---");
		lbl_DeathSaves.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Health.add(lbl_DeathSaves, "cell 0 5 4 1,alignx center,aligny center");
		
		lbl_SuccessfulDeathSaves = new JLabel("Successful:");
		panel_Health.add(lbl_SuccessfulDeathSaves, "cell 0 6,alignx center,aligny center");
		
		radio_sSave1 = new JRadioButton("");
		panel_Health.add(radio_sSave1, "cell 1 6");
		
		radio_sSave2 = new JRadioButton("");
		panel_Health.add(radio_sSave2, "cell 2 6,alignx center");
		
		radio_sSave3 = new JRadioButton("");
		panel_Health.add(radio_sSave3, "cell 3 6");
		
		lbl_FailedDeathSaves = new JLabel("Failed:");
		lbl_FailedDeathSaves.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Health.add(lbl_FailedDeathSaves, "cell 0 7,alignx center");
		
		radio_fSave1 = new JRadioButton("");
		panel_Health.add(radio_fSave1, "cell 1 7");
		
		radio_fSave2 = new JRadioButton("");
		panel_Health.add(radio_fSave2, "cell 2 7,alignx center");
		
		radio_fSave3 = new JRadioButton("");
		panel_Health.add(radio_fSave3, "cell 3 7");
		
		lblNewLabel = new JLabel("DEX Save");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Health.add(lblNewLabel, "cell 0 9,alignx center");
		
		lbl_DexSave = new JLabel("[ 0 ]");
		lbl_DexSave.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Health.add(lbl_DexSave, "cell 1 9,alignx center");
		
		lbl_DexSaveProf = new JLabel("(Prof.)");
		lbl_DexSaveProf.setVisible(false);
		lbl_DexSaveProf.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Health.add(lbl_DexSaveProf, "cell 2 9");
		
		lblStrSave = new JLabel("STR Save");
		lblStrSave.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Health.add(lblStrSave, "cell 0 10,alignx center");
		
		lbl_StrSave = new JLabel("[ 0 ]");
		lbl_StrSave.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Health.add(lbl_StrSave, "cell 1 10");
		
		lbl_StrSaveProf = new JLabel("(Prof.)");
		lbl_StrSaveProf.setVisible(false);
		lbl_StrSaveProf.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Health.add(lbl_StrSaveProf, "cell 2 10");
		
		lblConSave = new JLabel("CON Save");
		lblConSave.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Health.add(lblConSave, "cell 0 11,alignx center");
		
		lbl_ConSave = new JLabel("[ 0 ]");
		lbl_ConSave.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Health.add(lbl_ConSave, "cell 1 11");
		
		lbl_ConSaveProf = new JLabel("(Prof.)");
		lbl_ConSaveProf.setVisible(false);
		lbl_ConSaveProf.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Health.add(lbl_ConSaveProf, "cell 2 11");
		
		lblChrsave = new JLabel("CHR Save");
		lblChrsave.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Health.add(lblChrsave, "cell 0 12,alignx center");
		
		lbl_ChrSave = new JLabel("[ 0 ]");
		lbl_ChrSave.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Health.add(lbl_ChrSave, "cell 1 12");
		
		lbl_ChrSaveProf = new JLabel("(Prof.)");
		lbl_ChrSaveProf.setVisible(false);
		lbl_ChrSaveProf.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Health.add(lbl_ChrSaveProf, "cell 2 12");
		
		lblWisSave = new JLabel("WIS Save");
		lblWisSave.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Health.add(lblWisSave, "cell 0 13,alignx center");
		
		lbl_WisSave = new JLabel("[ 0 ]");
		lbl_WisSave.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Health.add(lbl_WisSave, "cell 1 13");
		
		lbl_WisSaveProf = new JLabel("(Prof.)");
		lbl_WisSaveProf.setVisible(false);
		lbl_WisSaveProf.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Health.add(lbl_WisSaveProf, "cell 2 13");
		
		lbl_Int = new JLabel("INT Save");
		lbl_Int.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Health.add(lbl_Int, "cell 0 14,alignx center");
		
		lbl_IntSave = new JLabel("[ 0 ]");
		lbl_IntSave.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Health.add(lbl_IntSave, "cell 1 14");
		
		lbl_IntSaveProf = new JLabel("(Prof.)");
		lbl_IntSaveProf.setVisible(false);
		lbl_IntSaveProf.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Health.add(lbl_IntSaveProf, "cell 2 14");
		
		JTabbedPane tabs_Actions = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabs_Actions, "cell 1 0 1 2,grow");
		
		JPanel panel_ActionsTab = new JPanel();
		tabs_Actions.addTab("Actions", null, panel_ActionsTab, null);
		panel_ActionsTab.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow]", "[][grow]"));
		
		lblNewLabel_14 = new JLabel("Action");
		panel_ActionsTab.add(lblNewLabel_14, "cell 0 0,alignx center");
		
		lblNewLabel_15 = new JLabel("Range");
		panel_ActionsTab.add(lblNewLabel_15, "cell 1 0,alignx center");
		
		lblNewLabel_16 = new JLabel("Hit");
		panel_ActionsTab.add(lblNewLabel_16, "cell 2 0,alignx center");
		
		lblNewLabel_17 = new JLabel("Damage");
		panel_ActionsTab.add(lblNewLabel_17, "cell 3 0,alignx center");
		
		lblNewLabel_18 = new JLabel("Damage Bonus");
		panel_ActionsTab.add(lblNewLabel_18, "cell 4 0,alignx center");
		
		lblNewLabel_22 = new JLabel("Ammo");
		panel_ActionsTab.add(lblNewLabel_22, "cell 5 0,alignx center");
		
		lblNewLabel_23 = new JLabel("Misc.");
		panel_ActionsTab.add(lblNewLabel_23, "cell 6 0,alignx center");
		
		area_Actions = new JTextArea();
		panel_ActionsTab.add(area_Actions, "cell 0 1,grow");
		
		textArea = new JTextArea();
		panel_ActionsTab.add(textArea, "cell 1 1,grow");
		
		textArea_1 = new JTextArea();
		panel_ActionsTab.add(textArea_1, "cell 2 1,grow");
		
		textArea_2 = new JTextArea();
		panel_ActionsTab.add(textArea_2, "cell 3 1,grow");
		
		textArea_3 = new JTextArea();
		panel_ActionsTab.add(textArea_3, "cell 4 1,grow");
		
		textArea_4 = new JTextArea();
		panel_ActionsTab.add(textArea_4, "cell 5 1,grow");
		
		textArea_5 = new JTextArea();
		panel_ActionsTab.add(textArea_5, "cell 6 1,grow");
		
		JPanel panel_Proficiences = new JPanel();
		tabs_Actions.addTab("Proficiencies", null, panel_Proficiences, null);
		panel_Proficiences.setLayout(new GridLayout(1, 0, 0, 0));
		
		scroll_Proficiences = new JScrollPane();
		panel_Proficiences.add(scroll_Proficiences);
		
		area_Proficiences = new JTextArea();
		scroll_Proficiences.setViewportView(area_Proficiences);
		
		JPanel panel_Advantages = new JPanel();
		tabs_Actions.addTab("Adv/Disadv", null, panel_Advantages, null);
		panel_Advantages.setLayout(new MigLayout("", "[grow][grow]", "[grow]"));
		
		scroll_Adv = new JScrollPane();
		panel_Advantages.add(scroll_Adv, "cell 0 0,grow");
		
		lbl_Adv = new JLabel("Advantages");
		lbl_Adv.setHorizontalAlignment(SwingConstants.CENTER);
		scroll_Adv.setColumnHeaderView(lbl_Adv);
		
		area_Adv = new JTextArea();
		scroll_Adv.setViewportView(area_Adv);
		
		scroll_Disadv = new JScrollPane();
		panel_Advantages.add(scroll_Disadv, "cell 1 0,grow");
		
		lbl_Disadv = new JLabel("Disadvantages");
		lbl_Disadv.setHorizontalAlignment(SwingConstants.CENTER);
		scroll_Disadv.setColumnHeaderView(lbl_Disadv);
		
		area_Disadv = new JTextArea();
		scroll_Disadv.setViewportView(area_Disadv);
		
		JPanel panel_Bonuses = new JPanel();
		tabs_Actions.addTab("Bonuses", null, panel_Bonuses, null);
		panel_Bonuses.setLayout(new GridLayout(1, 1, 0, 0));
		
		scroll_Bonuses = new JScrollPane();
		panel_Bonuses.add(scroll_Bonuses);
		
		area_Bonuses = new JTextArea();
		scroll_Bonuses.setViewportView(area_Bonuses);
		
		JPanel panel_Skills = new JPanel();
		frame.getContentPane().add(panel_Skills, "cell 0 1,growx,aligny top");
		panel_Skills.setLayout(new MigLayout("", "[left][][][]", "[][][][][][][][][][][][][][][][][][]"));
		
		lbl_Acrobatics = new JLabel("(DEX) Acrobatics");
		lbl_Acrobatics.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_Acrobatics, "cell 0 0,alignx left,aligny center");
		
		lbl_AcrobaticsVal = new JLabel("[ 0 ]");
		lbl_AcrobaticsVal.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_AcrobaticsVal, "cell 1 0");
		
		lbl_AcrobaticsProf = new JLabel("(Prof.)");
		lbl_AcrobaticsProf.setVisible(false);
		lbl_AcrobaticsProf.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_AcrobaticsProf, "cell 2 0,alignx center,aligny center");
		
		lbl_AcrobaticsExpert = new JLabel("(Exp.)");
		lbl_AcrobaticsExpert.setVisible(false);
		lbl_AcrobaticsExpert.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_AcrobaticsExpert, "cell 3 0");
		
		lbl_AnimalHandling = new JLabel("(WIS) Animal Handling");
		lbl_AnimalHandling.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_AnimalHandling, "cell 0 1,alignx left,aligny center");
		
		lbl_AnimalHandlingVal = new JLabel("[ 0 ]");
		lbl_AnimalHandlingVal.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_AnimalHandlingVal, "cell 1 1");
		
		lbl_AnimalHandlingProf = new JLabel("(Prof.)");
		lbl_AnimalHandlingProf.setVisible(false);
		lbl_AnimalHandlingProf.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_AnimalHandlingProf, "cell 2 1");
		
		lbl_AnimalHandlingExpert = new JLabel("(Exp.)");
		lbl_AnimalHandlingExpert.setVisible(false);
		lbl_AnimalHandlingExpert.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_AnimalHandlingExpert, "cell 3 1");
		
		lbl_Arcana = new JLabel("(INT) Arcana");
		lbl_Arcana.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_Arcana, "cell 0 2,alignx left,aligny center");
		
		lbl_ArcanaVal = new JLabel("[ 0 ]");
		lbl_ArcanaVal.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_ArcanaVal, "cell 1 2");
		
		lbl_ArcanaProf = new JLabel("(Prof.)");
		lbl_ArcanaProf.setVisible(false);
		lbl_ArcanaProf.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_ArcanaProf, "cell 2 2");
		
		lbl_ArcanaExpert = new JLabel("(Exp.)");
		lbl_ArcanaExpert.setVisible(false);
		lbl_ArcanaExpert.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_ArcanaExpert, "cell 3 2");
		
		lbl_Athletics = new JLabel("(STR) Athletics");
		lbl_Athletics.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_Athletics, "cell 0 3");
		
		lbl_AthleticsVal = new JLabel("[ 0 ]");
		lbl_AthleticsVal.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_AthleticsVal, "cell 1 3");
		
		lbl_AthleticsProf = new JLabel("(Prof.)");
		lbl_AthleticsProf.setVisible(false);
		lbl_AthleticsProf.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_AthleticsProf, "cell 2 3");
		
		lbl_AthleticsExpert = new JLabel("(Exp.)");
		lbl_AthleticsExpert.setVisible(false);
		lbl_AthleticsExpert.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_AthleticsExpert, "cell 3 3");
		
		lbl_Deception = new JLabel("(CHR) Deception");
		lbl_Deception.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_Deception, "cell 0 4");
		
		lbl_DeceptionVal = new JLabel("[ 0 ]");
		lbl_DeceptionVal.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_DeceptionVal, "cell 1 4");
		
		lbl_DeceptionProf = new JLabel("(Prof.)");
		lbl_DeceptionProf.setVisible(false);
		lbl_DeceptionProf.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_DeceptionProf, "cell 2 4");
		
		lbl_DeceptionExpert = new JLabel("(Exp.)");
		lbl_DeceptionExpert.setVisible(false);
		lbl_DeceptionExpert.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_DeceptionExpert, "cell 3 4");
		
		lbl_History = new JLabel("(INT) History");
		lbl_History.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_History, "cell 0 5");
		
		lbl_HistoryVal = new JLabel("[ 0 ]");
		lbl_HistoryVal.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_HistoryVal, "cell 1 5");
		
		lbl_HistoryProf = new JLabel("(Prof.)");
		lbl_HistoryProf.setVisible(false);
		lbl_HistoryProf.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_HistoryProf, "cell 2 5");
		
		lbl_HistoryExpert = new JLabel("(Exp.)");
		lbl_HistoryExpert.setVisible(false);
		lbl_HistoryExpert.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_HistoryExpert, "cell 3 5");
		
		lbl_Insight = new JLabel("(WIS) Insight");
		lbl_Insight.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_Insight, "cell 0 6");
		
		lbl_InsightVal = new JLabel("[ 0 ]");
		lbl_InsightVal.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_InsightVal, "cell 1 6");
		
		lbl_InsightProf = new JLabel("(Prof.)");
		lbl_InsightProf.setVisible(false);
		lbl_InsightProf.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_InsightProf, "cell 2 6");
		
		lbl_InsightExpert = new JLabel("(Exp.)");
		lbl_InsightExpert.setVisible(false);
		lbl_InsightExpert.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_InsightExpert, "cell 3 6");
		
		lbl_Intimidation = new JLabel("(CHR) Intimidation");
		lbl_Intimidation.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_Intimidation, "cell 0 7");
		
		lbl_IntimidationVal = new JLabel("[ 0 ]");
		lbl_IntimidationVal.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_IntimidationVal, "cell 1 7");
		
		lbl_IntimidationProf = new JLabel("(Prof.)");
		lbl_IntimidationProf.setVisible(false);
		lbl_IntimidationProf.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_IntimidationProf, "cell 2 7");
		
		lbl_IntimidationExpert = new JLabel("(Exp.)");
		lbl_IntimidationExpert.setVisible(false);
		lbl_IntimidationExpert.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_IntimidationExpert, "cell 3 7");
		
		lbl_Investigation = new JLabel("(INT) Investigation");
		lbl_Investigation.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_Investigation, "cell 0 8");
		
		lbl_InvestigationVal = new JLabel("[ 0 ]");
		lbl_InvestigationVal.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_InvestigationVal, "cell 1 8");
		
		lbl_InvestigationProf = new JLabel("(Prof.)");
		lbl_InvestigationProf.setVisible(false);
		lbl_InvestigationProf.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_InvestigationProf, "cell 2 8");
		
		lbl_InvestigationExpert = new JLabel("(Exp.)");
		lbl_InvestigationExpert.setVisible(false);
		lbl_InvestigationExpert.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_InvestigationExpert, "cell 3 8");
		
		lbl_Medicine = new JLabel("(WIS) Medicine");
		lbl_Medicine.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_Medicine, "cell 0 9");
		
		lbl_MedicineVal = new JLabel("[ 0 ]");
		lbl_MedicineVal.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_MedicineVal, "cell 1 9");
		
		lbl_MedicineProf = new JLabel("(Prof.)");
		lbl_MedicineProf.setVisible(false);
		lbl_MedicineProf.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_MedicineProf, "cell 2 9");
		
		lbl_MedicineExpert = new JLabel("(Exp.)");
		lbl_MedicineExpert.setVisible(false);
		lbl_MedicineExpert.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_MedicineExpert, "cell 3 9");
		
		lbl_Nature = new JLabel("(INT) Nature");
		lbl_Nature.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_Nature, "cell 0 10");
		
		lbl_NatureVal = new JLabel("[ 0 ]");
		lbl_NatureVal.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_NatureVal, "cell 1 10");
		
		lbl_NatureProf = new JLabel("(Prof.)");
		lbl_NatureProf.setVisible(false);
		lbl_NatureProf.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_NatureProf, "cell 2 10");
		
		lbl_NatureExpert = new JLabel("(Exp.)");
		lbl_NatureExpert.setVisible(false);
		lbl_NatureExpert.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_NatureExpert, "cell 3 10");
		
		lbl_Perception = new JLabel("(WIS) Perception");
		lbl_Perception.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_Perception, "cell 0 11");
		
		lbl_PerceptionVal = new JLabel("[ 0 ]");
		lbl_PerceptionVal.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_PerceptionVal, "cell 1 11");
		
		lbl_PerceptionProf = new JLabel("(Prof.)");
		lbl_PerceptionProf.setVisible(false);
		lbl_PerceptionProf.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_PerceptionProf, "cell 2 11");
		
		lbl_PerceptionExpert = new JLabel("(Exp.)");
		lbl_PerceptionExpert.setVisible(false);
		lbl_PerceptionExpert.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_PerceptionExpert, "cell 3 11");
		
		lbl_Performance = new JLabel("(CHR) Performance");
		lbl_Performance.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_Performance, "cell 0 12");
		
		lbl_PerformanceVal = new JLabel("[ 0 ]");
		lbl_PerformanceVal.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_PerformanceVal, "cell 1 12");
		
		lbl_PerformanceProf = new JLabel("(Prof.)");
		lbl_PerformanceProf.setVisible(false);
		lbl_PerformanceProf.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_PerformanceProf, "cell 2 12");
		
		lbl_PerformanceExpert = new JLabel("(Exp.)");
		lbl_PerformanceExpert.setVisible(false);
		lbl_PerformanceExpert.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_PerformanceExpert, "cell 3 12");
		
		lbl_Persuasion = new JLabel("(CHR) Persuasion");
		lbl_Persuasion.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_Persuasion, "cell 0 13");
		
		lbl_PersuasionVal = new JLabel("[ 0 ]");
		lbl_PersuasionVal.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_PersuasionVal, "cell 1 13");
		
		lbl_PersuasionProf = new JLabel("(Prof.)");
		lbl_PersuasionProf.setVisible(false);
		lbl_PersuasionProf.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_PersuasionProf, "cell 2 13");
		
		lbl_PersuasionExpert = new JLabel("(Exp.)");
		lbl_PersuasionExpert.setVisible(false);
		lbl_PersuasionExpert.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_PersuasionExpert, "cell 3 13");
		
		lbl_Religion = new JLabel("(INT) Religion");
		lbl_Religion.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_Religion, "cell 0 14");
		
		lbl_ReligionVal = new JLabel("[ 0 ]");
		lbl_ReligionVal.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_ReligionVal, "cell 1 14");
		
		lbl_ReligionProf = new JLabel("(Prof.)");
		lbl_ReligionProf.setVisible(false);
		lbl_ReligionProf.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_ReligionProf, "cell 2 14");
		
		lbl_ReligionExpert = new JLabel("(Exp.)");
		lbl_ReligionExpert.setVisible(false);
		lbl_ReligionExpert.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_ReligionExpert, "cell 3 14");
		
		lbl_SleightOfHand = new JLabel("(DEX) Sleight Of Hand");
		lbl_SleightOfHand.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_SleightOfHand, "cell 0 15");
		
		lbl_SleightOfHandVal = new JLabel("[ 0 ]");
		lbl_SleightOfHandVal.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_SleightOfHandVal, "cell 1 15");
		
		lbl_SleightOfHandProf = new JLabel("(Prof.)");
		lbl_SleightOfHandProf.setVisible(false);
		lbl_SleightOfHandProf.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_SleightOfHandProf, "cell 2 15");
		
		lbl_SleightOfHandExpert = new JLabel("(Exp.)");
		lbl_SleightOfHandExpert.setVisible(false);
		lbl_SleightOfHandExpert.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_SleightOfHandExpert, "cell 3 15");
		
		lbl_Stealth = new JLabel("(DEX) Stealth");
		lbl_Stealth.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_Stealth, "cell 0 16");
		
		lbl_StealthVal = new JLabel("[ 0 ]");
		lbl_StealthVal.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_StealthVal, "cell 1 16");
		
		lbl_StealthProf = new JLabel("(Prof.)");
		lbl_StealthProf.setVisible(false);
		lbl_StealthProf.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_StealthProf, "cell 2 16");
		
		lbl_StealthExpert = new JLabel("(Exp.)");
		lbl_StealthExpert.setVisible(false);
		lbl_StealthExpert.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_StealthExpert, "cell 3 16");
		
		lbl_Survival = new JLabel("(WIS) Survival");
		lbl_Survival.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_Survival, "cell 0 17");
		
		lbl_SurvivalVal = new JLabel("[ 0 ]");
		lbl_SurvivalVal.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_SurvivalVal, "cell 1 17");
		
		lbl_SurvivalProf = new JLabel("(Prof.)");
		lbl_SurvivalProf.setVisible(false);
		lbl_SurvivalProf.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_SurvivalProf, "cell 2 17");
		
		lbl_SurvivalExpert = new JLabel("(Exp.)");
		lbl_SurvivalExpert.setVisible(false);
		lbl_SurvivalExpert.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(lbl_SurvivalExpert, "cell 3 17");
	}
	
	
	public void update_CurrentHealth( int new_val )
	{
		lbl_CurrentHealthVal.setText( Integer.toString( new_val ) );
	}
	public void update_MaxHealth( int new_val )
	{
		lbl_MaxHealthVal.setText( Integer.toString( new_val ) );
	}
	public void update_TempHealth( int new_val )
	{
		lbl_TempHealthVal.setText( Integer.toString( new_val ) );
	}
	public void update_HitDie( int new_val, int lvl )
	{
		lbl_HitDieValue.setText( Integer.toString( new_val ) + "/" + Integer.toString( lvl ) );
	}
	
	public void fill_Speed( int ground, int fly, int swim, int dig, int climb )
	{
		SetLabelText( lbl_GroundSpeed, ground );
		SetLabelText( lbl_FlySpeed, fly );
		SetLabelText( lbl_SwimSpeed, swim );
		SetLabelText( lbl_DigSpeed, dig );
		SetLabelText( lbl_ClimbSpeed, climb );
	}
	
	public void fill_Health( int current, int max, int temp, E_DieType die )
	{
		lbl_CurrentHealthVal.setText( Integer.toString( current ) );
		lbl_MaxHealthVal.setText( Integer.toString( max ) );
		lbl_TempHealthVal.setText( Integer.toString( temp ) );
		lbl_HitDieType.setText( die.toString() );
	}
	
	public void fill_Misc(int lvl, int xp, int prof,  int initiative, int ac)
	{		
		SetLabelText( lbl_Level, lvl );
		SetLabelText( lbl_XP, xp );
		SetLabelText( lbl_AC, ac );
		SetLabelText( lbl_Initiative, initiative );
		SetLabelText( lbl_ProfBonus, prof );
		
		lbl_HitDieValue.setText( Integer.toString( lvl ) + "/" + Integer.toString( lvl ) );
	}
	
	public void fill_Stats( HashMap<String, int[]> stat_values, HashMap<String, Boolean> save_prof )
	{
		boolean temp_bool = false;
		int temp_str[] = stat_values.get( "Str" );
		int temp_dex[] = stat_values.get( "Dex" );
		int temp_con[] = stat_values.get( "Con" );
		int temp_wis[] = stat_values.get( "Wis" );
		int temp_int[] = stat_values.get( "Int" );
		int temp_chr[] = stat_values.get( "Chr" );

		
		lbl_DexMod.setText( Integer.toString( temp_dex[1] ) );
		lbl_StrMod.setText( Integer.toString( temp_str[1] ) );
		lbl_ConMod.setText( Integer.toString( temp_con[1] ) );
		lbl_WisMod.setText( Integer.toString( temp_wis[1] ) );
		lbl_IntMod.setText( Integer.toString( temp_int[1] ) );
		lbl_ChrMod.setText( Integer.toString( temp_chr[1] ) );
		lbl_DexStat.setText( "[ " + Integer.toString( temp_dex[0] ) + " ]" );
		lbl_StrStat.setText( "[ " + Integer.toString( temp_str[0] ) + " ]" );
		lbl_ConStat.setText( "[ " + Integer.toString( temp_con[0] ) + " ]" );
		lbl_WisStat.setText( "[ " + Integer.toString( temp_wis[0] ) + " ]" );
		lbl_IntStat.setText( "[ " + Integer.toString( temp_int[0] ) + " ]" );
		lbl_ChrStat.setText( "[ " + Integer.toString( temp_chr[0] ) + " ]" );


		lbl_StrSave.setText( "[ " + Integer.toString( temp_dex[1] ) + " ]" );
		lbl_DexSave.setText( "[ " + Integer.toString( temp_str[1] ) + " ]" );
		lbl_ConSave.setText( "[ " + Integer.toString( temp_con[1] ) + " ]" );
		lbl_WisSave.setText( "[ " + Integer.toString( temp_wis[1] ) + " ]" );
		lbl_IntSave.setText( "[ " + Integer.toString( temp_int[1] ) + " ]" );
		lbl_ChrSave.setText( "[ " + Integer.toString( temp_chr[1] ) + " ]" );
		
		
		temp_bool = save_prof.get( "Str" );
		lbl_StrSaveProf.setVisible( temp_bool );
		
		temp_bool = save_prof.get( "Dex" );
		lbl_DexSaveProf.setVisible( temp_bool );
		
		temp_bool = save_prof.get( "Con" );
		lbl_ConSaveProf.setVisible( temp_bool );
		
		temp_bool = save_prof.get( "Wis" );
		lbl_WisSaveProf.setVisible( temp_bool );
		
		temp_bool = save_prof.get( "Int" );
		lbl_IntSaveProf.setVisible( temp_bool );
		
		temp_bool = save_prof.get( "Chr" );
		lbl_ChrSaveProf.setVisible( temp_bool );
	}

	
	public void fill_Skills( HashMap<String, Boolean> skills_IsProfEnabled, HashMap<String, Boolean> skills_IsExpertEnabled,
								HashMap<String, Integer> skills_ValMap, HashMap<String, Integer> skills_BonusMap )
	{
		lbl_AnimalHandlingVal.setText( Integer.toString( ( skills_ValMap.get( "AnimalHandling" ) + skills_BonusMap.get( "AnimalHandling" ) ) ) );
		lbl_AcrobaticsVal.setText( Integer.toString( ( skills_ValMap.get( "Acrobatics" ) + skills_BonusMap.get( "Acrobatics" ) ) ) );
		lbl_ArcanaVal.setText( Integer.toString( ( skills_ValMap.get( "Arcana" ) + skills_BonusMap.get( "Arcana" ) ) ) );
		lbl_AthleticsVal.setText( Integer.toString( ( skills_ValMap.get( "Athletics" ) + skills_BonusMap.get( "Athletics" ) ) ) );
		lbl_DeceptionVal.setText( Integer.toString( ( skills_ValMap.get( "Deception" ) + skills_BonusMap.get( "Deception" ) ) ) );
		lbl_HistoryVal.setText( Integer.toString( ( skills_ValMap.get( "History" ) + skills_BonusMap.get( "History" ) ) ) );
		lbl_InsightVal.setText( Integer.toString( ( skills_ValMap.get( "Insight" ) + skills_BonusMap.get( "Insight" ) ) ) );
		lbl_IntimidationVal.setText( Integer.toString( ( skills_ValMap.get( "Intimidation" ) + skills_BonusMap.get( "Intimidation" ) ) ) );
		lbl_InvestigationVal.setText( Integer.toString( ( skills_ValMap.get( "Investigation" ) + skills_BonusMap.get( "Investigation" ) ) ) );
		lbl_MedicineVal.setText( Integer.toString( ( skills_ValMap.get( "Medicine" ) + skills_BonusMap.get( "Medicine" ) ) ) );
		lbl_NatureVal.setText( Integer.toString( ( skills_ValMap.get( "Nature" ) + skills_BonusMap.get( "Nature" ) ) ) );
		lbl_PerceptionVal.setText( Integer.toString( ( skills_ValMap.get( "Perception" ) + skills_BonusMap.get( "Perception" ) ) ) );
		lbl_PerformanceVal.setText( Integer.toString( ( skills_ValMap.get( "Performance" ) + skills_BonusMap.get( "Performance" ) ) ) );
		lbl_PersuasionVal.setText( Integer.toString( ( skills_ValMap.get( "Persuasion" ) + skills_BonusMap.get( "Persuasion" ) ) ) );
		lbl_ReligionVal.setText( Integer.toString( ( skills_ValMap.get( "Religion" ) + skills_BonusMap.get( "Religion" ) ) ) );
		lbl_SleightOfHandVal.setText( Integer.toString( ( skills_ValMap.get( "SleightOfHand" ) + skills_BonusMap.get( "SleightOfHand" ) ) ) );
		lbl_StealthVal.setText( Integer.toString( ( skills_ValMap.get( "Stealth" ) + skills_BonusMap.get( "Stealth" ) ) ) );
		lbl_SurvivalVal.setText( Integer.toString( ( skills_ValMap.get( "Survival" ) + skills_BonusMap.get( "Survival" ) ) ) );

		lbl_AnimalHandlingProf.setVisible( skills_IsProfEnabled.get( "AnimalHandling" ) );
		lbl_AcrobaticsProf.setVisible( skills_IsProfEnabled.get( "Acrobatics" ) );
		lbl_ArcanaProf.setVisible( skills_IsProfEnabled.get( "Arcana" ) );
		lbl_AthleticsProf.setVisible( skills_IsProfEnabled.get( "Athletics" ) );
		lbl_DeceptionProf.setVisible( skills_IsProfEnabled.get( "Deception" ) );
		lbl_HistoryProf.setVisible( skills_IsProfEnabled.get( "History" ) );
		lbl_InsightProf.setVisible( skills_IsProfEnabled.get( "Insight" ) );
		lbl_IntimidationProf.setVisible( skills_IsProfEnabled.get( "Intimidation" ) );
		lbl_InvestigationProf.setVisible( skills_IsProfEnabled.get( "Investigation" ) );
		lbl_MedicineProf.setVisible( skills_IsProfEnabled.get( "Medicine" ) );
		lbl_NatureProf.setVisible( skills_IsProfEnabled.get( "Nature" ) );
		lbl_PerceptionProf.setVisible( skills_IsProfEnabled.get( "Perception" ) );
		lbl_PerformanceProf.setVisible( skills_IsProfEnabled.get( "Performance" ) );
		lbl_PersuasionProf.setVisible( skills_IsProfEnabled.get( "Persuasion" ) );
		lbl_ReligionProf.setVisible( skills_IsProfEnabled.get( "Religion" ) );
		lbl_SleightOfHandProf.setVisible( skills_IsProfEnabled.get( "SleightOfHand" ) );
		lbl_StealthProf.setVisible( skills_IsProfEnabled.get( "Stealth" ) );
		lbl_SurvivalProf.setVisible( skills_IsProfEnabled.get( "Survival" ) );

		lbl_AnimalHandlingExpert.setVisible( skills_IsExpertEnabled.get( "AnimalHandling" ) );
		lbl_AcrobaticsExpert.setVisible( skills_IsExpertEnabled.get( "Acrobatics" ) );
		lbl_ArcanaExpert.setVisible( skills_IsExpertEnabled.get( "Arcana" ) );
		lbl_AthleticsExpert.setVisible( skills_IsExpertEnabled.get( "Athletics" ) );
		lbl_DeceptionExpert.setVisible( skills_IsExpertEnabled.get( "Deception" ) );
		lbl_HistoryExpert.setVisible( skills_IsExpertEnabled.get( "History" ) );
		lbl_InsightExpert.setVisible( skills_IsExpertEnabled.get( "Insight" ) );
		lbl_IntimidationExpert.setVisible( skills_IsExpertEnabled.get( "Intimidation" ) );
		lbl_InvestigationExpert.setVisible( skills_IsExpertEnabled.get( "Investigation" ) );
		lbl_MedicineExpert.setVisible( skills_IsExpertEnabled.get( "Medicine" ) );
		lbl_NatureExpert.setVisible( skills_IsExpertEnabled.get( "Nature" ) );
		lbl_PerceptionExpert.setVisible( skills_IsExpertEnabled.get( "Perception" ) );
		lbl_PerformanceExpert.setVisible( skills_IsExpertEnabled.get( "Performance" ) );
		lbl_PersuasionExpert.setVisible( skills_IsExpertEnabled.get( "Persuasion" ) );
		lbl_ReligionExpert.setVisible( skills_IsExpertEnabled.get( "Religion" ) );
		lbl_SleightOfHandExpert.setVisible( skills_IsExpertEnabled.get( "SleightOfHand" ) );
		lbl_StealthExpert.setVisible( skills_IsExpertEnabled.get( "Stealth" ) );
		lbl_SurvivalExpert.setVisible( skills_IsExpertEnabled.get( "Survival" ) );
	}
	
	
	@Override
	public void ToggleEdits()
	{
		// TODO (Luis): Check if one textfield is editable, and set the rest accordingly
		
	}
}

