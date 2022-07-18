package dnd_gui;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.parser.*;



/*
 * For maps of any kind, use the replace() method instead, as the player data class in control panel 
 * should not initialize with any null values.
 * 
 * Make sure to catch any IllegalStateExceptions in case a specific json files didn't load correctly in construction.
 * 
 */


@SuppressWarnings({"unchecked", "rawtypes"})
public class Json_Tools 
{	
	private static Object stats_obj = null;
	private static Object inv_obj = null;
	private static JSONObject stats_json = null;
	private static JSONObject inv_json = null;
	
	
	public Json_Tools()
	{
		try
		{
			stats_obj = new JSONParser().parse(new FileReader("save_data/character_stats.json"));
			stats_json = (JSONObject) stats_obj;
		}
		catch  ( ParseException | IOException json_error )
		{
			json_logger( json_error, "Exception caught while constructing c_sheet json" );
		}
		
		
		try
		{
			inv_obj = new JSONParser().parse(new FileReader("save_data/character_stats.json"));
			inv_json = (JSONObject) inv_obj;
		}
		catch  ( ParseException | IOException json_error )
		{
			json_logger( json_error, "Exception caught while constructing inventory json" );
		}
	}
	
	
	
	// CHARACTER SHEET
	public E_Dice load_HitdieType()
	{
		E_Dice temp_type = null;
		
		try
		{
			int enum_index = (int) stats_json.get("hitdie_type");
	        temp_type = E_Dice.values()[enum_index];
		}
		catch ( IllegalStateException | ArrayIndexOutOfBoundsException json_error )
		{
			json_logger( json_error, "Exception caught loading hitdie type");
			return null;
		}
		
		return temp_type;
	}
	
	public HashMap<E_Abilities, int[]> load_Abilities()
	{
		HashMap<E_Abilities, int[]> temp_map = new HashMap<E_Abilities, int[]>();
		Iterator<Map.Entry> itr1 = null;
		int[] temp = { 0, 0 };
		E_Abilities temp_ability = null;
		
		try
		{			
			Map temp_scores = ( (Map)stats_json.get("abilities") );
	        itr1 = temp_scores.entrySet().iterator();
	        while ( itr1.hasNext() )
	        {    
				Map.Entry pair = itr1.next();
				temp[0] = (int) pair.getValue();
				temp[1] = ( temp[0] - 10 ) / 2;
				temp_ability = E_Abilities.valueOf( pair.getKey().toString() );
				temp_map.put( temp_ability , temp );    
	        }
		}
		catch ( IllegalStateException | IllegalArgumentException json_error )
		{
			json_logger( json_error, "Exception caught while loading speeds" );
			return null;
		}
		
		return temp_map;
	}

	public HashMap<E_Abilities, Boolean> load_SaveProfs()
	{
		HashMap<E_Abilities, Boolean> temp_map = new HashMap<E_Abilities, Boolean>();
		Iterator<Map.Entry> itr1 = null;
		boolean temp = false;
		E_Abilities temp_speed = null;
		
		try
		{			
			Map temp_scores = ( (Map)stats_json.get("save_profs") );
	        itr1 = temp_scores.entrySet().iterator();
	        while ( itr1.hasNext() )
	        {    
				Map.Entry pair = itr1.next();
				temp = (boolean) pair.getValue();
				temp_speed = E_Abilities.valueOf( pair.getKey().toString() );
				temp_map.put( temp_speed , temp );    
	        }
		}
		catch ( IllegalStateException | IllegalArgumentException json_error )
		{
			json_logger( json_error, "Exception caught while loading save proficiencies" );
			return null;
		}
		
		return temp_map;
	}
		
	public HashMap<E_Abilities, Integer> load_SaveBonuses()
	{
		HashMap<E_Abilities, Integer> temp_map = new HashMap<E_Abilities, Integer>();
		Iterator<Map.Entry> itr1 = null;
		int temp = 0;
		E_Abilities temp_speed = null;
		
		try
		{			
			Map temp_scores = ( (Map)stats_json.get("save_bonuses") );
	        itr1 = temp_scores.entrySet().iterator();
	        while ( itr1.hasNext() )
	        {    
				Map.Entry pair = itr1.next();
				temp = (int) pair.getValue();
				temp_speed = E_Abilities.valueOf( pair.getKey().toString() );
				temp_map.put( temp_speed , temp );    
	        }
		}
		catch ( IllegalStateException | IllegalArgumentException json_error )
		{
			json_logger( json_error, "Exception caught while loading save bonuses" );
			return null;
		}
		
		return temp_map;
	}
	
	public HashMap<E_Speeds, Integer> load_Speeds()
	{
		HashMap<E_Speeds, Integer> temp_map = new HashMap<E_Speeds, Integer>();
		Iterator<Map.Entry> itr1 = null;
		int temp = 0;
		E_Speeds temp_speed = null;
		
		try
		{			
			Map temp_scores = ( (Map)stats_json.get("speeds") );
	        itr1 = temp_scores.entrySet().iterator();
	        while ( itr1.hasNext() )
	        {    
				Map.Entry pair = itr1.next();
				temp = (int) pair.getValue();
				temp_speed = E_Speeds.valueOf( pair.getKey().toString() );
				temp_map.put( temp_speed , temp );    
	        }
		}
		catch ( IllegalStateException | IllegalArgumentException json_error )
		{
			json_logger( json_error, "Exception caught while loading speeds" );
			return null;
		}
		
		return temp_map;
	}
	
	public HashMap<E_Stats, Integer> load_Health()
	{
		HashMap<E_Stats, Integer> temp_map = new HashMap<E_Stats, Integer>();
		Iterator<Map.Entry> itr1 = null;
		int temp = 0;
		E_Stats temp_stat = null;
		
		try
		{			
			Map temp_scores = ( (Map)stats_json.get("health") );
	        itr1 = temp_scores.entrySet().iterator();
	        while ( itr1.hasNext() )
	        {    
				Map.Entry pair = itr1.next();
				temp = (int) pair.getValue();
				temp_stat = E_Stats.valueOf( pair.getKey().toString() );
				temp_map.put( temp_stat , temp );    
	        }
		}
		catch ( IllegalStateException | IllegalArgumentException json_error )
		{
			json_logger( json_error, "Exception caught while loading health values" );
			return null;
		}
		
		return temp_map;
	}

	public HashMap<E_Stats, Integer> load_Core()
	{
		HashMap<E_Stats, Integer> temp_map = new HashMap<E_Stats, Integer>();
		Iterator<Map.Entry> itr1 = null;
		int temp = 0;
		E_Stats temp_stat = null;
		
		try
		{			
			Map temp_scores = ( (Map)stats_json.get("core") );
	        itr1 = temp_scores.entrySet().iterator();
	        while ( itr1.hasNext() )
	        {    
				Map.Entry pair = itr1.next();
				temp = (int) pair.getValue();
				temp_stat = E_Stats.valueOf( pair.getKey().toString() );
				temp_map.put( temp_stat , temp );    
	        }
		}
		catch ( IllegalStateException | IllegalArgumentException json_error )
		{
			json_logger( json_error, "Exception caught while loading skill proficiences" );
			return null;
		}
		
		return temp_map;
	}

	public HashMap<E_Skills, Boolean> load_SkillProfs()
	{
		HashMap<E_Skills, Boolean> temp_map = new HashMap<E_Skills, Boolean>();
		Iterator<Map.Entry> itr1 = null;
		boolean temp = false;
		E_Skills temp_skill = null;
		
		try
		{			
			Map temp_scores = ( (Map)stats_json.get("skill_profs") );
	        itr1 = temp_scores.entrySet().iterator();
	        while ( itr1.hasNext() )
	        {    
				Map.Entry pair = itr1.next();
				temp = (boolean) pair.getValue();
				temp_skill = E_Skills.valueOf( pair.getKey().toString() );
				temp_map.put( temp_skill , temp );    
	        }
		}
		catch ( IllegalStateException | IllegalArgumentException json_error )
		{
			json_logger( json_error, "Exception caught while loading skill proficiences" );
			return null;
		}
		
		return temp_map;
	}
	
	public HashMap<E_Skills, Boolean> load_SkillExpertise()
	{
		HashMap<E_Skills, Boolean> temp_map = new HashMap<E_Skills, Boolean>();
		Iterator<Map.Entry> itr1 = null;
		boolean temp = false;
		E_Skills temp_skill = null;
		
		try
		{			
			Map temp_scores = ( (Map)stats_json.get("skill_expertise") );
	        itr1 = temp_scores.entrySet().iterator();
	        while ( itr1.hasNext() )
	        {    
				Map.Entry pair = itr1.next();
				temp = (boolean) pair.getValue();
				temp_skill = E_Skills.valueOf( pair.getKey().toString() );
				temp_map.put( temp_skill , temp );    
	        }
		}
		catch ( IllegalStateException | IllegalArgumentException json_error )
		{
			json_logger( json_error, "Exception caught while loading skill_expertise" );
			return null;
		}
		
		return temp_map;
	}
	
	public HashMap<E_Skills, Integer> load_SkillBonuses()
	{
		HashMap<E_Skills, Integer> temp_map = new HashMap<E_Skills, Integer>();
		Iterator<Map.Entry> itr1 = null;
		int temp = 0;
		E_Skills temp_skill = null;
		
		try
		{			
			Map temp_scores = ( (Map)stats_json.get("skill_bonuses") );
	        itr1 = temp_scores.entrySet().iterator();
	        while ( itr1.hasNext() )
	        {    
				Map.Entry pair = itr1.next();
				temp = (int) pair.getValue();
				temp_skill = E_Skills.valueOf( pair.getKey().toString() );
				temp_map.put( temp_skill , temp );    
	        }
		}
		catch ( IllegalStateException | IllegalArgumentException json_error )
		{
			json_logger( json_error, "Exception caught while loading skill bonuses" );
			return null;
		}
		
		return temp_map;
	}
	
	// INVENTORY
	public HashMap<E_Currency, Integer> load_Money()
	{
		HashMap<E_Currency, Integer> temp_map = new HashMap<E_Currency, Integer>();
		Iterator<Map.Entry> itr1 = null;
		int temp = 0;
		E_Currency temp_coin = null;
		
		try
		{			
			Map temp_scores = ( (Map)inv_json.get("money") );
	        itr1 = temp_scores.entrySet().iterator();
	        while ( itr1.hasNext() )
	        {    
				Map.Entry pair = itr1.next();
				temp = (int) pair.getValue();
				temp_coin = E_Currency.valueOf( pair.getKey().toString() );
				temp_map.put( temp_coin , temp );    
	        }
		}
		catch ( IllegalStateException | IllegalArgumentException json_error )
		{
			json_logger( json_error, "Exception caught while loading health values" );
			return null;
		}
		
		return temp_map;
	}
	
	
	
	
	public void json_logger( Exception exception, String errMsg )
	{
		System.out.println( errMsg + ": " + exception );
	}
	
	class util
	{		
 		public static int IntFromString( String string )
		{
			return Integer.parseInt( string );
		}
		
		public static int IntFromObj( Map.Entry obj )
		{
			return Integer.parseInt( obj.getValue().toString() );
		}
	}
}
