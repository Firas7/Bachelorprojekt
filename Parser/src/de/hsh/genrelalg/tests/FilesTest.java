package de.hsh.genrelalg.tests;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

public class FilesTest {

	
	
	@Test
	public void testPonitsDeductionsFile(){
		File file = new File("points.json");
		assertTrue("Points deductions file is not found",file.exists());
	}
	
	@Test
	public void testAnswerOfStudentFile() {
		File file = new File("answerOfStudent");
		assertTrue("Answer of student is not found", file.exists());
	}
}
