package com.array;

public class SetMatrixZeros {

	public static void main(String[] args) {
		int[][] arr1 = new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		setZeroes(arr1);
	}

	public static void setZeroes(int[][] matrix) {

		int high = 0;
		int innerMatrix = matrix[0].length;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < innerMatrix; j++) {
				if (matrix[i][j] == 0) {
					System.out.println(" i, j " + i + ", " + j);
				}
			}
		}

	}

}
