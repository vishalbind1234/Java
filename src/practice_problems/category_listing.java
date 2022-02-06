package practice_problems;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class category_listing {
	
	static JSONArray main_arr;   

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		String id = "51";
		
		
		
		JSONParser parser = new JSONParser();
		
		FileReader f = new FileReader("/home/vishal/eclipse-workspace/practice_problems/resources/test_data.json");
		
		Object obj = parser.parse(f);
		
		main_arr = (JSONArray)obj;
		
		
		/*
		JSONObject job = (JSONObject)main_arr.get(0);
		
		System.out.println(  job.get("entity_id").toString() );
		*/
		
		
		/*
		for(Object o : main_arr) {
			
			JSONObject jo = (JSONObject)o;
			String str = jo.get("entity_id").toString();
			
			System.out.println(str);
		}
		*/
		
		//System.out.println(id);
		printAllParent(id );
		
		
	}
	
	public static void printAllParent(String id ) {
		
		for(Object o : main_arr) {
			
			JSONObject jo = (JSONObject)o;
			String eid = jo.get("entity_id").toString();
			if(eid.equals(id)) {
				System.out.println(eid);
				String pid = jo.get("parent_id").toString();
				//System.out.println(pid);
				printAllParent(pid );
				break;
			
			}
			
			
		}
		
		/*
		String pid = jo.get("parent_id").toString();
		printAllParent(pid , main_arr);
		*/
	
	}
	

}
 