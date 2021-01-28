package de.hsh.genrelalg.database;

import java.util.List;
import de.hsh.genrelalg.data.Relation;

public class DBFactory {

	
	static Database base = new Database();
	static List<Relation> relations = base.getRelations();
	
	public static Relation getRelationByName(String string) {
		for (int i = 0; i < relations.size(); i++) {
			if(relations.get(i).getName().equals(string)) {
				return relations.get(i);
			}
		}
		System.out.println("This relation doesnt exisit in the database!");
		return null;
	}
	
}
