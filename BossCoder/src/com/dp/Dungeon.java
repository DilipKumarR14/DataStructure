package com.dp;

public class Dungeon {

	public static void main(String[] args) {

		Solution33 solution33 = new Solution33();

		int calculateMinimumHP = solution33
				.calculateMinimumHP(new int[][] { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } });

		System.out.println("---- "+calculateMinimumHP);
	}
}

class Solution33 {
	public int calculateMinimumHP(int[][] grid) {
		// Get the number of rows and columns in the grid
		int n = grid.length;
		int m = grid[0].length;

		// Create a dynamic programming array to store minimum health required
		int dp[][] = new int[n][m];

		// Traverse the grid from bottom-right to top-left
		for (int i = n - 1; i >= 0; i--) {
			for (int j = m - 1; j >= 0; j--) {
				// If it's the bottom-right cell
				if (i == n - 1 && j == m - 1) {
					// Calculate minimum health required at this cell
					// Ensure the knight has at least 1 health after reaching the princess
					dp[i][j] = Math.max(1, 1 - grid[i][j]);
				}
				// If it's in the last row
				else if (i == n - 1) {
					// Calculate minimum health required at this cell based on the right cell
					dp[i][j] = Math.max(1, dp[i][j + 1] - grid[i][j]);
				}
				// If it's in the last column
				else if (j == m - 1) {
					// Calculate minimum health required at this cell based on the bottom cell
					dp[i][j] = Math.max(1, dp[i + 1][j] - grid[i][j]);
				}
				// For other cells in the grid
				else {
					// Calculate minimum health required at this cell based on the right or bottom
					// cell
					// Choose the path that requires less health
					dp[i][j] = Math.max(1, Math.min(dp[i][j + 1], dp[i + 1][j]) - grid[i][j]);
				}
			}
		}

		// Print the dp array
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

		// Return the minimum health required at the top-left cell
		return dp[0][0];
	}
}
