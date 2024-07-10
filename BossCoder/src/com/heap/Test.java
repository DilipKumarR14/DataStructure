package com.heap;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[][] twoDArray = { { 4, 5 }, { 1, 2 }, { 7, 8 } };
		for (int[] k : twoDArray) {
			System.out.println(Arrays.toString(k));
		}

		System.out.println();
		Arrays.sort(twoDArray, (a, b) -> {
			System.out.println("Comparing: " + Arrays.toString(a) + " and " + Arrays.toString(b));
			return b[1] - a[1];
		});
		
		for (int[] k : twoDArray) {
			System.out.println(Arrays.toString(k));
		}

	}

}
