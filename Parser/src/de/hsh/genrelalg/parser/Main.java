package de.hsh.genrelalg.parser;
import java.io.IOException;
import java.util.List;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


import de.hsh.genrelalg.antlr.expression.AntlrToProgram;

import de.hsh.genrelalg.antlr.expression.Program;
import de.hsh.genrelalg.antlr.expression.Project;
import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Aufgabe;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.database.DBFactory;
import de.hsh.genrelalg.database.Database;
import de.hsh.genrelalg.relalg.Projection;
import de.hsh.genrelalg.relalg.RelationalAlgebra;

public class Main {
	
	public static Database database;
	
	@SuppressWarnings({ "deprecation", "null" })
	public static void main(String[] args){
		
		/* Database, which contains all necessary data */
		database = new Database();
		
		/* A task that must be solved */
		Aufgabe aufgabe = new Aufgabe("Geben Sie eine Lösung ein", database,"Lösung");
		
		/* this method returns a parser */
		RelAlgebraParser parser = getParser();
		
		// tell Antlr to build a parse tree
		// parse from the start symbol 'prog'
		ParseTree antlrAST = parser.prog();
		// create a visitor for converting the parse tree to Program/Expression object
		AntlrToProgram progVisitor = new AntlrToProgram();
		Program prog = progVisitor.visit(antlrAST);
		
		/*** muss überarbeitet werden */
		/*Projection pro = null;
		Relation r  = DBFactory.findRelationByName(database, prog.expressions.get(0).getBase());
		
		Attribute [] atts = new Attribute[prog.expressions.get(0).getAttributes().size()];
		atts = DBFactory.findAttributByName(r, prog.expressions.get(0).getAttributes());
		
				
		
		if( prog.expressions.get(0) instanceof Project) {
			pro = new Projection(r,atts);
		}
		writeOutput(pro, "Test");*/
		/*****bis dahin ****/
	}
	
	/*
	 * Here typ types of parser and lexer are specific to the grammar
	 * name RelAlgebra.g4
	 * */
	
	public static RelAlgebraParser getParser(){
		RelAlgebraParser parser = null;
		try {
			CharStream input = CharStreams.fromFileName("test1");
			RelAlgebraLexer lexer = new RelAlgebraLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			parser = new RelAlgebraParser(tokens);
			//ParseTree tree = parser.expr();		
			//ParseTreeWalker walker = new ParseTreeWalker();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return parser;
	}
	
	public static void writeOutput(RelationalAlgebra expr, String task) {
		System.out.println("Aufgabe: " + task + "\n");		
		System.out.println(expr.toText("", false));
		System.out.println("\n");
		System.out.println(expr.toText("", true));
	}
}
