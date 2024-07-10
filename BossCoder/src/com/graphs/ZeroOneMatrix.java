package com.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

	public static void main(String[] args) {

		Solutions solutions = new Solutions();

		// Example input matrix
		int[][] matrix = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };

		// Print original matrix
		System.out.println("Original Matrix:");
		printMatrix(matrix);

		// Update the matrix
		int[][] updatedMatrix = solutions.updateMatrix(matrix);

		// Print updated matrix
		System.out.println("Updated Matrix:");
		printMatrix(updatedMatrix);
	}

	private static void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			for (int cell : row) {
				System.out.print(cell + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}

class Solutions {
	public int[][] updateMatrix(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					queue.offer(new int[] { i, j });
                    System.out.println("Added to queue: (" + i + ", " + j + ")");

					
				} else {
					matrix[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		
//		queue.stream().forEach(System.out::println);

		int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		while (!queue.isEmpty()) {
			int[] cell = queue.poll();
            System.out.println("Current Cell: (" + cell[0] + ", " + cell[1] + ")");

			for (int[] d : dirs) {
				int r = cell[0] + d[0];
				int c = cell[1] + d[1];
				printMatrix(matrix);
				if (r < 0 || r >= m || c < 0 || c >= n || 
						matrix[r][c] <= matrix[cell[0]][cell[1]] + 1) {
					continue;
				}
				queue.add(new int[] { r, c });
                System.out.println("Added new info to queue: (" + r + ", " + c + ")");
				matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
				printMatrix(matrix); // Debugging statement to print matrix after each update
			}
		}

		return matrix;
	}

	// Helper method to print the matrix
	private void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			for (int cell : row) {
				System.out.print(cell + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
