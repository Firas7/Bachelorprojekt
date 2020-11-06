package de.hsh.genrelalg.Entities;

import java.util.ArrayList;
import java.util.List;

import de.hsh.genrelalg.antlr.expression.Expr;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.relalg.RelationalAlgebra;

public class ProjectionEntity {

	private String relation;
	private List<String> attributes;
	
	public ProjectionEntity(String relation, List<String> attributes ) {
		this.relation = relation;
		attributes = new ArrayList<>();
		for(int i =0; i < attributes.size();i++) {
			this.attributes.add(attributes.get(i));
		}	
	}
	
	public List<String> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<String> attributes) {
		this.attributes = attributes;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}
	
}
