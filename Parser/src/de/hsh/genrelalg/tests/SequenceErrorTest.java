package de.hsh.genrelalg.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.errors.Sequence;

public class SequenceErrorTest {


	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@InjectMocks
	Sequence seq;
	
	@Mock
	Attribute att;
	
	@Test
	public void testSequence() {
		assertEquals("Reihenfolge", seq.getName());
		assertEquals("Abweichung der Reihenfolge", seq.getText());
		assertEquals("Medium", seq.getDifficulty());
		assertNotNull("List should not be null", seq.getFeedbacks());
	}
}
