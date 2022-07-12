package dnd_gui;

import java.awt.EventQueue;
import java.util.HashMap;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class InventorySheet extends Sheet
{

	public JFrame frame;

	JLabel lbl_Platinum;
	JLabel lbl_Gold;
	JLabel lbl_Electrum;
	JLabel lbl_Silver;
	JLabel lbl_Copper;
	JLabel lbl_SoulCoins;
	
	/**
	 * Create the application.
	 */
	public InventorySheet()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setSize(new Dimension(970, 360));
		frame.setResizable(false);
		frame.setBounds(100, 100, 970, 360); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][grow][grow][grow][grow]", "[grow]"));
		
		JPanel panel_Valubles = new JPanel();
		frame.getContentPane().add(panel_Valubles, "cell 0 0,grow");
		panel_Valubles.setLayout(new MigLayout("", "[grow]", "[][grow]"));
		
		JPanel panel = new JPanel();
		panel_Valubles.add(panel, "cell 0 0,alignx center,growy");
		panel.setLayout(new MigLayout("", "[][][][][][][][]", "[][]"));
		
		JLabel lblNewLabel = new JLabel("Platinum: ");
		panel.add(lblNewLabel, "cell 0 0");
		
		lbl_Platinum = new JLabel("1000");
		panel.add(lbl_Platinum, "cell 1 0,alignx center");
		
		JLabel lblNewLabel_1 = new JLabel("Gold:");
		panel.add(lblNewLabel_1, "cell 3 0");
		
		lbl_Gold = new JLabel("1000");
		panel.add(lbl_Gold, "cell 4 0,alignx center");
		
		JLabel lblNewLabel_2 = new JLabel("Electrum:");
		panel.add(lblNewLabel_2, "cell 6 0");
		
		lbl_Electrum = new JLabel("1000");
		panel.add(lbl_Electrum, "cell 7 0,alignx center");
		
		JLabel lblNewLabel_3 = new JLabel("Silver:");
		panel.add(lblNewLabel_3, "cell 0 1");
		
		lbl_Silver = new JLabel("1000");
		panel.add(lbl_Silver, "cell 1 1,alignx center");
		
		JLabel lblNewLabel_4 = new JLabel("Copper:");
		panel.add(lblNewLabel_4, "cell 3 1");
		
		lbl_Copper = new JLabel("1000");
		panel.add(lbl_Copper, "cell 4 1,alignx center");
		
		JLabel lblNewLabel_5 = new JLabel("Soul Coins:");
		panel.add(lblNewLabel_5, "cell 6 1");
		
		lbl_SoulCoins = new JLabel("1000");
		panel.add(lbl_SoulCoins, "cell 7 1,alignx center");
		
		JPanel panel_4 = new JPanel();
		panel_Valubles.add(panel_4, "cell 0 1,grow");
		panel_4.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JTextArea area_Valuables = new JTextArea();
		panel_4.add(area_Valuables, "cell 0 0,grow");
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, "cell 1 0,grow");
		
		JLabel lblNewLabel_6 = new JLabel("Armor / Clothes");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblNewLabel_6);
		
		JTextArea textArea_3 = new JTextArea();
		scrollPane.setViewportView(textArea_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		frame.getContentPane().add(scrollPane_1, "cell 2 0,grow");
		
		JLabel lblNewLabel_7 = new JLabel("Weapons / Tools");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_1.setColumnHeaderView(lblNewLabel_7);
		
		JTextArea textArea_2 = new JTextArea();
		scrollPane_1.setViewportView(textArea_2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		frame.getContentPane().add(scrollPane_2, "cell 3 0,grow");
		
		JLabel lblNewLabel_8 = new JLabel("Consumables");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_2.setColumnHeaderView(lblNewLabel_8);
		
		JTextArea textArea = new JTextArea();
		scrollPane_2.setViewportView(textArea);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		frame.getContentPane().add(scrollPane_3, "cell 4 0,grow");
		
		JLabel lblNewLabel_9 = new JLabel("Materials");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_3.setColumnHeaderView(lblNewLabel_9);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_3.setViewportView(textArea_1);
	}
	
	public void update_Currency( HashMap<E_Currency, Integer> coins )
	{
		lbl_Platinum.setText( Integer.toString( coins.get( E_Currency.Platinum ) ) );
		lbl_Gold.setText( Integer.toString( coins.get( E_Currency.Gold ) ) );
		lbl_Electrum.setText( Integer.toString( coins.get( E_Currency.Electrum ) ) );
		lbl_Silver.setText( Integer.toString( coins.get( E_Currency.Silver ) ) );
		lbl_Copper.setText( Integer.toString( coins.get( E_Currency.Copper ) ) );
		lbl_SoulCoins.setText( Integer.toString( coins.get( E_Currency.SoulCoins ) ) );
	}
}
