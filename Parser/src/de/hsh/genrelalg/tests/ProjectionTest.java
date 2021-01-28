package de.hsh.genrelalg.tests;



import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.tool.Attribute;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import de.hsh.genrelalg.relalg.Projection;
import de.hsh.genrelalg.relalg.RelationalAlgebra;

public class ProjectionTest {

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Mock
	RelationalAlgebra base;
	
	/*List<Attribute>  atts = new ArrayList<>();
	
	Projection proj = new Projection(base, atts);
	
	@Test
	public void testProjektion() {
		assertNull("Result of Projction should not be NULL", proj.getResult());
	}*/
	
	
}
