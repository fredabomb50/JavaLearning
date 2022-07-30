package dnd_gui;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
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
	// Pathing
	private static final String path_SaveData = "save_data/";
	private static final String path_Defaults = path_SaveData + "default.json";
	private static final String path_CharacterStats = path_SaveData + "character-sheet/character_stats.json";
	private static final String path_cs_Advantages = path_SaveData + "character-sheet/cs_Advantages.txt";
	private static final String path_cs_Disadvantages = path_SaveData + "character-sheet/cs_Disadvantages.txt";
	private static final String path_cs_Bonuses = path_SaveData + "character-sheet/cs_Bonuses.txt";
	private static final String path_cs_Proficiencies = path_SaveData + "character-sheet/cs_Proficiencies.txt";
	private static final String path_cs_ActionNames = path_SaveData + "character-sheet/actions/cs_Action_Names.txt";
	private static final String path_cs_ActionAmmo = path_SaveData + "character-sheet/actions/cs_Action_Ammo.txt";
	private static final String path_cs_ActionHits = path_SaveData + "character-sheet/actions/cs_Action_Hits.txt";
	private static final String path_cs_ActionRanges = path_SaveData + "character-sheet/actions/cs_Action_Ranges.txt";
	private static final String path_cs_ActionDmg = path_SaveData + "character-sheet/actions/cs_Action_Damages.txt";
	private static final String path_cs_ActionDmgBonus = path_SaveData + "character-sheet/actions/cs_Action_DamageBonuses.txt";
	private static final String path_cs_ActionMisc = path_SaveData + "character-sheet/actions/cs_Action_Misc.txt";
	private static final String path_cd_AboutMe = path_SaveData + "character-details/cd_AboutMe.txt";
	private static final String path_cd_Backstory = path_SaveData + "character-details/cd_Backstory.txt";
	private static final String path_cd_EmotionalStatus = path_SaveData + "character-details/cd_EmotionalStatus.txt";
	private static final String path_cd_Goals = path_SaveData + "character-details/cd_Goals.txt";
	private static final String path_Cantrips = path_SaveData + "spells/cantrips.txt";
	private static final String path_1stLevel = path_SaveData + "spells/1st_level.txt";
	private static final String path_2ndLevel = path_SaveData + "spells/2nd_level.txt";
	private static final String path_3rdLevel = path_SaveData + "spells/3rd_level.txt";
	private static final String path_4thLevel = path_SaveData + "spells/4th_level.txt";
	private static final String path_5thLevel = path_SaveData + "spells/5th_level.txt";
	private static final String path_6thLevel = path_SaveData + "spells/6th_level.txt";
	private static final String path_7thLevel = path_SaveData + "spells/7th_level.txt";
	private static final String path_8thLevel = path_SaveData + "spells/8th_level.txt";
	private static final String path_9thLevel = path_SaveData + "spells/9th_level.txt";
	private static final String path_N_People = path_SaveData + "notes/notes_People.txt";
	private static final String path_N_Places = path_SaveData + "notes/notes_Places.txt";
	private static final String path_N_History = path_SaveData + "notes/notes_History.txt";
	private static final String path_N_Factions = path_SaveData + "notes/notes_Factions.txt";
	private static final String path_N_Quests = path_SaveData + "notes/notes_Quests.txt";
	private static final String path_N_Fauna = path_SaveData + "notes/notes_Fauna.txt";
	private static final String path_N_Flora = path_SaveData + "notes/notes_Flora.txt";
	private static final String path_Inventory = path_SaveData + "inventory/inventory.json";
	private static final String path_Valuables = path_SaveData + "inventory/valuables.txt";
	private static final String path_Equipment = path_SaveData + "inventory/equipment.txt";
	private static final String path_Weapons = path_SaveData + "inventory/weapons.txt";
	private static final String path_Consumables = path_SaveData + "inventory/consumables.txt";
	private static final String path_Materials = path_SaveData + "inventory/materials.txt";
	
	
	// Json objects
	private static Object def_obj = null;
	private static Object stats_obj = null;
	private static Object inv_obj = null;
	private static JSONObject def_json = null;
	private static JSONObject stats_json = null;
	private static JSONObject inv_json = null;
	
	
	// Constructor and Logger
	public Json_Tools()
	{
		try
		{
			stats_obj = new JSONParser().parse(new FileReader( path_CharacterStats ));
			stats_json = (JSONObject) stats_obj;
		}
		catch  ( ParseException | IOException json_error )
		{
			json_logger( json_error, "Exception caught while constructing c_sheet json" );
		}
		
		
		try
		{
			inv_obj = new JSONParser().parse(new FileReader( path_Inventory ));
			inv_json = (JSONObject) inv_obj;
		}
		catch  ( ParseException | IOException json_error )
		{
			json_logger( json_error, "Exception caught while constructing inventory json" );
		}
		
		
		try
		{
			def_obj = new JSONParser().parse(new FileReader( path_Defaults ));
			def_json = (JSONObject) def_obj;
		}
		catch  ( ParseException | IOException json_error )
		{
			json_logger( json_error, "Exception caught while constructing defaults json" );
		}
	}
	public void json_logger( Exception exception, String errMsg )
	{
		System.out.println( errMsg + ": " + exception );
	}
	
	
	// CHARACTER SHEET
 	public E_Dice load_HitdieType()
	{
		E_Dice temp_type = null;
		
		try
		{
			int enum_index = util.IntFromObj( stats_json.get("hitdie_type") );
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
			Map temp_scores = (Map) stats_json.get("abilities");
	        itr1 = temp_scores.entrySet().iterator();
	        while ( itr1.hasNext() )
	        {    
				Map.Entry pair = itr1.next();
				temp[0] = util.IntFromObj( pair.getValue() );
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
				temp = util.IntFromObj( pair.getValue() );
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
				temp = util.IntFromObj( pair.getValue() );
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
				temp = util.IntFromObj( pair.getValue() );
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
				temp = util.IntFromObj( pair.getValue() );
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
				temp = util.IntFromObj( pair.getValue() );
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
	public HashMap<E_Skills, Integer> load_SkillValues()
	{
		HashMap<E_Skills, Integer> temp_map = new HashMap<E_Skills, Integer>();
		Iterator<Map.Entry> itr1 = null;
		int temp = 0;
		E_Skills temp_skill = null;
		
		try
		{			
			Map temp_scores = ( (Map)stats_json.get("skill_values") );
	        itr1 = temp_scores.entrySet().iterator();
	        while ( itr1.hasNext() )
	        {    
				Map.Entry pair = itr1.next();
				temp = util.IntFromObj( pair.getValue() );
				temp_skill = E_Skills.valueOf( pair.getKey().toString() );
				temp_map.put( temp_skill , temp );    
	        }
		}
		catch ( IllegalStateException | IllegalArgumentException json_error )
		{
			json_logger( json_error, "Exception caught while loading skill values" );
			return null;
		}
		
		return temp_map;
	}

	
	
	public String load_cs_Advantages()
	{
		return txt_loader.readFile( path_cs_Advantages );
	}
	public String load_cs_Disadvantages()
	{
		return txt_loader.readFile( path_cs_Disadvantages );
	}
	public String load_cs_Proficiencies()
	{
		return txt_loader.readFile( path_cs_Proficiencies );
	}
	public String load_cs_Bonuses()
	{
		return txt_loader.readFile( path_cs_Bonuses );
	}
	public String load_cs_ActionNames()
	{
		return txt_loader.readFile( path_cs_ActionNames );
	}
	public String load_cs_ActionAmmo()
	{
		return txt_loader.readFile( path_cs_ActionAmmo );
	}
	public String load_cs_ActionHits()
	{
		return txt_loader.readFile( path_cs_ActionHits );
	}
	public String load_cs_ActionRanges()
	{
		return txt_loader.readFile( path_cs_ActionRanges );
	}
	public String load_cs_ActionDmg()
	{
		return txt_loader.readFile( path_cs_ActionDmg );
	}
	public String load_cs_ActionDmgBonus()
	{
		return txt_loader.readFile( path_cs_ActionDmgBonus );
	}
	public String load_cs_ActionMisc()
	{
		return txt_loader.readFile( path_cs_ActionMisc );
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
			Map temp_scores = (Map<E_Currency, Integer>) inv_json.get("money") ;
	        itr1 = temp_scores.entrySet().iterator();
	        while ( itr1.hasNext() )
	        {    
				Map.Entry pair = itr1.next();
				temp = util.IntFromObj( pair.getValue() );
				temp_coin = E_Currency.valueOf( pair.getKey().toString() );
				temp_map.put( temp_coin , temp );    
	        }
		}
		catch ( IllegalStateException | IllegalArgumentException json_error )
		{
			json_logger( json_error, "Exception caught while loading money values" );
			return null;
		}
		
		return temp_map;
	}
	public String load_Valubles()
	{
		return txt_loader.readFile( path_Valuables );
	}
	public String load_Equipment()
	{
		return txt_loader.readFile( path_Equipment );
	}
	public String load_Weapons()
	{
		return txt_loader.readFile( path_Weapons );
	}
	public String load_Consumables()
	{
		return txt_loader.readFile( path_Consumables );
	}
	public String load_Materials()
	{
		return txt_loader.readFile( path_Materials );
	}
	
	
	// CHARACTER DETAILS
	public String load_cd_AboutMe()
	{
		return txt_loader.readFile( path_cd_AboutMe );
	}
	public String load_cd_Backstory()
	{
		return txt_loader.readFile( path_cd_Backstory );
	}
	public String load_cd_EmotionalStatus()
	{
		return txt_loader.readFile( path_cd_EmotionalStatus );
	}
	public String load_cd_Goals()
	{
		return txt_loader.readFile( path_cd_Goals );
	}
	
	
	// CASTING
	public String load_Cantrips()
	{
		return txt_loader.readFile( path_Cantrips );
	}
	public String load_1stLevel()
	{
		return txt_loader.readFile( path_1stLevel );
	}
	public String load_2ndLevel()
	{
	  return txt_loader.readFile( path_2ndLevel );
	}
	public String load_3rdLevel()
	{
	  return txt_loader.readFile( path_3rdLevel );
	}
	public String load_4thLevel()
	{
	  return txt_loader.readFile( path_4thLevel );
	}
	public String load_5thLevel()
	{
	  return txt_loader.readFile( path_5thLevel );
	}
	public String load_6thLevel()
	{
	  return txt_loader.readFile( path_6thLevel );
	}
	public String load_7thLevel()
	{
	  return txt_loader.readFile( path_7thLevel );
	}
	public String load_8thLevel()
	{
	  return txt_loader.readFile( path_8thLevel );
	}
	public String load_9thLevel()
	{
	  return txt_loader.readFile( path_9thLevel );
	}
	
	
	// NOTES
	public String load_N_People()
	{
		return txt_loader.readFile( path_N_People );
	}
	public String load_N_Places()
	{
		return txt_loader.readFile( path_N_Places );
	}
	public String load_N_History()
	{
		return txt_loader.readFile( path_N_History );
	}
	public String load_N_Quests()
	{
		return txt_loader.readFile( path_N_Quests );
	}
	public String load_N_Factions()
	{
		return txt_loader.readFile( path_N_Factions );
	}
	public String load_N_Fauna()
	{
		return txt_loader.readFile( path_N_Fauna );
	}
	public String load_N_Flora()
	{
		return txt_loader.readFile( path_N_Flora );
	}
	
	
	
	
	// always write to objects in longs ALT - add a conditional in convert method to check if value is a long
	public void write_test( HashMap<E_Currency, Integer> coins )
	{          
		Iterator<Map.Entry> iterator = null;
		int temp = 0;
		E_Currency temp_coin = null;
		
		
		try
		{			
			//Map temp_money = (Map) coins;
			Map temp_money = (Map<E_Currency, Integer>) coins ;
//			iterator = temp_money.entrySet().iterator();
//	        while ( iterator.hasNext() )
//	        {    
//				Map.Entry pair = iterator.next();
//				temp_coin = E_Currency.valueOf( pair.getKey().toString() );
//				temp = coins.get( temp_coin );
//				temp_money.replace( temp_coin , temp );    
//	        }
	        inv_json.replace( "money", temp_money );
		}
		catch ( IllegalStateException | IllegalArgumentException json_error )
		{
			json_logger( json_error, "Exception caught while loading health values" );
		}

		
        PrintWriter writer = null;
		try
		{
			writer = new PrintWriter( path_Inventory );
			JSONObject.writeJSONString( (Map) inv_json, writer );
			//writer.write( inv_json.toJSONString() );
		}
		catch ( IOException e)
		{
			e.printStackTrace();
		}
        
		writer.flush();
		writer.close();
	}
	
	
	class txt_loader
	{
	    public static String readFile( String path )
	    {
	    	byte[] encoded = null;
	    	
			try
			{
		        encoded = Files.readAllBytes(Paths.get(path));
			}
			catch ( IOException e )
			{
				System.out.println( "failure during readFile method: " + e.toString() );
			}

			return new String(encoded, Charset.defaultCharset() );
	    }
	}
	
	
	class util
	{			
 		public static int IntFromString( String string )
		{
			return Integer.parseInt( string );
		}
		
		public static int IntFromEntry( Map.Entry obj )
		{
			return Integer.parseInt( obj.getValue().toString() );
		}
		
		public static int IntFromObj( Object obj )
		{
			int temp = 0;
			try
			{
				temp = Math.toIntExact( (Long) obj );
			}
			catch ( ArithmeticException e )
			{
				System.out.println( "failure during IntFromObj method: " + e.toString() );
			}
	
			return temp;
		}
	}
}
