package de.hsh.genrelalg.parser;

import org.antlr.v4.runtime.tree.ParseTree;
import de.hsh.genrelalg.antlr.expression.AntlrToProgram;
import de.hsh.genrelalg.antlr.expression.Program;
import de.hsh.genrelalg.data.Aufgabe;
import de.hsh.genrelalg.database.Database;
import de.hsh.genrelalg.relalg.RelationalAlgebra;

public class Main {
	
	public static Database database;
	
	public static void main(String[] args){
		
		/* Database, which contains all necessary data */
		//database = new Database();
		
		/* A task that must be solved */
		Aufgabe aufgabe = new Aufgabe("Geben Sie eine Lösung ein", database,"Lösung");
		
		RelAlgebraParser parser = AntlrParser.getParser();
		
		// tell Antlr to build a parse tree
		// parse from the start symbol 'prog'
		ParseTree antlrAST = parser.prog();
		// create a visitor for converting the parse tree to Program/Expression object
		AntlrToProgram progVisitor = new AntlrToProgram();
		Program prog = progVisitor.visit(antlrAST);
	}
	
	
	public static void writeOutput(RelationalAlgebra expr, String task) {
		System.out.println("Aufgabe: " + task + "\n");		
		System.out.println(expr.toText("", false));
		System.out.println("\n");
		System.out.println(expr.toText("", true));
	}
}
