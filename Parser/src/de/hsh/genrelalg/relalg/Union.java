package de.hsh.genrelalg.relalg;

import java.util.List;
import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.data.Tuple;


public class Union extends RelationalAlgebra {

	
	RelationalAlgebra left, right;
	boolean matched = true;
	// constructor of Union
	public Union(RelationalAlgebra left, RelationalAlgebra right) {
		this.left = left;
		this.right = right;
	}

	
	
	public boolean getMatched() {
		return this.matched;
	}
	@Override
	public Relation getResult() {
		Relation left = this.left.getResult();
		Relation right = this.right.getResult();
		Relation result = new Relation(left.getAttributes());
		
		checkAttributesNumber(left, right);
		
		if(matched) {
			for(Tuple tl : left.getTuples()) {
				result.addTuple(tl);
			}
			for(Tuple tr : right.getTuples()) {
				result.addTuple(tr);
			}
				return result;
		}
		 
		return result;
	}

	@Override
	public String toText(String indent, boolean results) {
		String res = super.toText(indent, results);
		res += indent + "(";
		res += "\n" + left.toText(indent + "  ", results);
		res += "\n" + indent + "  Union _{  UN  }";
		res += "\n" + right.toText(indent + "  ", results);
		res += "\n" + indent + ")";
		return res;
	}


	public void checkAttributesNumber(Relation left, Relation right) {
		
		int anzahlLeft = left.getAttributes().size();
		int anzahlRight = right.getAttributes().size();
		if(anzahlLeft == anzahlRight) {
			// prüfe die Datentypen der Attribute in beider Relationen
			checkAttributesDataTypes(left.getAttributes(),right.getAttributes());
		} else {
			this.matched = false;
			System.out.println("Union Error: Spaltenanzahl beider Relation "+ left.getName() +" und " + right.getName() +" ist ungleich");
			System.exit(-1);
		}
	}
	
	/*
	 * Diese Methode prüft die Gleichheit der Namen sowie die Reihenfolge der Attribute in beider Relationen.
	 * wenn ein Attribute fehlt oder überflüssig ist, wird dies zu einer Liste hinzugefügt, die später zum Feedback beiträgt
	 * Außerdem wird ein Fehler erzeugt, dass Schemen beider Relationen voneinander abweichen
	 */

	@Override
	public void checkAttributesDataTypes(List<Attribute> left, List<Attribute> right) {
	
		for(int i = 0; i < left.size(); i++ ) {
			if(left.get(i).getClass() != right.get(i).getClass()) {
				System.out.println("Union Error: Die Datentypen der folgenden Attribute stimmen nicht überein :");
				System.out.print(left.get(i).getName() + " | ");
				System.out.println(right.get(i).getName());
				this.matched = false;
				System.exit(-1);
			}
		}
	}
	
}
