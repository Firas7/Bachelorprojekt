package de.compiler.tester;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {

	public static void main(String []args) throws IOException {
		
		CharStream input = CharStreams.fromFileName("test1");
		GramLexer lexer = new GramLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		// parser wird mit tokens gefüttert
		GramParser parser = new GramParser(tokens);
		
		// hier wird die Regel aufgerufen, mit der der Parser anfangen soll, zu parsen (Addition)
		ParseTree tree = parser.addition();
		System.out.println(new MyVisitor().visit(tree));
	}
}
