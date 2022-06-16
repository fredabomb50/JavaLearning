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

public class CharacterSheet
{
	private final static int MAX_INSPIRATION = 10;
	@SuppressWarnings("rawtypes")
	JComboBox combo_DieSelector = null;
	
	
	// Utility Classes
	// create a core-gameplay class that holds constant data. xp_table, maximums, etc
		// that would be for v.2
	Tools general_tools = new Tools();
	Dice dice_tools = new Dice();
	
	// XP table for reference
	int[][] xp_table =
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
	
	
	// GUI
	private JFrame frmCharacterSheet;
	private JTextField txt_Experience;
	private JTextField txt_STR;
	private JTextField txt_DEX;
	private JTextField txt_CON;
	private JTextField txt_INT;
	private JTextField txt_WIS;
	private JTextField txt_CHR;
	private JTextField txt_Acrobatics;
	private JTextField txt_AnimalHandling;
	private JTextField txt_Arcana;
	private JTextField txt_Athletics;
	private JTextField txt_Deception;
	private JTextField txt_History;
	private JTextField txt_Insight;
	private JTextField txt_Performance;
	private JTextField txt_Intimidation;
	private JTextField txt_Investigation;
	private JTextField txt_Medicine;
	private JTextField txt_Nature;
	private JTextField txt_Perception;
	private JTextField txt_Persuasion;
	private JTextField txt_Religion;
	private JTextField txt_SleightOfHand;
	private JTextField txt_Stealth;
	private JTextField txt_Survival;
	private JTextField txt_AC;
	private JTextField txt_Initiative;
	private JTextField txt_Speed;
	private JTextField txt_SwimSpeed;
	private JTextField txtDig;
	private JTextField txt_FlySpeed;
	private JTextField txt_Inspiration;
	private JTextField txt_Level;
	private JTextField txt_Proficiency;
	private JTextField txt_CurrentHealth;
	private JTextField txt_MaxHealth;
	private JTextField txt_TempHealth;
	private JTextField txt_HitDie;
	private JTextField txt_StrMod;
	private JTextField txt_DexMod;
	private JTextField txt_ConMod;
	private JTextField txt_IntMod;
	private JTextField txt_WisMod;
	private JTextField txt_ChrMod;
	private JTextField txt_StrSave;
	private JTextField txt_DexSave;
	private JTextField txt_ConSave;
	private JTextField txt_IntSave;
	private JTextField txt_WisSave;
	private JTextField txt_ChrSave;
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


	/**
	 * Create the application.
	 */
	public CharacterSheet()
	{
		initialize();
		init_StatMods();
		frmCharacterSheet.setVisible( false );
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frmCharacterSheet = new JFrame();
		frmCharacterSheet.setTitle("Character Sheet");
		frmCharacterSheet.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\_BULK\\Image Resources\\dnd\\dnd_beyond.png"));
		frmCharacterSheet.setBounds(100, 100, 1073, 729);
		frmCharacterSheet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCharacterSheet.getContentPane().setLayout(new MigLayout("", "[center][center][grow]", "[grow,center][7.00,center][][grow,center]"));
		
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
		
		txt_Proficiency = new JTextField();
		txt_Proficiency.setText("2");
		txt_Proficiency.setBackground(UIManager.getColor("CheckBoxMenuItem.background"));
		txt_Proficiency.setEditable(false);
		txt_Proficiency.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Header.add(txt_Proficiency, "cell 3 0,growx");
		txt_Proficiency.setColumns(10);
		
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
		bttn_AddXP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				UpdateXP( 100 );
			}
		});
		panel_Header.add(bttn_AddXP, "cell 0 5,alignx center,aligny center");
		
		
		JButton bttn_AddInsp = new JButton("Add Insp.");
		bttn_AddInsp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				int val = Integer.parseInt( txt_Inspiration.getText() );
				val++;
				val = general_tools.ClampInt( val, 0, MAX_INSPIRATION );
				SetTxtBoxInt( txt_Inspiration, val);
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
				SetTxtBoxInt( txt_Inspiration, val);
			}
		});
		panel_Header.add(bttn_BurnInsp, "cell 3 5,alignx center,aligny center");
		
		JPanel panel_Health = new JPanel();
		frmCharacterSheet.getContentPane().add(panel_Health, "cell 1 0,alignx center,growy");
		panel_Health.setLayout(new MigLayout("", "[grow,center][grow][][]", "[][][][][]"));
		
		JLabel lbl_CHealth = new JLabel("Current Health:");
		lbl_CHealth.setHorizontalAlignment(SwingConstants.LEFT);
		panel_Health.add(lbl_CHealth, "cell 0 0,alignx trailing");
		
		txt_CurrentHealth = new JTextField();
		txt_CurrentHealth.setText("100");
		txt_CurrentHealth.setHorizontalAlignment(SwingConstants.CENTER);
		txt_CurrentHealth.setBackground(UIManager.getColor("ColorChooser.background"));
		txt_CurrentHealth.setEditable(false);
		panel_Health.add(txt_CurrentHealth, "cell 1 0,growx");
		txt_CurrentHealth.setColumns(10);
		
		JButton bttn_AddCurrentHealth = new JButton("+");
		bttn_AddCurrentHealth.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
		        JFrame jFrame = new JFrame();
		        String value = JOptionPane.showInputDialog(jFrame, "Enter value: ");
		        
		        if ( value == null || value.length() == 0 )
		        {
		        	jFrame.dispose();
		        }
		        
		        try
		        {
		        	Heal( Math.abs( Integer.parseInt( value ) ) );
		        }
		        catch ( NumberFormatException ex_num )
		        {
		        	// logging?
		        }
		        
		        jFrame.dispose();
			}
		});
		panel_Health.add(bttn_AddCurrentHealth, "flowy,cell 2 0,alignx center");
		
		JButton bttn_SubCurrentHealth = new JButton("-");
		bttn_SubCurrentHealth.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
		        JFrame jFrame = new JFrame();
		        String value = JOptionPane.showInputDialog(jFrame, "Enter value: ");
		        
		        if ( value == null || value.length() == 0 )
		        {
		        	jFrame.dispose();
		        }
		        
		        try
		        {
		        	Hurt( ( Integer.parseInt( value ) ) );
		        }
		        catch ( NumberFormatException ex_num )
		        {
		        	// logging?
		        }
		        
		        jFrame.dispose();
			}
		});
		panel_Health.add(bttn_SubCurrentHealth, "cell 3 0,alignx center");
		
		JLabel lbl_MHealth = new JLabel("Max Health:");
		panel_Health.add(lbl_MHealth, "cell 0 1,alignx trailing");
		
		txt_MaxHealth = new JTextField();
		txt_MaxHealth.setText("100");
		txt_MaxHealth.setHorizontalAlignment(SwingConstants.CENTER);
		txt_MaxHealth.setBackground(UIManager.getColor("ColorChooser.background"));
		txt_MaxHealth.setEditable(false);
		panel_Health.add(txt_MaxHealth, "cell 1 1,growx");
		txt_MaxHealth.setColumns(10);
		
		JButton bttn_AddMaxHealth = new JButton("+");
		bttn_AddMaxHealth.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
		        JFrame jFrame = new JFrame();
		        String value = JOptionPane.showInputDialog(jFrame, "Enter value: ");
		        
		        if ( value == null || value.length() == 0 )
		        {
		        	jFrame.dispose();
		        }
		        
		        try
		        {
		    		int current = Integer.parseInt( txt_MaxHealth.getText() );
		    		int c_Health = Integer.parseInt( txt_CurrentHealth.getText() );
		    		if ( c_Health == current )
		    		{
		    			current += Math.abs( Integer.parseInt( value ) );
		    			SetTxtBoxInt( txt_CurrentHealth, current );
		    		}
		    		else
		    		{
		    			current += Math.abs( Integer.parseInt( value ) );
		    		}
		    		
		    		
		    		SetTxtBoxInt( txt_MaxHealth, current );
		        }
		        catch ( NumberFormatException ex_num )
		        {
		        	// logging?
		        }
		        
		        jFrame.dispose();
			}
		});
		panel_Health.add(bttn_AddMaxHealth, "cell 2 1,alignx center");
		
		JLabel lbl_THealth = new JLabel("Temp Health:");
		panel_Health.add(lbl_THealth, "cell 0 2,alignx trailing");
		
		txt_TempHealth = new JTextField();
		txt_TempHealth.setText("10");
		txt_TempHealth.setHorizontalAlignment(SwingConstants.CENTER);
		txt_TempHealth.setBackground(UIManager.getColor("ColorChooser.background"));
		txt_TempHealth.setEditable(false);
		panel_Health.add(txt_TempHealth, "cell 1 2,growx");
		txt_TempHealth.setColumns(10);
		
		JButton bttn_AddTempHealth = new JButton("+");
		panel_Health.add(bttn_AddTempHealth, "cell 2 2,alignx center");
		
		JButton bttn_SubTempHealth = new JButton("-");
		panel_Health.add(bttn_SubTempHealth, "cell 3 2,alignx center");
		
		JLabel lbl_HDie = new JLabel("Hit Die:");
		lbl_HDie.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Health.add(lbl_HDie, "cell 0 3,alignx trailing");
		
		txt_HitDie = new JTextField();
		txt_HitDie.setText("5");
		txt_HitDie.setHorizontalAlignment(SwingConstants.CENTER);
		txt_HitDie.setEditable(false);
		txt_HitDie.setBackground(UIManager.getColor("CheckBoxMenuItem.background"));
		panel_Health.add(txt_HitDie, "cell 1 3,growx");
		txt_HitDie.setColumns(10);
		
		JButton bttn_ConsumeHitDie = new JButton("Use");
		bttn_ConsumeHitDie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				int die_count = Integer.parseInt( txt_HitDie.getText() );
				int result = 0;
				int max = Integer.parseInt( txt_MaxHealth.getText() );
				int current = Integer.parseInt( txt_CurrentHealth.getText() );
				if ( !( current >= max ) )
				{
					switch ( (eDice) combo_DieSelector.getSelectedItem() )
					{
						case D4:
						{
							// set score mods to to text boxes as well
							die_count--;
							die_count = general_tools.ClampInt( die_count, 0, Integer.parseInt( txt_Level.getText() ) );
							result = dice_tools.RollD6( 1 );
							
							if ( die_count > 0 )
							{
								Heal( result );
							}
							// out of dice
						}
						case D6:
						{
							
						}
						case D8:
						{
							
						}
						case D10:
						{
							
						}
						case D12:
						{
							
						}
						default:
						{
							// picked an invalid dice type
						}break;
					}
					SetTxtBoxInt( txt_HitDie, die_count);
				}
			}
		});
		panel_Health.add(bttn_ConsumeHitDie, "cell 2 3 2 1,alignx center,aligny center");
		
		combo_DieSelector = new JComboBox();
		combo_DieSelector.setModel(new DefaultComboBoxModel(eDice.values()));
		panel_Health.add(combo_DieSelector, "cell 0 4,growx");
		
		JPanel panel_Stats = new JPanel();
		frmCharacterSheet.getContentPane().add(panel_Stats, "cell 2 0");
		panel_Stats.setLayout(new MigLayout("", "[center][][grow][][grow]", "[][][][][][][]"));
		
		JLabel lblNewLabel_3 = new JLabel("Stats");
		panel_Stats.add(lblNewLabel_3, "cell 0 0 2 1");
		
		JLabel lblNewLabel_2 = new JLabel("Saves");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lblNewLabel_2, "cell 3 0 2 1");
		
		JLabel lbl_Strength = new JLabel("Strength:");
		lbl_Strength.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lbl_Strength, "cell 0 1,grow");
		
		txt_STR = new JTextField();
		txt_STR.setEditable(false);
		txt_STR.setHorizontalAlignment(SwingConstants.CENTER);
		txt_STR.setText("11");
		panel_Stats.add(txt_STR, "cell 1 1,grow");
		txt_STR.setColumns(10);
		
		txt_StrMod = new JTextField();
		txt_StrMod.setEditable(false);
		txt_StrMod.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(txt_StrMod, "cell 2 1,growx");
		txt_StrMod.setColumns(10);
		
		JRadioButton radio_StrSave = new JRadioButton("");
		radio_StrSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if ( radio_StrSave.isSelected() )
				{
					AddProfBonus( txt_StrSave );
				}
				else
				{
					RemoveProfBonus( txt_StrSave );
				}
			}
		});
		panel_Stats.add(radio_StrSave, "cell 3 1");
		
		txt_StrSave = new JTextField();
		txt_StrSave.setHorizontalAlignment(SwingConstants.CENTER);
		txt_StrSave.setEditable(false);
		panel_Stats.add(txt_StrSave, "cell 4 1,growx");
		txt_StrSave.setColumns(10);
		
		JLabel lbl_Dexterity = new JLabel("Dexterity:");
		lbl_Dexterity.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lbl_Dexterity, "cell 0 2,grow");
		
		txt_DEX = new JTextField();
		txt_DEX.setEditable(false);
		txt_DEX.setHorizontalAlignment(SwingConstants.CENTER);
		txt_DEX.setText("14");
		panel_Stats.add(txt_DEX, "cell 1 2,grow");
		txt_DEX.setColumns(10);
		
		txt_DexMod = new JTextField();
		txt_DexMod.setEditable(false);
		txt_DexMod.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(txt_DexMod, "cell 2 2,growx");
		txt_DexMod.setColumns(10);
		
		JRadioButton radio_DexSave = new JRadioButton("");
		radio_DexSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if ( radio_DexSave.isSelected() )
				{
					AddProfBonus( txt_DexSave );
				}
				else
				{
					RemoveProfBonus( txt_DexSave );
				}
			}
		});
		panel_Stats.add(radio_DexSave, "flowx,cell 3 2");
		
		txt_DexSave = new JTextField();
		txt_DexSave.setHorizontalAlignment(SwingConstants.CENTER);
		txt_DexSave.setEditable(false);
		txt_DexSave.setColumns(10);
		panel_Stats.add(txt_DexSave, "cell 4 2,growx");
		
		JLabel lbl_Constitution = new JLabel("Constitution:");
		lbl_Constitution.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lbl_Constitution, "cell 0 3,grow");
		
		txt_CON = new JTextField();
		txt_CON.setEditable(false);
		txt_CON.setHorizontalAlignment(SwingConstants.CENTER);
		txt_CON.setText("15");
		panel_Stats.add(txt_CON, "cell 1 3,grow");
		txt_CON.setColumns(10);
		
		txt_ConMod = new JTextField();
		txt_ConMod.setEditable(false);
		txt_ConMod.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(txt_ConMod, "cell 2 3,growx");
		txt_ConMod.setColumns(10);
		
		JRadioButton radio_ConSave = new JRadioButton("");
		radio_ConSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if ( radio_ConSave.isSelected() )
				{
					AddProfBonus( txt_ConSave );
				}
				else
				{
					RemoveProfBonus( txt_ConSave );
				}
			}
		});
		panel_Stats.add(radio_ConSave, "flowx,cell 3 3");
		
		txt_ConSave = new JTextField();
		txt_ConSave.setHorizontalAlignment(SwingConstants.CENTER);
		txt_ConSave.setEditable(false);
		txt_ConSave.setColumns(10);
		panel_Stats.add(txt_ConSave, "cell 4 3,growx");
		
		JLabel lbl_Intelligence = new JLabel("Intelligence:");
		lbl_Intelligence.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lbl_Intelligence, "cell 0 4,grow");
		
		txt_INT = new JTextField();
		txt_INT.setEditable(false);
		txt_INT.setHorizontalAlignment(SwingConstants.CENTER);
		txt_INT.setText("12");
		panel_Stats.add(txt_INT, "cell 1 4,grow");
		txt_INT.setColumns(10);
		
		txt_IntMod = new JTextField();
		txt_IntMod.setEditable(false);
		txt_IntMod.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(txt_IntMod, "cell 2 4,growx");
		txt_IntMod.setColumns(10);
		
		JRadioButton radio_IntSave = new JRadioButton("");
		radio_IntSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if ( radio_IntSave.isSelected() )
				{
					AddProfBonus( txt_IntSave );
				}
				else
				{
					RemoveProfBonus( txt_IntSave );
				}
			}
		});
		panel_Stats.add(radio_IntSave, "flowx,cell 3 4");
		
		txt_IntSave = new JTextField();
		txt_IntSave.setHorizontalAlignment(SwingConstants.CENTER);
		txt_IntSave.setEditable(false);
		txt_IntSave.setColumns(10);
		panel_Stats.add(txt_IntSave, "cell 4 4,growx");
		
		JLabel lbl_Wisdom = new JLabel("Wisdom:");
		lbl_Wisdom.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lbl_Wisdom, "cell 0 5,grow");
		
		txt_WIS = new JTextField();
		txt_WIS.setEditable(false);
		txt_WIS.setHorizontalAlignment(SwingConstants.CENTER);
		txt_WIS.setText("20");
		panel_Stats.add(txt_WIS, "cell 1 5,grow");
		txt_WIS.setColumns(10);
		
		txt_WisMod = new JTextField();
		txt_WisMod.setEditable(false);
		txt_WisMod.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(txt_WisMod, "cell 2 5,growx");
		txt_WisMod.setColumns(10);
		
		JRadioButton radio_WisSave = new JRadioButton("");
		radio_WisSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if ( radio_WisSave.isSelected() )
				{
					AddProfBonus( txt_WisSave );
				}
				else
				{
					RemoveProfBonus( txt_WisSave );
				}
				
			}
		});
		panel_Stats.add(radio_WisSave, "flowx,cell 3 5");
		
		txt_WisSave = new JTextField();
		txt_WisSave.setHorizontalAlignment(SwingConstants.CENTER);
		txt_WisSave.setEditable(false);
		txt_WisSave.setColumns(10);
		panel_Stats.add(txt_WisSave, "cell 4 5,growx");
		
		JLabel lbl_Charisma = new JLabel("Charisma:");
		lbl_Charisma.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(lbl_Charisma, "cell 0 6,grow");
		
		txt_CHR = new JTextField();
		txt_CHR.setEditable(false);
		txt_CHR.setHorizontalAlignment(SwingConstants.CENTER);
		txt_CHR.setText("12");
		panel_Stats.add(txt_CHR, "cell 1 6,grow");
		txt_CHR.setColumns(10);
		
		txt_ChrMod = new JTextField();
		txt_ChrMod.setEditable(false);
		txt_ChrMod.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Stats.add(txt_ChrMod, "cell 2 6,growx");
		txt_ChrMod.setColumns(10);
		
		JRadioButton radio_ChrSave = new JRadioButton("");
		radio_ChrSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if ( radio_ChrSave.isSelected() )
				{
					AddProfBonus( txt_ChrSave );
				}
				else
				{
					RemoveProfBonus( txt_ChrSave );
				}
			}
		});
		panel_Stats.add(radio_ChrSave, "flowx,cell 3 6");
		
		txt_ChrSave = new JTextField();
		txt_ChrSave.setHorizontalAlignment(SwingConstants.CENTER);
		txt_ChrSave.setEditable(false);
		txt_ChrSave.setColumns(10);
		panel_Stats.add(txt_ChrSave, "cell 4 6,growx");
		
		JPanel panel_Skills = new JPanel();
		frmCharacterSheet.getContentPane().add(panel_Skills, "cell 0 1 1 3,grow");
		panel_Skills.setLayout(new MigLayout("", "[left][]", "[][][][][][][][][][][][][][][][][][]"));
		
		JRadioButton radio_Acrobatics = new JRadioButton("(DEX) Acrobatics");
		radio_Acrobatics.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if ( radio_Acrobatics.isSelected() )
				{
					AddProfBonus( txt_Acrobatics );
				}
				else
				{
					RemoveProfBonus( txt_Acrobatics );
				}
			}
		});
		panel_Skills.add(radio_Acrobatics, "cell 0 0");
		
		txt_Acrobatics = new JTextField();
		txt_Acrobatics.setEditable(false);
		txt_Acrobatics.setText("5");
		txt_Acrobatics.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(txt_Acrobatics, "cell 1 0,alignx center");
		txt_Acrobatics.setColumns(10);
		
		JRadioButton radio_Insight = new JRadioButton("(WIS) Insight");
		radio_Insight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if ( radio_Insight.isSelected() )
				{
					AddProfBonus( txt_Insight );
				}
				else
				{
					RemoveProfBonus( txt_Insight );
				}
			}
		});
		panel_Skills.add(radio_Insight, "cell 0 6");
		
		txt_Insight = new JTextField();
		txt_Insight.setEditable(false);
		txt_Insight.setText("5");
		txt_Insight.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(txt_Insight, "cell 1 6,growx");
		txt_Insight.setColumns(10);
		
		JRadioButton radio_AnimalHandling = new JRadioButton("(INT) Animal Handling");
		radio_AnimalHandling.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if ( radio_AnimalHandling.isSelected() )
				{
					AddProfBonus( txt_AnimalHandling );
				}
				else
				{
					RemoveProfBonus( txt_AnimalHandling );
				}
			}
		});
		panel_Skills.add(radio_AnimalHandling, "cell 0 1");
		
		txt_AnimalHandling = new JTextField();
		txt_AnimalHandling.setEditable(false);
		txt_AnimalHandling.setText("5");
		txt_AnimalHandling.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(txt_AnimalHandling, "cell 1 1,growx");
		txt_AnimalHandling.setColumns(10);
		
		JRadioButton radio_Arcana = new JRadioButton("(INT) Arcana");
		radio_Arcana.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if ( radio_Arcana.isSelected() )
				{
					AddProfBonus( txt_Arcana );
				}
				else
				{
					RemoveProfBonus( txt_Arcana );
				}
			}
		});
		panel_Skills.add(radio_Arcana, "flowy,cell 0 2");
		
		txt_Arcana = new JTextField();
		txt_Arcana.setEditable(false);
		txt_Arcana.setText("5");
		txt_Arcana.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(txt_Arcana, "cell 1 2,growx");
		txt_Arcana.setColumns(10);
		
		JRadioButton radio_Intimidation = new JRadioButton("(CHR) Intimidation");
		radio_Intimidation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if ( radio_Intimidation.isSelected() )
				{
					AddProfBonus( txt_Intimidation );
				}
				else
				{
					RemoveProfBonus( txt_Intimidation );
				}
			}
		});
		panel_Skills.add(radio_Intimidation, "cell 0 7");
		
		JRadioButton radio_Athletics = new JRadioButton("(STR) Athletics");
		radio_Athletics.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if ( radio_Athletics.isSelected() )
				{
					AddProfBonus( txt_Athletics );
				}
				else
				{
					RemoveProfBonus( txt_Athletics );
				}
			}
		});
		panel_Skills.add(radio_Athletics, "cell 0 3");
		
		txt_Athletics = new JTextField();
		txt_Athletics.setEditable(false);
		txt_Athletics.setText("5");
		txt_Athletics.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(txt_Athletics, "cell 1 3,growx");
		txt_Athletics.setColumns(10);
		
		txt_Intimidation = new JTextField();
		txt_Intimidation.setEditable(false);
		txt_Intimidation.setText("5");
		txt_Intimidation.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Intimidation.setColumns(10);
		panel_Skills.add(txt_Intimidation, "cell 1 7,growx");
		
		JRadioButton radio_Deception = new JRadioButton("(CHR) Deception");
		radio_Deception.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if ( radio_Deception.isSelected() )
				{
					AddProfBonus( txt_Deception );
				}
				else
				{
					RemoveProfBonus( txt_Deception );
				}
			}
		});
		panel_Skills.add(radio_Deception, "cell 0 4");
		
		txt_Deception = new JTextField();
		txt_Deception.setEditable(false);
		txt_Deception.setText("5");
		txt_Deception.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(txt_Deception, "cell 1 4,growx");
		txt_Deception.setColumns(10);
		
		JRadioButton radio_History = new JRadioButton("(INT) History");
		radio_History.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if ( radio_History.isSelected() )
				{
					AddProfBonus( txt_History );
				}
				else
				{
					RemoveProfBonus( txt_History );
				}
			}
		});
		panel_Skills.add(radio_History, "cell 0 5");
		
		txt_History = new JTextField();
		txt_History.setEditable(false);
		txt_History.setText("5");
		txt_History.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(txt_History, "cell 1 5,growx");
		txt_History.setColumns(10);
		
		JRadioButton radio_Investigation = new JRadioButton("(Int) Investigation");
		radio_Investigation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if ( radio_Investigation.isSelected() )
				{
					AddProfBonus( txt_Investigation );
				}
				else
				{
					RemoveProfBonus( txt_Investigation );
				}
			}
		});
		panel_Skills.add(radio_Investigation, "cell 0 8");
		
		txt_Investigation = new JTextField();
		txt_Investigation.setEditable(false);
		txt_Investigation.setText("5");
		txt_Investigation.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Investigation.setColumns(10);
		panel_Skills.add(txt_Investigation, "cell 1 8,growx");
		
		JRadioButton radio_Medicine = new JRadioButton("(WIS) Medicine");
		radio_Medicine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if ( radio_Medicine.isSelected() )
				{
					AddProfBonus( txt_Medicine );
				}
				else
				{
					RemoveProfBonus( txt_Medicine );
				}
			}
		});
		panel_Skills.add(radio_Medicine, "cell 0 9");
		
		txt_Medicine = new JTextField();
		txt_Medicine.setEditable(false);
		txt_Medicine.setText("5");
		txt_Medicine.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Medicine.setColumns(10);
		panel_Skills.add(txt_Medicine, "cell 1 9,growx");
		
		JRadioButton radio_Nature = new JRadioButton("(INT) Nature");
		radio_Nature.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if ( radio_Nature.isSelected() )
				{
					AddProfBonus( txt_Nature );
				}
				else
				{
					RemoveProfBonus( txt_Nature );
				}
			}
		});
		panel_Skills.add(radio_Nature, "cell 0 10");
		
		txt_Nature = new JTextField();
		txt_Nature.setEditable(false);
		txt_Nature.setText("5");
		txt_Nature.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Nature.setColumns(10);
		panel_Skills.add(txt_Nature, "cell 1 10,growx");
		
		JRadioButton radio_Perception = new JRadioButton("(WIS) Perception");
		radio_Perception.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if ( radio_Perception.isSelected() )
				{
					AddProfBonus( txt_Perception );
				}
				else
				{
					RemoveProfBonus( txt_Perception );
				}
			}
		});
		panel_Skills.add(radio_Perception, "cell 0 11");
		
		txt_Perception = new JTextField();
		txt_Perception.setEditable(false);
		txt_Perception.setText("5");
		txt_Perception.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Perception.setColumns(10);
		panel_Skills.add(txt_Perception, "cell 1 11,growx");
		
		JRadioButton radio_Performance = new JRadioButton("(CHR) Performance");
		radio_Performance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if ( radio_Performance.isSelected() )
				{
					AddProfBonus( txt_Performance );
				}
				else
				{
					RemoveProfBonus( txt_Performance );
				}
			}
		});
		panel_Skills.add(radio_Performance, "cell 0 12");
		
		txt_Performance = new JTextField();
		txt_Performance.setEditable(false);
		txt_Performance.setText("5");
		txt_Performance.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Skills.add(txt_Performance, "cell 1 12,growx");
		txt_Performance.setColumns(10);
		
		JRadioButton radio_Persuasion = new JRadioButton("(CHR) Persuasion");
		radio_Persuasion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if ( radio_Persuasion.isSelected() )
				{
					AddProfBonus( txt_Persuasion );
				}
				else
				{
					RemoveProfBonus( txt_Persuasion );
				}
			}
		});
		panel_Skills.add(radio_Persuasion, "cell 0 13");
		
		txt_Persuasion = new JTextField();
		txt_Persuasion.setEditable(false);
		txt_Persuasion.setText("5");
		txt_Persuasion.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Persuasion.setColumns(10);
		panel_Skills.add(txt_Persuasion, "cell 1 13,growx");
		
		JRadioButton radio_Religion = new JRadioButton("(INT) Religion");
		radio_Religion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if ( radio_Religion.isSelected() )
				{
					AddProfBonus( txt_Religion );
				}
				else
				{
					RemoveProfBonus( txt_Religion );
				}
			}
		});
		panel_Skills.add(radio_Religion, "cell 0 14");
		
		txt_Religion = new JTextField();
		txt_Religion.setEditable(false);
		txt_Religion.setText("5");
		txt_Religion.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Religion.setColumns(10);
		panel_Skills.add(txt_Religion, "cell 1 14,growx");
		
		JRadioButton radio_SleightOfHand = new JRadioButton("(DEX) Sleight of Hand");
		radio_SleightOfHand.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if ( radio_SleightOfHand.isSelected() )
				{
					AddProfBonus( txt_SleightOfHand );
				}
				else
				{
					RemoveProfBonus( txt_SleightOfHand );
				}
			}
		});
		panel_Skills.add(radio_SleightOfHand, "cell 0 15");
		
		txt_SleightOfHand = new JTextField();
		txt_SleightOfHand.setEditable(false);
		txt_SleightOfHand.setHorizontalAlignment(SwingConstants.CENTER);
		txt_SleightOfHand.setText("5");
		txt_SleightOfHand.setColumns(10);
		panel_Skills.add(txt_SleightOfHand, "cell 1 15,growx");
		
		JRadioButton radio_Stealth = new JRadioButton("(DEX) Stealth");
		radio_Stealth.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if ( radio_Stealth.isSelected() )
				{
					AddProfBonus( txt_Stealth );
				}
				else
				{
					RemoveProfBonus( txt_Stealth );
				}
			}
		});
		panel_Skills.add(radio_Stealth, "cell 0 16");
		
		txt_Stealth = new JTextField();
		txt_Stealth.setEditable(false);
		txt_Stealth.setText("5");
		txt_Stealth.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Stealth.setColumns(10);
		panel_Skills.add(txt_Stealth, "cell 1 16,growx");
		
		JRadioButton radio_Survival = new JRadioButton("(WIS) Survival");
		radio_Survival.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if ( radio_Survival.isSelected() )
				{
					AddProfBonus( txt_Survival );
				}
				else
				{
					RemoveProfBonus( txt_Survival );
				}
			}
		});
		panel_Skills.add(radio_Survival, "cell 0 17");
		
		txt_Survival = new JTextField();
		txt_Survival.setEditable(false);
		txt_Survival.setText("5");
		txt_Survival.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Survival.setColumns(10);
		panel_Skills.add(txt_Survival, "cell 1 17,growx");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmCharacterSheet.getContentPane().add(tabbedPane, "cell 1 1 2 3,grow");
		
		JPanel panel_ActionsTab = new JPanel();
		tabbedPane.addTab("Actions", null, panel_ActionsTab, null);
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
		tabbedPane.addTab("Proficiencies", null, panel_Proficiences, null);
		panel_Proficiences.setLayout(new GridLayout(1, 0, 0, 0));
		
		scroll_Proficiences = new JScrollPane();
		panel_Proficiences.add(scroll_Proficiences);
		
		area_Proficiences = new JTextArea();
		scroll_Proficiences.setViewportView(area_Proficiences);
		
		JPanel panel_Advantages = new JPanel();
		tabbedPane.addTab("Adv/Disadv", null, panel_Advantages, null);
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
		tabbedPane.addTab("Bonuses", null, panel_Bonuses, null);
		panel_Bonuses.setLayout(new GridLayout(1, 1, 0, 0));
		
		scroll_Bonuses = new JScrollPane();
		panel_Bonuses.add(scroll_Bonuses);
		
		area_Bonuses = new JTextArea();
		scroll_Bonuses.setViewportView(area_Bonuses);
	}
	
	public void ToggleVisibility()
	{
		if ( frmCharacterSheet.isVisible() )
		{
			frmCharacterSheet.setVisible( false );
		}
		else
		{
			frmCharacterSheet.setVisible( true );
		}
	}
	
	public void ToggleVisibility( boolean value )
	{
		frmCharacterSheet.setVisible(value);
	}
	
	public void SetTxtBoxInt( JTextField txt_box, int val)
	{
		txt_box.setText( Integer.toString( val ) );
	}
	
	public void Heal( int val )
	{
		int max_heal = Integer.parseInt( txt_MaxHealth.getText() );
		int current = Integer.parseInt( txt_CurrentHealth.getText() );
		current += val;
		current = general_tools.ClampInt( current, 0, max_heal);
		txt_CurrentHealth.setText( Integer.toString( current ) );
	}
	
	public void Hurt( int val )
	{
		int max_hurt = Integer.parseInt( txt_MaxHealth.getText() );
		int current = Integer.parseInt( txt_CurrentHealth.getText() );
		current -= val;
		current = general_tools.ClampInt( current, 0, max_hurt );
		txt_CurrentHealth.setText( Integer.toString( current ) );
	}
	
	public void init_StatMods()
	{
		
		int str_value = ( Integer.parseInt( txt_STR.getText() ) - 10 ) / 2;
		int dex_value = ( Integer.parseInt( txt_DEX.getText() ) - 10 ) / 2;
		int con_value = ( Integer.parseInt( txt_CON.getText() ) - 10 ) / 2;
		int int_value = ( Integer.parseInt( txt_INT.getText() ) - 10 ) / 2;
		int wis_value = ( Integer.parseInt( txt_WIS.getText() ) - 10 ) / 2;
		int chr_value = ( Integer.parseInt( txt_CHR.getText() ) - 10 ) / 2;
		

		SetTxtBoxInt( txt_StrMod, str_value );
		SetTxtBoxInt( txt_DexMod, dex_value );
		SetTxtBoxInt( txt_ConMod, con_value );
		SetTxtBoxInt( txt_IntMod, int_value );
		SetTxtBoxInt( txt_WisMod, wis_value );
		SetTxtBoxInt( txt_ChrMod, chr_value );
		

		SetTxtBoxInt( txt_StrSave, str_value );
		SetTxtBoxInt( txt_DexSave, dex_value );
		SetTxtBoxInt( txt_ConSave, con_value );
		SetTxtBoxInt( txt_IntSave, int_value );
		SetTxtBoxInt( txt_WisSave, wis_value );
		SetTxtBoxInt( txt_ChrSave, chr_value );
		
		
		SetTxtBoxInt( txt_Acrobatics, dex_value );
		SetTxtBoxInt( txt_AnimalHandling, wis_value );
		SetTxtBoxInt( txt_Arcana, int_value );
		SetTxtBoxInt( txt_Athletics, str_value );
		SetTxtBoxInt( txt_Deception, chr_value );
		SetTxtBoxInt( txt_History, int_value );
		SetTxtBoxInt( txt_Insight, wis_value );
		SetTxtBoxInt( txt_Performance, chr_value );
		SetTxtBoxInt( txt_Intimidation, chr_value );
		SetTxtBoxInt( txt_Investigation, int_value );
		SetTxtBoxInt( txt_Medicine, wis_value );
		SetTxtBoxInt( txt_Nature, int_value );
		SetTxtBoxInt( txt_Perception, wis_value );
		SetTxtBoxInt( txt_Persuasion, chr_value );
		SetTxtBoxInt( txt_Religion, int_value );
		SetTxtBoxInt( txt_SleightOfHand, dex_value );
		SetTxtBoxInt( txt_Stealth, dex_value );
		SetTxtBoxInt( txt_Survival, wis_value );
	}
	
	public void UpdateXP( int xp_received )
	{
		// NOTE (Luis): Player level is always 1 or greater, and is also used as the index for the 2d array, index 0 never accessed
		int current_xp = Integer.parseInt( txt_Experience.getText() );
		int current_level = Integer.parseInt( txt_Level.getText() );
		
		if (current_xp + xp_received >= xp_table[current_level][0])
		{
			System.out.print("current level: " + Integer.toString( current_level ) + "\n" );
			System.out.print("current xp: " + Integer.toString( current_xp + xp_received ) + "\n" );
			SetTxtBoxInt( txt_Level, current_level + 1);
			SetTxtBoxInt( txt_Proficiency, xp_table[current_level][1] );	
		}
		current_xp += xp_received;
		SetTxtBoxInt( txt_Experience, current_xp);
	}
	
	public void AddProfBonus( JTextField field )
	{
		int prof_bonus = Integer.parseInt( txt_Proficiency.getText() );
		int field_val = Integer.parseInt( field.getText() );
		
		SetTxtBoxInt( field, field_val + prof_bonus);
	}
	
	public void RemoveProfBonus( JTextField field )
	{
		int prof_bonus = Integer.parseInt( txt_Proficiency.getText() );
		int field_val = Integer.parseInt( field.getText() );
		
		SetTxtBoxInt( field, field_val - prof_bonus);
	}
}

