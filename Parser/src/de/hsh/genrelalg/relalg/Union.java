package de.hsh.genrelalg.relalg;

import java.util.ArrayList;
import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.data.Tuple;
import de.hsh.genrelalg.errors.Discrepancy;
import de.hsh.genrelalg.errors.ErrorService;

public class Union extends RelationalAlgebra {

	
	RelationalAlgebra left, right;
	boolean matched = true;
	List<Attribute> faultyAttributes = new ArrayList<>();
	// constructor of Union
	public Union(RelationalAlgebra left, RelationalAlgebra right) {
		this.left = left;
		this.right = right;
	}

	public List<Attribute> getFaultyAttributes(){
		return this.faultyAttributes;
	}
	
	public boolean getMatched() {
		return this.matched;
	}
	@Override
	public Relation getResult() {
		Relation left = this.left.getResult();
		Relation right = this.right.getResult();
		String [] names = new String [left.getAttributes().size()];
		for(int i = 0 ; i < left.getAttributes().size(); i++) {
			names[i] = left.getAttributes().get(i).getName();
		}
		Relation result = new Relation("RES", names);
		
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


	/*
	 * Diese Methode prüft die Anzahl der Attribute beider Relationen
	 * gleiche Anzahl: werden dann die Namen der Attribute geprüft.
	 * ungleiche Anzahl: Fehlererzeugung.
	 * 
	 */
	public void checkAttributesNumber(Relation left, Relation right) {
		
		int anzahlLeft = left.getAttributes().size();
		int anzahlRight = right.getAttributes().size();
		if(anzahlLeft == anzahlRight) {
			// gleich
			checkAttributesNames(left.getAttributes(),right.getAttributes());
		}else {
			// ungleich TODO ErrorService.addError(new Inequality());
			System.out.println("Anzahl der Attribute ist ungleich");
			matched = false;
		}
	
	}
	
	/*
	 * Diese Methode prüft die Gleichheit der Namen sowie die Reihenfolge der Attribute in beider Relationen.
	 * wenn ein Attribute fehlt oder überflüssig ist, wird dies zu einer Liste hinzugefügt, die später zum Feedback beiträgt
	 * Außerdem wird ein Fehler erzeugt, dass Schemen beider Relationen voneinander abweichen
	 */

	@Override
	public void checkAttributesNames(List<Attribute> left, List<Attribute> right) {
	
		for(int i = 0; i < right.size(); i++) {
			boolean found = false;
				if(right.get(i).getName().toUpperCase().equals(left.get(i).getName().toUpperCase())) {
					found = true;	
			}
			if(!found) {
			// Attribute stimmen nicht überein oder die Reihenfolge der Attribute
			faultyAttributes.add(right.get(i));
			matched = false;
			ErrorService.addError(new Discrepancy());
			}
		}
	}
	
}
