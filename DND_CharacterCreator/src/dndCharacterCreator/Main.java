package dndCharacterCreator;


public class Main
{


	public static void logger(String log)
	{
		System.out.println(log);
	}

	
	public static void main(String[] args)
	{	
		logger("Declaring player...");
		PlayerCharacter test_character = new PlayerCharacter();
		
		logger("Naming player...");
		test_character.name = "Jimbo";
		
		logger("Defining player stats...");
		test_character.maxHealth = 100;
		test_character.currentHealth = 100;
		test_character.armorClass = 15;
		test_character.RollAbilityScores();
		
		logger("Checking player stats...");
		test_character.print_CoreStats();
	}
}
