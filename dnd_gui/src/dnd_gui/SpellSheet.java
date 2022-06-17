package dnd_gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;

public class SpellSheet {

	private JFrame frmSpellSheet;

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
		frmSpellSheet.setBounds(100, 100, 450, 300);
		frmSpellSheet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
