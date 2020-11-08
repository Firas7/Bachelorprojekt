package de.hsh.genrelalg.antlr.expression;

import java.util.ArrayList;
import java.util.List;

public class Project extends Expr{

	String name;
	String relation ;
	List<String> attributes;
	
	public Project(String name, String rela, List<String> atts) {
		attributes = new ArrayList<>();
		this.name = name;
		this.relation = rela;
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
		return name;
	}

	@Override
	public String getBase() {
		// TODO Auto-generated method stub
		return this.relation;
	}


	@Override
	public List<String> getAttributes() {
		// TODO Auto-generated method stub
		return this.attributes;
	}

}
