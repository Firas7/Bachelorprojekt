package de.hsh.genrelalg.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import de.hsh.genrelalg.data.Predicate;
import de.hsh.genrelalg.expr.BooleanExpression;
import de.hsh.genrelalg.expr.ExprEquals;

public class PredicateTest {

	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	Predicate p = new Predicate("Left", "Expr" , "Right");
	
	@Mock
	BooleanExpression b;
	
	
	@Test
	public void testPredicate() {
		assertEquals("Left", p.getLeft());
		assertEquals("Right", p.getRight());
		assertEquals("Expr", p.getExpr());
		assertEquals("LeftExprRight", p.toText());
	}
	
	@Test
	public void testBooleanExpressionOfPredicate() {
		p.setBooleanexprisson(b);
		assertEquals(b, p.getBooleanExpression());
	}
	

}
