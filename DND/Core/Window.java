package core;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Window {

	private JFrame frmCharacterRandomizer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frmCharacterRandomizer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCharacterRandomizer = new JFrame();
		frmCharacterRandomizer.setTitle("Character Randomizer");
		frmCharacterRandomizer.setBounds(100, 100, 450, 300);
		frmCharacterRandomizer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmCharacterRandomizer.setJMenuBar(menuBar);
		
		JMenu mnNew = new JMenu("New");
		menuBar.add(mnNew);
		
		JMenuItem mntmFullRandom = new JMenuItem("Full Random");
		mnNew.add(mntmFullRandom);
		
		JMenu mnPrint = new JMenu("Print");
		menuBar.add(mnPrint);
	}

}
