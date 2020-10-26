package de.compiler.parser;
import java.util.Arrays;
import java.util.List;

import org.antlr.v4.gui.TestRig;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import de.compiler.parser.*;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception{
		
		CharStream input = CharStreams.fromFileName("test1");
		RelAlgebraLexer lexer = new RelAlgebraLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		RelAlgebraParser parser = new RelAlgebraParser(tokens);
		ParseTree tree = parser.expression();
		
		// frame öffnet sich nicht
		final List<String> ruleNames = Arrays.asList(parser.ruleNames);
		final TreeViewer view = new TreeViewer(ruleNames, tree);
		view.open();
		new MyVisitor().visit(tree);
		
	}
}
