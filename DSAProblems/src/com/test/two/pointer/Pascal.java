package com.test.two.pointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pascal {

	public static void main(String[] args) {

		// for (int i = 1; i <= numRows; i++) {
		arrayCreater();
		// }
//		System.out.println(arrayCreater1);

	}

	private static List<List<Integer>> arrayCreater() {

		List<List<Integer>> allrows = new ArrayList<List<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		int numRows = 5;
		for (int i = 0; i < numRows; i++) {
			System.out.println("row sta : "+row);

			row.add(0, 1);
			System.out.println("row: "+row);
			for (int j = 1; j < row.size() - 1; j++) {
				row.set(j, row.get(j) + row.get(j + 1));
			}
			allrows.add(new ArrayList<Integer>(row));
		}
		return allrows;

	}

}
