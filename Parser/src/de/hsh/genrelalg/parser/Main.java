package de.hsh.genrelalg.parser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.antlr.v4.gui.TestRig;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.SyntaxTree;

import de.hsh.genrelalg.antlr.expression.AntlrToProgram;
import de.hsh.genrelalg.antlr.expression.Expr;
import de.hsh.genrelalg.antlr.expression.Program;
import de.hsh.genrelalg.data.Aufgabe;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.data.Tuple;
import de.hsh.genrelalg.database.Database;
import de.hsh.genrelalg.database.Database_employee;
import de.hsh.genrelalg.parser.*;
import de.hsh.genrelalg.relalg.RelationalAlgebra;

public class Main {
	
	public static Database database;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		//MyListener listener = new MyListener(parser);
		//walker.walk(listener, tree);
		// frame öffnet sich nicht
		/*final List<String> ruleNames = Arrays.asList(parser.ruleNames);
		final TreeViewer view = new TreeViewer(ruleNames, tree);
		view.open();*/
		
		database = new Database();
		Aufgabe aufgabe = new Aufgabe("Geben Sie eine Lösung ein", database,"Lösung");
		
		RelAlgebraParser parser = getParser();
		// tell Antlr to build a parse tree
		// parse from the start symbol 'prog'
		ParseTree antlrAST = parser.prog();
		// create a visitor for converting the parse tree to Program/Expression object
		AntlrToProgram progVisitor = new AntlrToProgram();
		Program prog = progVisitor.visit(antlrAST);
		
		for(int i=0; i< prog.expressions.size();i++) {
			System.out.println("Ouput in Main: "+prog.expressions.get(i).printSomething());
		}
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
