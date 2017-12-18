package org.aptlist.friday;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class SeatRandomizerTest {

	private static final int TABLE_SIZE_5 = 5;
	private static final int TABLE_SIZE_3 = 3;
	private static final int[] TABLE_SIZES = new int[] { TABLE_SIZE_3, TABLE_SIZE_5 };

	@Test
	public void testCreateTables() {
		SeatRandomizer randomizer = new SeatRandomizer();
		List<Table> actualTableList = null;
		int total = 15;
		try {
			actualTableList = randomizer.createTables(total, TABLE_SIZES);
		} catch (Exception e) {
			Assert.fail("create table should not throw exception");
		}

		// key represents the table size,
		// the value represents the number of tables of size
		Map<Integer, Integer> expectedTables = new HashMap<>();

		int expectedTablesOf3 = 0;
		int expectedTablesOf5 = 3;

		expectedTables.put(TABLE_SIZE_5, expectedTablesOf5);
		expectedTables.put(TABLE_SIZE_3, expectedTablesOf3);

		actualTableList.stream().forEach(table -> {
			int tableSize = table.getSize();
			int tableCount = expectedTables.get(tableSize);
			expectedTables.put(tableSize, --tableCount);
		});

		Assert.assertTrue(0 == expectedTables.get(TABLE_SIZE_5));
		Assert.assertTrue(0 == expectedTables.get(TABLE_SIZE_3));
	}

	@Test
	public void testReturnSumResultMatrixWith1Guests() {
		int[] expected = new int[] { -1, -1 };

		SeatRandomizer randomizer = new SeatRandomizer();
		int total = 1;
		int[] actual = randomizer.returnResultArray(total, TABLE_SIZES);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testReturnSumResultMatrixWith2Guests() {
		int[] expected = new int[] { -1, -1, -1 };

		SeatRandomizer randomizer = new SeatRandomizer();
		int total = 2;
		int[] actual = randomizer.returnResultArray(total, TABLE_SIZES);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testReturnSumResultMatrixWith3Guests() {
		int[] expected = new int[] { -1, -1, -1, 3 };

		SeatRandomizer randomizer = new SeatRandomizer();
		int total = 3;
		int[] actual = randomizer.returnResultArray(total, TABLE_SIZES);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testReturnSumResultMatrixWith5Guests() {
		int[] expected = new int[] { -1, -1, -1, 3, -1, 5 };

		SeatRandomizer randomizer = new SeatRandomizer();
		int total = 5;
		int[] actual = randomizer.returnResultArray(total, TABLE_SIZES);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testReturnSumResultMatrixWith6Guests() {
		int[] expected = new int[] { -1, -1, -1, 3, -1, 5, 3 };

		SeatRandomizer randomizer = new SeatRandomizer();
		int total = 6;
		int[] actual = randomizer.returnResultArray(total, TABLE_SIZES);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testReturnSumResultMatrixWith8Guests() {
		int[] expected = new int[] { -1, -1, -1, 3, -1, 5, 3, -1, 5 };

		SeatRandomizer randomizer = new SeatRandomizer();
		int total = 8;
		int[] actual = randomizer.returnResultArray(total, TABLE_SIZES);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testReturnSumResultMatrixWith9Guests() {
		int[] expected = new int[] { -1, -1, -1, 3, -1, 5, 3, -1, 5, 3 };

		SeatRandomizer randomizer = new SeatRandomizer();
		int total = 9;
		int[] actual = randomizer.returnResultArray(total, TABLE_SIZES);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testReturnSumResultMatrixWith10Guests() {
		int[] expected = new int[] { -1, -1, -1, 3, -1, 5, 3, -1, 5, 3, 5 };

		SeatRandomizer randomizer = new SeatRandomizer();
		int total = 10;
		int[] actual = randomizer.returnResultArray(total, TABLE_SIZES);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testReturnSumResultMatrixWith11Guests() {
		int[] expected = new int[] { -1, -1, -1, 3, -1, 5, 3, -1, 5, 3, 5, 5 };

		SeatRandomizer randomizer = new SeatRandomizer();
		int total = 11;
		int[] actual = randomizer.returnResultArray(total, TABLE_SIZES);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testReturnSumResultMatrixWith12Guests() {
		int[] expected = new int[] { -1, -1, -1, 3, -1, 5, 3, -1, 5, 3, 5, 5, 3 };

		SeatRandomizer randomizer = new SeatRandomizer();
		int total = 12;
		int[] actual = randomizer.returnResultArray(total, TABLE_SIZES);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testReturnSumResultMatrixWith13Guests() {
		int[] expected = new int[] { -1, -1, -1, 3, -1, 5, 3, -1, 5, 3, 5, 5, 3, 5 };

		SeatRandomizer randomizer = new SeatRandomizer();
		int total = 13;
		int[] actual = randomizer.returnResultArray(total, TABLE_SIZES);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testReturnSumResultMatrixWith14Guests() {
		int[] expected = new int[] { -1, -1, -1, 3, -1, 5, 3, -1, 5, 3, 5, 5, 3, 5, 5 };

		SeatRandomizer randomizer = new SeatRandomizer();
		int total = 14;
		int[] actual = randomizer.returnResultArray(total, TABLE_SIZES);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testReturnSumResultMatrixWith15Guests() {
		int[] expected = new int[] { -1, -1, -1, 3, -1, 5, 3, -1, 5, 3, 5, 5, 3, 5, 5, 5 };

		SeatRandomizer randomizer = new SeatRandomizer();
		int total = 15;
		int[] actual = randomizer.returnResultArray(total, TABLE_SIZES);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testCreateTablesWith15Guests() {
		int[] R = new int[] { -1, -1, -1, 3, -1, 5, 3, -1, 5, 3, 5, 5, 3, 5, 5, 5 };

		SeatRandomizer randomizer = new SeatRandomizer();
		List<Table> actualTableList = null;
		try {
			actualTableList = randomizer.createTables(R);
		} catch (Exception e) {
			Assert.fail("create table should not throw exception");
		}

		// key represents the table size,
		// the value represents the number of tables of size
		Map<Integer, Integer> expectedTables = new HashMap<>();

		int expectedTablesOf3 = 0;
		int expectedTablesOf5 = 3;

		expectedTables.put(TABLE_SIZE_5, expectedTablesOf5);
		expectedTables.put(TABLE_SIZE_3, expectedTablesOf3);

		actualTableList.stream().forEach(table -> {
			int tableSize = table.getSize();
			int tableCount = expectedTables.get(tableSize);
			expectedTables.put(tableSize, --tableCount);
		});

		Assert.assertTrue(0 == expectedTables.get(TABLE_SIZE_5));
		Assert.assertTrue(0 == expectedTables.get(TABLE_SIZE_3));
	}

	@Test
	public void testCreateTablesWith14Guests() {
		int[] R = new int[] { -1, -1, -1, 3, -1, 5, 3, -1, 5, 3, 5, 5, 3, 5, 5 };
		SeatRandomizer randomizer = new SeatRandomizer();
		List<Table> actualTableList = null;
		try {
			actualTableList = randomizer.createTables(R);
		} catch (Exception e) {
			Assert.fail("create table should not throw exception");
		}

		Map<Integer, Integer> expectedTables = new HashMap<>();

		int expectedTablesOf3 = 3;
		int expectedTablesOf5 = 1;

		expectedTables.put(TABLE_SIZE_3, expectedTablesOf3);
		expectedTables.put(TABLE_SIZE_5, expectedTablesOf5);

		actualTableList.stream().forEach(table -> {
			int tableSize = table.getSize();
			int tableCount = expectedTables.get(tableSize);
			expectedTables.put(tableSize, --tableCount);
		});

		Assert.assertTrue(0 == expectedTables.get(TABLE_SIZE_5));
		Assert.assertTrue(0 == expectedTables.get(TABLE_SIZE_3));
	}

	@Test
	public void testCreateTablesWith13Guests() {
		int[] R = new int[] { -1, -1, -1, 3, -1, 5, 3, -1, 5, 3, 5, 5, 3, 5 };
		SeatRandomizer randomizer = new SeatRandomizer();
		List<Table> actualTableList = null;

		try {
			actualTableList = randomizer.createTables(R);
		} catch (Exception e) {
			Assert.fail("create table should not throw exception");
		}

		Map<Integer, Integer> expectedTables = new HashMap<>();

		int expectedTablesOf3 = 1;
		int expectedTablesOf5 = 2;

		expectedTables.put(TABLE_SIZE_3, expectedTablesOf3);
		expectedTables.put(TABLE_SIZE_5, expectedTablesOf5);

		actualTableList.stream().forEach(table -> {
			int tableSize = table.getSize();
			int tableCount = expectedTables.get(tableSize);
			expectedTables.put(tableSize, --tableCount);
		});

		Assert.assertTrue(0 == expectedTables.get(TABLE_SIZE_5));
		Assert.assertTrue(0 == expectedTables.get(TABLE_SIZE_3));
	}

	@Test
	public void testCreateTablesWith12Guests() {
		int[] R = new int[] { -1, -1, -1, 3, -1, 5, 3, -1, 5, 3, 5, 5, 3 };
		SeatRandomizer randomizer = new SeatRandomizer();
		List<Table> actualTableList = null;
		try {
			actualTableList = randomizer.createTables(R);
		} catch (Exception e) {
			Assert.fail("create table should not throw exception");
		}

		Map<Integer, Integer> expectedTables = new HashMap<>();

		int expectedTablesOf3 = 4;
		int expectedTablesOf5 = 0;

		expectedTables.put(TABLE_SIZE_3, expectedTablesOf3);
		expectedTables.put(TABLE_SIZE_5, expectedTablesOf5);

		actualTableList.stream().forEach(table -> {
			int tableSize = table.getSize();
			int tableCount = expectedTables.get(tableSize);
			expectedTables.put(tableSize, --tableCount);
		});

		Assert.assertTrue(0 == expectedTables.get(TABLE_SIZE_5));
		Assert.assertTrue(0 == expectedTables.get(TABLE_SIZE_3));
	}

	@Test
	public void testCreateTablesWith11Guests() {
		int[] R = new int[] { -1, -1, -1, 3, -1, 5, 3, -1, 5, 3, 5, 5 };
		SeatRandomizer randomizer = new SeatRandomizer();

		List<Table> actualTableList = null;
		try {
			actualTableList = randomizer.createTables(R);
		} catch (Exception e) {
			Assert.fail("create table should not throw exception");
		}

		Map<Integer, Integer> expectedTables = new HashMap<>();

		int expectedTablesOf3 = 2;
		int expectedTablesOf5 = 1;

		expectedTables.put(TABLE_SIZE_3, expectedTablesOf3);
		expectedTables.put(TABLE_SIZE_5, expectedTablesOf5);

		actualTableList.stream().forEach(table -> {
			int tableSize = table.getSize();
			int tableCount = expectedTables.get(tableSize);
			expectedTables.put(tableSize, --tableCount);
		});

		Assert.assertTrue(0 == expectedTables.get(TABLE_SIZE_5));
		Assert.assertTrue(0 == expectedTables.get(TABLE_SIZE_3));
	}

	@Test
	public void testCreateTablesWith10Guests() {
		int[] R = new int[] { -1, -1, -1, 3, -1, 5, 3, -1, 5, 3, 5 };
		SeatRandomizer randomizer = new SeatRandomizer();

		List<Table> actualTableList = null;
		try {
			actualTableList = randomizer.createTables(R);
		} catch (Exception e) {
			Assert.fail("create table should not throw exception");
		}

		Map<Integer, Integer> expectedTables = new HashMap<>();

		int expectedTablesOf3 = 0;
		int expectedTablesOf5 = 2;

		expectedTables.put(TABLE_SIZE_3, expectedTablesOf3);
		expectedTables.put(TABLE_SIZE_5, expectedTablesOf5);

		actualTableList.stream().forEach(table -> {
			int tableSize = table.getSize();
			int tableCount = expectedTables.get(tableSize);
			expectedTables.put(tableSize, --tableCount);
		});

		Assert.assertTrue(0 == expectedTables.get(TABLE_SIZE_5));
		Assert.assertTrue(0 == expectedTables.get(TABLE_SIZE_3));
	}

	@Test
	public void testCreateTablesWith9Guests() {
		int[] R = new int[] { -1, -1, -1, 3, -1, 5, 3, -1, 5, 3 };
		SeatRandomizer randomizer = new SeatRandomizer();

		List<Table> actualTableList = null;
		try {
			actualTableList = randomizer.createTables(R);
		} catch (Exception e) {
			Assert.fail("create table should not throw exception");
		}

		Map<Integer, Integer> expectedTables = new HashMap<>();

		int expectedTablesOf3 = 3;
		int expectedTablesOf5 = 0;

		expectedTables.put(TABLE_SIZE_3, expectedTablesOf3);
		expectedTables.put(TABLE_SIZE_5, expectedTablesOf5);

		actualTableList.stream().forEach(table -> {
			int tableSize = table.getSize();
			int tableCount = expectedTables.get(tableSize);
			expectedTables.put(tableSize, --tableCount);
		});

		Assert.assertTrue(0 == expectedTables.get(TABLE_SIZE_5));
		Assert.assertTrue(0 == expectedTables.get(TABLE_SIZE_3));
	}

	@Test
	public void testCreateTablesWith8Guests() {
		int[] R = new int[] { -1, -1, -1, 3, -1, 5, 3, -1, 5 };
		SeatRandomizer randomizer = new SeatRandomizer();

		List<Table> actualTableList = null;
		try {
			actualTableList = randomizer.createTables(R);
		} catch (Exception e) {
			Assert.fail("create table should not throw exception");
		}

		Map<Integer, Integer> expectedTables = new HashMap<>();

		int expectedTablesOf3 = 1;
		int expectedTablesOf5 = 1;

		expectedTables.put(TABLE_SIZE_3, expectedTablesOf3);
		expectedTables.put(TABLE_SIZE_5, expectedTablesOf5);

		actualTableList.stream().forEach(table -> {
			int tableSize = table.getSize();
			int tableCount = expectedTables.get(tableSize);
			expectedTables.put(tableSize, --tableCount);
		});

		Assert.assertTrue(0 == expectedTables.get(TABLE_SIZE_5));
		Assert.assertTrue(0 == expectedTables.get(TABLE_SIZE_3));
	}

	@Test(expected = Exception.class)
	public void testCreateTablesWith7Guests() throws Exception {
		int[] R = new int[] { -1, -1, -1, 3, -1, 5, 3, -1 };
		SeatRandomizer randomizer = new SeatRandomizer();
		randomizer.createTables(R);

	}

	@Test
	public void testCreateTablesWith6Guests() {
		int[] R = new int[] { -1, -1, -1, 3, -1, 5, 3 };
		SeatRandomizer randomizer = new SeatRandomizer();

		List<Table> actualTableList = null;
		try {
			actualTableList = randomizer.createTables(R);
		} catch (Exception e) {
			Assert.fail("create table should not throw exception");
		}

		Map<Integer, Integer> expectedTables = new HashMap<>();

		int expectedTablesOf3 = 2;
		int expectedTablesOf5 = 0;

		expectedTables.put(TABLE_SIZE_3, expectedTablesOf3);
		expectedTables.put(TABLE_SIZE_5, expectedTablesOf5);

		actualTableList.stream().forEach(table -> {
			int tableSize = table.getSize();
			int tableCount = expectedTables.get(tableSize);
			expectedTables.put(tableSize, --tableCount);
		});

		Assert.assertTrue(0 == expectedTables.get(TABLE_SIZE_5));
		Assert.assertTrue(0 == expectedTables.get(TABLE_SIZE_3));
	}

	@Test
	public void testCreateTablesWith5Guests() {
		int[] R = new int[] { -1, -1, -1, 3, -1, 5 };
		SeatRandomizer randomizer = new SeatRandomizer();

		List<Table> actualTableList = null;
		try {
			actualTableList = randomizer.createTables(R);
		} catch (Exception e) {
			Assert.fail("create table should not throw exception");
		}

		Map<Integer, Integer> expectedTables = new HashMap<>();

		int expectedTablesOf3 = 0;
		int expectedTablesOf5 = 1;

		expectedTables.put(TABLE_SIZE_3, expectedTablesOf3);
		expectedTables.put(TABLE_SIZE_5, expectedTablesOf5);

		actualTableList.stream().forEach(table -> {
			int tableSize = table.getSize();
			int tableCount = expectedTables.get(tableSize);
			expectedTables.put(tableSize, --tableCount);
		});

		Assert.assertTrue(0 == expectedTables.get(TABLE_SIZE_5));
		Assert.assertTrue(0 == expectedTables.get(TABLE_SIZE_3));
	}

	@Test(expected = Exception.class)
	public void testCreateTablesWith4Guests() throws Exception {
		int[] R = new int[] { -1, -1, -1, 3, -1 };
		SeatRandomizer randomizer = new SeatRandomizer();
		randomizer.createTables(R);

	}

	@Test
	public void testCreateTablesWith3Guests() {
		int[] R = new int[] { -1, -1, -1, 3 };
		SeatRandomizer randomizer = new SeatRandomizer();
		List<Table> actualTableList = null;
		try {
			actualTableList = randomizer.createTables(R);
		} catch (Exception e) {
			Assert.fail("create table should not throw exception");
		}

		Map<Integer, Integer> expectedTables = new HashMap<>();

		int expectedTablesOf3 = 1;
		int expectedTablesOf5 = 0;

		expectedTables.put(TABLE_SIZE_3, expectedTablesOf3);
		expectedTables.put(TABLE_SIZE_5, expectedTablesOf5);

		actualTableList.stream().forEach(table -> {
			int tableSize = table.getSize();
			int tableCount = expectedTables.get(tableSize);
			expectedTables.put(tableSize, --tableCount);
		});

		Assert.assertTrue(0 == expectedTables.get(TABLE_SIZE_5));
		Assert.assertTrue(0 == expectedTables.get(TABLE_SIZE_3));
	}

	@Test(expected = Exception.class)
	public void testCreateTablesWith2Guests() throws Exception {
		int[] R = new int[] { -1, -1, -1 };
		SeatRandomizer randomizer = new SeatRandomizer();
		randomizer.createTables(R);
	}

	@Test(expected = Exception.class)
	public void testCreateTablesWith1Guests() throws Exception {
		int[] R = new int[] { -1, -1 };

		SeatRandomizer randomizer = new SeatRandomizer();
		randomizer.createTables(R);
	}
}
