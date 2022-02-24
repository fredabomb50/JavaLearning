package core;


// compile java src with javac from command line. needs java SSE package from oracle: https://www.oracle.com/java/technologies/downloads/#jdk17-windows
// http://www.skylit.com/javamethods/faqs/javaindos.html

//FUN KNOWLEDGE
//it looks like a good way to hide data, is to set class variables to private, and have a public method that sets them as needed
// something like method(int x){this.x = x};
public class Main
{
	public static void logger(String log)
	{
		System.out.println(log + ".....");
	}

	
	public static void initializePlayer(PlayerCharacter player)
	{
		byte default_value = 1;
		
		logger("Naming player...");
		player.name = "Jimbo";

		logger("Defining player stats...");
		player.maxHealth = 100;
		player.currentHealth = 100;
		player.armorClass = 15;
		player.RollAbilityScores();

		
		//skills
		player.skills.put("Acrobatics", default_value);
		player.skills.put("AnimalHandling", default_value);
		player.skills.put("Arcana", default_value);
		player.skills.put("Athletics", default_value);
		player.skills.put("Deception", default_value);
		player.skills.put("History", default_value);
		player.skills.put("Insight", default_value);
		player.skills.put("Intimidation", default_value);
		player.skills.put("Investigation", default_value);
		player.skills.put("Medicine", default_value);
		player.skills.put("Nature", default_value);
		player.skills.put("Perception", default_value);
		player.skills.put("Performance", default_value);
		player.skills.put("Persuasion", default_value);
		player.skills.put("Religion", default_value);
		player.skills.put("SleightOfHand", default_value);
		player.skills.put("Stealth", default_value);
		player.skills.put("Survival", default_value);
		player.skills.put("Performance", default_value);
	}
	
	
	public static void main(String[] args)
	{
		//scheduling for thread safety; more necessary with swing, less with AWT
		javax.swing.SwingUtilities.invokeLater(new Runnable() 
		{
           public void run()
            {
        	   logger("Initializing gui");
        	   Gui mainWindow = new Gui();
        	   mainWindow.createAndShowGUI();
            }
        }); // end of invokeLater
	} // end of main method
	
	
	//holds a comment for later functionality
	public void stub()
	{
		/*
		logger("Declaring player...");
		PlayerCharacter test_character = new PlayerCharacter();
		initializePlayer(test_character);
		
		logger("Checking player stats...");
		test_character.print_CoreStats();
*/
	}
}