package de.hsh.genrelalg.database;
import java.util.ArrayList;
import java.util.List;

import de.hsh.genrelalg.antlr.expression.Expr;
import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.relalg.RelationalAlgebra;

public class Controller {

	
	@SuppressWarnings("unlikely-arg-type")
	public static Relation getRelationFromDB(Expr expression, Database base) {
		
		ArrayList<Relation> relations = base.getRelations();
		RelationalAlgebra r = expression.getRelation();
		String name = expression.getRelation().getName();
		for(int i = 0 ; i < relations.size(); i++) {
			if(relations.get(i).getName().equals(name)) {
				return relations.get(i);
			}
		}
		System.out.println("This Relation " +expression.getRelation().getName() + " doesnt exisit in the Database ");
		return null;
	}
	
	
	public static Attribute [] getAttributesFromDB (Expr expression , Relation r) {
		
		// a list of attributes that have been found and should be returned as a list of type attributes
		Attribute [] attributes = new Attribute[expression.getAttributes().size()];
		
		List<Attribute>attributesOfExpression = expression.getAttributes();
		// get all attributes of the relation r.
		List<Attribute> attributesOfRelation = r.getAttributes();
		// List for all attribute names of a relation as string  
		List<String> namesOfAttributs = new ArrayList<>();
		// add attribute names to the list
		for(int i = 0 ; i < attributesOfRelation.size(); i++) {
			namesOfAttributs.add(r.getAttributes().get(i).getName());
		}
		
		for(int i = 0 ; i < expression.getAttributes().size(); i++) {
			if(namesOfAttributs.contains(attributesOfExpression.get(i).getName())) {
				attributes[i] = findAttributByName(attributesOfRelation,expression.getAttributes().get(i).getName());
			}else {
				System.out.println("Das Attribut "+ expression.getAttributes().get(i).getName()+" ist nicht in der Relation enthalten!");
			}
		}
				
		return attributes;
	}
	
public static Attribute findAttributByName(List<Attribute> att , String name) {
		
		for(int i = 0; i < att.size(); i++) {
			if(att.get(i).getName().equals(name)) {
				return att.get(i);
			}
		}
		System.out.println("This attribut connt be found");
		return null;
	}
}
