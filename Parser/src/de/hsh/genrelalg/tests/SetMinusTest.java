package de.hsh.genrelalg.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.InjectMocks;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.database.DBFactory;
import de.hsh.genrelalg.relalg.SetMinus;

public class SetMinusTest {


	@InjectMocks
	Relation left1 = DBFactory.getRelationByName("ANGEST");
	
	@InjectMocks
	Relation left2 = DBFactory.getRelationByName("PROJEKT");
	
	@InjectMocks
	Relation right = DBFactory.getRelationByName("ANGESTELLTE");
	
	double x = 20;
	SetMinus minus1, minus2, minus3;
	
	@Test
	public void matchedTrue() {
		minus1 = new SetMinus(left1,right, x);
		assertNotNull(minus1.getResult());
		for(int i = 0; i < left1.getAttributes().size(); i++) {
			assertTrue(left1.getAttributes().get(i).getName().equals(right.getAttributes().get(i).getName()));
		}
	}
	
	@Test
	public void matchedFalse() {
		minus2 = new SetMinus(left1,right, x);
		assertNotNull(minus2.toText("Test", false));
		assertNotNull(minus2.getResult());
	}
	
	@Test
	public void testLeftNotEqualsRight() {
		minus3 = new SetMinus(left2,right, x);
		assertTrue(left2.getAttributes().size() != right.getAttributes().size());
		assertNotNull(minus3.getResult());
	}
	
}
