package de.hsh.genrelalg.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import de.hsh.genrelalg.database.DBFactory;
import de.hsh.genrelalg.database.Database;

public class DBTest {

	Database db = new Database();

	@Test
	public void testRelations() {
		assertNotNull("there is no Relations in the DB", db.getRelations());
		assertTrue("Relation List size is 0", db.getRelations().size() != 0);
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
