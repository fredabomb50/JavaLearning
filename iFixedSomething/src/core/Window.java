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
		frmIfixedsomething.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmIfixedsomething.getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(7, 1, 0, 0));
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		
		JLabel lbl_MenuPlaceholder = new JLabel(" ");
		panel.add(lbl_MenuPlaceholder);
		
		JLabel lbl_MenuPlaceholder_1 = new JLabel(" ");
		panel.add(lbl_MenuPlaceholder_1);
		
		JLabel lbl_MenuPlaceholder_2 = new JLabel(" ");
		panel.add(lbl_MenuPlaceholder_2);
		
		JLabel lbl_MenuPlaceholder_3 = new JLabel(" ");
		panel.add(lbl_MenuPlaceholder_3);
		
		JButton bttn_Exit = new JButton("Exit");
		bttn_Exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exit_App();
			}
		});
		panel.add(bttn_Exit);
	}

	public void exit_App()
	{
		// create event that processes just like the standard "x" close button
		WindowEvent event = new WindowEvent(frmIfixedsomething, WindowEvent.WINDOW_CLOSING);
		
		// post the close event to the systems message queue; this ensures that thread and memory is freed
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(event);
		
		// visibly remove the window and its elements
		frmIfixedsomething.setVisible(false);
		frmIfixedsomething.dispose();
		
		// terminate JVM with no error code
		System.exit(0);
	}
}
