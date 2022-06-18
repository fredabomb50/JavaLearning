package dnd_gui;

import java.awt.EventQueue;
import javax.swing.*;
import java.util.HashMap;


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
	
	private static HashMap<String, Boolean> skills_ProfMap = new HashMap<String, Boolean>();
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
		init_stats();
		initialize();
	}


	// Builds GUI and button functionality
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		
//		HashMap<String, Boolean> skills_ProfMap = new HashMap<String, Boolean>();
		skills_ProfMap.put("Acrobatics", false);
		skills_ProfMap.put("AnimalHandling", false);
		skills_ProfMap.put("Arcana", false);
		skills_ProfMap.put("Athletics", false);
		skills_ProfMap.put("Deception", false);
		skills_ProfMap.put("History", false);
		skills_ProfMap.put("Insight", false);
		skills_ProfMap.put("Performance", false);
		skills_ProfMap.put("Intimidation", false);
		skills_ProfMap.put("Investigation", false);
		skills_ProfMap.put("Medicine", false);
		skills_ProfMap.put("Nature", false);
		skills_ProfMap.put("Perception", false);
		skills_ProfMap.put("Persuasion", false);
		skills_ProfMap.put("Religion", false);
		skills_ProfMap.put("SleightOfHand", false);
		skills_ProfMap.put("Stealth", false);
		skills_ProfMap.put("Survival", false);
		
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
}
