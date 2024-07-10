package com.array;

public class Search2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr1 = new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
				{ 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } };
//		int[][] arr1 = new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
//				{ 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } };
		boolean searchMatrix = searchMatrix(arr1, 10);

		System.out.println(searchMatrix);
	}

	public static boolean searchMatrix(int[][] matrix, int target) {

		int m = matrix.length;
		int n = matrix[0].length;

		int r = 0, c = n - 1;
		// until r reach top to bottom, c reaches right to left
		while (r < m && c >= 0) {
			if (matrix[r][c] == target) {
				return true;
			} else if (matrix[r][c] > target) {
				c--;
			} else {
				r++;
			}
		}

		return false;

	}
}
