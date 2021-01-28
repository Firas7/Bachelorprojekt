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
	
	
	@InjectMocks
	Discrepancy dis;
	
	@Mock
	Attribute att;
	
	@Test
	public void testDiscrepancy() {
		att.setName("TestAttribut");
		assertEquals("Unstimmigkeit", dis.getName());
		assertEquals("Medium", dis.getDifficulty());
		assertEquals("Schemata stimmen nicht überein", dis.getText());
		assertNotNull("Feedback list should be not NULL", dis.getFeedbacks());
	}
}
