package com.dynamic.programming;

import java.util.Arrays;

public class GridTraveller {

	public static void main(String[] args) {

		int size = 18;
		long[][] grid = new long[size + 1][size + 1];

		grid[1][1] = 1;
		int m = grid.length;
		int n = grid[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				long current = grid[i][j];

				if (j + 1 < n)
					grid[i][j + 1] += current;
				if (i + 1 < m)
					grid[i + 1][j] += current;

			}
		}
//		for (long[] ele : grid) {
//			System.out.println(Arrays.toString(ele));
//		}
		
		System.out.println(grid[size][size]);
	}

}
