package core;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Toolkit;
import java.awt.Window.Type;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.swing.JLayeredPane;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;

public class Window {

	private JFrame frmIfixedsomething;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frmIfixedsomething.setVisible(true);
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

	public void exit_App()
	{
		WindowEvent event = new WindowEvent(frmIfixedsomething, WindowEvent.WINDOW_CLOSING);
		
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(event);
		frmIfixedsomething.setVisible(false);
		frmIfixedsomething.dispose();
		
		System.exit(0);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIfixedsomething = new JFrame();
		frmIfixedsomething.setResizable(false);
		frmIfixedsomething.setTitle("iFixedSomething");
		frmIfixedsomething.setIconImage(Toolkit.getDefaultToolkit().getImage("W:\\JavaLearning\\iFixedSomething\\resources\\grey_ivy_logo.png"));
		frmIfixedsomething.setBounds(100, 100, 400, 300);
		frmIfixedsomething.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIfixedsomething.setUndecorated(true);
		frmIfixedsomething.getContentPane().setLayout(new GridLayout(1, 1, 0, 0));
		
		JSplitPane split_Frame = new JSplitPane();
		frmIfixedsomething.getContentPane().add(split_Frame);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		split_Frame.setRightComponent(layeredPane);
		
		JPanel panel_Menu = new JPanel();
		split_Frame.setLeftComponent(panel_Menu);
		panel_Menu.setLayout(new GridLayout(7, 1, 0, 0));
		
		JButton bttn_Debug = new JButton("Debug");
		panel_Menu.add(bttn_Debug);
		
		JButton bttn_Rework = new JButton("Rework");
		panel_Menu.add(bttn_Rework);
		
		JButton bttn_Admin = new JButton("Admin");
		panel_Menu.add(bttn_Admin);
		
		JLabel lbl_MenuPlaceholder = new JLabel(" ");
		panel_Menu.add(lbl_MenuPlaceholder);
		
		JLabel lbl_MenuPlaceholder_1 = new JLabel(" ");
		panel_Menu.add(lbl_MenuPlaceholder_1);
		
		JLabel lbl_MenuPlaceholder_2 = new JLabel(" ");
		panel_Menu.add(lbl_MenuPlaceholder_2);
		
		JButton bttn_Exit = new JButton("Exit");
		bttn_Exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exit_App();
			}
		});
		panel_Menu.add(bttn_Exit);
	}
}
