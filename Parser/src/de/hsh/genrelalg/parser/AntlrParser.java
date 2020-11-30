package de.hsh.genrelalg.parser;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class AntlrParser {

	public static RelAlgebraParser getParser(){
		
		/* this method returns a Antlr Parser */
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
}
