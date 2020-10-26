package de.hsh.genrelalg.data;

import java.util.LinkedList;
import java.util.List;

/**
 * a tuple from a relation. the values of the compentents are strings
 * @author felix
 *
 */
public class Tuple {

	private List<String> fields = new LinkedList<>();
	
	public Tuple(String ... fields) {
		for (String f : fields) {
			this.fields.add(f);
		}
	}
	
	public String toText(int [] len) {
		String res = "";
		for (int i = 0; i < fields.size(); i++) {
			res += "| ";
			res += String.format("%1$-" + len[i] + "s", fields.get(i)) + " ";
		}
		return res + "|";
	}

	public String getField(int i) {
		return fields.get(i);
	}

	public void addField(String field) {
		fields.add(field);
	}

	public Tuple join(Tuple that) {
		Tuple t = new Tuple();
		for (String val : this.fields) {
			t.addField(val);
		}
		for (String val : that.fields) {
			t.addField(val);
		}
		return t;
	}

	public Tuple joinLeftOuter(Relation r) {
		Tuple t = new Tuple();
		for (String val : this.fields) {
			t.addField(val);
		}
		for (int i = 0; i < r.getAttributes().size(); i++) {
			t.addField(null);
		}
		return t;
	}

	public Tuple joinRightOuter(Relation r) {
		Tuple t = new Tuple();
		for (int i = 0; i < r.getAttributes().size(); i++) {
			t.addField(null);
		}
		for (String val : this.fields) {
			t.addField(val);
		}
		return t;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fields == null) ? 0 : fields.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tuple other = (Tuple) obj;
		if (fields == null) {
			if (other.fields != null)
				return false;
		} else if (!fields.equals(other.fields))
			return false;
		return true;
	}	
}
