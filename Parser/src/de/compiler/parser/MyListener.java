package de.compiler.parser;

import org.antlr.v4.runtime.tree.TerminalNode;

import de.hsh.genrelalg.relalg.Selection;

public class MyListener extends RelAlgebraBaseListener{
	
	RelAlgebraParser parser;
	
	public MyListener(RelAlgebraParser parser) {
		this.parser = parser;
	}	
}
