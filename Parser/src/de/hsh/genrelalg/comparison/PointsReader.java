package de.hsh.genrelalg.comparison;


import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import de.hsh.genrelalg.errors.Discrepancy;
import de.hsh.genrelalg.errors.Fehler;
import de.hsh.genrelalg.errors.Inequality;
import de.hsh.genrelalg.errors.Mistake;
import de.hsh.genrelalg.errors.Sequence;


public class PointsReader {

	static HashMap<String, String> deduction = new HashMap<>();
	
	public static void getPointsDeductions() {
		
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		try {     
	            Object obj = parser.parse(new FileReader("points.json"));
	            jsonObject = (JSONObject) obj;
	            // get an Array from JSON Object
	            JSONArray arr = (JSONArray) jsonObject.get("Errors");
	            
	            for(int i = 0; i < arr.size(); i++) {
	            	JSONObject jsonErrors = (JSONObject) arr.get(i);
	            	deduction.put((String)jsonErrors.get("Name"), (String)jsonErrors.get("Minus"));
	            }

	        } catch (Exception ex) {
	            System.out.println(ex.getMessage());
	        }
	}
	
	public static HashMap<String, String> getDeduction(){
		return deduction;
	}
	
	public static double getMinus(Mistake m) {
		if(m instanceof Sequence) {
			return Double.parseDouble(deduction.get("Sequence")); 
		}else if(m instanceof Inequality) {
			return Double.parseDouble(deduction.get("Inequality"));
		}else if(m instanceof Discrepancy) {
			return Double.parseDouble(deduction.get("Discrepancy"));
		}else if(m instanceof Fehler) {
			return Double.parseDouble(deduction.get("Fehler"));
		}
		else {
			return 0.0;
		}
	}
}
