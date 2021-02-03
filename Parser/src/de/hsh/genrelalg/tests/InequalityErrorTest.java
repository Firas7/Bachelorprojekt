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
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.errors.Inequality;
import de.hsh.genrelalg.score.DeductionReader;

public class InequalityErrorTest {

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

		
	@Mock
	List<Attribute> left= new ArrayList<>();
	
	@Mock
	List<Attribute> right= new ArrayList<>();
	
	@Mock 
	Attribute att1 = new Attribute("att1");
	@Mock 
	Attribute att2 =  new Attribute("att2");
	@Mock 
	Attribute att3 = new Attribute("att3"); 
	@Mock 
	Attribute att4 = new Attribute("att4"); 
	@Mock 
	Attribute att5 = new Attribute("att5");
	
	@InjectMocks
	Inequality ineq = new Inequality(left, right);
	
	@Test
	public void testGetterOfInequality() {
		left.add(att1);
		left.add(att2);
		left.add(att3);
		right.add(att4);
		right.add(att5);
		assertEquals("Ungleichheit", ineq.getName());
		assertEquals("Medium", ineq.getDifficulty());
		assertEquals("Die Spaltenzahl stimmt nicht überein", ineq.getText());
		assertFalse("Extra Variable should be false",ineq.getExtra());
		assertFalse("Missing Variable should be false",ineq.getMissing());
		assertNotNull("Feedback should be not NULL", ineq.getFeedbacks());
	}
	
	@Test
	public void extraIsTrue(){
		left.add(att1);
		left.add(att2);
		left.add(att3);
		right.add(att4);
		right.add(att5);
		ineq.setExtra(true);
		ineq.checkAttributes(left, right);
		assertNotNull("Feedback should be not NULL", ineq.getFeedbacks());
	}

}
