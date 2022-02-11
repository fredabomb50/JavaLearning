package dndCharacterCreator;


public class Main
{


	public static void logger(String log)
	{
		System.out.println(log);
	}
// compile java src with javac from command line. needs java SSE package from oracle: https://www.oracle.com/java/technologies/downloads/#jdk17-windows
// http://www.skylit.com/javamethods/faqs/javaindos.html

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
