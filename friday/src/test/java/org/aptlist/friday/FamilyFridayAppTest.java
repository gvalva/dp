package org.aptlist.friday;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class FamilyFridayAppTest {

	@Test
	public void testWith15Guests() {
		String fileName = "src/test/resources/names_15.txt";
		FamilyFridayApp app = new FamilyFridayApp();
		try {
			app.run(fileName);
		} catch (Exception e) {
			Assert.fail("Test should not fail");
		}

		// verify total names are equal to total of all guests for each table
		List<String> guestList = app.getFamilyList();
		List<Table> tableList = app.getTableList();

		int expectedGuestTotal = guestList.size();
		int actualGuestTotal = sumGuestsFromTables(tableList);

		Set<String> expectedNames = guestList.stream().collect(Collectors.toSet());
		Set<String> actualGuestNames = getGuestsFromTable(tableList);

		Assert.assertTrue(expectedGuestTotal == actualGuestTotal);
		Assert.assertTrue(expectedNames.equals(actualGuestNames));
	}

	@Test
	public void testWith14Guests() {
		String fileName = "src/test/resources/names_14.txt";
		FamilyFridayApp app = new FamilyFridayApp();
		try {
			app.run(fileName);
		} catch (Exception e) {
			Assert.fail("Test should not fail");
		}

		// verify total names are equal to total of all guests for each table
		List<String> guestList = app.getFamilyList();
		List<Table> tableList = app.getTableList();

		int expectedGuestTotal = guestList.size();
		int actualGuestTotal = sumGuestsFromTables(tableList);

		Set<String> expectedNames = guestList.stream().collect(Collectors.toSet());
		Set<String> actualGuestNames = getGuestsFromTable(tableList);

		Assert.assertTrue(expectedGuestTotal == actualGuestTotal);
		Assert.assertTrue(expectedNames.equals(actualGuestNames));
	}

	@Test
	public void testWith13Guests() {
		String fileName = "src/test/resources/names_13.txt";
		FamilyFridayApp app = new FamilyFridayApp();
		try {
			app.run(fileName);
		} catch (Exception e) {
			Assert.fail("Test should not fail");
		}

		// verify total names are equal to total of all guests for each table
		List<String> guestList = app.getFamilyList();
		List<Table> tableList = app.getTableList();

		int expectedGuestTotal = guestList.size();
		int actualGuestTotal = sumGuestsFromTables(tableList);

		Set<String> expectedNames = guestList.stream().collect(Collectors.toSet());
		Set<String> actualGuestNames = getGuestsFromTable(tableList);

		Assert.assertTrue(expectedGuestTotal == actualGuestTotal);
		Assert.assertTrue(expectedNames.equals(actualGuestNames));
	}

	@Test
	public void testWith12Guests() {
		String fileName = "src/test/resources/names_12.txt";
		FamilyFridayApp app = new FamilyFridayApp();
		try {
			app.run(fileName);
		} catch (Exception e) {
			Assert.fail("Test should not fail");
		}

		// verify total names are equal to total of all guests for each table
		List<String> guestList = app.getFamilyList();
		List<Table> tableList = app.getTableList();

		int expectedGuestTotal = guestList.size();
		int actualGuestTotal = sumGuestsFromTables(tableList);

		Set<String> expectedNames = guestList.stream().collect(Collectors.toSet());
		Set<String> actualGuestNames = getGuestsFromTable(tableList);

		Assert.assertTrue(expectedGuestTotal == actualGuestTotal);
		Assert.assertTrue(expectedNames.equals(actualGuestNames));
	}

	private int sumGuestsFromTables(List<Table> tableList) {
		return tableList.stream() //
				.map(table -> table.getNames()) //
				.mapToInt(nameList -> nameList.size()) //
				.reduce(0, (a, b) -> a + b);

	}

	private Set<String> getGuestsFromTable(List<Table> tableList) {
		return tableList.stream() //
				.map(Table::getNames) //
				.flatMap(List::stream) //
				.collect(Collectors.toSet());
	}
}
