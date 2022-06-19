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

public class CharacterSheet extends Sheet implements Sheet_Generics
{
	private final static int MAX_INSPIRATION = 10;
	@SuppressWarnings("rawtypes")
	JComboBox combo_DieSelector = null;
	
	
	
	// GUI
	public JFrame frmCharacterSheet;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
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
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;
	private JTextField textField_39;
	private JTextField textField_40;
	private JTextField textField_41;
	private JTextField textField_42;
	private JTextField textField_43;
	private JTextField textField_44;
	private JTextField textField_45;
	private JTextField textField_46;
	private JTextField textField_47;
	private JTextField textField_48;
	private JTextField textField_49;
	private JTextField textField_50;
	private JTextField textField_51;
	private JTextField textField_52;
	private JTextField textField_53;
	private JTextField textField_54;
	private JTextField textField_55;
	private JTextField textField_56;
	private JTextField textField_57;
	private JTextField textField_58;
	private JTextField textField_59;
	private JScrollPane scroll_Reactions;
	private JPanel panel_Reactions;
	private JLabel lbl_Reaction;
	private JLabel lbl_ActionRange_2;
	private JLabel lbl_ActionHit_2;
	private JLabel lbl_ActionDmg_2;
	private JLabel lbl_ActionDmgBonus_2;
	private JLabel lbl_ActionSavingThrow_2;
	private JTextField textField_60;
	private JTextField textField_61;
	private JTextField textField_62;
	private JTextField textField_63;
	private JTextField textField_64;
	private JTextField textField_65;
	private JTextField textField_66;
	private JTextField textField_67;
	private JTextField textField_68;
	private JTextField textField_69;
	private JTextField textField_70;
	private JTextField textField_71;
	private JTextField textField_72;
	private JTextField textField_73;
	private JTextField textField_74;
	private JTextField textField_75;
	private JTextField textField_76;
	private JTextField textField_77;
	private JTextField textField_78;
	private JTextField textField_79;
	private JTextField textField_80;
	private JTextField textField_81;
	private JTextField textField_82;
	private JTextField textField_83;
	private JTextField textField_84;
	private JTextField textField_85;
	private JTextField textField_86;
	private JTextField textField_87;
	private JTextField textField_88;
	private JTextField textField_89;
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
	private JLabel lbl_CurrentHealthVal;
	private JLabel lbl_MaxHealth;
	private JLabel lbl_MaxHealthVal;
	private JLabel lbl_TempHealth;
	private JLabel lbl_TempHealthVal;
	private JLabel lbl_HitDie;
	private JLabel lbl_HitDieValue;
	private JLabel lbl_DeathSaves;
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
		frmCharacterSheet = new JFrame();
		frmCharacterSheet.setUndecorated(true);
		frmCharacterSheet.setTitle("Character Sheet");
		frmCharacterSheet.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\_BULK\\Image Resources\\dnd\\dnd_beyond.png"));
		frmCharacterSheet.setBounds(100, 100, 827, 719);
		frmCharacterSheet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCharacterSheet.getContentPane().setLayout(new MigLayout("", "[grow,center][center][]", "[grow][]"));
		
		tabs_Header = new JTabbedPane(JTabbedPane.TOP);
		frmCharacterSheet.getContentPane().add(tabs_Header, "cell 0 0,grow");
		
		panel_Stats = new JPanel();
		tabs_Header.addTab("Stats", null, panel_Stats, null);
		panel_Stats.setLayout(new MigLayout("", "[][][][][]", "[][][][][][][][][][][]"));
		
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
		frmCharacterSheet.getContentPane().add(tabs_Actions, "cell 1 0 2 2,grow");
		
		JPanel panel_ActionsTab = new JPanel();
		tabs_Actions.addTab("Actions", null, panel_ActionsTab, null);
		panel_ActionsTab.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JPanel panel_ActionsContainer = new JPanel();
		panel_ActionsTab.add(panel_ActionsContainer, "cell 0 0,grow");
		panel_ActionsContainer.setLayout(new MigLayout("", "[grow][]", "[][][grow]"));
		
		JScrollPane scroll_Actions = new JScrollPane();
		panel_ActionsContainer.add(scroll_Actions, "cell 0 0,grow");
		
		JPanel panel_Actions = new JPanel();
		scroll_Actions.setViewportView(panel_Actions);
		panel_Actions.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow]", "[][][][][][]"));
		
		JLabel lbl_Actions = new JLabel("Action");
		lbl_Actions.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Actions.add(lbl_Actions, "cell 0 0,alignx center,aligny center");
		
		JLabel lbl_ActionRange = new JLabel("Range");
		lbl_ActionRange.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Actions.add(lbl_ActionRange, "cell 1 0,alignx center,aligny center");
		
		JLabel lbl_ActionHit = new JLabel("To Hit");
		lbl_ActionHit.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Actions.add(lbl_ActionHit, "cell 2 0,alignx center,aligny center");
		
		JLabel lbl_ActionDmg = new JLabel("Dmg");
		lbl_ActionDmg.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Actions.add(lbl_ActionDmg, "cell 3 0,alignx center,aligny center");
		
		JLabel lbl_ActionDmgBonus = new JLabel("Dmg Bonus");
		lbl_ActionDmgBonus.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Actions.add(lbl_ActionDmgBonus, "cell 4 0,alignx center,aligny center");
		
		JLabel lbl_ActionSavingThrow = new JLabel("Saving Throw");
		lbl_ActionSavingThrow.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Actions.add(lbl_ActionSavingThrow, "cell 5 0,alignx center,aligny center");
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Actions.add(textField, "cell 0 1,growx");
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Actions.add(textField_1, "cell 1 1,growx");
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Actions.add(textField_2, "cell 2 1,growx");
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Actions.add(textField_3, "cell 3 1,growx");
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Actions.add(textField_4, "cell 4 1,growx");
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Actions.add(textField_5, "cell 5 1,growx");
		textField_5.setColumns(10);
		
		textField_17 = new JTextField();
		textField_17.setHorizontalAlignment(SwingConstants.CENTER);
		textField_17.setColumns(10);
		panel_Actions.add(textField_17, "cell 0 2,growx");
		
		textField_16 = new JTextField();
		textField_16.setHorizontalAlignment(SwingConstants.CENTER);
		textField_16.setColumns(10);
		panel_Actions.add(textField_16, "cell 1 2,growx");
		
		textField_12 = new JTextField();
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setColumns(10);
		panel_Actions.add(textField_12, "cell 2 2,growx");
		
		textField_11 = new JTextField();
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setColumns(10);
		panel_Actions.add(textField_11, "cell 3 2,growx");
		
		textField_10 = new JTextField();
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setColumns(10);
		panel_Actions.add(textField_10, "cell 4 2,growx");
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setColumns(10);
		panel_Actions.add(textField_6, "cell 5 2,growx");
		
		textField_19 = new JTextField();
		textField_19.setHorizontalAlignment(SwingConstants.CENTER);
		textField_19.setColumns(10);
		panel_Actions.add(textField_19, "cell 0 3,growx");
		
		textField_21 = new JTextField();
		textField_21.setHorizontalAlignment(SwingConstants.CENTER);
		textField_21.setColumns(10);
		panel_Actions.add(textField_21, "cell 1 3,growx");
		
		textField_23 = new JTextField();
		textField_23.setHorizontalAlignment(SwingConstants.CENTER);
		textField_23.setColumns(10);
		panel_Actions.add(textField_23, "cell 2 3,growx");
		
		textField_14 = new JTextField();
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		textField_14.setColumns(10);
		panel_Actions.add(textField_14, "cell 3 3,growx");
		
		textField_13 = new JTextField();
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setColumns(10);
		panel_Actions.add(textField_13, "cell 4 3,growx");
		
		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setColumns(10);
		panel_Actions.add(textField_7, "cell 5 3,growx");
		
		textField_20 = new JTextField();
		textField_20.setHorizontalAlignment(SwingConstants.CENTER);
		textField_20.setColumns(10);
		panel_Actions.add(textField_20, "cell 0 4,growx");
		
		textField_22 = new JTextField();
		textField_22.setHorizontalAlignment(SwingConstants.CENTER);
		textField_22.setColumns(10);
		panel_Actions.add(textField_22, "cell 1 4,growx");
		
		textField_24 = new JTextField();
		textField_24.setHorizontalAlignment(SwingConstants.CENTER);
		textField_24.setColumns(10);
		panel_Actions.add(textField_24, "cell 2 4,growx");
		
		textField_25 = new JTextField();
		textField_25.setHorizontalAlignment(SwingConstants.CENTER);
		textField_25.setColumns(10);
		panel_Actions.add(textField_25, "cell 3 4,growx");
		
		textField_15 = new JTextField();
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setColumns(10);
		panel_Actions.add(textField_15, "cell 4 4,growx");
		
		textField_8 = new JTextField();
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setColumns(10);
		panel_Actions.add(textField_8, "cell 5 4,growx");
		
		textField_18 = new JTextField();
		textField_18.setHorizontalAlignment(SwingConstants.CENTER);
		textField_18.setColumns(10);
		panel_Actions.add(textField_18, "cell 0 5,growx");
		
		textField_26 = new JTextField();
		textField_26.setHorizontalAlignment(SwingConstants.CENTER);
		textField_26.setColumns(10);
		panel_Actions.add(textField_26, "cell 1 5,growx");
		
		textField_27 = new JTextField();
		textField_27.setHorizontalAlignment(SwingConstants.CENTER);
		textField_27.setColumns(10);
		panel_Actions.add(textField_27, "cell 2 5,growx");
		
		textField_28 = new JTextField();
		textField_28.setHorizontalAlignment(SwingConstants.CENTER);
		textField_28.setColumns(10);
		panel_Actions.add(textField_28, "cell 3 5,growx");
		
		textField_29 = new JTextField();
		textField_29.setHorizontalAlignment(SwingConstants.CENTER);
		textField_29.setColumns(10);
		panel_Actions.add(textField_29, "cell 4 5,growx");
		
		textField_9 = new JTextField();
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setColumns(10);
		panel_Actions.add(textField_9, "cell 5 5,growx");
		
		JScrollPane scroll_BonusActions = new JScrollPane();
		panel_ActionsContainer.add(scroll_BonusActions, "cell 0 1,grow");
		
		JPanel panel_BonusActions = new JPanel();
		scroll_BonusActions.setViewportView(panel_BonusActions);
		panel_BonusActions.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow]", "[][][][][][]"));
		
		JLabel lbl_BonusAction = new JLabel("Bonus Action");
		lbl_BonusAction.setHorizontalAlignment(SwingConstants.CENTER);
		panel_BonusActions.add(lbl_BonusAction, "cell 0 0,alignx center");
		
		JLabel lbl_ActionRange_1 = new JLabel("Range");
		lbl_ActionRange_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_BonusActions.add(lbl_ActionRange_1, "cell 1 0,alignx center");
		
		JLabel lbl_ActionHit_1 = new JLabel("To Hit");
		lbl_ActionHit_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_BonusActions.add(lbl_ActionHit_1, "cell 2 0,alignx center");
		
		JLabel lbl_ActionDmg_1 = new JLabel("Dmg");
		lbl_ActionDmg_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_BonusActions.add(lbl_ActionDmg_1, "cell 3 0,alignx center");
		
		JLabel lbl_ActionDmgBonus_1 = new JLabel("Dmg Bonus");
		lbl_ActionDmgBonus_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_BonusActions.add(lbl_ActionDmgBonus_1, "cell 4 0,alignx center");
		
		JLabel lbl_ActionSavingThrow_1 = new JLabel("Saving Throw");
		lbl_ActionSavingThrow_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_BonusActions.add(lbl_ActionSavingThrow_1, "cell 5 0,alignx center");
		
		textField_30 = new JTextField();
		textField_30.setHorizontalAlignment(SwingConstants.CENTER);
		panel_BonusActions.add(textField_30, "cell 0 1,alignx center");
		textField_30.setColumns(10);
		
		textField_31 = new JTextField();
		textField_31.setHorizontalAlignment(SwingConstants.CENTER);
		textField_31.setColumns(10);
		panel_BonusActions.add(textField_31, "cell 1 1,alignx center");
		
		textField_32 = new JTextField();
		textField_32.setHorizontalAlignment(SwingConstants.CENTER);
		textField_32.setColumns(10);
		panel_BonusActions.add(textField_32, "cell 2 1,alignx center");
		
		textField_33 = new JTextField();
		textField_33.setHorizontalAlignment(SwingConstants.CENTER);
		textField_33.setColumns(10);
		panel_BonusActions.add(textField_33, "cell 3 1,alignx center");
		
		textField_34 = new JTextField();
		textField_34.setHorizontalAlignment(SwingConstants.CENTER);
		textField_34.setColumns(10);
		panel_BonusActions.add(textField_34, "cell 4 1,alignx center");
		
		textField_35 = new JTextField();
		textField_35.setHorizontalAlignment(SwingConstants.CENTER);
		textField_35.setColumns(10);
		panel_BonusActions.add(textField_35, "cell 5 1,alignx center");
		
		textField_36 = new JTextField();
		textField_36.setHorizontalAlignment(SwingConstants.CENTER);
		textField_36.setColumns(10);
		panel_BonusActions.add(textField_36, "cell 0 2,alignx center");
		
		textField_37 = new JTextField();
		textField_37.setHorizontalAlignment(SwingConstants.CENTER);
		textField_37.setColumns(10);
		panel_BonusActions.add(textField_37, "cell 1 2,alignx center");
		
		textField_38 = new JTextField();
		textField_38.setHorizontalAlignment(SwingConstants.CENTER);
		textField_38.setColumns(10);
		panel_BonusActions.add(textField_38, "cell 2 2,alignx center");
		
		textField_39 = new JTextField();
		textField_39.setHorizontalAlignment(SwingConstants.CENTER);
		textField_39.setColumns(10);
		panel_BonusActions.add(textField_39, "cell 3 2,alignx center");
		
		textField_40 = new JTextField();
		textField_40.setHorizontalAlignment(SwingConstants.CENTER);
		textField_40.setColumns(10);
		panel_BonusActions.add(textField_40, "cell 4 2,alignx center");
		
		textField_41 = new JTextField();
		textField_41.setHorizontalAlignment(SwingConstants.CENTER);
		textField_41.setColumns(10);
		panel_BonusActions.add(textField_41, "cell 5 2,alignx center");
		
		textField_42 = new JTextField();
		textField_42.setHorizontalAlignment(SwingConstants.CENTER);
		textField_42.setColumns(10);
		panel_BonusActions.add(textField_42, "cell 0 3,alignx center");
		
		textField_43 = new JTextField();
		textField_43.setHorizontalAlignment(SwingConstants.CENTER);
		textField_43.setColumns(10);
		panel_BonusActions.add(textField_43, "cell 1 3,alignx center");
		
		textField_44 = new JTextField();
		textField_44.setHorizontalAlignment(SwingConstants.CENTER);
		textField_44.setColumns(10);
		panel_BonusActions.add(textField_44, "cell 2 3,alignx center");
		
		textField_45 = new JTextField();
		textField_45.setHorizontalAlignment(SwingConstants.CENTER);
		textField_45.setColumns(10);
		panel_BonusActions.add(textField_45, "cell 3 3,alignx center");
		
		textField_46 = new JTextField();
		textField_46.setHorizontalAlignment(SwingConstants.CENTER);
		textField_46.setColumns(10);
		panel_BonusActions.add(textField_46, "cell 4 3,alignx center");
		
		textField_47 = new JTextField();
		textField_47.setHorizontalAlignment(SwingConstants.CENTER);
		textField_47.setColumns(10);
		panel_BonusActions.add(textField_47, "cell 5 3,alignx center");
		
		textField_57 = new JTextField();
		textField_57.setHorizontalAlignment(SwingConstants.CENTER);
		panel_BonusActions.add(textField_57, "cell 0 4,alignx center");
		textField_57.setColumns(10);
		
		textField_56 = new JTextField();
		textField_56.setHorizontalAlignment(SwingConstants.CENTER);
		panel_BonusActions.add(textField_56, "cell 1 4,alignx center");
		textField_56.setColumns(10);
		
		textField_55 = new JTextField();
		textField_55.setHorizontalAlignment(SwingConstants.CENTER);
		panel_BonusActions.add(textField_55, "cell 2 4,alignx center");
		textField_55.setColumns(10);
		
		textField_50 = new JTextField();
		textField_50.setHorizontalAlignment(SwingConstants.CENTER);
		panel_BonusActions.add(textField_50, "cell 3 4,alignx center");
		textField_50.setColumns(10);
		
		textField_51 = new JTextField();
		textField_51.setHorizontalAlignment(SwingConstants.CENTER);
		panel_BonusActions.add(textField_51, "cell 4 4,alignx center");
		textField_51.setColumns(10);
		
		textField_52 = new JTextField();
		textField_52.setHorizontalAlignment(SwingConstants.CENTER);
		panel_BonusActions.add(textField_52, "cell 5 4,alignx center");
		textField_52.setColumns(10);
		
		textField_58 = new JTextField();
		textField_58.setHorizontalAlignment(SwingConstants.CENTER);
		panel_BonusActions.add(textField_58, "cell 0 5,alignx center");
		textField_58.setColumns(10);
		
		textField_59 = new JTextField();
		textField_59.setHorizontalAlignment(SwingConstants.CENTER);
		panel_BonusActions.add(textField_59, "cell 1 5,alignx center");
		textField_59.setColumns(10);
		
		textField_54 = new JTextField();
		textField_54.setHorizontalAlignment(SwingConstants.CENTER);
		panel_BonusActions.add(textField_54, "cell 2 5,alignx center");
		textField_54.setColumns(10);
		
		textField_53 = new JTextField();
		textField_53.setHorizontalAlignment(SwingConstants.CENTER);
		panel_BonusActions.add(textField_53, "cell 3 5,alignx center");
		textField_53.setColumns(10);
		
		textField_49 = new JTextField();
		textField_49.setHorizontalAlignment(SwingConstants.CENTER);
		panel_BonusActions.add(textField_49, "cell 4 5,alignx center");
		textField_49.setColumns(10);
		
		textField_48 = new JTextField();
		textField_48.setHorizontalAlignment(SwingConstants.CENTER);
		panel_BonusActions.add(textField_48, "cell 5 5,alignx center");
		textField_48.setColumns(10);
		
		scroll_Reactions = new JScrollPane();
		panel_ActionsContainer.add(scroll_Reactions, "cell 0 2,grow");
		
		panel_Reactions = new JPanel();
		scroll_Reactions.setViewportView(panel_Reactions);
		panel_Reactions.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow]", "[][][][][][]"));
		
		lbl_Reaction = new JLabel("Reaction");
		lbl_Reaction.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Reactions.add(lbl_Reaction, "cell 0 0,alignx center,aligny center");
		
		lbl_ActionRange_2 = new JLabel("Range");
		lbl_ActionRange_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Reactions.add(lbl_ActionRange_2, "cell 1 0,alignx center,aligny center");
		
		lbl_ActionHit_2 = new JLabel("To Hit");
		lbl_ActionHit_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Reactions.add(lbl_ActionHit_2, "cell 2 0,alignx center,aligny center");
		
		lbl_ActionDmg_2 = new JLabel("Dmg");
		lbl_ActionDmg_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Reactions.add(lbl_ActionDmg_2, "cell 3 0,alignx center,aligny center");
		
		lbl_ActionDmgBonus_2 = new JLabel("Dmg Bonus");
		lbl_ActionDmgBonus_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Reactions.add(lbl_ActionDmgBonus_2, "cell 4 0,alignx center,aligny center");
		
		lbl_ActionSavingThrow_2 = new JLabel("Saving Throw");
		lbl_ActionSavingThrow_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Reactions.add(lbl_ActionSavingThrow_2, "cell 5 0,alignx center,aligny center");
		
		textField_63 = new JTextField();
		textField_63.setHorizontalAlignment(SwingConstants.CENTER);
		textField_63.setColumns(10);
		panel_Reactions.add(textField_63, "cell 0 1,growx");
		
		textField_65 = new JTextField();
		textField_65.setHorizontalAlignment(SwingConstants.CENTER);
		textField_65.setColumns(10);
		panel_Reactions.add(textField_65, "cell 1 1,growx");
		
		textField_64 = new JTextField();
		textField_64.setHorizontalAlignment(SwingConstants.CENTER);
		textField_64.setColumns(10);
		panel_Reactions.add(textField_64, "cell 2 1,growx");
		
		textField_62 = new JTextField();
		textField_62.setHorizontalAlignment(SwingConstants.CENTER);
		textField_62.setColumns(10);
		panel_Reactions.add(textField_62, "cell 3 1,growx");
		
		textField_61 = new JTextField();
		textField_61.setHorizontalAlignment(SwingConstants.CENTER);
		textField_61.setColumns(10);
		panel_Reactions.add(textField_61, "cell 4 1,growx");
		
		textField_60 = new JTextField();
		textField_60.setHorizontalAlignment(SwingConstants.CENTER);
		textField_60.setColumns(10);
		panel_Reactions.add(textField_60, "cell 5 1,growx");
		
		textField_66 = new JTextField();
		textField_66.setHorizontalAlignment(SwingConstants.CENTER);
		textField_66.setColumns(10);
		panel_Reactions.add(textField_66, "cell 0 2,growx");
		
		textField_75 = new JTextField();
		textField_75.setHorizontalAlignment(SwingConstants.CENTER);
		textField_75.setColumns(10);
		panel_Reactions.add(textField_75, "cell 1 2,growx");
		
		textField_76 = new JTextField();
		textField_76.setHorizontalAlignment(SwingConstants.CENTER);
		textField_76.setColumns(10);
		panel_Reactions.add(textField_76, "cell 2 2,growx");
		
		textField_78 = new JTextField();
		textField_78.setHorizontalAlignment(SwingConstants.CENTER);
		textField_78.setColumns(10);
		panel_Reactions.add(textField_78, "cell 3 2,growx");
		
		textField_80 = new JTextField();
		textField_80.setHorizontalAlignment(SwingConstants.CENTER);
		textField_80.setColumns(10);
		panel_Reactions.add(textField_80, "cell 4 2,growx");
		
		textField_82 = new JTextField();
		textField_82.setHorizontalAlignment(SwingConstants.CENTER);
		textField_82.setColumns(10);
		panel_Reactions.add(textField_82, "cell 5 2,growx");
		
		textField_67 = new JTextField();
		textField_67.setHorizontalAlignment(SwingConstants.CENTER);
		textField_67.setColumns(10);
		panel_Reactions.add(textField_67, "cell 0 3,growx");
		
		textField_74 = new JTextField();
		textField_74.setHorizontalAlignment(SwingConstants.CENTER);
		textField_74.setColumns(10);
		panel_Reactions.add(textField_74, "cell 1 3,growx");
		
		textField_77 = new JTextField();
		textField_77.setHorizontalAlignment(SwingConstants.CENTER);
		textField_77.setColumns(10);
		panel_Reactions.add(textField_77, "cell 2 3,growx");
		
		textField_79 = new JTextField();
		textField_79.setHorizontalAlignment(SwingConstants.CENTER);
		textField_79.setColumns(10);
		panel_Reactions.add(textField_79, "cell 3 3,growx");
		
		textField_81 = new JTextField();
		textField_81.setHorizontalAlignment(SwingConstants.CENTER);
		textField_81.setColumns(10);
		panel_Reactions.add(textField_81, "cell 4 3,growx");
		
		textField_83 = new JTextField();
		textField_83.setHorizontalAlignment(SwingConstants.CENTER);
		textField_83.setColumns(10);
		panel_Reactions.add(textField_83, "cell 5 3,growx");
		
		textField_68 = new JTextField();
		textField_68.setHorizontalAlignment(SwingConstants.CENTER);
		textField_68.setColumns(10);
		panel_Reactions.add(textField_68, "cell 0 4,growx");
		
		textField_73 = new JTextField();
		textField_73.setHorizontalAlignment(SwingConstants.CENTER);
		textField_73.setColumns(10);
		panel_Reactions.add(textField_73, "cell 1 4,growx");
		
		textField_72 = new JTextField();
		textField_72.setHorizontalAlignment(SwingConstants.CENTER);
		textField_72.setColumns(10);
		panel_Reactions.add(textField_72, "cell 2 4,growx");
		
		textField_71 = new JTextField();
		textField_71.setHorizontalAlignment(SwingConstants.CENTER);
		textField_71.setColumns(10);
		panel_Reactions.add(textField_71, "cell 3 4,growx");
		
		textField_70 = new JTextField();
		textField_70.setHorizontalAlignment(SwingConstants.CENTER);
		textField_70.setColumns(10);
		panel_Reactions.add(textField_70, "cell 4 4,growx");
		
		textField_69 = new JTextField();
		textField_69.setHorizontalAlignment(SwingConstants.CENTER);
		textField_69.setColumns(10);
		panel_Reactions.add(textField_69, "cell 5 4,growx");
		
		textField_85 = new JTextField();
		textField_85.setHorizontalAlignment(SwingConstants.CENTER);
		textField_85.setColumns(10);
		panel_Reactions.add(textField_85, "cell 0 5,growx");
		
		textField_86 = new JTextField();
		textField_86.setHorizontalAlignment(SwingConstants.CENTER);
		textField_86.setColumns(10);
		panel_Reactions.add(textField_86, "cell 1 5,growx");
		
		textField_87 = new JTextField();
		textField_87.setHorizontalAlignment(SwingConstants.CENTER);
		textField_87.setColumns(10);
		panel_Reactions.add(textField_87, "cell 2 5,growx");
		
		textField_88 = new JTextField();
		textField_88.setHorizontalAlignment(SwingConstants.CENTER);
		textField_88.setColumns(10);
		panel_Reactions.add(textField_88, "cell 3 5,growx");
		
		textField_89 = new JTextField();
		textField_89.setHorizontalAlignment(SwingConstants.CENTER);
		textField_89.setColumns(10);
		panel_Reactions.add(textField_89, "cell 4 5,growx");
		
		textField_84 = new JTextField();
		textField_84.setHorizontalAlignment(SwingConstants.CENTER);
		textField_84.setColumns(10);
		panel_Reactions.add(textField_84, "cell 5 5,growx");
		
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
		frmCharacterSheet.getContentPane().add(panel_Skills, "cell 0 1,growx,aligny top");
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
	
	private static void update_CurrentHealth( int new_val )
	{
		
	}


	@Override
	public void ToggleEdits()
	{
		// TODO (Luis): Check if one textfield is editable, and set the rest accordingly
		
	}
}

