package dnd_gui;

public class Math
{
	private static String error_msg = null;
	
	
	public int ClampInt( int value, int min, int max )
	{
		int result = 0;
		
		if ( value >= max )
		{
			result = max;
		}
		else if ( value <= min )
		{
			result = min;
		}
		else
		{
			result = value;
		}
		return result;
	}

	
	
}
