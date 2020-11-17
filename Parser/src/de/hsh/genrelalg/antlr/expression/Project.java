package de.hsh.genrelalg.antlr.expression;

import java.util.ArrayList;
import java.util.List;

import de.hsh.genrelalg.data.Relation;


public class Project extends Expr{

	String name;
	String relationName ;
	List<String> attributes;
	Relation relation;
	
	public Project(String name, String rela, List<String> atts) {
		attributes = new ArrayList<>();
		this.name = name;
		this.relationName = rela;
		for(int i = 0; i < atts.size(); i++) {
			attributes.add(atts.get(i));
		}
	}
	
	
	@Override
	public String printSomething() {
		// TODO Auto-generated method stub
		return "Here is a Projection";
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getBase() {
		// TODO Auto-generated method stub
		return this.relationName;
	}


	@Override
	public List<String> getAttributes() {
		// TODO Auto-generated method stub
		return this.attributes;
	}


	@Override
	public Relation getRelation() {
		// TODO Auto-generated method stub
		return this.relation;
	}


	@Override
	public void setRelation(Relation r) {
		this.relation = r;
		
	}
}
