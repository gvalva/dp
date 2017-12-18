package org.aptlist.friday;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;

public class FamilyFridayApp {

	private final static int MAX_GROUP_SIZE = 5;
	private final static int MIN_GROUP_SIZE = 3;
	private final static int[] TABLE_SIZE_ARRAY = new int[] { MIN_GROUP_SIZE, MAX_GROUP_SIZE };
	private List<Table> tableList; // used for testing
	private List<String> familyList; // used for testing

	public static void main(String[] args) {

		String fileName = "src/main/resources/names.txt";
		FamilyFridayApp app = new FamilyFridayApp();
		try {
			app.run(fileName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	protected void run(String fileName) throws Exception {

		familyList = FileUtils.readLines(new File(fileName), Charset.defaultCharset());
		int total = familyList.size();

		SeatRandomizer randomizer = new SeatRandomizer();

		// create table instances for each table size
		tableList = randomizer.createTables(total, TABLE_SIZE_ARRAY);

		final int totalTables = tableList.size();
		final Random randomUtil = new Random();

		// assign each member to a random table
		// if the table is full reassign to a new random table
		familyList.stream().forEach(member -> {
			int tableNumber = randomUtil.nextInt(totalTables);

			Table randomTable = tableList.get(tableNumber);
			while (randomTable.isFull()) {
				tableNumber = randomUtil.nextInt(totalTables);
				randomTable = tableList.get(tableNumber);
			}
			randomTable.addGuest(member);

		});

		// print out the table list with assigned family members
		tableList.stream().forEach(table -> {
			System.out.println(table);
		});
	}

	public List<Table> getTableList() {
		return tableList;
	}

	public List<String> getFamilyList() {
		return familyList;
	}
}
