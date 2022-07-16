package dnd_gui;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.parser.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@SuppressWarnings({"unchecked", "rawtypes"})
public class Json_Tools 
{
	
	
	private static String JSON_ERROR = null;
	
	
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
			Object obj = new JSONParser().parse(new FileReader("save_data/character_stats.json"));
			JSONObject json_obj = (JSONObject) obj;
			
			
			Map temp_scores = ( (Map)json_obj.get("abilities") );
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
		catch ( ParseException | IOException json_error )
		{
			JSON_ERROR = json_error.toString();
			System.out.println( "Exception caught during json test: " + JSON_ERROR );
		}

		
		if ( !(JSON_ERROR == null) )
		{
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
			Object obj = new JSONParser().parse(new FileReader("save_data/character_stats.json"));
			JSONObject json_obj = (JSONObject) obj;
			
			
			Map temp_scores = ( (Map)json_obj.get("saves") );
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
		catch ( ParseException | IOException json_error )
		{
			JSON_ERROR = json_error.toString();
			System.out.println( "Exception caught during json test: " + JSON_ERROR );
		}

		
		if ( !(JSON_ERROR == null) )
		{
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
			Object obj = new JSONParser().parse(new FileReader("save_data/character_stats.json"));
			JSONObject json_obj = (JSONObject) obj;
			
			
			Map temp_scores = ( (Map)json_obj.get("saves") );
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
		catch ( ParseException | IOException json_error )
		{
			JSON_ERROR = json_error.toString();
			System.out.println( "Exception caught during json test: " + JSON_ERROR );
		}

		
		if ( !(JSON_ERROR == null) )
		{
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
		
		
		try
		{
			Object obj = new JSONParser().parse(new FileReader("save_data/inventory.json"));
			JSONObject json_obj = (JSONObject) obj;
			
			
			Map temp_scores = ( (Map)json_obj.get("money") );
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
	            
	        }

	        temp_map = new HashMap<E_Currency, Integer>();
	        temp_map.put( E_Currency.Platinum, platinum );
	        temp_map.put( E_Currency.Gold, gold );
	        temp_map.put( E_Currency.Electrum, electrum );
	        temp_map.put( E_Currency.Silver, silver );
	        temp_map.put( E_Currency.Copper, copper );
	        temp_map.put( E_Currency.SoulCoins, soul_coins );
	        
		}
		catch ( ParseException | IOException json_error )
		{
			JSON_ERROR = json_error.toString();
			System.out.println( "Exception caught during json test: " + JSON_ERROR );
		}

		
		if ( !(JSON_ERROR == null) )
		{
			return null;
		}
		
		return temp_map;
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
