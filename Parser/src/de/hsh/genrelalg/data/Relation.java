package de.hsh.genrelalg.data;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import de.hsh.genrelalg.relalg.RelationalAlgebra;

/**
 * a complete relation including its schema (attributes) and tuples
 * string is the only supported data type for a value at the moment.
 * @author felix
 *
 */
public class Relation extends RelationalAlgebra {
	List<Attribute> attributes = new LinkedList<>();
	List<Tuple> tuples = new LinkedList<>();
	String name;
	
	/* diese Methode setzt den Namen + Attribute einer Relation */
	public Relation(String name, String ... attNames) {
		this.name = name;
		for (String att : attNames) {
			this.attributes.add(new Attribute(name, att));
		}
	}
	
	public Relation(String name) {
		this.name = name;
	}
	/* Konstruktur legt eine leere Relation an*/
	public Relation() {
		this.name = "RES";
	}
	
	/* Konstruktur legt eine Relation ohne gegebenen Namen an */
	public Relation(List<Attribute> attributes) {
		this.name = "RES";
		this.attributes.addAll(attributes);
	}
	
	/* fuegt in einer Relation einen Datensatz ein */
	public void addTuple(Tuple t) {
		if (!tuples.contains(t))
			tuples.add(t);
	}
	
	public String contentToText(String indent) {
		int [] len = new int[attributes.size()];
		for (int i = 0; i < attributes.size(); i++) {
			len[i] = attributes.get(i).toText().length();
			for (Tuple t : tuples) {
				len[i] = Math.max(t.getField(i).length(), len[i]);
			}
		}

		String res = indent;
		String sep = indent;
		for (int i = 0; i < attributes.size(); i++) {
			res += "| ";
			sep += "+-";
			res += String.format("%1$-" + len[i] + "s", attributes.get(i).toText()) + " ";
			sep += String.format("%1$" + len[i] + "s", "").replace(" ", "-") + "-";
		}
		sep += "+";
		res += "|\n" + sep;
		for (Tuple t : tuples) {
			res += "\n" + indent;
			res += t.toText(len);
		}
		return sep + "\n" + res + "\n" + sep;
	}

	@Override
	public String toText(String indent, boolean results) {
		String res = super.toText(indent, results);
		return res + indent + name;
	}

	/* liefert die Datensaetze einer Relation als collection zurueck */
	public Collection<Tuple> getTuples() {
		return tuples;
	}

	@Override
	public Relation getResult() {
		return this;
	}

	/* liefert die Attribute einer Relation als Liste zurueck*/
	public List<Attribute> getAttributes() {
		return attributes;
	}

	/* fuegt ein neues Attribut hinzu */
	public void addAttribute(Attribute att) {
		attributes.add(att);
	}

	public boolean contains(Tuple t) {
		return tuples.contains(t);
	}
	
	public String getName() {
		return this.name;
	}
}
