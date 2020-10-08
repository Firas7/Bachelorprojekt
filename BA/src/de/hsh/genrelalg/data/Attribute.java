package de.hsh.genrelalg.data;

/**
 * name and relation of an attribute. the relation can be NULL, in this case only the name is stored
 * @author felix
 *
 */
public class Attribute {
	String relation, name;
	
	public Attribute(String relation, String name) {
		this.relation = relation;
		this.name = name;
	}
	
	public Attribute(String name) {
		this.relation = null;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Attribute other = (Attribute) obj;
		if (relation != null && other.relation != null) {
			if (!relation.equalsIgnoreCase(other.relation))
				return false;
		}
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String toText() {
		String res;
		if (relation != null)
			res = relation + ".";
		else 
			res = "";
		return res + name;
	}

	public String getRelation() {
		return relation;
	}
}
