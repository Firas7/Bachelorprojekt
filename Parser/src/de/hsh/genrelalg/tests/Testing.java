package de.hsh.genrelalg.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.junit.Test;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.errors.Discrepancy;
import de.hsh.genrelalg.errors.ErrorService;
import de.hsh.genrelalg.errors.Sequence;
import de.hsh.genrelalg.score.Calculator;
import de.hsh.genrelalg.score.DeductionReader;
import de.hsh.genrelalg.starter.AntlrParser;

public class Testing {

	// testen, ob Score unter Null geht.
	@Test
	public void testCalculator() {
		DeductionReader.getDeductions();
		ErrorService.getInstance();
		//Sequence sequence = new Sequence(new Attribute("Left"), new Attribute("Right"));
		Discrepancy dis1 = new Discrepancy(new Attribute("Test"));
		Discrepancy dis2 = new Discrepancy(new Attribute("Discrepancy"));
	//	ErrorService.addError(sequence);
		ErrorService.addError(dis1);
		ErrorService.addError(dis2);
		double score = Calculator.calculatePoints(ErrorService.getInstance(),1);
		assertTrue("Score ist kleiner Null",score >= 0);
		
	}
	
	@Test
	public void testPonitsDeductionsFile(){
		File file = new File("points.json");
		assertTrue("Points deductions file ist not found",file.exists());
	}
	
	@Test
	public void testAnswerOfStudentFile() {
		File file = new File("answerOfStudent");
		assertTrue("Answer of student is not found", file.exists());
	}

	
	@Test 
	public void testGetMinus() {
		DeductionReader.getDeductions();
		//Sequence sequence = new Sequence(new Attribute("Left"), new Attribute("Right"));
		//Discrepancy dis = new Discrepancy(new Attribute("Test"));
		//assertNotNull("Seqence Minus is Null", DeductionReader.getMinus(sequence));
		//assertNotNull("Discrepancy Minus is Null", DeductionReader.getMinus(dis));
	}
	
	@Test
	public void testGetParser() throws ParseCancellationException, IOException {
		assertNotNull("Parser is null", AntlrParser.getParser()); 
		assertNotNull("Parser of student's answer is null", AntlrParser.getParserForRightAnswer("Test"));
	}
	
	// feedback-Liste des Sequence-Fehlers darf nicht Null sein.
	@Test
	public void testGetFeedbackOfSequence() {
		//Sequence seq = new Sequence(new Attribute("Att left"), new Attribute("Att right"));
		//assertFalse("Feedback list is empty ",seq.getFeedbacks().isEmpty());
	}
	
	
	
}
