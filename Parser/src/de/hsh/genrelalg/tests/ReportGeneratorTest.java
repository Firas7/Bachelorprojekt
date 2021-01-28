package de.hsh.genrelalg.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.errors.Discrepancy;
import de.hsh.genrelalg.errors.ErrorService;
import de.hsh.genrelalg.errors.Sequence;
import de.hsh.genrelalg.feedback.Feedback;
import de.hsh.genrelalg.relalg.RelationalAlgebra;
import de.hsh.genrelalg.report.ReportGenerator;

public class ReportGeneratorTest {

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Mock
	Relation r;
	
	
	@Mock
	ErrorService errors = ErrorService.getInstance();
	
	@Mock
	Sequence seq;
	
	@Mock
	Discrepancy dis;
	
	@Mock
	Attribute att;
	
	@Mock
	Feedback fed;
	
	
	double score = 9.5;
	
	ReportGenerator gen = new ReportGenerator(r,errors,score);
	
	@Test
	public void testprintErrorsAndScore() {
		ErrorService.addError(dis);
		ErrorService.addError(seq);
		assertFalse(r == null );
		gen.printErrorsAndScore();
	}
	
	@Test
	public void testprintFeedbacks() {
		seq = new Sequence(att);
		dis = new Discrepancy(att);
		seq.addFeedback(fed);
		seq.addFeedback(fed);
		gen.printFeedbacks();
	}
	
	@Test
	public void testPrintFinaleResult() {
		r = new Relation();
		gen.printFinaleResult();
	}

	@Test
	public void testConstructor() {
		gen = new ReportGenerator(errors, 5.0);
		assertTrue(r.getTuples().size() == 0 && errors.getMistakes().size() == 0);
		assertFalse(r == null);
	}
}
