package de.hsh.genrelalg.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import de.hsh.genrelalg.database.DBFactory;
import de.hsh.genrelalg.database.Database;

public class DBTest {

	@Before
	public void setUp() throws Exception {
		 MockitoAnnotations.initMocks(this);
	 }
	 
	@Mock
	Database mockedDB;

	@Test
	public void testRelations() {
		assertNotNull("there is no DB Relations ", mockedDB.getRelations());
	}
	
	@Test
	public void testDBFactory() {
		assertNotNull("there is no DB Relations ", DBFactory.getRelationByName("ANGEST"));
		assertNotNull("there is no DB Relations ", DBFactory.getRelationByName("PROJEKT"));
		assertNotNull("there is no DB Relations ", DBFactory.getRelationByName("ANG_PRO"));
		assertNotNull("there is no DB Relations ", DBFactory.getRelationByName("ANGESTELLTE"));
		assertNull("there is no DB Relations ", DBFactory.getRelationByName("NOTFOUND"));
	}
}
