package dndCharacterCreator;

enum Die
{
	coin,
	D4,
	D6,
	D8,
	D10,
	D12,
	D20,
	D100
}


public interface Dice
{
	public int Roll_Dice (Die die);
	public int Roll_Dice (int count, Die die);
}
