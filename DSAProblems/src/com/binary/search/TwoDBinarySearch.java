package com.binary.search;

public class TwoDBinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] num = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };

		boolean searchMatrix = searchMatrix(num, 10);
		System.out.println(searchMatrix);

	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;

		int left = 0, right = m * n - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			int mid_val = matrix[mid / n][mid % n];

			System.out.println("mid " + mid);
			System.out.println("mid_val " + mid_val);

			if (mid_val == target)
				return true;
			else if (mid_val < target)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return false;
	}
}
