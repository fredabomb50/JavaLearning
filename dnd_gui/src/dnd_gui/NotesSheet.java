package dnd_gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.GridLayout;

public class NotesSheet extends Sheet
{

	public JFrame frame;
	private JTextArea area_People = null;
	private JTextArea area_Places = null;
	private JTextArea area_History = null;
	private JTextArea area_Quests = null;
	private JTextArea area_Factions = null;
	private JTextArea area_Fauna = null;
	private JTextArea area_Flora = null;

	
	public NotesSheet()
	 {
		initialize();
	 }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setTitle("Notes");
		frame.setBounds(100, 100, 630, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabs_Notes = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabs_Notes, BorderLayout.CENTER);
		
		JPanel panel_People = new JPanel();
		tabs_Notes.addTab("People", null, panel_People, null);
		panel_People.setLayout(new GridLayout(1, 0, 0, 0));
		
		area_People = new JTextArea();
		panel_People.add(area_People);
		
		JPanel panel_Places = new JPanel();
		tabs_Notes.addTab("Places", null, panel_Places, null);
		panel_Places.setLayout(new GridLayout(1, 0, 0, 0));
		
		area_Places = new JTextArea();
		panel_Places.add(area_Places);
		
		JPanel panel_History = new JPanel();
		tabs_Notes.addTab("History", null, panel_History, null);
		panel_History.setLayout(new GridLayout(1, 0, 0, 0));
		
		area_History = new JTextArea();
		panel_History.add(area_History);
		
		JPanel panel_Quests = new JPanel();
		tabs_Notes.addTab("Quests", null, panel_Quests, null);
		panel_Quests.setLayout(new GridLayout(1, 0, 0, 0));
		
		area_Quests = new JTextArea();
		panel_Quests.add(area_Quests);
		
		JPanel panel_Factions = new JPanel();
		tabs_Notes.addTab("Factions", null, panel_Factions, null);
		panel_Factions.setLayout(new GridLayout(1, 0, 0, 0));
		
		area_Factions = new JTextArea();
		panel_Factions.add(area_Factions);
		
		JPanel panel_Fauna = new JPanel();
		tabs_Notes.addTab("Fauna", null, panel_Fauna, null);
		panel_Fauna.setLayout(new GridLayout(1, 0, 0, 0));
		
		area_Fauna = new JTextArea();
		panel_Fauna.add(area_Fauna);
		
		JPanel panel_Flora = new JPanel();
		tabs_Notes.addTab("Flora", null, panel_Flora, null);
		panel_Flora.setLayout(new GridLayout(1, 0, 0, 0));
		
		area_Flora = new JTextArea();
		panel_Flora.add(area_Flora);
	}

	
	public void load_Flora( String saved_text )
	{
		area_Flora.setText( saved_text );
	}
	public void load_Fauna( String saved_text )
	{
		area_Fauna.setText( saved_text );
	}
	public void load_Factions( String saved_text )
	{
		area_Factions.setText( saved_text );
	}
	public void load_Quests( String saved_text )
	{
		area_Quests.setText( saved_text );
	}
	public void load_History( String saved_text )
	{
		area_History.setText( saved_text );
	}
	public void load_Places( String saved_text )
	{
		area_Places.setText( saved_text );
	}
	public void load_People( String saved_text )
	{
		area_People.setText( saved_text );
	}
}
