package de.hsh.genrelalg.tests;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.database.DBFactory;
import de.hsh.genrelalg.relalg.Projection;

public class ProjectionTest {

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@InjectMocks
	Relation base = DBFactory.getRelationByName("ANGEST");
	
	Attribute [] atts = new Attribute [2];
	
	Projection proj1, proj2;
	
	@Test
	public void test() {
		atts[0] = new Attribute("ANGNR");
		atts[1] = new Attribute("GEHALT");
		proj2 = new Projection(base, atts);
		assertNotNull(proj2.getResult());
		assertEquals("ANGNR", proj2.getResult().getAttributes().get(0).getName());
		assertEquals("GEHALT", proj2.getResult().getAttributes().get(1).getName());
		assertEquals(2, proj2.getResult().getAttributes().size());
	}
	
	@Test
	public void testProjektion() {
		atts[0] = new Attribute("att1");
		atts[1] = new Attribute("att2");
		proj1 = new Projection(base, atts);
		
		assertNotNull(proj1.getResult());
	}
	
	
	
	
}
