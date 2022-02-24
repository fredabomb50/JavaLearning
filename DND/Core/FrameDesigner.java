package core;

//AWT
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.GridBagConstraints;

//SWING
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class FrameDesigner extends Gui
{
	//======================Constants
	//Fonts
	final private static Font font_GenericButton = new Font(Font.SERIF, Font.PLAIN, 12);
	final private static Font font_LargeHeader = new Font(Font.SERIF, Font.BOLD, 36);
	final private static Font font_MediumHeader = new Font(Font.SERIF, Font.BOLD, 24);
	final private static Font font_SmallHeader = new Font(Font.SERIF, Font.BOLD, 12);
	final private static Font font_MenuHeader = new Font(Font.SERIF, Font.ITALIC, 12);
	
	//Colors
	final private static Color color_PanelBackdrop = new Color(191, 179, 148);	// BFB394
	final private static Color color_PanelBorder = new Color(228, 222, 197);	// E4DEC5
	final private static Color color_GenericText = new Color(0, 0, 0);	
	final private static Color color_LogoText = new Color(146, 9, 9);			// 920909
	final private static Color color_LightBackdrop = new Color(241, 235, 228);	// F1EBE4
	
	
	//Images
	final private static Image icon_Window = Toolkit.getDefaultToolkit().getImage("Resources/window_icon.png");
	
	
	//======================Variables
	public JFrame frame = new JFrame("Character Randomizer");
	public static Image img_Avatar;
	
	
	//======================Constructor
	public FrameDesigner()
	{
		frame.setIconImage(icon_Window);
	}
	
	
	public void setLayoutManager(GridBagLayout grid)
	{
		frame.setLayout(grid);
	}
	
	
	public void setAvatarLogo(String newPath)
	{
		img_Avatar = Toolkit.getDefaultToolkit().getImage(newPath);
	}
	//======================JComponent Builders
}
