package de.hsh.genrelalg.database;

public class SearchinDB {

	String relation;
	String attributs;
	Database base;
	
	public SearchinDB(Database base, String relation, String attributs) {
		
		this.base = base;
		this.relation = relation;
		this.attributs = attributs;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getAttributs() {
		return attributs;
	}
	public void setAttributs(String attributs) {
		this.attributs = attributs;
	}
	
	
	
}
