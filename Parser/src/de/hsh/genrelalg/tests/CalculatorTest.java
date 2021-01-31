package de.hsh.genrelalg.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import de.hsh.genrelalg.errors.Discrepancy;
import de.hsh.genrelalg.errors.ErrorService;
import de.hsh.genrelalg.errors.Sequence;
import de.hsh.genrelalg.score.Calculator;
import de.hsh.genrelalg.score.DeductionReader;

public class CalculatorTest {

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Mock
	Sequence mockedSequence1, mockedSequence2 ; 
	
	@Mock
	Discrepancy mockedDiscrenpancy1, mockedDiscrenpancy2 ;
	
	@Mock
	ErrorService errors;
	
	@Mock
	DeductionReader reder;
	
	@Test
	public void testCalculator() {
		DeductionReader.getDeductions();
		ErrorService.getInstance();
		ErrorService.addError(mockedSequence1);
		ErrorService.addError(mockedSequence2);
		ErrorService.addError(mockedDiscrenpancy1);
		ErrorService.addError(mockedDiscrenpancy2);
		double score = Calculator.calculatePoints(ErrorService.getInstance(),1);
		assertFalse("The score is not equal to the entered value", score != 1);
		assertTrue("The score must be greater than or equal to zero",score >= 0);
	}
	
	@Test
	public void noErrorsInErrorService() {
		DeductionReader.getDeductions();
		ErrorService.getInstance();
		double score = Calculator.calculatePoints(ErrorService.getInstance(),1);
		assertTrue(errors.getMistakes().size() == 0);
		assertTrue(score == 1);
	}
	
	@Test
	public void pointIsLessThenZero() {
		DeductionReader.getDeductions();
		ErrorService.getInstance();
		ErrorService.addError(mockedSequence1);
		ErrorService.addError(mockedSequence2);
		ErrorService.addError(mockedDiscrenpancy1);
		ErrorService.addError(mockedDiscrenpancy2);
		double score = Calculator.calculatePoints(ErrorService.getInstance(),-5);
		assertTrue(errors.getMistakes().size() == 0);
		assertTrue(score == 0);
	}
}
