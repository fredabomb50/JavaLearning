package dnd_gui;

import java.util.Random;


public class Dice
{
	public int RollD4(int quantity)
	{
		int result = 0;
		Random num = new Random();
		
		for (int i = 0; i <= quantity; i++)
		{
			result += num.nextInt(1, 4);
		}
		
		return result;
	}
	
	public int RollD6(int quantity)
	{
		int result = 0;
		Random num = new Random();
		
		for (int i = 0; i <= quantity; i++)
		{
			result += num.nextInt(1, 6);
		}
		
		return result;
	}
	
	public enum eDice
	{
		D4,
		D6,
		D8,
		D10,
		D12,
		D20,
		D100
	}
}
