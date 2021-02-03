package de.hsh.genrelalg.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.relalg.Union;

public class UnionTest {

	
	
	Relation left= new Relation();
	Relation right = new Relation();
	
	Union un = new Union(left, right);
	
	@Test
	public void testMatchedIsTrue() {
		assertTrue(un.getMatched());
		assertNotNull(un.toText("Test", true));
		assertNotNull(un.getResult());
	}
	
	@Test
	public void MatchedIsFalse() {
		un.setMatched(false);
		assertNotNull(un.toText("Test", true));
		assertNotNull(un.getResult());
	}
	
	@Test
	public void testLeftGreaterRight() {
		left.addAttribute(new Attribute("att1OfLeftRelation"));
		left.addAttribute(new Attribute("att2OfLeftRelation"));
		right.addAttribute(new Attribute("att1OfRightRelation"));
		assertNotNull(un.getResult());
	}
	
	@Test
	public void testLeftEqualsRight1() {
		left.addAttribute(new Attribute("att1OfLeftRelation"));
		left.addAttribute(new Attribute("att2OfLeftRelation"));
		right.addAttribute(new Attribute("att1OfRightRelation"));
		right.addAttribute(new Attribute("att2OfRightRelation"));
		assertFalse(left.getClass() != right.getClass());
		assertNotNull(un.getResult());
	}
	
}
