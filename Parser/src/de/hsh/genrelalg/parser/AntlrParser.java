package de.hsh.genrelalg.parser;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import de.hsh.genrelalg.errorHandling.ThrowingErrorListener;


public class AntlrParser {

	public static RelAlgebraParser getParser() throws ParseCancellationException{
		
		/* this method returns a Antlr Parser */
		RelAlgebraParser parser = null;
		try {
			CharStream input = CharStreams.fromFileName("test1");
			RelAlgebraLexer lexer = new RelAlgebraLexer(input);
			lexer.removeErrorListeners();
			lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			parser = new RelAlgebraParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(ThrowingErrorListener.INSTANCE);
			//ParseTree tree = parser.expr();		
			//ParseTreeWalker walker = new ParseTreeWalker();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return parser;
	}
	
	public static RelAlgebraParser getParserForRightAnswer(String answer) throws ParseCancellationException, IOException {
		RelAlgebraParser parser = null;
		CharStream input = new ANTLRInputStream(answer);
		RelAlgebraLexer lexer = new RelAlgebraLexer(input);
		lexer.removeErrorListeners();
		lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		parser = new RelAlgebraParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(ThrowingErrorListener.INSTANCE);
		//ParseTree tree = parser.expr();		
		//ParseTreeWalker walker = new ParseTreeWalker();
		return parser;
	}
}
