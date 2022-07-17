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
	
	
	
	
	public HashMap<E_Abilities, int[]> load_Abilities()
	{
		HashMap<E_Abilities, int[]> temp_map = null;;
		Iterator<Map.Entry> itr1 = null;
		int temp_str[] = { 0, 0 };
		int temp_dex[] = { 0, 0 };
		int temp_con[] = { 0, 0 };
		int temp_wis[] = { 0, 0 };
		int temp_int[] = { 0, 0 };
		int temp_chr[] = { 0, 0 };
		
		
		try
		{	
			Map temp_scores = ( (Map)stats_json.get("abilities") );
	        itr1 = temp_scores.entrySet().iterator();
	        while ( itr1.hasNext() )
	        {
				Map.Entry pair = itr1.next();
				String key = pair.getKey().toString();
				
	            if ( key.equalsIgnoreCase("dex") )
	            {
	            	temp_dex[0] = util.IntFromObj( pair );
	            	temp_dex[1] = ( temp_dex[0] - 10 ) / 2;
	            }
	            
	            if ( key.equalsIgnoreCase("str") )
	            {
	            	temp_str[0] = util.IntFromObj( pair );
	            	temp_str[1] = ( temp_str[0] - 10 ) / 2;
	            }
	            
	            if ( key.equalsIgnoreCase("con") )
	            {
	            	temp_con[0] = util.IntFromObj( pair );
	            	temp_con[1] = ( temp_con[0] - 10 ) / 2;
	            }
	            
	            if ( key.equalsIgnoreCase("wis") )
	            {
	            	temp_wis[0] = util.IntFromObj( pair );
	            	temp_wis[1] = ( temp_wis[0] - 10 ) / 2;
	            }
	            
	            if ( key.equalsIgnoreCase("int") )
	            {
	            	temp_int[0] = util.IntFromObj( pair );
	            	temp_int[1] = ( temp_int[0] - 10 ) / 2;
	            }
	            
	            if ( key.equalsIgnoreCase("chr") )
	            {
	            	temp_chr[0] = util.IntFromObj( pair );
	            	temp_chr[1] = ( temp_chr[0] - 10 ) / 2;
	            }
	        }
	        
	        temp_map = new HashMap<E_Abilities, int[]>();
	        temp_map.put( E_Abilities.Dex , temp_dex );
	        temp_map.put( E_Abilities.Str , temp_str );
	        temp_map.put( E_Abilities.Con , temp_con );
	        temp_map.put( E_Abilities.Wis , temp_wis );
	        temp_map.put( E_Abilities.Int , temp_int );
	        temp_map.put( E_Abilities.Chr , temp_chr );
		}
		catch ( IllegalStateException json_error )
		{
			json_logger( json_error, "Exception caught while loading abilities" );
			return null;
		}

		return temp_map;
	}


	public HashMap<E_Abilities, Boolean> load_SaveProfs()
	{
		HashMap<E_Abilities, Boolean> temp_map = null;;
		Iterator<Map.Entry> itr1 = null;
		boolean temp_dex = false;
		boolean temp_str = false;
		boolean temp_con = false;
		boolean temp_wis = false;
		boolean temp_int = false;
		boolean temp_chr = false;
		
		
		try
		{			
			Map temp_scores = ( (Map)stats_json.get("saves") );
	        itr1 = temp_scores.entrySet().iterator();
	        while ( itr1.hasNext() )
	        {
	            
				Map.Entry pair = itr1.next();
	            if ( pair.getKey().toString().equalsIgnoreCase("dex_prof") )
	            {
	            	temp_dex = (boolean) pair.getValue();
	            }
	            
	            if ( pair.getKey().toString().equalsIgnoreCase("str_prof") )
	            {
	            	temp_str = (boolean) pair.getValue();
	            }
	            
	            if ( pair.getKey().toString().equalsIgnoreCase("con_prof") )
	            {
	            	temp_con = (boolean) pair.getValue();
	            }
	            
	            if ( pair.getKey().toString().equalsIgnoreCase("wis_prof") )
	            {
	            	temp_wis = (boolean) pair.getValue();
	            }
	            
	            if ( pair.getKey().toString().equalsIgnoreCase("int_prof") )
	            {
	            	temp_int = (boolean) pair.getValue();
	            }
	            
	            if ( pair.getKey().toString().equalsIgnoreCase("chr_prof") )
	            {
	            	temp_chr = (boolean) pair.getValue();
	            }
	            
	        }

	        temp_map = new HashMap<E_Abilities, Boolean>();
	        temp_map.put( E_Abilities.Dex , temp_dex );
	        temp_map.put( E_Abilities.Str , temp_str );
	        temp_map.put( E_Abilities.Con , temp_con );
	        temp_map.put( E_Abilities.Wis , temp_wis );
	        temp_map.put( E_Abilities.Int , temp_int );
	        temp_map.put( E_Abilities.Chr , temp_chr );
		}
		catch ( IllegalStateException json_error )
		{
			json_logger( json_error, "Exception caught during json test" );
			return null;
		}
		
		return temp_map;
	}
	
	
	public HashMap<E_Abilities, Integer> load_SaveBonuses()
	{
		HashMap<E_Abilities, Integer> temp_map = null;;
		Iterator<Map.Entry> itr1 = null;
		int temp_dex = 0;
		int temp_str = 0;
		int temp_con = 0;
		int temp_wis = 0;
		int temp_int = 0;
		int temp_chr = 0;
		
		
		try
		{
			Map temp_scores = ( (Map)stats_json.get("saves") );
	        itr1 = temp_scores.entrySet().iterator();
	        while ( itr1.hasNext() )
	        {
	            
				Map.Entry pair = itr1.next();
	            if ( pair.getKey().toString().equalsIgnoreCase("dex") )
	            {
	            	temp_dex = util.IntFromObj( pair );
	            }
	            
	            if ( pair.getKey().toString().equalsIgnoreCase("str") )
	            {
	            	temp_str = util.IntFromObj( pair );
	            }
	            
	            if ( pair.getKey().toString().equalsIgnoreCase("con") )
	            {
	            	temp_con = util.IntFromObj( pair );
	            }
	            
	            if ( pair.getKey().toString().equalsIgnoreCase("wis") )
	            {
	            	temp_wis = util.IntFromObj( pair );
	            }
	            
	            if ( pair.getKey().toString().equalsIgnoreCase("int") )
	            {
	            	temp_int = util.IntFromObj( pair );
	            }
	            
	            if ( pair.getKey().toString().equalsIgnoreCase("chr") )
	            {
	            	temp_chr = util.IntFromObj( pair );
	            }
	            
	        }

	        temp_map = new HashMap<E_Abilities, Integer>();
	        temp_map.put( E_Abilities.Dex , temp_dex );
	        temp_map.put( E_Abilities.Str , temp_str );
	        temp_map.put( E_Abilities.Con , temp_con );
	        temp_map.put( E_Abilities.Wis , temp_wis );
	        temp_map.put( E_Abilities.Int , temp_int );
	        temp_map.put( E_Abilities.Chr , temp_chr );
		}
		catch ( IllegalStateException json_error )
		{
			json_logger( json_error, "Exception caught during json test" );
			return null;
		}
		
		return temp_map;
	}
	
	
	public HashMap<E_Speeds, Integer> load_Speeds()
	{
		HashMap<E_Speeds, Integer> temp_map = null;;
		Iterator<Map.Entry> itr1 = null;
		int walk = 0;
		int swim = 0;
		int fly = 0;
		int dig = 0;
		int climb = 0;

		try
		{
			Map temp_scores = ( (Map)stats_json.get("speeds") );
	        itr1 = temp_scores.entrySet().iterator();
	        while ( itr1.hasNext() )
	        {
	            
				Map.Entry pair = itr1.next();
	            if ( pair.getKey().toString().equalsIgnoreCase("Walk") )
	            {
	            	walk = util.IntFromObj( pair );
	            }
	            
	            if ( pair.getKey().toString().equalsIgnoreCase("Swim") )
	            {
	            	swim = util.IntFromObj( pair );
	            }
	            
	            if ( pair.getKey().toString().equalsIgnoreCase("Fly") )
	            {
	            	fly = util.IntFromObj( pair );
	            }
	            
	            if ( pair.getKey().toString().equalsIgnoreCase("Dig") )
	            {
	            	dig = util.IntFromObj( pair );
	            }
	            
	            if ( pair.getKey().toString().equalsIgnoreCase("Climb") )
	            {
	            	climb = util.IntFromObj( pair );
	            }
	            
	        }

	        temp_map = new HashMap<E_Speeds, Integer>();
	        temp_map.put( E_Speeds.Walk, walk );
	        temp_map.put( E_Speeds.Swim, swim );
	        temp_map.put( E_Speeds.Fly, fly );
	        temp_map.put( E_Speeds.Dig, dig );
	        temp_map.put( E_Speeds.Climb, climb );
	        
		}
		catch ( IllegalStateException json_error )
		{
			json_logger( json_error, "Exception caught during json test");
			return null;
		}

		return temp_map;
	}

	
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
	
	// may separate linked data like health into their own maps, using the E_Stat, int format
	public HashMap<E_Speeds, Integer> load_Core()
	{
		HashMap<E_Speeds, Integer> temp_map = null;;
		Iterator<Map.Entry> itr1 = null;
		int level = 0;
		int xp = 0;
		int prof = 0;
		int ac = 0;
		int initiative = 0;

		int inspiration = 0;
		int current_health = 0;
		int max_health = 0;
		int temp_health = 0;
		int hitdie_count = 0;
		E_Dice hitdie_type = null;
		
		
		try
		{
			Map temp_scores = ( (Map)stats_json.get("core") );
	        itr1 = temp_scores.entrySet().iterator();
	        while ( itr1.hasNext() )
	        {
	            
				Map.Entry pair = itr1.next();
	            if ( pair.getKey().toString().equalsIgnoreCase("level") )
	            {
	            	level = util.IntFromObj( pair );
	            }
	            
	            if ( pair.getKey().toString().equalsIgnoreCase("xp") )
	            {
	            	xp = util.IntFromObj( pair );
	            }
	            
	            if ( pair.getKey().toString().equalsIgnoreCase("prof") )
	            {
	            	prof = util.IntFromObj( pair );
	            }
	            
	            if ( pair.getKey().toString().equalsIgnoreCase("ac") )
	            {
	            	ac = util.IntFromObj( pair );
	            }
	            
	            if ( pair.getKey().toString().equalsIgnoreCase("initiative") )
	            {
	            	initiative = util.IntFromObj( pair );
	            }
	            
	        }

	        temp_map = new HashMap<E_Speeds, Integer>();
 
		}
		catch ( IllegalStateException json_error )
		{
			json_logger( json_error, "Exception caught during json test" );
			return null;
		}
		
		
		return temp_map;
	}

	
	public HashMap<E_Currency, Integer> load_Money()
	{
		HashMap<E_Currency, Integer> temp_map = null;;
		Iterator<Map.Entry> itr1 = null;
		int platinum = 0;
		int gold = 0;
		int electrum = 0;
		int silver = 0;
		int copper = 0;
		int soul_coins = 0;
		int inspiration = 0;
		
		try
		{
			Map temp_scores = ( (Map)inv_json.get("money") );
	        itr1 = temp_scores.entrySet().iterator();
	        while ( itr1.hasNext() )
	        {
	            
				Map.Entry pair = itr1.next();
	            if ( pair.getKey().toString().equalsIgnoreCase("platinum") )
	            {
	            	platinum = util.IntFromObj( pair );
	            }
	            
	            if ( pair.getKey().toString().equalsIgnoreCase("gold") )
	            {
	            	gold = util.IntFromObj( pair );
	            }
	            
	            if ( pair.getKey().toString().equalsIgnoreCase("electrum") )
	            {
	            	electrum = util.IntFromObj( pair );
	            }
	            
	            if ( pair.getKey().toString().equalsIgnoreCase("silver") )
	            {
	            	silver = util.IntFromObj( pair );
	            }
	            
	            if ( pair.getKey().toString().equalsIgnoreCase("copper") )
	            {
	            	copper = util.IntFromObj( pair );
	            }
	            
	            if ( pair.getKey().toString().equalsIgnoreCase("soul_coins") )
	            {
	            	soul_coins = util.IntFromObj( pair );
	            }
	            
	            if ( pair.getKey().toString().equalsIgnoreCase("inspiration") )
	            {
	            	inspiration = util.IntFromObj( pair );
	            }
	        }

	        temp_map = new HashMap<E_Currency, Integer>();
	        temp_map.replace( E_Currency.Platinum, platinum );
	        temp_map.replace( E_Currency.Gold, gold );
	        temp_map.replace( E_Currency.Electrum, electrum );
	        temp_map.replace( E_Currency.Silver, silver );
	        temp_map.replace( E_Currency.Copper, copper );
	        temp_map.replace( E_Currency.SoulCoins, soul_coins );
	        temp_map.replace( E_Currency.Inspiration, inspiration );
		}
		catch ( IllegalStateException json_error )
		{
			json_logger( json_error, "Exception caught during json test" );
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
