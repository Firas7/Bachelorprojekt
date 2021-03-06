package de.hsh.genrelalg.expr;

import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Tuple;

public interface FieldExpression {
	public String eval(Tuple t, List<Attribute> attributes);
	public String toText();
}
