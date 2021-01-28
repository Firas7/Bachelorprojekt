package de.hsh.genrelalg.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Any;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;

public class RelationTest {

	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	String [] atts = {"Att1", "Att2", "Att3"}; 
	
	List<Attribute> attributes = new ArrayList<>();

	
	
	@Test
	public void testContructor1OfRelation() {
		Relation r = new Relation("Relation", atts);
		assertEquals("Relation", r.getName());
		assertEquals("Att1", r.getAttributes().get(0).getName());
		assertEquals("Att2", r.getAttributes().get(1).getName());
		assertEquals("Att3", r.getAttributes().get(2).getName());
		r.addAttribute(new Attribute("addNewAtt"));
		assertEquals("addNewAtt", r.getAttributes().get(3).getName());
	}
	
	@Test
	public void testRelation() {
		Relation r = new Relation("Test");
		assertEquals("Test", r.getName());
		assertNotNull(r.getResult());
	}
	
	@Test
	public void testConstructor2OfRelation() {
		Relation r = new Relation();
		assertEquals("RES", r.getName());
	}
	
	@Test
	public void testConstructor3OfRelation() {
		attributes.add(new Attribute("Test"));
		Relation r = new Relation(attributes);
		assertEquals("RES", r.getName());
	}
	
	@Test
	public void testContainAttributeMethodOfRelation() {
		Relation r = new Relation("Relation", atts);
		assertTrue(r.containsAttribute(new Attribute("Att1")));
		assertFalse(r.containsAttribute(new Attribute("name")));
	}
	
	@Test 
	public void testSetNameOfRelation() {
		Relation r = new Relation();
		r.setName("newName");
		assertEquals("newName", r.getName());
		
	}
	
	
}
