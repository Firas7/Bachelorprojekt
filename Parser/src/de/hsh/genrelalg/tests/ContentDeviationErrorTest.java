package de.hsh.genrelalg.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.errors.ContentDeviation;

public class ContentDeviationErrorTest {

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Mock
	Relation r;
	
	boolean x = true;
	
	@InjectMocks
	ContentDeviation cont = new ContentDeviation(r, x);


	@Test
	public void testContent() {
		assertEquals("Inhalt", cont.getName());
		assertEquals("Medium", cont.getDifficulty());
		assertEquals("Abweichung des Inhaltes",cont.getText());
		assertNotNull("Feedback list should be not NULL", cont.getFeedbacks());
	}
	
	@Test
	public void xIsFalse() {
		cont = new ContentDeviation(r, false);
		assertEquals("Inhalt", cont.getName());
		assertEquals("Medium", cont.getDifficulty());
		assertEquals("Abweichung des Inhaltes",cont.getText());
		assertNotNull("Feedback list should be not NULL", cont.getFeedbacks());
	}
}
