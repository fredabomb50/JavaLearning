package dnd_gui;

import javax.swing.*;

public class Sheet
{
	protected JFrame frame = null;


	void ToggleVisibility( JFrame window, boolean new_visibility )
	{
		window.setVisible( new_visibility );
	}
	
	void ToggleVisibility( JFrame window )
	{
		if ( window.isVisible() )
		{
			window.setVisible( false );
		}
		else
		{
			window.setVisible( true );
		}
	}
	
	void ToggleVisibility()
	{
		if ( this.frame.isVisible() )
		{
			this.frame.setVisible( false );
		}
		else
		{
			this.frame.setVisible( true );
		}
	}
	
	
	void ToggleLabelVisibility( JLabel label, boolean new_visibility )
	{
		label.setVisible( new_visibility );
	}
	
	void ToggleLabelVisibility( JLabel label )
	{
		if ( label.isVisible() )
		{
			label.setVisible( false );
		}
		else
		{
			label.setVisible( true );
		}
	}
	
	
	void SetLabelText(JLabel label, int val)
	{
		label.setText( Integer.toString( val ) );
	}
	
	void SetLabelText(JLabel label, String val)
	{
		
	}
	
	
	void SetTextField( JTextField txt_box, int val )
	{
		txt_box.setText( Integer.toString( val ) );
	}


	int GetModFromStat( int stat )
	{
		return ( stat - 10 ) / 2;
	}
}
