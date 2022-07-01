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


	/**
	 * Create the application.
	 */
	public NotesSheet() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Notes");
		frame.setBounds(100, 100, 630, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabs_Notes = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabs_Notes, BorderLayout.CENTER);
		
		JPanel panel_People = new JPanel();
		tabs_Notes.addTab("People", null, panel_People, null);
		panel_People.setLayout(new GridLayout(1, 0, 0, 0));
		
		JTextArea textArea_6 = new JTextArea();
		panel_People.add(textArea_6);
		
		JPanel panel_Places = new JPanel();
		tabs_Notes.addTab("Places", null, panel_Places, null);
		panel_Places.setLayout(new GridLayout(1, 0, 0, 0));
		
		JTextArea textArea_5 = new JTextArea();
		panel_Places.add(textArea_5);
		
		JPanel panel_History = new JPanel();
		tabs_Notes.addTab("History", null, panel_History, null);
		panel_History.setLayout(new GridLayout(1, 0, 0, 0));
		
		JTextArea textArea_4 = new JTextArea();
		panel_History.add(textArea_4);
		
		JPanel panel_Quests = new JPanel();
		tabs_Notes.addTab("Quests", null, panel_Quests, null);
		panel_Quests.setLayout(new GridLayout(1, 0, 0, 0));
		
		JTextArea textArea_3 = new JTextArea();
		panel_Quests.add(textArea_3);
		
		JPanel panel_Factions = new JPanel();
		tabs_Notes.addTab("Factions", null, panel_Factions, null);
		panel_Factions.setLayout(new GridLayout(1, 0, 0, 0));
		
		JTextArea textArea_2 = new JTextArea();
		panel_Factions.add(textArea_2);
		
		JPanel panel_Fauna = new JPanel();
		tabs_Notes.addTab("Fauna", null, panel_Fauna, null);
		panel_Fauna.setLayout(new GridLayout(1, 0, 0, 0));
		
		JTextArea textArea_1 = new JTextArea();
		panel_Fauna.add(textArea_1);
		
		JPanel panel_Flora = new JPanel();
		tabs_Notes.addTab("Flora", null, panel_Flora, null);
		panel_Flora.setLayout(new GridLayout(1, 0, 0, 0));
		
		JTextArea textArea = new JTextArea();
		panel_Flora.add(textArea);
	}

}
