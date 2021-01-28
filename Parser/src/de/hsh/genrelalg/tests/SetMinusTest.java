package de.hsh.genrelalg.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.relalg.SetMinus;

public class SetMinusTest {


	Relation left = new Relation();
	Relation right = new Relation();
	double x = 20;
	
	SetMinus minus = new SetMinus(left,right, x);
	
	
	@Test
	public void testMatchedTrue() {
		assertNotNull(minus.getResult());
		assertNotNull(minus.toText("Test", true));
	}
	
	@Test
	public void testMatchedFalse() {
		minus.setMatched(false);
		assertNotNull(minus.toText("Test", true));
		assertNotNull(minus.getResult());
	}
	
	@Test
	public void testLeftEqualsRight() {
		left.addAttribute(new Attribute("att1OfLeftRelation"));
		left.addAttribute(new Attribute("att2OfLeftRelation"));
		right.addAttribute(new Attribute("att1OfRightRelation"));
		assertNotNull(minus.getResult());
	}
	
}
