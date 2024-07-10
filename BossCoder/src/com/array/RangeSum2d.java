package com.array;

import java.util.Arrays;

public class RangeSum2d {

	int matric[][];
	int sum[][];

	public RangeSum2d(int[][] matric) {
		super();
		this.matric = matric;
		this.sum = new int[matric.length][matric[0].length];
		this.fillSum();
	}

	public void fillSum() {
		sum[0][0] = matric[0][0];

		// filling the first column
		for (int row = 1; row < sum.length; row++) {
			sum[row][0] = sum[row - 1][0] + matric[row][0];
		}

		// first row
		for (int col = 1; col < sum[0].length; col++) {
			sum[0][col] = sum[0][col - 1] + matric[0][col];
		}

//		System.out.println(Arrays.toString(sum));

		// create sum array similar
		for (int row = 1; row < sum.length; row++) {
			for (int col = 1; col < sum[0].length; col++) {

				sum[row][col] = 
						matric[row][col]
						+ sum[row - 1][col]
								+ sum[row][col - 1]
										- sum[row - 1][col - 1];

			}
		}

	}

	private int getValue(int row, int col) {
		if (row < 0 || col < 0) {
			return 0;
		}
		return sum[row][col];

	}

	public int sumRegion(int tlr, int tlc, int brr, int brc) {

		// bottom right row-brr, brc-column
		// top left column-tlc
		int s = getValue(brr, brc);
		int a = getValue(brc, tlc - 1);
		int b = getValue(tlr - 1, brc);
		int c = getValue(tlr - 1, tlc - 1);
		int ans = s - a - b + c;

		return ans;
	}

	public static void main(String[] args) {

	}

}
