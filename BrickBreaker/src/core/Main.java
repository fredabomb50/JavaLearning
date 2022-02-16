package core;
import javax.swing.*;

@SuppressWarnings("serial")
public class Main
{
	public static void main(String[] args)
	{
		InputHandler input_processor = new InputHandler();
		
		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() 
			{
				input_processor.createAndShowGui();
			}
		}); // end of async GUI display 
	} //end of main method
} //end of main class
