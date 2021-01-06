package de.hsh.genrelalg.relalg;

import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.data.Tuple;

public class Intersection extends RelationalAlgebra{

	RelationalAlgebra left, right;
	boolean matched = true;

	public Intersection(RelationalAlgebra left, RelationalAlgebra right) {
		this.left = left;
		this.right = right;
	}

	
	@Override
	public Relation getResult() {
		Relation left = this.left.getResult();
		Relation right = this.right.getResult();
		Relation result = new Relation(left.getAttributes());
		
		checkAttributesNumber(left, right);
		
		if(matched) {
			for(Tuple tl: left.getTuples()) {
				if(right.contains(tl)) {
					result.addTuple(tl);
				}
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
		res += "\n" + indent + "  Intersection _{  IN  }";
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
					checkAttributesDataTypes(left.getAttributes(),right.getAttributes());
				}else {
					this.matched = false;
					System.out.println("Intersection Error: Spaltenanzahl beider Relation "+ left.getName() +" und " + right.getName() +" ist ungleich");
					System.exit(-1);
				}
			
			}

		/*
		 * Diese Methode pr�ft die Gleichheit der Namen sowie die Reihenfolge der Attribute in beider Relationen.
		 * wenn ein Attribute fehlt oder �berfl�ssig ist, wird dies zu einer Liste hinzugef�gt, die sp�ter zum Feedback beitr�gt
		 * Au�erdem wird ein Fehler erzeugt, dass Schemen beider Relationen voneinander abweichen
		 */
	
	@Override
	public void checkAttributesDataTypes(List<Attribute> left, List<Attribute> right) {
		for(int i = 0; i < left.size(); i++ ) {
			if(left.get(i).getClass() != right.get(i).getClass()) {
				System.out.println("Intersection Error: Die Datentypen der folgenden Attribute stimmen nicht �berein :");
				System.out.print(left.get(i).getName() + " | ");
				System.out.println(right.get(i).getName());
				this.matched = false;
				System.exit(-1);
			}
		}
	}

	
}
