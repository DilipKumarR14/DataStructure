package com.dp;

public class MinPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution1 solution1 = new Solution1();
		int minPathSum = solution1.minPathSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } });

		System.out.println(minPathSum);
	}

}

class Solution1 {
	public int minPathSum(int[][] grid) {
		if (grid.length == 0) {
			return 0;
		}

		int m = grid.length;
		int n = grid[0].length;

		for (int i = 1; i < n; i++) {
			grid[0][i] += grid[0][i - 1];
		}

		for (int i = 1; i < m; i++) {
			grid[i][0] += grid[i - 1][0];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
			}
		}

		return grid[m - 1][n - 1];

	}
}
