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
	
	public JFrame frmSpellSheet;

	/**
	 * Create the application.
	 */
	public SpellSheet()
	{
		initialize();
		frmSpellSheet.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSpellSheet = new JFrame();
		frmSpellSheet.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\_BULK\\Image Resources\\dnd\\dnd_beyond.png"));
		frmSpellSheet.setTitle("Spell Sheet");
		frmSpellSheet.setBounds(100, 100, 645, 430);
		frmSpellSheet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpellSheet.getContentPane().setLayout(new MigLayout("", "[grow]", "[][grow]"));
		
		JPanel panel_SpellCastingInfo = new JPanel();
		frmSpellSheet.getContentPane().add(panel_SpellCastingInfo, "cell 0 0,growx,aligny top");
		panel_SpellCastingInfo.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][][][][][][][][][]", "[]"));
		
		JLabel lblNewLabel = new JLabel("Spellcasting Ability: ");
		panel_SpellCastingInfo.add(lblNewLabel, "cell 0 0");
		
		JLabel lbl_SpellCastingAbility = new JLabel("INT");
		panel_SpellCastingInfo.add(lbl_SpellCastingAbility, "cell 1 0");
		
		JLabel lblNewLabel_2 = new JLabel("Spell Save DC:");
		panel_SpellCastingInfo.add(lblNewLabel_2, "cell 3 0");
		
		JLabel lbl_SpellSaveDC = new JLabel("20");
		panel_SpellCastingInfo.add(lbl_SpellSaveDC, "cell 4 0");
		
		JLabel lblNewLabel_4 = new JLabel("Spell Attack Bonus:");
		panel_SpellCastingInfo.add(lblNewLabel_4, "cell 6 0");
		
		JLabel lbl_SpellAttackBonus = new JLabel("20");
		panel_SpellCastingInfo.add(lbl_SpellAttackBonus, "cell 7 0");
		
		JLabel lblNewLabel_1 = new JLabel("Spells known:");
		panel_SpellCastingInfo.add(lblNewLabel_1, "cell 22 0");
		
		JLabel lbl_SpellsKnown = new JLabel("14");
		panel_SpellCastingInfo.add(lbl_SpellsKnown, "cell 23 0");
		
		JTabbedPane tabs_SpellLevels = new JTabbedPane(JTabbedPane.RIGHT);
		frmSpellSheet.getContentPane().add(tabs_SpellLevels, "cell 0 1,grow");
		
		JPanel panel_Cantrips = new JPanel();
		tabs_SpellLevels.addTab("Cantrips", null, panel_Cantrips, null);
		panel_Cantrips.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_Cantrips.add(scrollPane, "cell 0 0,grow");
		
		JLabel lbl_CantripSlots = new JLabel("Spell Slots: -1");
		lbl_CantripSlots.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lbl_CantripSlots);
		
		JTextArea area_Cantrips = new JTextArea();
		scrollPane.setViewportView(area_Cantrips);
		
		JPanel panel_1stLevel = new JPanel();
		tabs_SpellLevels.addTab("1st Level", null, panel_1stLevel, null);
		panel_1stLevel.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1stLevel.add(scrollPane_1, "cell 0 0,grow");
		
		JLabel lbl_1stLevelSlots = new JLabel("Spell Slots: 4");
		lbl_1stLevelSlots.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_1.setColumnHeaderView(lbl_1stLevelSlots);
		
		JTextArea area_1stLevel = new JTextArea();
		scrollPane_1.setViewportView(area_1stLevel);
		
		JPanel panel_2ndLevel = new JPanel();
		tabs_SpellLevels.addTab("2nd Level", null, panel_2ndLevel, null);
		panel_2ndLevel.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_2ndLevel.add(scrollPane_2, "cell 0 0,grow");
		
		JLabel lbl_2ndLevelSlots = new JLabel("Spell Slots: 3");
		lbl_2ndLevelSlots.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_2.setColumnHeaderView(lbl_2ndLevelSlots);
		
		JTextArea area_2ndLevel = new JTextArea();
		scrollPane_2.setViewportView(area_2ndLevel);
		
		JPanel panel_3rdLevel = new JPanel();
		tabs_SpellLevels.addTab("3rd Level", null, panel_3rdLevel, null);
		panel_3rdLevel.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel_3rdLevel.add(scrollPane_3, "cell 0 0,grow");
		
		JLabel lbl_3rdLevelSlots = new JLabel("Spell Slots: 2");
		lbl_3rdLevelSlots.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_3.setColumnHeaderView(lbl_3rdLevelSlots);
		
		JTextArea area_3rdLevel = new JTextArea();
		scrollPane_3.setViewportView(area_3rdLevel);
		
		JPanel panel_4thLevel = new JPanel();
		tabs_SpellLevels.addTab("4th Level", null, panel_4thLevel, null);
		panel_4thLevel.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JScrollPane scrollPane_4 = new JScrollPane();
		panel_4thLevel.add(scrollPane_4, "cell 0 0,grow");
		
		JLabel lbl_4thLevelSlots = new JLabel("Spell Slots: 0");
		lbl_4thLevelSlots.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_4.setColumnHeaderView(lbl_4thLevelSlots);
		
		JTextArea area_4thLevel = new JTextArea();
		scrollPane_4.setViewportView(area_4thLevel);
		
		JPanel panel_5thLevel = new JPanel();
		tabs_SpellLevels.addTab("5th Level", null, panel_5thLevel, null);
		panel_5thLevel.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JScrollPane scrollPane_5 = new JScrollPane();
		panel_5thLevel.add(scrollPane_5, "cell 0 0,grow");
		
		JLabel lbl_5thLevelSlots = new JLabel("Spell Slots: 0");
		lbl_5thLevelSlots.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_5.setColumnHeaderView(lbl_5thLevelSlots);
		
		JTextArea area_5thLevel = new JTextArea();
		scrollPane_5.setViewportView(area_5thLevel);
		
		JPanel panel_6thLevel = new JPanel();
		tabs_SpellLevels.addTab("6th Level", null, panel_6thLevel, null);
		
		JPanel panel_7thLevel = new JPanel();
		tabs_SpellLevels.addTab("7th Level", null, panel_7thLevel, null);
		
		JPanel panel_8thLevel = new JPanel();
		tabs_SpellLevels.addTab("8th Level", null, panel_8thLevel, null);
		
		JPanel panel_9thLevel = new JPanel();
		tabs_SpellLevels.addTab("9th Level", null, panel_9thLevel, null);
	}

}
