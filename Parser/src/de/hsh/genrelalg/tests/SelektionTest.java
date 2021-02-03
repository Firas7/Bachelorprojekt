package de.hsh.genrelalg.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.expr.BooleanExpression;
import de.hsh.genrelalg.relalg.RelationalAlgebra;
import de.hsh.genrelalg.relalg.Selection;

public class SelektionTest {

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Mock
	BooleanExpression expr;
	RelationalAlgebra base= new Relation();
	
	Selection select;
	
	@Test
	public void testSelection() {
		select = new Selection(base, expr);
		assertNotNull(select.getResult());
		assertNotNull(select.toText("Test", true));
	}
	
	
}
