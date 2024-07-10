package com.test.arrays.neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {

		int n = 5;

//		List<List<Integer>> generate = generate(n);
		List<List<Integer>> generateSol2 = generateSol2(n);
		System.out.println(generateSol2);

	}

	private static List<List<Integer>> generate(int numRows) {

		if (numRows == 0)
			return new ArrayList<>();

		if (numRows == 1) {
			List<List<Integer>> result = new ArrayList<>();
			result.add(Arrays.asList(1));
			return result;
		}

		List<List<Integer>> prevRows = generate(numRows - 1);
		List<Integer> newRow = new ArrayList<>();

		for (int i = 0; i < numRows; i++) {
			newRow.add(1);
		}

		for (int i = 1; i < numRows - 1; i++) {
			Integer firstEle = prevRows.get(numRows - 2).get(i - 1);
			Integer secEle = prevRows.get(numRows - 2).get(i);
			newRow.set(i, firstEle + secEle);
		}

		prevRows.add(newRow);
		return prevRows;
	}

	private static List<List<Integer>> generateSol2(int numRows) {

		if (numRows == 0) {
			return new ArrayList<>();
		}

		if (numRows == 1) {
			List<List<Integer>> prevRows = new ArrayList<>();
			prevRows.add(Arrays.asList(1));
			return prevRows;
		}

		List<List<Integer>> recurCall = generateSol2(numRows - 1);
		List<Integer> newRow = new ArrayList<>();

		for (int i = 0; i < numRows; i++) {
			newRow.add(1);
		}

		for (int i = 1; i < numRows - 1; i++) {
			Integer first = recurCall.get(numRows - 2).get(i - 1);
			Integer sec = recurCall.get(numRows - 2).get(i);
			newRow.set(i, first + sec);
		}

		recurCall.add(newRow);
//		System.out.println(recurCall);

		return recurCall;

	}

}
