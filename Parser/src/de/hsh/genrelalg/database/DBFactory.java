package de.hsh.genrelalg.database;

import java.util.ArrayList;
import java.util.List;

import de.hsh.genrelalg.antlr.expression.Expr;
import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;

public class DBFactory {

	
	static Database base = new Database();
	static List<Relation> relations = base.getRelations();
	
	/* This method searches for the name of a relation in the database and returns a relation object */
	public static Relation findRelationByName(Database base, String string) {
		ArrayList<Relation> relations = base.getRelations();
		
		for (int i = 0; i < relations.size(); i++) {
			if(relations.get(i).getName().equals(string)) {
				return relations.get(i);
			}
		}
		System.out.println("This relation doesnt exisit in the database!");
		return null;
	}
	
	/* This method gets as parameter a relation object and a name list of the entered attributes 
	 * and searches for the entered attributes in a certain relation and returns the attributes as a list
	 * */
	public static Attribute [] findAttributByName(Relation r, List<String> atts) {
		
		// a list of attributes that have been found and should be returned as a list of type attributes
		Attribute [] attributes = new Attribute[atts.size()];
		// get all attributes of the relation r.
		List<Attribute> attOfRelation = r.getAttributes();
		// List for all attribute names of a relation as string  
		List<String> namesOfAttributs = new ArrayList<>();
		
		// add attribute names to the list
		for(int i = 0 ; i < attOfRelation.size(); i++) {
			namesOfAttributs.add(r.getAttributes().get(i).getName());
		}
		
		// checks if the entered attributes match the attribute names of the relation  
		// If not,  the method will display a Error message
		
		for(int i = 0 ; i < atts.size(); i++) {
			if(namesOfAttributs.contains(atts.get(i))) {
				attributes[i] = findAttributByName(attOfRelation,  atts.get(i));
			}else {
				System.out.println("Das Attribut "+ atts.get(i) +" ist nicht in der Relation enthalten!");
			}
		}
		return attributes;
	}
	
	public static Attribute findAttributByName(List<Attribute> att , String name) {
		
		for(int i = 0; i < att.size(); i++) {
			if(att.get(i).getName().equals(name.toUpperCase())) {
				return att.get(i);
			}
		}
		System.out.println("This attribut connt be found");
		return null;
	}
	/*************
	 * 
	 ****
	 * 
	 **/
	public static Relation getRelationByName(Expr expression) {
		
		for (int i = 0; i < relations.size(); i++) {
			if(relations.get(i).getName().equals(expression.getBase())) {
				return relations.get(i);
			}
		}
		System.out.println("This relation doesnt exisit in the database!");
		return null;
	}
	
	public static Attribute getAttributeByName(Relation r, String att) {
		// a list of attributes that have been found and should be returned as a list of type attributes

		Attribute attribut = null;
		List<Attribute> attOfRelation = r.getAttributes();
		for(int i = 0; i< attOfRelation.size(); i++){
			if(attOfRelation.get(i).getName().toUpperCase().equals(att.toUpperCase())) {
				attribut = attOfRelation.get(i);
			}
		}
		
		
		return attribut;
	}
	
	public static Relation getRelationByName(String string) {
		
		for (int i = 0; i < relations.size(); i++) {
			if(relations.get(i).getName().equals(string)) {
				return relations.get(i);
			}
		}
		System.out.println("This relation doesnt exisit in the database!");
		return new Relation("relation is not found");
	}
	
}
