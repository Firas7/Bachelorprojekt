package de.hsh.genrelalg.expr;

import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Tuple;

public class ExprAttribute implements FieldExpression {

	private Attribute attribute;

	public ExprAttribute(Attribute name) {
		this.attribute = name;
	}
	
	public ExprAttribute(String name) {
		this.attribute = new Attribute(name);
	}

	public ExprAttribute(String relation, String name) {
		this.attribute = new Attribute(relation, name);
	}

	@Override
	public String eval(Tuple t, List<Attribute> attributes) {
		for (int i = 0; i < attributes.size(); i++) {
			//System.out.println("Attributes: " + attributes.get(i).getName());
			//System.out.println("Tuple " + t.getField(i).toString());
			if (attributes.get(i).equals(attribute))
				return t.getField(i);
		}
		return "NULL";
	}
	
	@Override
	public String toText() {
		return attribute.toText();
	}
	
	
}
