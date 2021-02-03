package de.hsh.genrelalg.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.database.DBFactory;
import de.hsh.genrelalg.expr.BooleanExpression;
import de.hsh.genrelalg.relalg.Join;

public class JoinTest{
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Mock
	BooleanExpression cond;
	
	@InjectMocks
	Relation left = DBFactory.getRelationByName("ANGEST");
	@InjectMocks
	Relation right = DBFactory.getRelationByName("ANGESTELLTE");
	
	double spread = 20;
	boolean leftOuter, rightOuter;
	
	Join jn;
	
	
	@Test
	public void test() {
		jn = new Join(left, right, cond, spread);
		assertNotNull(jn.getResult());
		assertTrue(left.getAttributes().get(0).getName().equals(right.getAttributes().get(0).getName()));
		assertTrue(left.getAttributes().get(1).getName().equals(right.getAttributes().get(1).getName()));
	}
	
	@Test
	public void testLeftJoin() {
		leftOuter = true;
		rightOuter = false;
		jn = new Join(left,right,cond,spread,leftOuter, rightOuter);
		assertNotNull(jn.getResult());
		assertTrue(left.getAttributes().get(0).getName().equals(right.getAttributes().get(0).getName()));
		assertTrue(left.getAttributes().get(1).getName().equals(right.getAttributes().get(1).getName()));
	}
	
	@Test
	public void testRightJoin() {
		leftOuter = false;
		rightOuter = true;
		jn = new Join(left,right,cond,spread,leftOuter, rightOuter);
		assertNotNull(jn.getResult());
		assertTrue(left.getAttributes().get(0).getName().equals(right.getAttributes().get(0).getName()));
		assertTrue(left.getAttributes().get(1).getName().equals(right.getAttributes().get(1).getName()));
	}
	
	@Test
	public void testFullJoin() {
		leftOuter = true;
		rightOuter = true;
		jn = new Join(left,right,cond,spread,leftOuter, rightOuter);
		assertNotNull(jn.getResult());
		assertTrue(left.getAttributes().get(0).getName().equals(right.getAttributes().get(0).getName()));
		assertTrue(left.getAttributes().get(1).getName().equals(right.getAttributes().get(1).getName()));
	}

}