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
	Json_Tools json_tools = new Json_Tools();
	
	
	// add a toggle that unlocks any value for override, and maybe a refresh function to make sure all relevant stats update
	
	
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
					stat_values.set_CurrentHealth( incoming_health );
//					stat_values.health_Current = general_tools.ClampInt( stat_values.health_Current + incoming_health, 0, stat_values.health_Max );
				}
				catch (NumberFormatException e1)
				{
					// Re-prompt user
					mouseClicked( e );
				}

				c_Sheet.update_CurrentHealth( stat_values.health_Current );
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
					if ( stat_values.health_Temp <= 0 )
					{
						stat_values.set_CurrentHealth( -incoming_pain );
					}
					else
					{
						stat_values.health_Temp -= incoming_pain;
						if ( stat_values.health_Temp <= 0 )
						{
							int remainder = Math.abs( stat_values.health_Temp );
							stat_values.set_TempHealth( -999 );
							stat_values.set_CurrentHealth( -remainder );
						}
					}
				}
				catch (NumberFormatException e1)
				{
					// Re-prompt user
					mouseClicked( e );
				}
				
				c_Sheet.update_CurrentHealth( stat_values.health_Current );
				c_Sheet.update_TempHealth( stat_values.health_Temp );
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
					stat_values.set_MaxHealth( incoming_bump );
				}
				catch (NumberFormatException e1)
				{
					// Re-prompt user
					mouseClicked( e );
				}

				c_Sheet.update_MaxHealth( stat_values.health_Max );
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
					stat_values.set_TempHealth( incoming_temp );
				}
				catch (NumberFormatException e1)
				{
					// Re-prompt user
					mouseClicked( e );
				}

				c_Sheet.update_TempHealth( stat_values.health_Temp );
			}
		});
		panel_HealthControls.add(bttn_AddTempHealth, "cell 3 1,grow");
		
		JButton bttn_HitDie = new JButton("Use Hit Die");
		bttn_HitDie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if ( stat_values.hitdie_Count > 0 )
				{
					int max_roll = 0;
					switch ( stat_values.hitdie_Type )
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
							max_roll = 0;
						} break;
					}
					
					
					int[] temp = stat_values.abilities.get( E_Abilities.Con );
					String input = JOptionPane.showInputDialog( "Add dice roll (w/o con bonus): " );
					int incoming_heal;
					try
					{
						incoming_heal = Math.abs( Integer.parseInt( input ) );
						incoming_heal = general_tools.ClampInt( incoming_heal, 1, max_roll );
						stat_values.set_CurrentHealth( incoming_heal + temp[1] );
						stat_values.set_HitDieCount( -1 );
					}
					catch (NumberFormatException e1)
					{
						// Re-prompt user
						mouseClicked( e );
					}
				}
				c_Sheet.update_CurrentHealth( stat_values.health_Current );
				c_Sheet.update_HitDie( stat_values.hitdie_Type, stat_values.hitdie_Count, stat_values.current_Level );
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
				int current_xp = stat_values.current_XP;
				int current_lvl = stat_values.current_Level;
				int current_prof = stat_values.current_Prof;
				int incoming_temp;
				try
				{
					incoming_temp = Math.abs( Integer.parseInt( input ) );
					current_xp = general_tools.ClampInt( current_xp + incoming_temp, 0, stat_values.xp_table[19][0] + 1 );

					int index = 0;
					boolean lvl_up = false;
					while( !lvl_up )
					{	
						try
						{
							if ( current_xp <= stat_values.xp_table[index][0] )
							{
								lvl_up = true;
								current_prof = stat_values.xp_table[index][1];
								current_lvl = index;
								
								stat_values.set_Casting();
								s_Sheet.update_Sheet(stat_values.spell_slots_table, current_lvl - 1, stat_values.spell_save, stat_values.spell_hit_bonus);
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

				c_Sheet.update_XP( current_xp, current_lvl, current_prof );
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
						stat_values.ToggleSkillProf( temp_Skill );
						break;
					}
				}
				
				c_Sheet.update_SkillProf( temp_Skill, stat_values.get_SkillProfStatus( temp_Skill ) );
				c_Sheet.update_SkillValue( temp_Skill, stat_values.get_SkillVal( temp_Skill ) );
			}
		});
		panel_GenericControls.add(bttn_ToggleProf, "cell 3 1,grow");
		
		JButton bttn_AddInsp = new JButton("Gain Insp.");
		bttn_AddInsp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				stat_values.set_Currency( E_Currency.Inspiration, 1 );
				c_Sheet.update_Inspiration( stat_values.coins.get( E_Currency.Inspiration ) );
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
				stat_values.set_Currency( E_Currency.Inspiration, -1 );
				c_Sheet.update_Inspiration( stat_values.coins.get( E_Currency.Inspiration ) );
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
						stat_values.set_Currency( temp_Currency, Math.abs(temp_Val) );
						i_Sheet.update_Currency( stat_values.coins );
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
						stat_values.set_Currency( temp_Currency, -Math.abs(temp_Val) );
						i_Sheet.update_Currency( stat_values.coins );
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
		// RUN A SUCCESSFUL BUILD FIRST, AND THEN START ADDING LOAD FUNCTIONS
	}
	
	
	private void init_sheets()
	{
		// character sheet: 830 x 750
		c_Sheet = new CharacterSheet();
		c_Sheet.ToggleVisibility(c_Sheet.frame, false);
		c_Sheet.frame.setBounds(100, 100, 830, 750);
		c_Sheet.update_CurrentHealth( stat_values.health_Current );
		c_Sheet.update_MaxHealth( stat_values.health_Max );
		c_Sheet.update_TempHealth( stat_values.health_Temp );
		c_Sheet.update_HitDie( stat_values.hitdie_Type, stat_values.hitdie_Count, stat_values.current_Level );
		c_Sheet.fill_Stats( stat_values.abilities, stat_values.save_prof );
		c_Sheet.fill_Skills( stat_values.skills_ProfStatus, stat_values.skills_Values );
		c_Sheet.fill_Misc( stat_values.current_Level, stat_values.current_XP, stat_values.current_Prof, stat_values.initiative, stat_values.armor_class);
		c_Sheet.fill_Speeds( stat_values.speeds );
		
		// Details sheet: ? x ?
		d_Sheet = new DetailsSheet();
		d_Sheet.ToggleVisibility(d_Sheet.frame, false);
		d_Sheet.frame.setBounds(100, 100, 830, 750);
		
		// spell sheet : 750 x 430
		s_Sheet = new SpellSheet();
		s_Sheet.ToggleVisibility(s_Sheet.frame, false);
		s_Sheet.frame.setBounds(100, 100, 750, 430);
		s_Sheet.update_Sheet( stat_values.spell_slots_table, stat_values.current_Level, stat_values.spell_save, stat_values.spell_hit_bonus );
		
		
		// notes sheet 0 x 0
		n_Sheet = new NotesSheet();
		n_Sheet.ToggleVisibility(n_Sheet.frame, false);
		n_Sheet.frame.setBounds(100, 100, 500, 500);
		
		
		// Inventory sheet : 970 x 360
		i_Sheet = new InventorySheet();
		i_Sheet.ToggleVisibility(n_Sheet.frame, false);
		i_Sheet.frame.setBounds(100, 500, 970, 360);
		i_Sheet.update_Currency( stat_values.coins );
	}
	
	
	public void ToggleProfBonus( E_Skills skill )
	{
		int[] current = stat_values.skills_Values.get( skill );
		boolean[] profs = stat_values.skills_ProfStatus.get( skill );
		
		if( profs[0] )
		{
			profs[0] = false;
			current[0] = current[0] - stat_values.current_Prof;	
		}
		else
		{
			profs[0] = true;
			current[0] = current[0] + stat_values.current_Prof;	
		}
		
		stat_values.skills_ProfStatus.replace( skill, profs );
		stat_values.skills_Values.replace( skill, current );
		c_Sheet.update_SkillValue( skill, current[0] );
		c_Sheet.update_SkillProf( skill, profs[0] );
	}
	
	
	private class Load extends AbstractAction
	{
		private static final long serialVersionUID = 1L;
		public Load()
		{
			putValue(NAME, "Load");
			putValue(SHORT_DESCRIPTION, "Load JSON files in save folder");
		}
		public void actionPerformed(ActionEvent e)
		{
			// Character Sheet loaders
			stat_values.abilities = json_tools.load_Abilities();
			stat_values.save_prof = json_tools.load_SaveProfs();
			stat_values.save_bonus = json_tools.load_SaveBonuses();
			stat_values.speeds = json_tools.load_Speeds();
			stat_values.hitdie_Type = json_tools.load_HitdieType();
			
			c_Sheet.fill_Stats( stat_values.abilities, stat_values.save_prof );
			c_Sheet.fill_Speeds( stat_values.speeds );
			
			
			// Inventory Sheet Loaders
			stat_values.coins = json_tools.load_Money();
			i_Sheet.update_Currency( stat_values.coins );
		}
	}
	
	
	private class Stats
	{
		// CONSTANTS
		private final int[][] xp_table =
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
		private final int[][] spell_slots_table =
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
		
		
		private int current_Level = 1;
		private int current_XP = 0;
		private int current_Prof = 2;
		private int initiative = 0;
		private int armor_class = 0;
		
		
		private HashMap<E_Currency, Integer> coins = new HashMap<E_Currency, Integer>();
		private HashMap<E_Speeds, Integer> speeds = new HashMap<E_Speeds, Integer>();

		
		// ability[0] = score, ability[1] = mod
		private HashMap<E_Abilities, int[]> abilities = new HashMap<E_Abilities, int[]>();
		private HashMap<E_Abilities, Integer> ability_bonus = new HashMap<E_Abilities, Integer>();
		private HashMap<E_Abilities, Boolean> save_prof = new HashMap<E_Abilities, Boolean>();
		private HashMap<E_Abilities, Integer> save_bonus = new HashMap<E_Abilities, Integer>();
		
		// skill[0] = proficiency ; skill[1] = expertise
		private HashMap<E_Skills, boolean[]> skills_ProfStatus = new HashMap<E_Skills, boolean[]>();
		
		// skill[0] = base ; skill[1] = bonus ( equipment, spell, etc. )
		private HashMap<E_Skills, int[]> skills_Values = new HashMap<E_Skills, int[]>();

		private HashMap<E_Stats, Integer> health_Values = new HashMap<E_Stats, Integer>();
		private int health_Current = 100;
		private int health_Max = 100;
		private int health_Temp = 15;
		
		
		// move to hashmap for future multi-class support
		private int hitdie_Count = 1;
		private E_Dice hitdie_Type = E_Dice.D6;
		

		// 8 + prof + spell_mod
		private int spell_save = 0;
		
		// prof + spell_mod
		private int spell_hit_bonus = 0;
		
		
		// Constructors
		public Stats()
		{
			// initialize class to ensure maps are not null

			// Fillers
			fill_health();
			fill_money();
			fill_speeds();
			fill_abilities();
			fill_skills();
		}
		
	
		// Getters
		private int get_AbilityMod( E_Abilities ability )
		{
			int[] temp = this.abilities.get( ability );
			return temp[1];
		}
		
		private boolean get_SkillProfStatus( E_Skills skill )
		{
			boolean[] temp = this.skills_ProfStatus.get( skill );
			return temp[0];
		}
		
		private int get_SkillVal( E_Skills skill )
		{
			int[] temp = this.skills_Values.get( skill );
			return temp[0] + temp[1];
		}
		
		// Setters
		public void set_CurrentHealth( int new_val )
		{
			this.health_Current = general_tools.ClampInt( this.health_Current + new_val, 0, this.health_Max );
		}
		
		public void set_MaxHealth( int new_val )
		{
			this.health_Max += new_val;
		}
		
		public void set_TempHealth( int new_val )
		{
			this.health_Temp = general_tools.ClampInt( this.health_Temp + new_val, 0, 999 );
		}
		
		public void set_HitDieCount( int new_val )
		{
			this.hitdie_Count = general_tools.ClampInt( this.hitdie_Count + new_val, 0, this.current_Level );
		}
		
		public void set_ArmorClass( int new_val )
		{
			this.armor_class = new_val + get_AbilityMod( E_Abilities.Dex );
		}
		
		public void set_Initiative( int new_val )
		{
			this.initiative = new_val + get_AbilityMod( E_Abilities.Dex );;
		}
		
		public void set_Currency( E_Currency coin, int new_val )
		{
			if ( coin == E_Currency.Inspiration )
			{
				int temp = general_tools.ClampInt( this.coins.get(coin) + new_val, 0, 10 );
				this.coins.replace( coin, temp );
			}
			else
			{
				int temp = general_tools.ClampInt( this.coins.get(coin) + new_val, 0, 9999 );
				this.coins.replace( coin, temp );
			}

		}
		
		public void set_AbilityScore( E_Abilities ability, int[] new_val )
		{
			this.abilities.replace(ability, new_val);
		}
		
		
		public void set_Casting()
		{
			spell_save = 8 + current_Prof + get_AbilityMod( E_Abilities.Int );
			spell_hit_bonus = current_Prof + get_AbilityMod( E_Abilities.Int );
		}
				
		public void ToggleSkillProf( E_Skills skill )
		{
			boolean[] temp = this.skills_ProfStatus.get( skill );
			int[] temp_val = this.skills_Values.get( skill );
			
			if ( temp[0] )
			{
				temp[0] = false;
				temp_val[0] -= this.current_Prof;
			}
			else
			{
				temp[0] = true;
				temp_val[0] += this.current_Prof;
			}
			
			this.skills_ProfStatus.replace( skill, temp );
			this.skills_Values.replace( skill, temp_val );
		}
		
		// ToggleSkillExpertise
		// AddSkillBonus
		
		
		// Fillers
		private void fill_health()
		{
			HashMap<E_Stats, Integer> temp = new HashMap<E_Stats, Integer>();
			temp.put(E_Stats.HealthCurrent, 0);
			temp.put(E_Stats.HealthMax, 0);
			temp.put(E_Stats.HealthTemp, 0);
		}
		
		private void fill_money()
		{
			coins.put( E_Currency.Platinum, 0 );
			coins.put( E_Currency.Gold, 0 );
			coins.put( E_Currency.Electrum, 0 );
			coins.put( E_Currency.Silver, 0 );
			coins.put( E_Currency.Copper, 0 );
			coins.put( E_Currency.SoulCoins, 0 );
			coins.put( E_Currency.Inspiration, 0);
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
			
		
			set_Casting();
		}
	
		private void fill_skills()
		{
			boolean[] temp_bools = { false, false };
			int[] temp_ints = { 0, 0 };
			
			for ( E_Skills element : E_Skills.values() )
			{
				skills_ProfStatus.put( element, temp_bools );
				skills_Values.put( element, temp_ints );
			}
		}
	}
}