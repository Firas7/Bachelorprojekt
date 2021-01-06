package de.hsh.genrelalg.comparison;

import java.util.ArrayList;
import java.util.List;

import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.errors.ErrorService;
import de.hsh.genrelalg.feedback.Feedback;


public class ReportGenerator {

	ErrorService errors;
	double score;
	boolean x;
	Relation base;
	
	// Wenn Tabellen gleich sind und minus 0 Daten hat.
	public ReportGenerator (Relation base, ErrorService errors, double score) {
		this.base = base;
		this.errors = errors;
		this.score = score;
		printErrorsAndScore();
		printFinaleResult();
	}

	// Wenn der strukturelle Verleich fehlschlägt
	public ReportGenerator (ErrorService errors, double score) {
		this.errors = errors;
		this.score = score;
		printErrorsAndScore();
		printFinaleResult();
		printFeedbacks();
	}
	
	// Wenn Minus noch Daten hat
	public ReportGenerator(Relation base,ErrorService erros, double score, boolean x) {
		this.errors = erros;
		this.score = score;
		this.x = x;
		this.base =base;
		printErrorsAndScore();
		printFinaleResult();
		printFeedbacks();
		printTable();
	}

	// gibt die Datensätze aus, die durch den inhaltlichen Vergleich entstehen können
	public void printTable() {
			System.out.println(this.base.getResult().contentToText(""));
		}
	
	
   /*
	* Diese Methode gibt die Feedbacks jedes Fehlers aus.
	*/
	public void printFeedbacks() {
		List<Feedback> feedbacks = new ArrayList<>();
		for(int i = 0; i <errors.getMistakes().size(); i++){
			feedbacks = errors.getMistakes().get(i).getFeedbacks();
		}
		for(int j = 0; j < feedbacks.size(); j++){
			System.out.println("Feedback: " + feedbacks.get(j).getText());
		}
	}
	
	
	/*
	 * Diese Methode gibt die Fehler und die erreichte Punkte einer Lösung aus.
	 * 
	 * */
	
	public void printErrorsAndScore() {
		
		String leftAlignFormat = "| %-15s | %-38s | %-23s| %n";
		String socre = "| %-15s | %-63s |%n";
		System.out.format("+-----------------+-----------------------------------------------------------------+%n");
		System.out.format("| Errors          | Text                	           | Minus                  |%n");
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
		
		String result = "| %-15s | %-63s |%n";
		System.out.format("+-----------------+-----------------------------------------------------------------+%n");
		if(this.base == null) {
			System.out.format(result,"Restul","  is not correct ");
			System.out.format("+-----------------+-----------------------------------------------------------------+%n");
		}
		else if(this.base.getResult().getTuples().size() == 0 && this.errors.getMistakes().size() == 0) {
			System.out.format(result,"Result", " is correct");
			System.out.format("+-----------------+-----------------------------------------------------------------+%n");
		} else {
			// Error --> check predicate.
			System.out.format(result,"Result","  is not correct ");
			System.out.format("+-----------------+-----------------------------------------------------------------+%n");
		}
	}
}
