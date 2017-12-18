package org.aptlist.friday;

import org.junit.Assert;
import org.junit.Test;

public class TableTest {

	@Test
	public void testAddGuest() {
		int tableSize = 3;
		Table testTable = new Table(tableSize);
		String name = "member";
		testTable.addGuest(name);

		Assert.assertTrue(!testTable.isFull());
		Assert.assertTrue(testTable.getNames().contains(name));
	}

	@Test
	public void testIsFull() {
		int tableSize = 2;
		Table testTable = new Table(tableSize);
		String member1 = "member1";
		String member2 = "member2";

		testTable.addGuest(member1);
		testTable.addGuest(member2);

		Assert.assertTrue(testTable.isFull());
	}

	@Test
	public void testAddGuestWhenFull() {
		int tableSize = 2;
		Table testTable = new Table(tableSize);
		String member1 = "member1";
		String member2 = "member2";

		testTable.addGuest(member1);
		testTable.addGuest(member2);

		Assert.assertFalse(testTable.addGuest(member2));
	}

}
