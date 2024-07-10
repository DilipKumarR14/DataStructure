package com.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrange {

	public static void main(String[] args) {
		// Example grid
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };

		// Create an instance of the Solution class
		Solution solution = new Solution();

		// Call the orangesRotting method to find the minimum time required
		int minTime = solution.orangesRotting(grid);

		// Output the result
		if (minTime == -1) {
			System.out.println("It is not possible to rot all oranges.");
		} else {
			System.out.println("Minimum time required for all oranges to rot: " + minTime);
		}
	}

}

// Define a Pair class to represent coordinates of oranges and their respective time
class Pair {
	int row;
	int col;
	int time;

	// Constructor to initialize row, col, and time
	Pair(int row, int col, int time) {
		this.row = row;
		this.col = col;
		this.time = time;
	}

	@Override
	public String toString() {
		return "Pair [row=" + row + ", col=" + col + ", time=" + time + "]";
	}
	
	
}

// Define the Solution class
class Solution {

	// Define directions: top, bottom, left, right
	int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	// Method to find the minimum time required for all oranges to rot
	public int orangesRotting(int[][] grid) {
		// Get the number of rows and columns in the grid
		int row = grid.length;
		int col = grid[0].length;
		int count = 0, max = 0; // Initialize count and max

		// Create a queue to store pairs of coordinates
		Queue<Pair> queue = new LinkedList<>();

		// Create a boolean array to mark visited cells
		boolean[][] visited = new boolean[row][col];

		// Iterate through the grid to find all the rotten oranges and add them to the
		// queue
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 2) {
					queue.add(new Pair(i, j, 0)); // Add rotten oranges to the queue with time 0
				}
			}
		}

		// Process the oranges in the queue
		while (!queue.isEmpty()) {
			Pair p = queue.remove(); // Remove the pair from the queue
			visited[p.row][p.col] = true; // Mark the current cell as visited

			System.out.println("Processing orange at (" + p.row + ", " + p.col + ") with time " + p.time);

			// Iterate through the directions
			for (int dr[] : dir) {
				int i = p.row + dr[0]; // Calculate the new row index
				int j = p.col + dr[1]; // Calculate the new column index

				// Check if the new position is valid and contains a fresh orange
				if (isValidDir(i, j, grid) && grid[i][j] == 1 && !visited[i][j]) {
					System.out.println("Rotten orange spreads to (" + i + ", " + j + ")");
					grid[i][j] = 2; // Mark the orange as rotten
					queue.add(new Pair(i, j, p.time + 1)); // Add the new rotten orange to the queue with updated time
				}
			}
			max = Math.max(max, p.time); // Update the maximum time
		}

		// Count the number of fresh oranges left in the grid
		for (int rows[] : grid) {
			for (int cols : rows) {
				if (cols == 1)
					count++;
			}
		}

		// Return -1 if there are still fresh oranges, otherwise return the maximum time
		return count > 0 ? -1 : max;
	}

	// Method to check if the given position is valid
	private boolean isValidDir(int i, int j, int grid[][]) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
			return false;
		}

		return true;
	}
}
