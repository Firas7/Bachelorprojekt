package de.hsh.genrelalg.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.errors.Sequence;

public class FeedbackTest {

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@InjectMocks 
	Sequence seq;
	
	@Mock 
	Attribute att;
	
	@Test
	public void testGetFeedbackOfSequence() {
		assertFalse("Feedback list is empty ",seq.getFeedbacks().isEmpty());
		assertEquals(" Das Attribut 'null' steht an der falschen Stelle", seq.getFeedbacks().get(0).getText());
	}
}

