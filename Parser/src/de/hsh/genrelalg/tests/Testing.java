package de.hsh.genrelalg.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import de.hsh.genrelalg.comparison.Calculator;
import de.hsh.genrelalg.errors.ErrorService;

public class Testing {

	@Test
	public void testCalculator() {
		double point = Calculator.calculatePoints(ErrorService.getInstance(),0);
		if(point < 0) {
			fail("Not yet implemented");
		}else {
			
		}
		
	}

}
