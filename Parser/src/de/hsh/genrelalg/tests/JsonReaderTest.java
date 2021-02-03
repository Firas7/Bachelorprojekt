package de.hsh.genrelalg.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import de.hsh.genrelalg.errors.ContentDeviation;
import de.hsh.genrelalg.errors.Discrepancy;
import de.hsh.genrelalg.errors.Inequality;
import de.hsh.genrelalg.errors.Mistake;
import de.hsh.genrelalg.errors.Sequence;
import de.hsh.genrelalg.score.DeductionReader;

public class JsonReaderTest {

	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Mock
	Sequence seq;
	
	@Mock
	Discrepancy dis;
	
	@Mock 
	ContentDeviation cont;
	
	@Mock
	Inequality ineq;
	
	@Mock
	Mistake mis;
	
	
	@Test 
	public void testGetMinus() {
		DeductionReader.getDeductions();
		assertNotNull("Seqence Minus is Null", DeductionReader.getMinus(seq));
		assertNotNull("Discrepancy Minus is Null", DeductionReader.getMinus(dis));
		assertNotNull("Discrepancy Minus is Null", DeductionReader.getMinus(cont));
		assertNotNull("Discrepancy Minus is Null", DeductionReader.getMinus(ineq));
		assertTrue("",DeductionReader.getMinus(mis) == 0);
	}
	
	
	

	
	
	
}
