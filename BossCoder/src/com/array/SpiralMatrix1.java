package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix1 {

	public static void main(String[] args) {
		int[][] arr1 = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		spiralOrder(arr1);
	}

	public static List<Integer> spiralOrder(int[][] matrix) {

		int m = matrix[0].length, n = matrix.length, top = 0, bottom = n - 1, left = 0, right = m - 1;
		ArrayList<Integer> arrayList = new ArrayList<>();

		while (left <= right && top <= bottom) {
			for (int i = left; i <= right; i++) {
				arrayList.add(matrix[top][i]);
				System.out.println(arrayList);
			}
			top++;
			for (int i = top; i <= bottom; i++) {
				arrayList.add(matrix[i][right]);
				System.out.println(arrayList);

			}
			right--;
			// if one row, left wont be printed but top will be printed
			if (top <= bottom) {
				for (int i = right; i >= left; i--) {
					arrayList.add(matrix[bottom][i]);
					System.out.println(arrayList);

				}
				bottom--;
			}
			// if still element is present in left to right
			if (left <= right) {
				for (int i = bottom; i >= top; i--) {
					arrayList.add(matrix[i][left]);
					System.out.println(arrayList);

				}
				left++;
			}
		}
		return arrayList;

	}

}
