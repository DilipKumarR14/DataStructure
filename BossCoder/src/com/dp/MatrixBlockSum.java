package com.dp;

import java.util.Arrays;

public class MatrixBlockSum {

	public static void main(String[] args) {
		Solution21w solution21w = new Solution21w();

		int[][] matrixBlockSum = solution21w.matrixBlockSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, 1);

		printArr(matrixBlockSum);

	}

	static void printArr(int[][] matrixBlockSum) {
		for (int l[] : matrixBlockSum) {
			System.out.println(Arrays.toString(l));
		}
	}

}

class Solution21w {
	public int[][] matrixBlockSum(int[][] mat, int K) {
		int m = mat.length, n = mat[0].length;
		int[][] sum = new int[m + 1][n + 1]; // sum[i][j] is sum of all elements from rectangle (0,0,i,j) as left, top,
												// right, bottom corresponding
		for (int r = 1; r <= m; r++) {
			for (int c = 1; c <= n; c++) {
				sum[r][c] = mat[r - 1][c - 1] + sum[r - 1][c] + sum[r][c - 1] - sum[r - 1][c - 1];
			}
		}
		
		MatrixBlockSum.printArr(sum);

		int[][] ans = new int[m][n];
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				int r1 = Math.max(0, r - K), c1 = Math.max(0, c - K);
				int r2 = Math.min(m - 1, r + K), c2 = Math.min(n - 1, c + K);
				r1++;
				c1++;
				r2++;
				c2++; // Since `sum` start with 1 so we need to increase r1, c1, r2, c2 by 1
				ans[r][c] = sum[r2][c2] - sum[r2][c1 - 1] - sum[r1 - 1][c2] + sum[r1 - 1][c1 - 1];
			}
		}
		return ans;
	}
}
