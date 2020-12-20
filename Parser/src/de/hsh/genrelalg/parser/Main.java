package de.hsh.genrelalg.parser;

import java.io.IOException;

import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import de.hsh.genrelalg.antlr.expression.AntlrToProgram;
import de.hsh.genrelalg.antlr.expression.Program;
import de.hsh.genrelalg.comparison.Comperator;
import de.hsh.genrelalg.data.Assignment;
import de.hsh.genrelalg.database.Database;
import de.hsh.genrelalg.relalg.RelationalAlgebra;

public class Main {
	
	public static Database database;
	
	public static void main(String[] args){
		
		
		/* A task that must be solved */
		Assignment aufgabe = new Assignment("Aufgabe 1", database,"PR [name , gehalt] (ANGEST)",1.0);
	
		RelAlgebraParser parser = AntlrParser.getParser();
		RelAlgebraParser parserOfAnswer = null;
		try {
			parserOfAnswer = AntlrParser.getParserForRightAnswer(aufgabe.getAnswer());
		} catch (ParseCancellationException | IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * get Parser for correct answer
		 * */
		ParseTree ast = parserOfAnswer.prog();
		/*
		 * create a visitor for the correct answer
		 * */
		AntlrToProgram progVisitorOfAnswer = new AntlrToProgram();
		Program progOfAnswer = progVisitorOfAnswer.visit(ast);
		//writeOutput(progOfAnswer.getResult().getResult(), "The correct Answer is");
		
		/*
		 * get Parser for input answer
		 * */
		ParseTree antlrAST = parser.prog();
		/* 
		 * create a visitor for input answer 
		 * */
		AntlrToProgram progVisitor = new AntlrToProgram();
		Program prog = progVisitor.visit(antlrAST);
		prog.getResult().setName("Answer of student");
		//writeOutput(prog.getResult().getResult(), aufgabe.getText());	
		
		Comperator com = new Comperator(aufgabe,progOfAnswer.getResult().getResult(),prog.getResult().getResult());
		
		
	}
	
	public static void writeOutput(RelationalAlgebra expr, String task) {
		System.out.println("Aufgabe: " + task + "\n");		
		System.out.println(expr.toText("", false));
		System.out.println("\n");
		System.out.println(expr.toText("", true));
	}
}
