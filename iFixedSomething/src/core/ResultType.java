package core;

import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JTextField;

public enum ResultType
{
	FT_Ready,
	EST,
	Intel_Hold;
}



/*
		public Window() {
		checkFileStructure();
		runMacros();
		initialize();
	}


		JButton bttn_Debug = new JButton("Debug");
		bttn_Debug.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_Debug.setVisible(true);
				panel_Settings.setVisible(false);
			}
		});
		
		
		JButton bttn_Settings = new JButton("Settings");
		bttn_Settings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_Settings.setVisible(true);
				panel_Debug.setVisible(false);
			}
		});


		txt_ModelNumber = new JTextField();
		txt_ModelNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e)
			{
				if (e.getKeyCode() == 10)
				{
					txt_ModelNumber.setEnabled(false);
					txt_ServiceTag.requestFocusInWindow();
				}
			}
		});
		
		


	
	// needs to be parameterized so any pop up can be opened
	public void showPopUp()
	{
		Pop_DebugNote temp = new Pop_DebugNote();
		temp.show();
	}
	
	// clean closure of application
	public void exit_App()
	{
		// create windows-safe event for closing app
		WindowEvent event = new WindowEvent(frmIfixedsomething, WindowEvent.WINDOW_CLOSING);
		
		// close process for macros.exe
		proc_Macro.destroy();
		
		// post windows-safe event
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(event);
		
		// remove GUI from screen
		frmIfixedsomething.setVisible(false);
		
		// dispose of class instance
		frmIfixedsomething.dispose();
		
		// exit application
		System.exit(0);
	}
	
	// run macros.exe
	public void runMacros()
*/