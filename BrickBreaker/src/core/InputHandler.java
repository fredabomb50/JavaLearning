package core;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;


public class InputHandler extends JPanel
{
	Gameplay gamePlay = new Gameplay();
	
	//======================constructor
	public InputHandler()
	{
		int IsWindowInFocus = JComponent.WHEN_IN_FOCUSED_WINDOW;
		ActionMap actionMap = getActionMap();
		InputMap inputMap = getInputMap(IsWindowInFocus);
		
		
		for (Direction direction : Direction.values())
		{
			inputMap.put(direction.getKeyStroke(), direction.getText());
			actionMap.put(direction.getText(), new KeyBinder(direction.getText()));
		}
	} // end of InputHandler constructor

	
	public void createAndShowGui()
	{
		JFrame frame = new JFrame();
			frame.setBounds(10, 10, 700, 600);
			frame.setTitle("Spaz Breaker");		
			frame.setResizable(false);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(this);
			frame.add(gamePlay);
			frame.setVisible(true);
	}
	
	
	public class KeyBinder extends AbstractAction
	{
		public KeyBinder(String text)
		{
			super(text);
			putValue(ACTION_COMMAND_KEY, text);
		} //end of key binder constructor
		
	
		@Override public void actionPerformed(ActionEvent action_event)
		{
			String actionCommand = action_event.getActionCommand();
			//System.out.println("Action Performed: " + actionCommand);
			gamePlay.KeysHandler(actionCommand);
			
		} //end of action performed method
	} // end of KeyBinder class

//======================stubs
} //end of InputHandler class


enum Direction
{
	//======================Enumerated Values
	LEFT("Left", KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0)),
	RIGHT("Right", KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0)),
	ENTER("Enter", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0)),
	ESC("Escape", KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
	
	private String text;
	private KeyStroke keyStroke;
	Direction(String text, KeyStroke keyStroke)
	{
		this.text = text;
		this.keyStroke = keyStroke;
	}
	   
   
	//======================Getters
	public String getText()
	{
		return text;
	}

	public KeyStroke getKeyStroke()
	{
		return keyStroke;
	}

	@Override public String toString()
	{
		return text;
	}
} //end of Directions enumeration


