package dnd_gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class InventorySheet {

	private JFrame frame;

	
	/**
	 * Create the application.
	 */
	public InventorySheet() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 768, 305);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow][grow][grow][grow]", "[grow]"));
		
		JPanel panel_Valubles = new JPanel();
		frame.getContentPane().add(panel_Valubles, "cell 0 0,grow");
		panel_Valubles.setLayout(new MigLayout("", "[grow]", "[][grow]"));
		
		JPanel panel = new JPanel();
		panel_Valubles.add(panel, "cell 0 0,alignx center,growy");
		panel.setLayout(new MigLayout("", "[][][][][][][][]", "[][]"));
		
		JLabel lblNewLabel = new JLabel("Platinum: ");
		panel.add(lblNewLabel, "cell 0 0");
		
		JLabel lbl_Platinum = new JLabel("1000");
		panel.add(lbl_Platinum, "cell 1 0,alignx center");
		
		JLabel lblNewLabel_1 = new JLabel("Gold:");
		panel.add(lblNewLabel_1, "cell 3 0");
		
		JLabel lbl_Gold = new JLabel("1000");
		panel.add(lbl_Gold, "cell 4 0,alignx center");
		
		JLabel lblNewLabel_2 = new JLabel("Electrum:");
		panel.add(lblNewLabel_2, "cell 6 0");
		
		JLabel lbl_Electrum = new JLabel("1000");
		panel.add(lbl_Electrum, "cell 7 0,alignx center");
		
		JLabel lblNewLabel_3 = new JLabel("Silver:");
		panel.add(lblNewLabel_3, "cell 0 1");
		
		JLabel lbl_Silver = new JLabel("1000");
		panel.add(lbl_Silver, "cell 1 1,alignx center");
		
		JLabel lblNewLabel_4 = new JLabel("Copper:");
		panel.add(lblNewLabel_4, "cell 3 1");
		
		JLabel lbl_Copper = new JLabel("1000");
		panel.add(lbl_Copper, "cell 4 1,alignx center");
		
		JLabel lblNewLabel_5 = new JLabel("Soul Coins:");
		panel.add(lblNewLabel_5, "cell 6 1");
		
		JLabel lbl_SoulCoins = new JLabel("1000");
		panel.add(lbl_SoulCoins, "cell 7 1,alignx center");
		
		JPanel panel_4 = new JPanel();
		panel_Valubles.add(panel_4, "cell 0 1,grow");
		panel_4.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JTextArea area_Valuables = new JTextArea();
		panel_4.add(area_Valuables, "cell 0 0,grow");
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, "cell 1 0,grow");
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, "cell 2 0,grow");
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, "cell 3 0,grow");
	}

}
