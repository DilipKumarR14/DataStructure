package com.array;

import java.util.Arrays;

public class Convert1Dto2d {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] dia = { 1, 2, 3, 4 };

		construct2DArray(dia, 2, 2);
	}

	public static int[][] construct2DArray(int[] original, int m, int n) {

		int length = original.length;
		if (length != m * n) {
			return new int[0][0];
		}
		int[][] result = new int[m][n];

		for (int i = 0; i < length; i++) {
//			int j2 = original[i];
			result[i / n][i % n] = original[i];
		}

		// System.out.println(Arrays.toString(result));
		for (int g = 0; g < result.length; g++) {
			System.out.println(Arrays.toString(result[g]));
		}
		return result;

	}

}
