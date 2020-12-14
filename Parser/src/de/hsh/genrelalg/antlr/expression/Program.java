package de.hsh.genrelalg.antlr.expression;



import de.hsh.genrelalg.data.Relation;

/* a model class for a program 
 * 
 * */
public class Program {
	
	public Relation result;
	
	public Program() {
		this.result = new Relation("Ergebnis");
	}
	
	public void setResult(Relation res) {
		this.result = res;
	}
	
	public Relation getResult(){
		return this.result;
	}
}
