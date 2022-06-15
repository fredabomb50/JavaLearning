package dnd_gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdjustValue
{
	private JFrame frame;
	public int value = 0;
	private JTextField txt_Value;
	

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					AdjustValue window = new AdjustValue();
					window.frame.setVisible(true);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the application.
	 */
	public AdjustValue()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 312, 201);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][][][][]", "[][]"));
		
		JButton bttn_SendValue = new JButton("Send");
		bttn_SendValue.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				value = Integer.parseInt( txt_Value.getText() );
				frame.dispose();
			}
		});
		frame.getContentPane().add(bttn_SendValue, "cell 0 1");
		
		txt_Value = new JTextField();
		txt_Value.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(txt_Value, "cell 3 1 2 1,growx");
		txt_Value.setColumns(10);
	}

}
