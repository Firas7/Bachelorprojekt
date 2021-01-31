package de.hsh.genrelalg.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.errors.Discrepancy;

public class DiscrapancyErrorTest {

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Mock
	Attribute att= new Attribute("Test");
	
	@InjectMocks
	Discrepancy dis = new Discrepancy(att);
	
	@Test
	public void testDiscrepancy() {
		assertEquals("Unstimmigkeit", dis.getName());
		assertEquals("Medium", dis.getDifficulty());
		assertEquals("Schemata stimmen nicht überein", dis.getText());
		assertNotNull("Feedbacks list should not be NULL", dis.getFeedbacks());
	}
}
