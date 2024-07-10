package com.array;

public class SumOfSubmatrices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };

		System.out.println(matrixSum(arr));
	}

	static int matrixSum(int arr[][]) {

		int n = 3;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				int top_left = (i + 1) * (j + 1);

				int bottom_right = (n - i) * (n - j);
 
				sum = sum + top_left * bottom_right * arr[i][j];
			}
		}

		return sum;

	}

}
