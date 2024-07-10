package com.matrices;

import java.util.Arrays;

public class TransposeMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { { 1,2,3 }, { 4,5,6 }, { 7,8,9 } };

		System.out.println(transpose(arr));
	}

	public static int[][] transpose(int[][] matrix) {

		
		int length = matrix.length;
		int length2 = matrix[0].length;
		int[][] ans = new int[length][length2];
		
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length2; j++) {
				ans[j][i] = matrix[i][j];
			}
		}

		for (int g = 0; g < length; g++) {
			System.out.println("rs " + Arrays.toString(ans[g]));
		}

		return ans;
	}
}
