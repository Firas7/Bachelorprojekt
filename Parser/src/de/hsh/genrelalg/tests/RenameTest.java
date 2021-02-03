package de.hsh.genrelalg.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mockito.InjectMocks;

import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.database.DBFactory;
import de.hsh.genrelalg.relalg.Rename;

public class RenameTest {

	
	@InjectMocks
	Relation relation = DBFactory.getRelationByName("ANGEST");
	
	String newName = "Test";
	Rename rename;
	
	@Test
	public void testRename() {
		rename = new Rename(relation, newName);
		assertNotNull(rename.getResult());
		assertEquals(newName, rename.getResult().getName());
		assertEquals(rename.getResult().getAttributes().get(0).getName(), relation.getAttributes().get(0).getName());
		assertEquals(rename.getResult().getAttributes().get(1).getName(), relation.getAttributes().get(1).getName());
		assertEquals(rename.getResult().getAttributes().get(2).getName(), relation.getAttributes().get(2).getName());
		assertEquals(rename.getResult().getAttributes().get(3).getName(), relation.getAttributes().get(3).getName());
		assertEquals(rename.getResult().getAttributes().size(), relation.getAttributes().size());
	}
}
