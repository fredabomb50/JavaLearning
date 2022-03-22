package core;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

public class Pop_DebugNote {

	private JFrame frmNote;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pop_DebugNote window = new Pop_DebugNote();
					window.frmNote.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pop_DebugNote() {
		initialize();
	}

	public void close()
	{
		frmNote.setVisible(false);
		frmNote.dispose();
	}
	
	public void show()
	{
		frmNote.setVisible(true);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNote = new JFrame();
		frmNote.setIconImage(Toolkit.getDefaultToolkit().getImage("W:\\JavaLearning\\iFixedSomething\\Resources\\grey_ivy_logo.png"));
		frmNote.setTitle("Note");
		frmNote.setBounds(100, 100, 450, 300);
		frmNote.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmNote.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(ResultType.values()));
		comboBox.setBounds(10, 11, 125, 30);
		panel.add(comboBox);
		
		JTextArea txtbx_Note = new JTextArea();
		txtbx_Note.setBounds(10, 58, 414, 158);
		panel.add(txtbx_Note);
		
		JButton bttn_Submit = new JButton("Submit");
		bttn_Submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				close();
			}
		});
		bttn_Submit.setBounds(335, 227, 89, 23);
		panel.add(bttn_Submit);
		
		
	}
}
