package dnd_gui;

import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomDialogs extends Sheet
{
	
	// 
	
	private static JTextField txt_AddField;
	private static int stored_value = 0;
	private static E_Currency stored_type = null;
	
	private static JFrame frame;
	private static JDialog custom;
	
	public CustomDialogs()
	{
		initialize();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 365, 126);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][grow][][grow][]", "[][][]"));
		
		JComboBox combo_SelectCurrency = new JComboBox();
		combo_SelectCurrency.setModel(new DefaultComboBoxModel(E_Currency.values()));
		frame.getContentPane().add(combo_SelectCurrency, "cell 0 0,growx");
		
		txt_AddField = new JTextField();
		txt_AddField.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(txt_AddField, "cell 1 0,growx");
		txt_AddField.setColumns(10);
		
		JButton bttn_Confirm = new JButton("Confirm");
		bttn_Confirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				boolean is_valid = true;
				try
				{
					stored_value = Integer.parseInt( txt_AddField.getText() );
					stored_type = (E_Currency) combo_SelectCurrency.getSelectedItem();
				}
				catch (NumberFormatException exception)
				{
					is_valid = false;
					stored_value = 0;
				}
				
				if ( is_valid )
				{
					ToggleVisibility( frame, false );
					frame.dispose();
				}
				else
				{
					txt_AddField.setText( "???" );
				}
			}
		});
		frame.getContentPane().add(bttn_Confirm, "cell 4 0,alignx center,aligny center");
		
		JButton bttn_Cancel = new JButton("Cancel");
		bttn_Cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				frame.dispose();
			}
		});
		frame.getContentPane().add(bttn_Cancel, "cell 0 2,alignx center,aligny center");
	}

	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void test()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 365, 126);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][grow][][grow][]", "[][][]"));
		frame.setVisible(true);
		
		custom = new JDialog( frame, "Select Skill", true );
		JComboBox combo_SelectCurrency = new JComboBox();
		combo_SelectCurrency.setModel(new DefaultComboBoxModel(E_Currency.values()));
		frame.getContentPane().add(combo_SelectCurrency, "cell 0 0,growx");
		
		txt_AddField = new JTextField();
		txt_AddField.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(txt_AddField, "cell 1 0,growx");
		txt_AddField.setColumns(10);
		
		JButton bttn_Confirm = new JButton("Confirm");
		bttn_Confirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				boolean is_valid = true;
				try
				{
					stored_value = Integer.parseInt( txt_AddField.getText() );
					stored_type = (E_Currency) combo_SelectCurrency.getSelectedItem();
				}
				catch (NumberFormatException exception)
				{
					is_valid = false;
					stored_value = 0;
				}
				
				if ( is_valid )
				{
					frame.setVisible(false);
					frame.dispose();
				}
				else
				{
					txt_AddField.setText( "???" );
				}
			}
		});
		frame.getContentPane().add(bttn_Confirm, "cell 4 0,alignx center,aligny center");
		
		JButton bttn_Cancel = new JButton("Cancel");
		bttn_Cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				frame.dispose();
			}
		});
		frame.getContentPane().add(bttn_Cancel, "cell 0 2,alignx center,aligny center");
		custom.add(frame);
		
	}
	
	
	public int get_value()
	{
		return stored_value;
	}
	
	public E_Currency get_type()
	{
		return stored_type;
	}
}
