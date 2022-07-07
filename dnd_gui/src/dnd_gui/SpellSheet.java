package dnd_gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class SpellSheet extends Sheet
{
	// header should have:
	//casting ability(wisdom, int, char, etc..) && spell hit bonus (casting ability mod + prof) && spell save (8 + cast mod + prof)
	//10 tables, from 0 - 9
	// each table has 10 available entries
	// each spell needs the following:
	// cast time, duration, range, save, dmg, components 
	
	public JFrame frame;
	
	private JLabel lbl_SpellSaveDC;
	private JLabel lbl_SpellHitBonus;
	
	private JLabel lbl_CantripSlots;
	private JLabel lbl_1stLevelSlots;
	private JLabel lbl_2ndLevelSlots;
	private JLabel lbl_3rdLevelSlots;
	private JLabel lbl_4thLevelSlots;
	private JLabel lbl_5thLevelSlots;
	private JLabel lbl_6thLevelSlots;
	private JLabel lbl_7thLevelSlots;
	private JLabel lbl_8thLevelSlots;
	private JLabel lbl_9thLevelSlots;
	
	public SpellSheet()
	{
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\_BULK\\Image Resources\\dnd\\dnd_beyond.png"));
		frame.setTitle("Spell Sheet");
		frame.setBounds(100, 100, 659, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][grow]"));
		
		JPanel panel_SpellCastingInfo = new JPanel();
		frame.getContentPane().add(panel_SpellCastingInfo, "cell 0 0,growx,aligny top");
		panel_SpellCastingInfo.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][][][][][][][][][]", "[]"));
		
		JLabel lblNewLabel = new JLabel("Spellcasting Ability: ");
		panel_SpellCastingInfo.add(lblNewLabel, "cell 0 0");
		
		JLabel lbl_SpellCastingAbility = new JLabel("INT");
		panel_SpellCastingInfo.add(lbl_SpellCastingAbility, "cell 1 0");
		
		JLabel lblNewLabel_2 = new JLabel("Spell Save DC:");
		panel_SpellCastingInfo.add(lblNewLabel_2, "cell 3 0");
		
		lbl_SpellSaveDC = new JLabel("16");
		lbl_SpellSaveDC.setHorizontalAlignment(SwingConstants.CENTER);
		panel_SpellCastingInfo.add(lbl_SpellSaveDC, "cell 4 0");
		
		JLabel lblNewLabel_4 = new JLabel("Spell Attack Bonus:");
		panel_SpellCastingInfo.add(lblNewLabel_4, "cell 6 0");
		
		lbl_SpellHitBonus = new JLabel("20");
		lbl_SpellHitBonus.setHorizontalAlignment(SwingConstants.CENTER);
		panel_SpellCastingInfo.add(lbl_SpellHitBonus, "cell 7 0");
		
		JLabel lblNewLabel_1 = new JLabel("Spells known:");
		panel_SpellCastingInfo.add(lblNewLabel_1, "cell 22 0");
		
		JLabel lbl_SpellsKnown = new JLabel("14");
		panel_SpellCastingInfo.add(lbl_SpellsKnown, "cell 23 0");
		
		JTabbedPane tabs_SpellLevels = new JTabbedPane(JTabbedPane.RIGHT);
		frame.getContentPane().add(tabs_SpellLevels, "cell 0 1,grow");
		
		JPanel panel_Cantrips = new JPanel();
		tabs_SpellLevels.addTab("Cantrips", null, panel_Cantrips, null);
		panel_Cantrips.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_Cantrips.add(scrollPane, "cell 0 0,grow");
		
		lbl_CantripSlots = new JLabel("Spell Slots: -1");
		lbl_CantripSlots.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lbl_CantripSlots);
		
		JTextArea area_Cantrips = new JTextArea();
		scrollPane.setViewportView(area_Cantrips);
		
		JPanel panel_1stLevel = new JPanel();
		tabs_SpellLevels.addTab("1st Level", null, panel_1stLevel, null);
		panel_1stLevel.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1stLevel.add(scrollPane_1, "cell 0 0,grow");
		
		lbl_1stLevelSlots = new JLabel("Spell Slots: 4");
		lbl_1stLevelSlots.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_1.setColumnHeaderView(lbl_1stLevelSlots);
		
		JTextArea area_1stLevel = new JTextArea();
		scrollPane_1.setViewportView(area_1stLevel);
		
		JPanel panel_2ndLevel = new JPanel();
		tabs_SpellLevels.addTab("2nd Level", null, panel_2ndLevel, null);
		panel_2ndLevel.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_2ndLevel.add(scrollPane_2, "cell 0 0,grow");
		
		lbl_2ndLevelSlots = new JLabel("Spell Slots: 3");
		lbl_2ndLevelSlots.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_2.setColumnHeaderView(lbl_2ndLevelSlots);
		
		JTextArea area_2ndLevel = new JTextArea();
		scrollPane_2.setViewportView(area_2ndLevel);
		
		JPanel panel_3rdLevel = new JPanel();
		tabs_SpellLevels.addTab("3rd Level", null, panel_3rdLevel, null);
		panel_3rdLevel.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel_3rdLevel.add(scrollPane_3, "cell 0 0,grow");
		
		lbl_3rdLevelSlots = new JLabel("Spell Slots: 2");
		lbl_3rdLevelSlots.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_3.setColumnHeaderView(lbl_3rdLevelSlots);
		
		JTextArea area_3rdLevel = new JTextArea();
		scrollPane_3.setViewportView(area_3rdLevel);
		
		JPanel panel_4thLevel = new JPanel();
		tabs_SpellLevels.addTab("4th Level", null, panel_4thLevel, null);
		panel_4thLevel.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JScrollPane scrollPane_4 = new JScrollPane();
		panel_4thLevel.add(scrollPane_4, "cell 0 0,grow");
		
		lbl_4thLevelSlots = new JLabel("Spell Slots: 0");
		lbl_4thLevelSlots.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_4.setColumnHeaderView(lbl_4thLevelSlots);
		
		JTextArea area_4thLevel = new JTextArea();
		scrollPane_4.setViewportView(area_4thLevel);
		
		JPanel panel_5thLevel = new JPanel();
		tabs_SpellLevels.addTab("5th Level", null, panel_5thLevel, null);
		panel_5thLevel.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JScrollPane scrollPane_5 = new JScrollPane();
		panel_5thLevel.add(scrollPane_5, "cell 0 0,grow");
		
		lbl_5thLevelSlots = new JLabel("Spell Slots: 0");
		lbl_5thLevelSlots.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_5.setColumnHeaderView(lbl_5thLevelSlots);
		
		JTextArea area_5thLevel = new JTextArea();
		scrollPane_5.setViewportView(area_5thLevel);
		
		JPanel panel_6thLevel = new JPanel();
		tabs_SpellLevels.addTab("6th Level", null, panel_6thLevel, null);
		panel_6thLevel.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JScrollPane scrollPane_6 = new JScrollPane();
		panel_6thLevel.add(scrollPane_6, "cell 0 0,grow");
		
		lbl_6thLevelSlots = new JLabel("New label");
		lbl_6thLevelSlots.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_6.setColumnHeaderView(lbl_6thLevelSlots);
		
		JTextArea textArea = new JTextArea();
		scrollPane_6.setViewportView(textArea);
		
		JPanel panel_7thLevel = new JPanel();
		tabs_SpellLevels.addTab("7th Level", null, panel_7thLevel, null);
		panel_7thLevel.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JScrollPane scrollPane_7 = new JScrollPane();
		panel_7thLevel.add(scrollPane_7, "cell 0 0,grow");
		
		lbl_7thLevelSlots = new JLabel("New label");
		lbl_7thLevelSlots.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_7.setColumnHeaderView(lbl_7thLevelSlots);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_7.setViewportView(textArea_1);
		
		JPanel panel_8thLevel = new JPanel();
		tabs_SpellLevels.addTab("8th Level", null, panel_8thLevel, null);
		panel_8thLevel.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JScrollPane scrollPane_8 = new JScrollPane();
		panel_8thLevel.add(scrollPane_8, "cell 0 0,grow");
		
		lbl_8thLevelSlots = new JLabel("New label");
		lbl_8thLevelSlots.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_8.setColumnHeaderView(lbl_8thLevelSlots);
		
		JTextArea textArea_2 = new JTextArea();
		scrollPane_8.setViewportView(textArea_2);
		
		JPanel panel_9thLevel = new JPanel();
		tabs_SpellLevels.addTab("9th Level", null, panel_9thLevel, null);
		panel_9thLevel.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JScrollPane scrollPane_9 = new JScrollPane();
		panel_9thLevel.add(scrollPane_9, "cell 0 0,grow");
		
		lbl_9thLevelSlots = new JLabel("New label");
		lbl_9thLevelSlots.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_9.setColumnHeaderView(lbl_9thLevelSlots);
		
		JTextArea textArea_3 = new JTextArea();
		scrollPane_9.setViewportView(textArea_3);
	}

	
	public void update_Sheet( int[][] slots, int lvl, int new_save, int new_hit )
	{
		String prefix = "Total Slots: ";
		
		lbl_CantripSlots.setText( prefix + ( Integer.toString(slots[lvl][0]) ) );
		lbl_1stLevelSlots.setText( prefix + ( Integer.toString(slots[lvl][1]) ) );
		lbl_2ndLevelSlots.setText( prefix + ( Integer.toString(slots[lvl][2]) ) );
		lbl_3rdLevelSlots.setText( prefix + ( Integer.toString(slots[lvl][3]) ) );
		lbl_4thLevelSlots.setText( prefix + ( Integer.toString(slots[lvl][4]) ) );
		lbl_5thLevelSlots.setText( prefix + ( Integer.toString(slots[lvl][5]) ) );
		lbl_6thLevelSlots.setText( prefix + ( Integer.toString(slots[lvl][6]) ) );
		lbl_7thLevelSlots.setText( prefix + ( Integer.toString(slots[lvl][7]) ) );
		lbl_8thLevelSlots.setText( prefix + ( Integer.toString(slots[lvl][8]) ) );
		lbl_9thLevelSlots.setText( prefix + ( Integer.toString(slots[lvl][9]) ) );
		
		lbl_SpellSaveDC.setText( Integer.toString(new_save) );
		lbl_SpellHitBonus.setText( Integer.toString(new_hit) );
	}
}
