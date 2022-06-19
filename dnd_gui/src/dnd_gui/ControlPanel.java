package dnd_gui;

import java.awt.EventQueue;
import javax.swing.*;
import java.util.HashMap;
import java.awt.Toolkit;
import net.miginfocom.swing.MigLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ControlPanel
{
	// Utility classes
	Tools general_tools = new Tools();
	Dice dice_tools = new Dice();
	
	// add a toggle that unlocks core stats for editing, and maybe a refresh function to make sure all relevant stats update
	
	
	// CORE STATS
	private static int strength = 0;
	private static int str_mod = 0;
	private static int dexterity = 0;
	private static int dex_mod = 0;
	private static int consititution = 0;
	private static int con_mod = 0;
	private static int intelligence = 0;
	private static int int_mod = 0;
	private static int wisdom = 0;
	private static int wis_mod = 0;
	private static int charisma = 0;
	private static int chr_mod = 0;
	
	private static int speed_Ground = 0;
	private static int speed_Swim = 0;
	private static int speed_Fly = 0;
	private static int speed_Dig = 0;
	private static int speed_Climb = 0;
			
	private static int initiative = 0;
	private static int armor_class = 0;
	
	private static int health_Current = 0;
	private static int health_Max = 0;
	private static int health_Temp = 0;
	
	private static int hitdie_Current = 0;
	private static int hitdie_Max = 0;
	private static E_DieType current_HitDie = null;
	
	private static HashMap<String, Boolean> skills_IsProfEnabled = new HashMap<String, Boolean>();
	private static HashMap<String, Integer> skills_ValMap = new HashMap<String, Integer>();
	private static HashMap<String, Integer> skills_BonusMap = new HashMap<String, Integer>();
	
	private static int current_xp = 0;
	private static int current_lvl = 0;
	private static int current_Proficiency = 0;
	private static final int[][] xp_table =
	{
		{0, 2}, 		// level 1
		{300, 2},		// level 2
		{900, 2},		// level 3
		{2700, 2},		// level 4
		{6500, 3},		// level 5
		{14000, 3},		// level 6
		{23000, 3},		// level 7
		{34000, 3},		// level 8
		{48000, 4},		// level 9
		{64000, 4},		// level 10
		{85000, 4},		// level 11
		{100000, 4},	// level 12
		{120000, 5},	// level 13
		{140000, 5},	// level 14
		{165000, 5},	// level 15
		{195000, 5},	// level 16
		{225000, 6},	// level 17
		{265000, 6},	// level 18
		{305000, 6},	// level 19
		{355000, 6}		// level 20
	};
	

	// GUI sheets
	private static CharacterSheet c_Sheet = null;
	private static DetailsSheet d_Sheet = null;
	
	
	// GUI elements
	private JFrame frame;

	
	
	// interact process goes as such:
	// gui is initialized, loading a save file (json)
	// player clicks button on control panel
	// prompts user for value, passes back into method that called it
	// calls Update interface method from c_sheet 
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					ControlPanel window = new ControlPanel();
					window.frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}


	public ControlPanel()
	{
		init_stats();
		initialize();
		init_sheets();
	}


	// Builds GUI and button functionality
	private void initialize()
	{
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\_BULK\\Image Resources\\dnd\\dnd_beyond.png"));
		frame.setBounds(100, 100, 550, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][][]"));
		
		JPanel panel_HealthControls = new JPanel();
		frame.getContentPane().add(panel_HealthControls, "cell 0 0,alignx center,aligny center");
		panel_HealthControls.setLayout(new MigLayout("", "[][][][][][]", "[][][]"));
		
		JButton bttn_Heal = new JButton("Heal Health");
		panel_HealthControls.add(bttn_Heal, "cell 0 1,grow");
		
		JButton bttn_Hurt = new JButton("Hurt Health");
		panel_HealthControls.add(bttn_Hurt, "cell 1 1,grow");
		
		JButton bttn_AddMaxHealth = new JButton("Add Max Health");
		panel_HealthControls.add(bttn_AddMaxHealth, "cell 2 1,grow");
		
		JButton bttn_AddTempHealth = new JButton("Add Temp Health");
		panel_HealthControls.add(bttn_AddTempHealth, "cell 3 1,grow");
		
		JButton bttn_HitDie = new JButton("Use Hit Die");
		panel_HealthControls.add(bttn_HitDie, "cell 4 1,grow");
		
		JPanel panel_GenericControls = new JPanel();
		frame.getContentPane().add(panel_GenericControls, "cell 0 1,alignx center,aligny center");
		panel_GenericControls.setLayout(new MigLayout("", "[][][][][]", "[][][]"));
		
		JButton bttn_LongRest = new JButton("Long Rest");
		panel_GenericControls.add(bttn_LongRest, "cell 0 1,grow");
		
		JButton bttn_AddXP = new JButton("Gain Xp");
		panel_GenericControls.add(bttn_AddXP, "cell 1 1,grow");
		
		JButton bttn_ToggleVantage = new JButton("Toggle Adv/Disadv");
		panel_GenericControls.add(bttn_ToggleVantage, "cell 2 1,grow");
		
		JButton bttn_ToggleProf = new JButton("Toggle Prof.");
		panel_GenericControls.add(bttn_ToggleProf, "cell 3 1,grow");
		
		JButton bttn_AddInsp = new JButton("Gain Insp.");
		panel_GenericControls.add(bttn_AddInsp, "cell 4 1,grow");
		
		JButton bttn_ShortRest = new JButton("Short Rest");
		panel_GenericControls.add(bttn_ShortRest, "cell 0 2,grow");
		
		JButton bttn_BurnInsp = new JButton("Burn Insp.");
		panel_GenericControls.add(bttn_BurnInsp, "cell 4 2,grow");
		
		JPanel panel_InventoryControls = new JPanel();
		frame.getContentPane().add(panel_InventoryControls, "cell 0 2,alignx center,aligny center");
		panel_InventoryControls.setLayout(new MigLayout("", "[][][][]", "[]"));
		
		JButton bttn_AddMoney = new JButton("Add Money");
		panel_InventoryControls.add(bttn_AddMoney, "cell 0 0,grow");
		
		JButton bttn_SpendMoney = new JButton("Spend Money");
		panel_InventoryControls.add(bttn_SpendMoney, "cell 1 0,grow");
		
		JButton bttn_AddItem = new JButton("Add Item");
		panel_InventoryControls.add(bttn_AddItem, "cell 2 0,grow");
		
		JButton bttn_RemoveItem = new JButton("Remove Item");
		panel_InventoryControls.add(bttn_RemoveItem, "cell 3 0,grow");
		
		JPanel panel_Sheets = new JPanel();
		frame.getContentPane().add(panel_Sheets, "cell 0 3,alignx center,aligny center");
		panel_Sheets.setLayout(new MigLayout("", "[][][][][]", "[]"));
		
		JButton bttn_CSheet = new JButton("Character Sheet");
		bttn_CSheet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				c_Sheet.ToggleVisibility(c_Sheet.frmCharacterSheet);
				d_Sheet.ToggleVisibility(false);
			}
		});
		panel_Sheets.add(bttn_CSheet, "cell 0 0,grow");
		
		JButton bttn_SSheet = new JButton("Spell Sheet");
		panel_Sheets.add(bttn_SSheet, "cell 1 0,grow");
		
		JButton bttn_DSheet = new JButton("Character Details");
		panel_Sheets.add(bttn_DSheet, "cell 2 0,grow");
		
		JButton bttn_Inventory = new JButton("Inventory");
		panel_Sheets.add(bttn_Inventory, "cell 3 0,grow");
		
		JButton bttn_Notes = new JButton("Notes");
		panel_Sheets.add(bttn_Notes, "cell 4 0,grow");
	}

	
	// NOTE (Luis): should ultimately use a json loading class to save and load player data
	private static void init_stats()
	{
		
		current_lvl = 5;
		current_xp = 6500;
		current_Proficiency = 3;
		
		strength = 20;
		str_mod = ( strength - 10 ) / 2;
		dexterity = 20;
		dex_mod = ( dexterity - 10 ) / 2;
		consititution = 20;
		con_mod = ( consititution - 10 ) / 2;
		intelligence = 20;
		int_mod = ( intelligence - 10 ) / 2;
		wisdom = 20;
		wis_mod = ( wisdom - 10 ) / 2;
		charisma = 20;
		chr_mod = ( charisma - 10 ) / 2;
		
		
		speed_Ground = 35;
		speed_Swim = 35;
		speed_Fly = 35;
		speed_Dig = 35;
		speed_Climb = 35;

		initiative = dex_mod;
		armor_class = 15 + dex_mod;

		health_Current = 100;
		health_Max = 100;
		health_Temp = 15;
		hitdie_Current = current_lvl;
		hitdie_Max = current_lvl;
		current_HitDie = E_DieType.D6;
		
		
//		HashMap<String, Boolean> skills_ProfMap = new HashMap<String, Boolean>();
		skills_IsProfEnabled.put("Acrobatics", false);
		skills_IsProfEnabled.put("AnimalHandling", false);
		skills_IsProfEnabled.put("Arcana", false);
		skills_IsProfEnabled.put("Athletics", false);
		skills_IsProfEnabled.put("Deception", false);
		skills_IsProfEnabled.put("History", false);
		skills_IsProfEnabled.put("Insight", false);
		skills_IsProfEnabled.put("Performance", false);
		skills_IsProfEnabled.put("Intimidation", false);
		skills_IsProfEnabled.put("Investigation", false);
		skills_IsProfEnabled.put("Medicine", false);
		skills_IsProfEnabled.put("Nature", false);
		skills_IsProfEnabled.put("Perception", false);
		skills_IsProfEnabled.put("Persuasion", false);
		skills_IsProfEnabled.put("Religion", false);
		skills_IsProfEnabled.put("SleightOfHand", false);
		skills_IsProfEnabled.put("Stealth", false);
		skills_IsProfEnabled.put("Survival", false);
		
//		HashMap<String, Integer> skills_ValMap = new HashMap<String, Integer>();
		skills_ValMap.put("Acrobatics", dex_mod);
		skills_ValMap.put("AnimalHandling", wis_mod);
		skills_ValMap.put("Arcana", int_mod);
		skills_ValMap.put("Athletics", str_mod);
		skills_ValMap.put("Deception", chr_mod);
		skills_ValMap.put("History", int_mod);
		skills_ValMap.put("Insight", wis_mod);
		skills_ValMap.put("Performance", chr_mod);
		skills_ValMap.put("Intimidation", chr_mod);
		skills_ValMap.put("Investigation", int_mod);
		skills_ValMap.put("Medicine", wis_mod);
		skills_ValMap.put("Nature", int_mod);
		skills_ValMap.put("Perception", wis_mod);
		skills_ValMap.put("Persuasion", chr_mod);
		skills_ValMap.put("Religion", int_mod);
		skills_ValMap.put("SleightOfHand", dex_mod);
		skills_ValMap.put("Stealth", dex_mod);
		skills_ValMap.put("Survival", wis_mod);		

//		HashMap<String, Integer> skills_BonusMap = new HashMap<String, Integer>();
		skills_BonusMap.put("Acrobatics", 0);
		skills_BonusMap.put("AnimalHandling", 0);
		skills_BonusMap.put("Arcana", 0);
		skills_BonusMap.put("Athletics", 0);
		skills_BonusMap.put("Deception", 0);
		skills_BonusMap.put("History", 0);
		skills_BonusMap.put("Insight", 0);
		skills_BonusMap.put("Performance", 0);
		skills_BonusMap.put("Intimidation", 0);
		skills_BonusMap.put("Investigation", 0);
		skills_BonusMap.put("Medicine", 0);
		skills_BonusMap.put("Nature", 0);
		skills_BonusMap.put("Perception", 0);
		skills_BonusMap.put("Persuasion", 0);
		skills_BonusMap.put("Religion", 0);
		skills_BonusMap.put("SleightOfHand", 0);
		skills_BonusMap.put("Stealth", 0);
		skills_BonusMap.put("Survival", 0);
	}
	
	private static void init_sheets()
	{
		c_Sheet = new CharacterSheet();
		c_Sheet.ToggleVisibility(c_Sheet.frmCharacterSheet, false);
		
		
		d_Sheet = new DetailsSheet();
		d_Sheet.ToggleVisibility(false);
	}
	
	public void Heal( int val )
	{
		health_Current = general_tools.ClampInt( health_Current + val, 0, health_Max);
	}
	
	public void Hurt( int val )
	{
		if ( health_Temp > 0 )
		{
			health_Temp = general_tools.ClampInt( health_Temp - val, 0, health_Temp );
		}
		else
		{
			health_Current = general_tools.ClampInt( health_Current - val, 0, health_Current );
		}
	}

	public void UpdateXP( int xp_received )
	{
		// NOTE (Luis): Player level is always 1 or greater, 
		// and is also used as the index for the 2d array, index 0 never accessed
		if (current_xp + xp_received >= xp_table[current_lvl][0])
		{
			current_lvl++;
			current_Proficiency = xp_table[current_lvl][1];	
		}
		current_xp += xp_received;
	}
	
	public void ToggleProfBonus( String skill_name )
	{
		int current_value = skills_ValMap.get( skill_name );
			
		if( skills_IsProfEnabled.get(skill_name) )
		{
			skills_IsProfEnabled.replace(skill_name, false);
			skills_ValMap.replace(skill_name, current_value - current_Proficiency);	
		}
		else
		{
			skills_IsProfEnabled.replace(skill_name, true);
			skills_ValMap.replace(skill_name, current_value + current_Proficiency);
		}
	}
}
