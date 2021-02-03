package de.hsh.genrelalg.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.relalg.Intersection;

public class IntersectionTest {

	Relation left= new Relation();
	Relation right = new Relation();
	
	Intersection inter = new Intersection(left, right);
	
	@Test
	public void testGetResult() {
		assertNotNull(inter.getResult());
		assertNotNull(inter.toText("Test", true));
	}
	
	@Test
	public void testMatchedIsFalse() {
		inter.setMatched(false);
		assertNotNull(inter.toText("Test", true));
		assertNotNull(inter.getResult());
	}
	
	@Test
	public void testLeftGreaterRight() {
		left.addAttribute(new Attribute("att1OfLeftRelation"));
		left.addAttribute(new Attribute("att2OfLeftRelation"));
		right.addAttribute(new Attribute("att1OfRightRelation"));
		assertNotNull(inter.getResult());
	}
}
