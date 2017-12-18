package org.aptlist.friday;

import java.util.ArrayList;
import java.util.List;

public class Table {

	private int size;
	private List<String> names;

	public Table(int size) {
		super();
		this.size = size;
		names = new ArrayList<>();
	}

	public boolean addGuest(String name) {
		if (names.size() >= size)
			return false;
		return names.add(name);
	}

	public boolean isFull() {
		return names.size() >= size;
	}

	// used for testing names in list
	public List<String> getNames() {
		return names;
	}

	// used for testing correct table size
	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "Guest list for table: " + names;
	}

}
