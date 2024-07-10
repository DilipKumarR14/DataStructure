package com.array;

public class DiagonalSum {

	public static void main(String[] args) {

		int[][] dia = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		diagonalSum(dia);

	}

	private static void diagonalSum(int[][] dia) {

		int sum = 0;
		int n = dia.length;

		for (int i = 0; i < n; i++) {
			sum = sum + dia[i][i] + dia[i][n-1-i];
		}
		
		if (n%2!=0) {
			sum = sum - dia[n/2][n/2];
		}
		
		System.out.println(sum);

	}

}
