package de.hsh.genrelalg.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.errors.Inequality;

public class InequalityErrorTest {

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@InjectMocks
	Inequality ineq;
	
	
	@Mock
	List<Attribute> left, right;
	
	@Mock 
	Attribute att1, att2, att3, att4, att5;
	
	@Test
	public void testInequality() {
		assertEquals("Ungleichheit", ineq.getName());
		assertEquals("Medium", ineq.getDifficulty());
		assertEquals("Die Spaltenzahl stimmt nicht überein", ineq.getText());
		assertFalse("Extra Variable should be false",ineq.getExtra());
		assertFalse("Missing Variable should be false",ineq.getMissing());
	}
	
	@Test
	public void testGetFeedbackInInequality() {
		left.add(att1);
		left.add(att2);
		left.add(att5);
		right.add(att3);
		right.add(att4);
		ineq.checkAttributes(left, right);
		ineq.setExtra(true);
		assertNotNull("Feedback should be not NULL", ineq.getFeedbacks());
	}
	

}
