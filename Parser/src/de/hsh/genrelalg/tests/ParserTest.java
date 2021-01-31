package de.hsh.genrelalg.tests;

import static org.junit.Assert.assertNotNull;
import java.io.IOException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import de.hsh.genrelalg.starter.AntlrParser;

public class ParserTest {

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Mock
	Parser p1 = AntlrParser.getParser();
	@Mock
	Parser p2;
	
	
	@Test
	public void testGetParser() throws ParseCancellationException, IOException {
		p2 = AntlrParser.getParserForRightAnswer("Test");
		assertNotNull("Parser is null", p1); 
		assertNotNull("Parser of student's answer is null", p2);
	}
}
