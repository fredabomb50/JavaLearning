package dndCharacterCreator;
import java.util.Random;


public class Actor implements Dice
{
	//======================Variables
	int currentHealth;
	int maxHealth;
	int armorClass;
	
	//ability scores
	int strength;
	int constitution;
	int intelligence;
	int wisdom;
	int charisma;
	
	//======================Core methods
	void print_CoreStats()
	{
		System.out.printf("Health: %s/%s \n", currentHealth, maxHealth);
		System.out.printf("AC: %s \n", armorClass);
		System.out.printf("str: %s\t (%s)\n", (strength - 10) / 2, strength);
		System.out.printf("con: %s\t (%s)\n", (constitution - 10) / 2, constitution);
		System.out.printf("int: %s\t (%s)\n", (intelligence - 10) / 2, intelligence);
		System.out.printf("wis: %s\t (%s)\n", (wisdom - 10) / 2, wisdom);
		System.out.printf("chr: %s\t (%s)\n", (charisma - 10) / 2, charisma);
	}
	
	
	//======================Dice implementations
	public int Roll_Dice (Die die)
	{
		int result = 0;
		int MaxDieValue = 0;
		switch (die)
		{
			case coin:
			{
				MaxDieValue = 2;
			}break;
			
			case D4:
			{
				MaxDieValue = 4;
			}break;
			
			case D6:
			{
				MaxDieValue = 6;
			}break;
			
			case D8:
			{
				MaxDieValue = 8;
			}break;
			
			case D10:
			{
				MaxDieValue = 10;
			}break;
			
			case D12:
			{
				MaxDieValue = 12;
			}break;
			
			case D20:
			{
				MaxDieValue = 20;
			}break;
			
			case D100:
			{
				MaxDieValue = 100;
			}break;
			
			default:
			{
				System.out.println("invalid die type");
			} break;
		} //end of die switch
			
		Random temp_value = new Random();
		result = temp_value.nextInt(1, MaxDieValue);
			
		return result;
	}
	
	
	public int Roll_Dice(int count, Die die)
	{
		int result = 0;
		int MaxDieValue = 0;
		switch (die)
		{
			case coin:
			{
				MaxDieValue = 2;
			}break;
			
			case D4:
			{
				MaxDieValue = 4;
			}break;
			
			case D6:
			{
				MaxDieValue = 6;
			}break;
			
			case D8:
			{
				MaxDieValue = 8;
			}break;
			
			case D10:
			{
				MaxDieValue = 10;
			}break;
			
			case D12:
			{
				MaxDieValue = 12;
			}break;
			
			case D20:
			{
				MaxDieValue = 20;
			}break;
			
			case D100:
			{
				MaxDieValue = 100;
			}break;
			
			default:
			{
				System.out.println("invalid die type");
			} break;
		}//end of die switch
		
		
		Random temp_value = new Random();
		for (int i = 1; i <= count; ++i)
		{
			result += temp_value.nextInt(1, MaxDieValue);
		}
		
		return result;
	}
	
	
	//======================lightly-used methods
}
class Monster extends Actor
{
	String name;
}

class PlayerCharacter extends Actor
{
	String name;
	
	//======================lightly-used methods
	public void RollAbilityScores()
	{
		Die stat_die = Die.D6;
		
		int temp1, temp2, temp3, temp4, temp_total;
		
		int[] first_set = {0, 0, 0, 0, 0};
		int first_total = 0;
		
		int[] second_set = {0, 0, 0, 0, 0};
		int second_total = 0;
		
		
		for (int i = 0; i <= 4; i++)
		{
			temp1 = Roll_Dice(stat_die);
			temp2 = Roll_Dice(stat_die);
			temp3 = Roll_Dice(stat_die);
			temp4 = Roll_Dice(stat_die);
			temp_total = 0;
			
			if (temp4 <= temp3 && temp4 <= temp2 && temp4 <= temp1)
			{
				temp_total = temp1 + temp2 + temp3;
			}
			if (temp3 <= temp4 && temp3 <= temp2 && temp3 <= temp1)
			{
				temp_total = temp1 + temp2 + temp4;
			}
			if (temp2 <= temp4 && temp2 <= temp3 && temp2 <= temp1)
			{
				temp_total = temp1 + temp3 + temp4;
			}
			if (temp1 <= temp4 && temp1 <= temp2 && temp1 <= temp3)
			{
				temp_total = temp2 + temp3 + temp4;
			}
			first_set[i] = temp_total;
			first_total += first_set[i];
		}
		
		
		for (int i = 0; i <= 4; i++)
		{
			temp1 = Roll_Dice(stat_die);
			temp2 = Roll_Dice(stat_die);
			temp3 = Roll_Dice(stat_die);
			temp4 = Roll_Dice(stat_die);
			temp_total = 0;
			
			if (temp4 <= temp3 && temp4 <= temp2 && temp4 <= temp1)
			{
				temp_total = temp1 + temp2 + temp3;
			}
			if (temp3 <= temp4 && temp3 <= temp2 && temp3 <= temp1)
			{
				temp_total = temp1 + temp2 + temp4;
			}
			if (temp2 <= temp4 && temp2 <= temp3 && temp2 <= temp1)
			{
				temp_total = temp1 + temp3 + temp4;
			}
			if (temp1 <= temp4 && temp1 <= temp2 && temp1 <= temp3)
			{
				temp_total = temp2 + temp3 + temp4;
			}
			second_set[i] = temp_total;
			second_total += second_set[i];
		}
		
		
		if (first_total > second_total)
		{
			strength = first_set[0];
			constitution = first_set[1];
			intelligence = first_set[2];
			wisdom = first_set[3];
			charisma = first_set[4];
		}
		else
		{
			strength = second_set[0];
			constitution = second_set[1];
			intelligence = second_set[2];
			wisdom = second_set[3];
			charisma = second_set[4];
		}
	}
}


final class NPC extends PlayerCharacter
{
	String name;
}