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
import javax.swing.WindowConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomDialogs extends Sheet
{
	
	// Stored values to pass along
	private static int stored_value = 0;
	private static E_Currency stored_currency = null;
	private static E_Skills stored_skill = null;
	
	
	// GUI stuff
	private static JFrame frame;
	private static JDialog custom;
	private static JTextField txt_AddField;
	
	
	
	public CustomDialogs( JFrame owner, E_Dialog type )
	{
		switch ( type )
		{
			case SelectSkill:
			{
				Select_Skill( owner );
			} break;
			
			case EnterCurrency:
			{
				
			} break;
			
			default:
			{
				
			} break;
		}
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
					stored_currency = (E_Currency) combo_SelectCurrency.getSelectedItem();
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
	public void Select_Skill( JFrame owner )
	{
		custom = new JDialog( owner, "Select Skill", true );
		custom.setBounds(100, 100, 365, 126);
		custom.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
		custom.getContentPane().setLayout(new MigLayout("", "[][grow][][grow][]", "[][][]"));
		
		JComboBox combo_SelectSkill = new JComboBox();
		combo_SelectSkill.setModel(new DefaultComboBoxModel(E_Skills.values()));
		custom.add(combo_SelectSkill, "cell 0 0,growx");
		
		JButton bttn_Confirm = new JButton("Confirm");
		bttn_Confirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				stored_skill = (E_Skills) combo_SelectSkill.getSelectedItem();
				custom.setVisible(false);
				custom.dispose();
			}
		});
		custom.add(bttn_Confirm, "cell 4 0,alignx center,aligny center");
		
		
		JButton bttn_Cancel = new JButton("Cancel");
		bttn_Cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				custom.setVisible(false);
				custom.dispose();
			}
		});
		custom.add(bttn_Cancel, "cell 0 2,alignx center,aligny center");
		custom.setVisible(true);
	}
	
	
	public int get_value()
	{
		return stored_value;
	}
	
	public E_Currency get_currency()
	{
		return stored_currency;
	}
	
	public E_Skills get_skill()
	{
		return stored_skill;
	}
}
