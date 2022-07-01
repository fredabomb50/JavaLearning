package dnd_gui;

import java.awt.EventQueue;
import javax.swing.*;
import java.util.HashMap;
import java.awt.Toolkit;
import net.miginfocom.swing.MigLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ControlPanel extends Sheet
{
	// Utility classes
	Tools general_tools = new Tools();
	Dice dice_tools = new Dice();
	
	// add a toggle that unlocks core stats for editing, and maybe a refresh function to make sure all relevant stats update
	
	
	// CORE STATS
	private static int str_mod = 0;
	private static int dex_mod = 0;
	private static int con_mod = 0;
	private static int int_mod = 0;
	private static int wis_mod = 0;
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
	
	private static HashMap<String, int[]> stats = new HashMap<String, int[]>();
	private static HashMap<String, Boolean> saves = new HashMap<String, Boolean>();
	private static HashMap<String, Boolean> skills_IsProfEnabled = new HashMap<String, Boolean>();
	private static HashMap<String, Boolean> skills_IsExpertEnabled = new HashMap<String, Boolean>();
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
	private static SpellSheet s_Sheet = null;
	private static NotesSheet n_Sheet = null;
	
	// GUI elements
	private JFrame frame;

	
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
		initialize();
		init_stats();
		init_sheets();
	}


	// Builds GUI and button functionality
	private void initialize()
	{
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 612, 284);
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
		
		JButton bttn_LoseXP = new JButton("Lose XP");
		panel_GenericControls.add(bttn_LoseXP, "cell 1 2");
		
		JButton bttn_OverideField = new JButton("Overwrite");
		panel_GenericControls.add(bttn_OverideField, "cell 2 2,growx");
		
		JButton bttn_ToggleExpert = new JButton("Toggle Expert");
		panel_GenericControls.add(bttn_ToggleExpert, "cell 3 2");
		
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
				c_Sheet.ToggleVisibility( c_Sheet.frame );
				d_Sheet.ToggleVisibility( d_Sheet.frame, false );
			}
		});
		panel_Sheets.add(bttn_CSheet, "cell 0 0,grow");
		
		JButton bttn_SSheet = new JButton("Spell Sheet");
		bttn_SSheet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				
				s_Sheet.ToggleVisibility(s_Sheet.frmSpellSheet);
				d_Sheet.ToggleVisibility( d_Sheet.frame, false );
				c_Sheet.ToggleVisibility( c_Sheet.frame, false );
				
			}
		});
		panel_Sheets.add(bttn_SSheet, "cell 1 0,grow");
		
		JButton bttn_DSheet = new JButton("Character Details");
		bttn_DSheet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				d_Sheet.ToggleVisibility( d_Sheet.frame );
				c_Sheet.ToggleVisibility( c_Sheet.frame, false );
				
			}
		});
		panel_Sheets.add(bttn_DSheet, "cell 2 0,grow");
		
		JButton bttn_Inventory = new JButton("Inventory");
		panel_Sheets.add(bttn_Inventory, "cell 3 0,grow");
		
		JButton bttn_Notes = new JButton("Notes");
		bttn_Notes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				c_Sheet.ToggleVisibility( c_Sheet.frame, false );
			}
		});
		panel_Sheets.add(bttn_Notes, "cell 4 0,grow");
	}

	
	// NOTE (Luis): should ultimately use a json loading class to save and load player data
	private static void init_stats()
	{
		int temp_str[] = { 0, 0 };
		int temp_dex[] = { 0, 0 };
		int temp_con[] = { 0, 0 };
		int temp_wis[] = { 0, 0 };
		int temp_int[] = { 0, 0 };
		int temp_chr[] = { 0, 0 };
		
		
		current_lvl = 5;
		current_xp = 6500;
		current_Proficiency = 3;
		
		
//		HashMap<String, int[]> stats = new HashMap<String, int[]>();
		temp_str[0] = 11;
		temp_str[1] = GetModFromStat( temp_str[0] );
		str_mod = temp_str[1];
		stats.put("Str", temp_str);

		temp_dex[0] = 14;
		temp_dex[1] = GetModFromStat( temp_dex[0] );
		dex_mod = temp_dex[1];
		stats.put("Dex", temp_dex);
		
		temp_con[0] = 16;
		temp_con[1] = GetModFromStat( temp_con[0] );
		con_mod = temp_con[1];
		stats.put("Con", temp_con);
		
		temp_wis[0] = 12;
		temp_wis[1] = GetModFromStat( temp_wis[0] );
		wis_mod = temp_wis[1];
		stats.put("Wis", temp_wis);
		
		temp_int[0] = 20;
		temp_int[1] = GetModFromStat( temp_int[0] );
		int_mod = temp_int[1];
		stats.put("Int", temp_int);
		
		temp_chr[0] = 12;
		temp_chr[1] = GetModFromStat( temp_chr[0] );
		chr_mod = temp_chr[1];
		stats.put("Chr", temp_chr);
		
		
		speed_Ground = 30;
		speed_Swim = 0;
		speed_Fly = 0;
		speed_Dig = 0;
		speed_Climb = 0;

		
		initiative = dex_mod;
		armor_class = 10 + dex_mod;

		
		health_Current = 45;
		health_Max = 45;
		health_Temp = 0;
		hitdie_Current = current_lvl;
		hitdie_Max = current_lvl;
		current_HitDie = E_DieType.D6;
		
//		HashMap<String, Boolean> saves = new HashMap<String, Boolean>();
		saves.put("Str", false);
		saves.put("Dex", false);
		saves.put("Con", false);
		saves.put("Wis", false);
		saves.put("Int", false);
		saves.put("Chr", false);	
		
		
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
		
//		HashMap<String, Boolean> skills_IsExpertEnabled = new HashMap<String, Boolean>();
		skills_IsExpertEnabled.put("Acrobatics", false);
		skills_IsExpertEnabled.put("AnimalHandling", false);
		skills_IsExpertEnabled.put("Arcana", false);
		skills_IsExpertEnabled.put("Athletics", false);
		skills_IsExpertEnabled.put("Deception", false);
		skills_IsExpertEnabled.put("History", false);
		skills_IsExpertEnabled.put("Insight", false);
		skills_IsExpertEnabled.put("Performance", false);
		skills_IsExpertEnabled.put("Intimidation", false);
		skills_IsExpertEnabled.put("Investigation", false);
		skills_IsExpertEnabled.put("Medicine", false);
		skills_IsExpertEnabled.put("Nature", false);
		skills_IsExpertEnabled.put("Perception", false);
		skills_IsExpertEnabled.put("Persuasion", false);
		skills_IsExpertEnabled.put("Religion", false);
		skills_IsExpertEnabled.put("SleightOfHand", false);
		skills_IsExpertEnabled.put("Stealth", false);
		skills_IsExpertEnabled.put("Survival", false);
	
		

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
		c_Sheet.ToggleVisibility(c_Sheet.frame, false);
		c_Sheet.fill_Health( health_Current, health_Max, health_Max );
		c_Sheet.fill_Stats(stats, saves);
		c_Sheet.fill_Skills(skills_IsProfEnabled, skills_IsExpertEnabled, skills_ValMap, skills_BonusMap);
		c_Sheet.fill_Speed(speed_Ground, speed_Fly, speed_Swim, speed_Dig, speed_Climb);
		c_Sheet.fill_Misc(current_lvl, current_xp, current_Proficiency, initiative, armor_class);
		
		d_Sheet = new DetailsSheet();
		d_Sheet.ToggleVisibility(d_Sheet.frame, false);
		
		s_Sheet = new SpellSheet();
		s_Sheet.ToggleVisibility(s_Sheet.frmSpellSheet, false);
		
		n_Sheet = new NotesSheet();
		n_Sheet.ToggleVisibility(n_Sheet.frame, false);
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
