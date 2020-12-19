package de.hsh.genrelalg.relalg;

import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.data.Tuple;
import de.hsh.genrelalg.errors.Discrepancy;
import de.hsh.genrelalg.errors.ErrorService;
import de.hsh.genrelalg.errors.Inequality;

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
		String [] names = new String [left.getAttributes().size()];
		for(int i = 0 ; i < left.getAttributes().size(); i++) {
			names[i] = left.getAttributes().get(i).getName();
		}
		Relation result = new Relation("RES", names);
		
		if(left.getAttributes().size() == right.getAttributes().size()) {
			checkAttributesNumber(left, right);
		}else {
			System.out.println("Anzahl der Attribute ist ungleich");
		}

		
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
	 * Diese Methode pr�ft die Anzahl der Attribute beider Relationen
	 * gleiche Anzahl: werden dann die Namen der Attribute gepr�ft.
	 * ungleiche Anzahl: Fehlererzeugung.
	 * 
	 */
	public void checkAttributesNumber(Relation left, Relation right) {
		
		int anzahlLeft = left.getAttributes().size();
		int anzahlRight = right.getAttributes().size();
		if(anzahlLeft == anzahlRight) {
			// check the consistency of the attribute names
			checkAttributesNames(left.getAttributes(),right.getAttributes());
		} else {
			matched = false;
			ErrorService.addError(new Inequality(left.getAttributes(),right.getAttributes()));
		}
	}
	
	/*
	 * Diese Methode pr�ft die Gleichheit der Namen sowie die Reihenfolge der Attribute in beider Relationen.
	 * wenn ein Attribute fehlt oder �berfl�ssig ist, wird dies zu einer Liste hinzugef�gt, die sp�ter zum Feedback beitr�gt
	 * Au�erdem wird ein Fehler erzeugt, dass Schemen beider Relationen voneinander abweichen
	 */

	@Override
	public void checkAttributesNames(List<Attribute> left, List<Attribute> right) {
	
		boolean found = false;
		for(int i = 0; i < right.size(); i++) {
			for(int j = 0; j< left.size(); j++) {
				found = false;
				if(right.get(i).getName().toUpperCase().equals(left.get(i).getName().toUpperCase())) {
					found = true;	
				}
			}
			
			if(!found) {
				// Attribute stimmen nicht �berein oder die Reihenfolge der Attribute
				System.out.println("Die Namen oder die Reihenfolge stimmen nicht �berein");
				matched = false;
				ErrorService.addError(new Discrepancy(left,right));
			}
		}
	}
	
}
