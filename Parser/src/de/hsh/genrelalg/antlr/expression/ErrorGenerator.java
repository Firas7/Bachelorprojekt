package de.hsh.genrelalg.antlr.expression;

import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;

public class ErrorGenerator {

	/*
	 * This method returns a boolean value if an attribute is contained in a relation. If not, an error message  will be displayed
	 * */
	public static boolean isAttributInRelation(Relation rel, String attributName) {
		
		List<Attribute> attributes = rel.getAttributes();
		for(int i = 0; i< attributes.size(); i++) {
			if(attributes.get(i).getName().toUpperCase().equals(attributName.toUpperCase())) {
				return true;
			}
		}
		System.out.println("The relation " + rel.getName() + " does not contain this attribute ("+ attributName +")" );
		return false;
		
	}
	
	public static boolean isRelationEqualRelation(String a, String b) {
		
		if(a.toUpperCase().equals(b.toUpperCase())) {
			return true;
		}else {
			System.out.println("Please check the relation name in the condition");
			return false;
		}
	}
}
