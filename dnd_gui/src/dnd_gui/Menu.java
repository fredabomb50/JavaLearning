package dnd_gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu {

	private JFrame frame_Menu;
	private CharacterSheet c_Sheet;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame_Menu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
		init_sheets();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame_Menu = new JFrame();
		frame_Menu.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\_BULK\\Image Resources\\dnd\\dnd_beyond.png"));
		frame_Menu.setBounds(100, 100, 165, 317);
		frame_Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_Menu.getContentPane().setLayout(new MigLayout("", "[grow]", "[][grow][][grow][][grow][][grow]"));
		
		JButton bttn_CharacterSheet = new JButton("Character Sheet");
		bttn_CharacterSheet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				c_Sheet.ToggleVisibility();
			}
		});
		frame_Menu.getContentPane().add(bttn_CharacterSheet, "cell 0 0 1 2,grow");
		
		JButton bttn_SpellSheet = new JButton("Spell Sheet");
		frame_Menu.getContentPane().add(bttn_SpellSheet, "cell 0 2 1 2,grow");
		
		JButton bttn_CharacterDetails = new JButton("Character Details");
		frame_Menu.getContentPane().add(bttn_CharacterDetails, "cell 0 4 1 2,grow");
		
		JButton bttn_Inventory = new JButton("Inventory");
		frame_Menu.getContentPane().add(bttn_Inventory, "cell 0 6 1 2,grow");
	}

	
	private void init_sheets()
	{
		c_Sheet = new CharacterSheet();
	}
}