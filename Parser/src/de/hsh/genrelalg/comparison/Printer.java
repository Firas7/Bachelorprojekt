package de.hsh.genrelalg.comparison;

import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.errors.ErrorService;


public class Printer {

	ErrorService errors;
	double score;
	boolean x;
	Relation base;
	
	// Wenn Tabellen gleich sind und minus 0 Daten hat.
	public Printer (Relation base, ErrorService errors, double score) {
		this.base = base;
		this.errors = errors;
		this.score = score;
		printFinaleResult();
	}

	// Wenn der strukturelle Verleich fehlschlägt
	public Printer (ErrorService errors, double score) {
		this.errors = errors;
		this.score = score;
		this.printReport();
	}
	
	// Wenn Minus noch Daten hat
	public Printer(Relation base,ErrorService erros, double score, boolean x) {
		this.errors = erros;
		this.score = score;
		this.x = x;
		this.base =base;
		this.printReport2();
	}

	// struktureller Vergleich ist fehlgeschlagen
	public void printReport() {
		for(int i = 0; i<errors.getMistakes().size(); i++) {
			System.out.println("Feedbacks: ");
			errors.getMistakes().get(i).getAttributesOfError();
		}
		printErrorsAndScore();
		printFinaleResult();
	}
	
	// Ausgabe der übrigen Daten in Minus
	public void printReport2() {
			String table;
		if(this.x) {
			// left hat mehr Daten als right --> Mangel
			
			System.out.println("In dem Ergebnisrelation fehlen folgende Zeilen, prüfen Sie das eingegebene Prädikat oder die durchgeführt Operation. ");
			table = this.base.getResult().contentToText("");
			System.out.println(table);
		}else {
			// right hat mehr Daten als left --> Überfluss
			System.out.println("In dem Ergebnisrelation sind folgende Zeilen überflüssig, prüfen Sie das eingegebene Prädikat oder die durchgeführt Operation. ");
			table = this.base.getResult().contentToText("");
			System.out.println(table);
		}
		
			printErrorsAndScore();
			for(int i = 0; i<errors.getMistakes().size(); i++) {
				System.out.println("Feedbacks: ");
				errors.getMistakes().get(i).getAttributesOfError();
			}
			printFinaleResult();
		}
	
	/*
	 * Diese Methode gibt die Fehler und die erreichte Punkte einer Lösung aus.
	 * 
	 * */
	
	public void printErrorsAndScore() {
		
		String leftAlignFormat = "| %-15s | %-15s | %-15s| %n";
		String socre = "| %-15s | %-41s |%n";
		System.out.format("+-----------------+-----------------------------------------------------------------+%n");
		System.out.format("| Errors          | Tetx                	           |   Minus                |%n");
		System.out.format("+-----------------+-----------------------------------------------------------------+%n");
		for (int i = 0; i < errors.getMistakes().size(); i++) {
		    System.out.format(leftAlignFormat, errors.getMistakes().get(i).getName(), errors.getMistakes().get(i).getText() , 
		    		errors.getMistakes().get(i).getMinus());
		}
		System.out.format("+-----------------+-----------------------------------------------------------------+%n");
		System.out.format(socre, "Socre " , this.score);
		System.out.format("+-----------------+-----------------------------------------------------------------+%n");
	}
	
	/*
	 * Diese Methode gibt aus, ob die Lösung als richtig oder falsch bewertet wurde
	 * */
	public void printFinaleResult() {
		
		String result = "| %-15s | %-41s |%n";
		System.out.format("+-----------------+-------------------------------------------+%n");
		if(this.base == null) {
			System.out.format(result,"Restul"," Result is not correct ");
			System.out.format("+-----------------+-------------------------------------------+%n");
		}
		else if(this.base.getResult().getTuples().size() == 0 && this.errors.getMistakes().size() == 0) {
			System.out.format(result,"Result", " is correct");
			System.out.format("+-----------------+-------------------------------------------+%n");
		} else {
			// Error --> check predicate.
			System.out.format(result,"Result","  is not correct ");
			System.out.format("+-----------------+-------------------------------------------+%n");
			if(this.x) {
				//writeOutput(minus, " In der Tabelle fehlen die folgende Datensätze  ");
			}else {
				//writeOutput(minus, " Die Tabelle enthält überflüssige Datensätze ");
			}	
		}
	}
}
