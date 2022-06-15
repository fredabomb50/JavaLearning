package dnd_gui;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class DetailsSheet {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public DetailsSheet()
	{
		initialize();
		frame.setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 808);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, "cell 0 0,grow");
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 770, 755);
		layeredPane.add(panel);
		
		JLabel lbl_Backdrop = new JLabel(" ");
		lbl_Backdrop.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Backdrop.setIcon(null);
		panel.add(lbl_Backdrop);
		lbl_Backdrop.setSize(791, 1024);
		lbl_Backdrop.setIcon( ScaledImage( lbl_Backdrop ) );
	}
	
	private ImageIcon ScaledImage( JLabel label )
	{
		BufferedImage img = null;
		try
		{
		    img = ImageIO.read(new File("F:\\_BULK\\Image Resources\\dnd\\details_sheet_template1.jpg"));
		}
		catch (IOException e)
		{
		    e.printStackTrace();
		    return null;
		}
		
		Image scaled_Image = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon result = new ImageIcon( scaled_Image );
		
		return result;
	}
	
	public void ToggleVisibility()
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
}
