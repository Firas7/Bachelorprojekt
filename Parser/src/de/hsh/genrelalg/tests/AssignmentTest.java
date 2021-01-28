package de.hsh.genrelalg.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import de.hsh.genrelalg.data.Assignment;
import de.hsh.genrelalg.database.Database;

public class AssignmentTest {

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Mock
	Database base;
	
	
	Assignment assignment = new Assignment("Test1", base, "Answer1", 3.0);
	
	@Test
	public void testAssignment() {
		assertEquals("Test1", assignment.getText());
		assertEquals("Answer1", assignment.getAnswer());
		assertEquals(3.0, assignment.getScore(), 0.0);
	}
	
	@Test
	public void testSetMethods() {
		assignment.setAnswer("Answer2");
		assignment.setScore(5.1);
		assignment.setText("Test2");
		assertEquals("Test2", assignment.getText());
		assertEquals("Answer2", assignment.getAnswer());
		assertEquals(5.1, assignment.getScore(), 0.0);
	}
}
