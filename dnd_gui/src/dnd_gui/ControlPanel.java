package dnd_gui;

import java.awt.EventQueue;
import javax.swing.*;

import org.json.simple.parser.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.awt.Toolkit;
import net.miginfocom.swing.MigLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlPanel extends Sheet
{
	// Utility classes
	Tools general_tools = new Tools();
	Stats stat_values = new Stats();
	
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
	private static E_Dice current_HitDie = null;
	
	
	// stat[0] == ability score ; stat[1] == ability mod
	private static HashMap<String, int[]> stats = new HashMap<String, int[]>();
	private static HashMap<String, Boolean> saves = new HashMap<String, Boolean>();
	private static HashMap<String, Boolean> skills_IsProfEnabled = new HashMap<String, Boolean>();
	private static HashMap<String, Boolean> skills_IsExpertEnabled = new HashMap<String, Boolean>();
	private static HashMap<String, Integer> skills_ValMap = new HashMap<String, Integer>();
	private static HashMap<String, Integer> skills_BonusMap = new HashMap<String, Integer>();
	
	
	private static HashMap<String, Integer> currency = new HashMap<String, Integer>();
	private static int inspiration = 0;
	
	
	
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
	private static final int[][] spell_slots_table =
	{
		{3, 2, 0, 0, 0, 0, 0, 0, 0, 0}, 	// level 1
		{3, 3, 0, 0, 0, 0, 0, 0, 0, 0},		// level 2
		{3, 4, 2, 0, 0, 0, 0, 0, 0, 0},		// level 3
		{4, 4, 3, 0, 0, 0, 0, 0, 0, 0},		// level 4
		{4, 4, 3, 2, 0, 0, 0, 0, 0, 0},		// level 5
		{4, 4, 3, 3, 0, 0, 0, 0, 0, 0},		// level 6
		{4, 4, 3, 3, 1, 0, 0, 0, 0, 0},		// level 7
		{4, 4, 3, 3, 2, 0, 0, 0, 0, 0},		// level 8
		{4, 4, 3, 3, 3, 1, 0, 0, 0, 0},		// level 9
		{5, 4, 3, 3, 3, 2, 0, 0, 0, 0},		// level 10
		{5, 4, 3, 3, 3, 2, 1, 0, 0, 0},		// level 11
		{5, 4, 3, 3, 3, 2, 1, 0, 0, 0},	  	// level 12
		{5, 4, 3, 3, 3, 2, 1, 1, 0, 0},	  	// level 13
		{5, 4, 3, 3, 3, 2, 1, 1, 0, 0},	 	// level 14
		{5, 4, 3, 3, 3, 2, 1, 1, 1, 0},	  	// level 15
		{5, 4, 3, 3, 3, 2, 1, 1, 1, 0},	  	// level 16
		{5, 4, 3, 3, 3, 2, 1, 1, 1, 1},	  	// level 17
		{5, 4, 3, 3, 3, 3, 1, 1, 1, 1},	  	// level 18
		{5, 4, 3, 3, 3, 3, 2, 1, 1, 1},   	// level 19
		{5, 4, 3, 3, 3, 3, 2, 2, 1, 1}    	// level 20
	};
	
	// Casting
	private static int spell_save = 0;
	private static int spell_hit_bonus = 0;

	
	// Misc
	private static int platinum = 0;
	private static int gold = 0;
	private static int electrum = 0;
	private static int silver = 0;
	private static int copper = 0;
	private static int soul_coins = 0;

	
	
	// GUI sheets
	private static CharacterSheet c_Sheet = null;
	private static DetailsSheet d_Sheet = null;
	private static SpellSheet s_Sheet = null;
	private static NotesSheet n_Sheet = null;
	private static InventorySheet i_Sheet = null;
	
	
	// GUI elements
	private JFrame frame;
	private final Action action = new Load();
	
	
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
		init_sheets();
		initialize();
	}


	// Builds GUI and button functionality
	private void initialize()
	{
		frame = new JFrame();
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 625, 315);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][][]"));
		
		JPanel panel_HealthControls = new JPanel();
		frame.getContentPane().add(panel_HealthControls, "cell 0 0,alignx center,aligny center");
		panel_HealthControls.setLayout(new MigLayout("", "[][][][][][]", "[][][]"));
		
		JButton bttn_Heal = new JButton("Heal Health");
		bttn_Heal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				String input = JOptionPane.showInputDialog( "Amount to heal: " );
				int incoming_health;
				try
				{
					incoming_health = Math.abs( Integer.parseInt( input ) );
					health_Current = general_tools.ClampInt( health_Current + incoming_health, 0, health_Max );
				}
				catch (NumberFormatException e1)
				{
					// Re-prompt user
					mouseClicked( e );
				}

				c_Sheet.update_CurrentHealth( health_Current );
			}
		});
		panel_HealthControls.add(bttn_Heal, "cell 0 1,grow");
		
		JButton bttn_Hurt = new JButton("Hurt Health");
		bttn_Hurt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				String input = JOptionPane.showInputDialog( "Amount to hurt: " );
				int incoming_pain;
				try
				{
					incoming_pain = Math.abs( Integer.parseInt( input ) );
					if ( health_Temp <= 0 )
					{
						health_Current = general_tools.ClampInt( health_Current - incoming_pain, 0, health_Max );
					}
					else
					{
						health_Temp -= incoming_pain;
						if ( health_Temp <= 0 )
						{
							int remainder = Math.abs( health_Temp );
							health_Temp = 0;
							health_Current = general_tools.ClampInt( health_Current - remainder, 0, health_Max );
						}
					}
				}
				catch (NumberFormatException e1)
				{
					// Re-prompt user
					mouseClicked( e );
				}
				
				c_Sheet.update_CurrentHealth( health_Current );
				c_Sheet.update_TempHealth( health_Temp );
			}
		});
		panel_HealthControls.add(bttn_Hurt, "cell 1 1,grow");
		
		JButton bttn_AddMaxHealth = new JButton("Add Max Health");
		bttn_AddMaxHealth.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				String input = JOptionPane.showInputDialog( "Amount to add: " );
				int incoming_bump;
				try
				{
					incoming_bump = Math.abs( Integer.parseInt( input ) );
					health_Max = general_tools.ClampInt( health_Max + incoming_bump, 0, 999 );
				}
				catch (NumberFormatException e1)
				{
					// Re-prompt user
					mouseClicked( e );
				}

				c_Sheet.update_MaxHealth( health_Max );
			}
		});
		panel_HealthControls.add(bttn_AddMaxHealth, "cell 2 1,grow");
		
		JButton bttn_AddTempHealth = new JButton("Add Temp Health");
		bttn_AddTempHealth.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				String input = JOptionPane.showInputDialog( "Amount to add: " );
				int incoming_temp;
				try
				{
					incoming_temp = Math.abs( Integer.parseInt( input ) );
					health_Temp = general_tools.ClampInt( health_Temp + incoming_temp, 0, health_Max );
				}
				catch (NumberFormatException e1)
				{
					// Re-prompt user
					mouseClicked( e );
				}

				c_Sheet.update_TempHealth( health_Temp );
			}
		});
		panel_HealthControls.add(bttn_AddTempHealth, "cell 3 1,grow");
		
		JButton bttn_HitDie = new JButton("Use Hit Die");
		bttn_HitDie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if ( hitdie_Current > 0 )
				{
					int max_roll = 0;
					switch ( current_HitDie )
					{
						case D4:
						{
							max_roll = 4;
						}break;
					
						case D6:
						{
							max_roll = 6;
						}break;
						
						case D8:
						{
							max_roll = 8;
						} break;
						
						case D10:
						{
							max_roll = 10;
						} break;
						
						case D12:
						{
							max_roll = 12;
						} break;
						
						default:
						{
							max_roll = 100;
						} break;
					}
					
					
					int[] temp = stats.get( "Con" );
					String input = JOptionPane.showInputDialog( "Add dice roll (w/o con bonus): " );
					int incoming_heal;
					try
					{
						incoming_heal = Math.abs( Integer.parseInt( input ) );
						incoming_heal = general_tools.ClampInt(incoming_heal, 1, max_roll);
						health_Current = general_tools.ClampInt( health_Current + incoming_heal + temp[1], 0, health_Max );
						hitdie_Current = general_tools.ClampInt( --hitdie_Current, 0, current_lvl );
					}
					catch (NumberFormatException e1)
					{
						// Re-prompt user
						mouseClicked( e );
					}
				}
				c_Sheet.update_CurrentHealth( health_Current );
				c_Sheet.update_HitDie( hitdie_Current, current_lvl );
			}
		});
		panel_HealthControls.add(bttn_HitDie, "cell 4 1,grow");
		
		JPanel panel_GenericControls = new JPanel();
		frame.getContentPane().add(panel_GenericControls, "cell 0 1,alignx center,aligny center");
		panel_GenericControls.setLayout(new MigLayout("", "[][][][][]", "[][][]"));
		
		JButton bttn_LongRest = new JButton("Long Rest");
		panel_GenericControls.add(bttn_LongRest, "cell 0 1,grow");
		
		JButton bttn_AddXP = new JButton("Gain Xp");
		bttn_AddXP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				String input = JOptionPane.showInputDialog( "Amount to add: " );
				int incoming_temp;
				try
				{
					incoming_temp = Math.abs( Integer.parseInt( input ) );
					current_xp = general_tools.ClampInt( current_xp + incoming_temp, 0, xp_table[19][0] + 1 );

					int index = 0;
					boolean lvl_up = false;
					while( !lvl_up )
					{	
						try
						{
							if ( current_xp <= xp_table[index][0] )
							{
								lvl_up = true;
								current_Proficiency = xp_table[index][1];
								current_lvl = index;
								
								RecalcCastingStats();
								s_Sheet.update_Sheet(spell_slots_table, current_lvl - 1, spell_save, spell_hit_bonus);
							}
							else
							{
								index++;
							}
						}
						catch ( ArrayIndexOutOfBoundsException fail )
						{
							break;
						}
					}
				}
				catch (NumberFormatException e1)
				{
					// Re-prompt user
					mouseClicked( e );
				}

				c_Sheet.update_XP( current_xp, current_lvl, current_Proficiency );
			}
		});
		panel_GenericControls.add(bttn_AddXP, "cell 1 1,grow");
		
		JButton bttn_ToggleVantage = new JButton("Toggle Adv/Disadv");
		panel_GenericControls.add(bttn_ToggleVantage, "cell 2 1,grow");
		
		JButton bttn_ToggleProf = new JButton("Toggle Prof.");
		bttn_ToggleProf.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				CustomDialogs dialog = new CustomDialogs( frame, E_Dialog.SelectSkill );
				E_Skills temp_Skill = dialog.get_skill();
				
				for ( E_Skills element : E_Skills.values() )
				{
					if ( dialog.get_skill() == element )
					{
						ToggleProfBonus( temp_Skill.name() );
					}
				}
			}
		});
		panel_GenericControls.add(bttn_ToggleProf, "cell 3 1,grow");
		
		JButton bttn_AddInsp = new JButton("Gain Insp.");
		bttn_AddInsp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				inspiration++;
				inspiration = general_tools.ClampInt( inspiration, 0, 10 );
				c_Sheet.update_Inspiration( inspiration );
			}
		});
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
		bttn_BurnInsp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				inspiration--;
				inspiration = general_tools.ClampInt( inspiration, 0, 10 );
				c_Sheet.update_Inspiration( inspiration );
			}
		});
		panel_GenericControls.add(bttn_BurnInsp, "cell 4 2,grow");
		
		JPanel panel_InventoryControls = new JPanel();
		frame.getContentPane().add(panel_InventoryControls, "cell 0 2,alignx center,aligny center");
		panel_InventoryControls.setLayout(new MigLayout("", "[grow][grow][][]", "[][]"));
		
		JButton bttn_AddMoney = new JButton("Add Money");
		bttn_AddMoney.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				CustomDialogs dialog = new CustomDialogs( frame, E_Dialog.EnterCurrency );
				E_Currency temp_Currency = dialog.get_currency();
				int temp_Val = dialog.get_value();
				
				for ( E_Currency element : E_Currency.values() )
				{
					if ( temp_Currency == element )
					{
						update_Money( temp_Currency, Math.abs(temp_Val) );
						break;
					}
				}
			}
		});
		panel_InventoryControls.add(bttn_AddMoney, "cell 0 0,grow");
		
		JButton bttn_SpendMoney = new JButton("Spend Money");
		bttn_SpendMoney.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				CustomDialogs dialog = new CustomDialogs( frame, E_Dialog.EnterCurrency );
				E_Currency temp_Currency = dialog.get_currency();
				int temp_Val = dialog.get_value();
				
				for ( E_Currency element : E_Currency.values() )
				{
					if ( temp_Currency == element )
					{
						update_Money( temp_Currency, -Math.abs(temp_Val) );
						break;
					}
				}
			}
		});
		panel_InventoryControls.add(bttn_SpendMoney, "cell 1 0,grow");
		
		JButton bttn_AddItem = new JButton("Add Item");
		bttn_AddItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
		        JFrame temp = new JFrame();
		        JOptionPane.showMessageDialog(temp, "COMING IN V.3");
			}
		});
		panel_InventoryControls.add(bttn_AddItem, "cell 2 0,grow");
		
		JButton bttn_RemoveItem = new JButton("Remove Item");
		bttn_RemoveItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
		        JFrame temp = new JFrame();
		        JOptionPane.showMessageDialog(temp, "COMING IN V.3");
			}
		});
		panel_InventoryControls.add(bttn_RemoveItem, "cell 3 0,grow");
		
		JPanel panel_Sheets = new JPanel();
		frame.getContentPane().add(panel_Sheets, "cell 0 3,alignx center,aligny center");
		panel_Sheets.setLayout(new MigLayout("", "[][][][][]", "[]"));
		
		JButton bttn_CSheet = new JButton("Character Sheet");
		bttn_CSheet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				c_Sheet.ToggleVisibility(c_Sheet.frame);
				d_Sheet.ToggleVisibility( d_Sheet.frame, false );
				s_Sheet.ToggleVisibility( s_Sheet.frame, false );
				i_Sheet.ToggleVisibility( i_Sheet.frame, false );
				n_Sheet.ToggleVisibility( n_Sheet.frame, false );
			}
		});
		panel_Sheets.add(bttn_CSheet, "cell 0 0,grow");
		
		JButton bttn_SSheet = new JButton("Spell Sheet");
		bttn_SSheet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				
				s_Sheet.ToggleVisibility(s_Sheet.frame);
				d_Sheet.ToggleVisibility( d_Sheet.frame, false );
				c_Sheet.ToggleVisibility( c_Sheet.frame, false );
				i_Sheet.ToggleVisibility( i_Sheet.frame, false );
				n_Sheet.ToggleVisibility( n_Sheet.frame, false );
				
			}
		});
		panel_Sheets.add(bttn_SSheet, "cell 1 0,grow");
		
		JButton bttn_DSheet = new JButton("Character Details");
		bttn_DSheet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				d_Sheet.ToggleVisibility(d_Sheet.frame);
				c_Sheet.ToggleVisibility( c_Sheet.frame, false );
				s_Sheet.ToggleVisibility( s_Sheet.frame, false );
				i_Sheet.ToggleVisibility( i_Sheet.frame, false );
				n_Sheet.ToggleVisibility( n_Sheet.frame, false );
				
			}
		});
		panel_Sheets.add(bttn_DSheet, "cell 2 0,grow");
		
		JButton bttn_Inventory = new JButton("Inventory");
		bttn_Inventory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				i_Sheet.ToggleVisibility(i_Sheet.frame);
				c_Sheet.ToggleVisibility( c_Sheet.frame, false );
				s_Sheet.ToggleVisibility( s_Sheet.frame, false );
				d_Sheet.ToggleVisibility( d_Sheet.frame, false );
				n_Sheet.ToggleVisibility( n_Sheet.frame, false );
			}
		});
		panel_Sheets.add(bttn_Inventory, "cell 3 0,grow");
		
		JButton bttn_Notes = new JButton("Notes");
		bttn_Notes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				n_Sheet.ToggleVisibility(n_Sheet.frame);
				c_Sheet.ToggleVisibility( c_Sheet.frame, false );
				s_Sheet.ToggleVisibility( s_Sheet.frame, false );
				d_Sheet.ToggleVisibility( d_Sheet.frame, false );
				i_Sheet.ToggleVisibility( i_Sheet.frame, false );
			}
		});
		panel_Sheets.add(bttn_Notes, "cell 4 0,grow");
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Save");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Save as");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Load");
		mntmNewMenuItem_2.setAction(action);
		mnNewMenu.add(mntmNewMenuItem_2);
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
		health_Temp = 5;
		hitdie_Current = current_lvl;
		current_HitDie = E_Dice.D6;
		
//		HashMap<String, Boolean> saves = new HashMap<String, Boolean>();
		saves.put("Str", false);
		saves.put("Dex", false);
		saves.put("Con", false);
		saves.put("Wis", false);
		saves.put("Int", false);
		saves.put("Chr", false);	
		
		
//		HashMap<String, Boolean> skills_ProfMap = new HashMap<String, Boolean>();
		for ( E_Skills element : E_Skills.values() )
		{
			skills_IsProfEnabled.put(element.name(), false);
		}
	
		
//		HashMap<String, Boolean> skills_IsExpertEnabled = new HashMap<String, Boolean>();
		for ( E_Skills element : E_Skills.values() )
		{
			skills_IsExpertEnabled.put(element.name(), false);
		}
	
		
//		HashMap<String, Integer> skills_BonusMap = new HashMap<String, Integer>();
		for ( E_Skills element : E_Skills.values() )
		{
			skills_BonusMap.put(element.name(), 0);
		}
		
		
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

		
		inspiration = 0;
		
		
		currency.put("Copper", 0);
		currency.put("Silver", 0);
		currency.put("Electrum", 0);
		currency.put("Gold", 0);
		currency.put("Platinum", 0);
		currency.put("SoulCoins", 0);
		
		
		spell_save = 8 + int_mod + current_Proficiency;
		spell_hit_bonus = int_mod + current_Proficiency;
	}
	
	private static void init_sheets()
	{
		// character sheet: 830 x 750
		c_Sheet = new CharacterSheet();
		c_Sheet.ToggleVisibility(c_Sheet.frame, false);
		c_Sheet.frame.setBounds(100, 100, 830, 750);
		c_Sheet.fill_Health( health_Current, health_Max, health_Temp, current_HitDie );
		c_Sheet.fill_Stats(stats, saves);
		c_Sheet.fill_Skills(skills_IsProfEnabled, skills_IsExpertEnabled, skills_ValMap, skills_BonusMap);
		c_Sheet.fill_Speed(speed_Ground, speed_Fly, speed_Swim, speed_Dig, speed_Climb);
		c_Sheet.fill_Misc(current_lvl, current_xp, current_Proficiency, initiative, armor_class);
		
		
		d_Sheet = new DetailsSheet();
		d_Sheet.ToggleVisibility(d_Sheet.frame, false);
		d_Sheet.frame.setBounds(100, 100, 830, 750);
		
		// spell sheet : 750 x 430
		s_Sheet = new SpellSheet();
		s_Sheet.ToggleVisibility(s_Sheet.frame, false);
		s_Sheet.frame.setBounds(100, 100, 750, 430);
		s_Sheet.update_Sheet(spell_slots_table, current_lvl - 1, spell_save, spell_hit_bonus);
		
		
		// notes sheet 0 x 0
		n_Sheet = new NotesSheet();
		n_Sheet.ToggleVisibility(n_Sheet.frame, false);
		n_Sheet.frame.setBounds(100, 100, 500, 500);
		
		
		// Inventory sheet : 970 x 360
		i_Sheet = new InventorySheet();
		i_Sheet.ToggleVisibility(n_Sheet.frame, false);
		i_Sheet.frame.setBounds(100, 500, 970, 360); 
		i_Sheet.update_Currency( platinum, gold, electrum, silver, copper, soul_coins );
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
		
		c_Sheet.update_Skill( skill_name, skills_ValMap.get(skill_name) );
		c_Sheet.update_SkillProf( skill_name, skills_IsProfEnabled.get(skill_name) );
	}
	
	
	private void update_Money( E_Currency currency, int new_val )
	{
		switch ( currency )
		{
			case Platinum:
			{
				platinum = general_tools.ClampInt( platinum + new_val, 0, 100000 );
			} break;
			
			case Gold:
			{
				gold = general_tools.ClampInt( gold + new_val, 0, 100000 );
			} break;
			
			case Electrum:
			{
				electrum = general_tools.ClampInt( electrum + new_val, 0, 100000 );
			} break;
			
			case Silver:
			{
				silver = general_tools.ClampInt( silver + new_val, 0, 100000 );
			} break;
			
			case Copper:
			{
				copper = general_tools.ClampInt( copper + new_val, 0, 100000 );
			} break;
			
			case SoulCoins:
			{
				soul_coins = general_tools.ClampInt( soul_coins + new_val, 0, 100000 );
			} break;
			
			default:
			{
				// do nothing for now
			} break;
		}
		i_Sheet.update_Currency( platinum, gold, electrum, silver, copper, soul_coins );
	}
	
	
	public void RecalcCastingStats()
	{
		int[] temp = stats.get("Int");
		spell_save = temp[1] + current_Proficiency + 8;
		spell_hit_bonus = temp[1] + current_Proficiency;
	}
	
	
	private class Load extends AbstractAction
	{
		private static final long serialVersionUID = 1L;
		public Load()
		{
			putValue(NAME, "Load");
			putValue(SHORT_DESCRIPTION, "Load JSON files in save folder");
		}
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public void actionPerformed(ActionEvent e)
		{
			Iterator<Map.Entry> itr1 = null;
			int temp_str[] = { 0, 0 };
			int temp_dex[] = { 0, 0 };
			int temp_con[] = { 0, 0 };
			int temp_wis[] = { 0, 0 };
			int temp_int[] = { 0, 0 };
			int temp_chr[] = { 0, 0 };
			
			
			try
			{
				Object obj = new JSONParser().parse(new FileReader("save_data/character_stats.json"));
				JSONObject json_obj = (JSONObject) obj;
				
				
				Map temp_scores = ( (Map)json_obj.get("scores") );
		        itr1 = temp_scores.entrySet().iterator();
		        while ( itr1.hasNext() )
		        {
		            Map.Entry pair = itr1.next();
		            if ( pair.getKey().toString().equalsIgnoreCase("dex_score") )
		            {
		            	temp_dex[0] = Integer.parseInt( pair.getValue().toString() );
		            }
		            
		            if ( pair.getKey().toString().equalsIgnoreCase("str_score") )
		            {
		            	temp_str[0] = Integer.parseInt( pair.getValue().toString() );
		            }
		            
		            if ( pair.getKey().toString().equalsIgnoreCase("con_score") )
		            {
		            	temp_con[0] = Integer.parseInt( pair.getValue().toString() );
		            }
		            
		            if ( pair.getKey().toString().equalsIgnoreCase("wis_score") )
		            {
		            	temp_wis[0] = Integer.parseInt( pair.getValue().toString() );
		            }
		            
		            if ( pair.getKey().toString().equalsIgnoreCase("int_score") )
		            {
		            	temp_int[0] = Integer.parseInt( pair.getValue().toString() );
		            }
		            
		            if ( pair.getKey().toString().equalsIgnoreCase("chr_score") )
		            {
		            	temp_chr[0] = Integer.parseInt( pair.getValue().toString() );
		            }
		            
		        }
		        
		        
				Map temp_mods = ( (Map)json_obj.get("modifiers") );
		        itr1 = temp_mods.entrySet().iterator();
		        while ( itr1.hasNext() )
		        {
		            Map.Entry pair = itr1.next();
		            if (  pair.getKey().toString().equalsIgnoreCase("dex_mod") )
		            {
		            	temp_dex[1] = Integer.parseInt( pair.getValue().toString() );
		            }
		            
		            if (  pair.getKey().toString().equalsIgnoreCase("str_mod") )
		            {
		            	temp_str[1] = Integer.parseInt( pair.getValue().toString() );
		            }
		            
		            if (  pair.getKey().toString().equalsIgnoreCase("con_mod") )
		            {
		            	temp_con[1] = Integer.parseInt( pair.getValue().toString() );
		            }
		            
		            if (  pair.getKey().toString().equalsIgnoreCase("wis_mod") )
		            {
		            	temp_wis[1] = Integer.parseInt( pair.getValue().toString() );
		            }
		            
		            if (  pair.getKey().toString().equalsIgnoreCase("int_mod") )
		            {
		            	temp_int[1] = Integer.parseInt( pair.getValue().toString() );
		            }
		            
		            if (  pair.getKey().toString().equalsIgnoreCase("chr_mod") )
		            {
		            	temp_chr[1] = Integer.parseInt( pair.getValue().toString() );
		            }
		        }

				
		        
		        // update stats and propagate
		        stat_values.set_AbilityScore( E_Abilities.Dex, temp_dex );
		        stat_values.set_AbilityScore( E_Abilities.Str, temp_str );
		        stat_values.set_AbilityScore( E_Abilities.Con, temp_con );
		        stat_values.set_AbilityScore( E_Abilities.Wis, temp_wis );
		        stat_values.set_AbilityScore( E_Abilities.Int, temp_int );
		        stat_values.set_AbilityScore( E_Abilities.Chr, temp_chr );
		        
				c_Sheet.fill_Stats( stat_values.get_Abilities(), saves );
				
				
			}
			catch ( ParseException | IOException parse_fail )
			{
				System.out.println( "Exception caught during json test" + parse_fail.toString() );
			}
		}
	}
	
	
	private class Stats
	{
		private HashMap<E_Currency, Integer> coins = new HashMap<E_Currency, Integer>();
		private HashMap<E_Speeds, Integer> speeds = new HashMap<E_Speeds, Integer>();

		
		private HashMap<E_Abilities, int[]> abilities = new HashMap<E_Abilities, int[]>();
		private HashMap<E_Abilities, Integer> ability_bonus = new HashMap<E_Abilities, Integer>();
		private HashMap<E_Abilities, Boolean> save_prof = new HashMap<E_Abilities, Boolean>();
		private HashMap<E_Abilities, Integer> save_bonus = new HashMap<E_Abilities, Integer>();
		
		
		private int health_Current = 0;
		private int health_Max = 0;
		private int health_Temp = 0;
		
		private int hitdie_Current = 0;
		private E_Dice current_HitDie = E_Dice.D4;
		
		private int initiative = 0;
		private int armor_class = 0;
		
		
		public Stats()
		{
			// initialize class to ensure maps are not null
			fill_money();
			fill_speeds();
			fill_abilities();
		}
		
		
		// Getters
		public int get_CurrentHealth()
		{
			return this.health_Current;
		}
		public int get_MaxHealth()
		{
			return this.health_Max;
		}
		public int get_TempHealth()
		{
			return this.health_Temp;
		}		
		
		public int get_ArmorClass()
		{
			return this.armor_class;
		}
		
		public HashMap<E_Abilities, int[]> get_Abilities()
		{
			return this.abilities;
		}
		
		// Setters
		public void set_CurrentHealth( int new_val )
		{
			this.health_Current = new_val;
		}
		public void set_MaxHealth( int new_val )
		{
			this.health_Max = new_val;
		}
		public void set_TempHealth( int new_val )
		{
			this.health_Temp = new_val;
		}
		
		public void set_ArmorClass( int new_val )
		{
			this.armor_class = new_val;
		}
		public void set_Initiative( int new_val )
		{
			this.initiative = new_val;
		}
		
		public void set_Currency( E_Currency coin, int new_val )
		{
			this.coins.replace( coin, new_val );
		}
		
		public void set_AbilityScore( E_Abilities ability, int[] new_val )
		{
			this.abilities.replace(ability, new_val);
		}
		
		
		// Fillers
		private void fill_money()
		{
			coins.put( E_Currency.Platinum, 0 );
			coins.put( E_Currency.Gold, 0 );
			coins.put( E_Currency.Electrum, 0 );
			coins.put( E_Currency.Silver, 0 );
			coins.put( E_Currency.Copper, 0 );
			coins.put( E_Currency.SoulCoins, 0 );
		}
		private void fill_speeds()
		{
			speeds.put(E_Speeds.Walk, 0);
			speeds.put(E_Speeds.Swim, 0);
			speeds.put(E_Speeds.Fly, 0);
			speeds.put(E_Speeds.Dig, 0);
			speeds.put(E_Speeds.Climb, 0);	
		}
		private void fill_abilities()
		{
			int[] temp = { 0, 0 };
			abilities.put(E_Abilities.Dex, temp );
			abilities.put(E_Abilities.Str, temp );
			abilities.put(E_Abilities.Con, temp );
			abilities.put(E_Abilities.Wis, temp );
			abilities.put(E_Abilities.Int, temp );
			abilities.put(E_Abilities.Chr, temp );
			
			
			ability_bonus.put(E_Abilities.Dex, 0);
			ability_bonus.put(E_Abilities.Str, 0);
			ability_bonus.put(E_Abilities.Con, 0);
			ability_bonus.put(E_Abilities.Wis, 0);
			ability_bonus.put(E_Abilities.Int, 0);
			ability_bonus.put(E_Abilities.Chr, 0);
			
		
			save_prof.put(E_Abilities.Dex, false);
			save_prof.put(E_Abilities.Str, false);
			save_prof.put(E_Abilities.Con, false);
			save_prof.put(E_Abilities.Wis, false);
			save_prof.put(E_Abilities.Int, false);
			save_prof.put(E_Abilities.Chr, false);
			
			
			save_bonus.put(E_Abilities.Dex, 0);
			save_bonus.put(E_Abilities.Str, 0);
			save_bonus.put(E_Abilities.Con, 0);
			save_bonus.put(E_Abilities.Wis, 0);
			save_bonus.put(E_Abilities.Int, 0);
			save_bonus.put(E_Abilities.Chr, 0);
		}
	}
}