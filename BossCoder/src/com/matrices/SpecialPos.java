package com.matrices;

import java.util.Arrays;
import java.util.Iterator;

public class SpecialPos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 1, 0, 0 }, { 0, 0, 1 }, { 1, 1, 0 } };
		numSpecial(arr);
	}

	public static int numSpecial(int[][] mat) {


		int m = mat.length;
		int n = mat[0].length;
		int[] rowSum = new int[m];
		int[] colSum = new int[n];
		

		System.out.println("rowSum " + Arrays.toString(rowSum));
		System.out.println("colSum " + Arrays.toString(colSum));
		int ans = 0;
//		int[][] arr = { 
//		{ 1, 0, 0 }, 
//		{ 0, 0, 1 }, 
//		{ 1, 0, 0 } 
//		};
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 1) {
					rowSum[i]++;
					colSum[j]++;

					System.out.println("rowSum i " + i + Arrays.toString(rowSum));
					System.out.println("colSum j " + j + Arrays.toString(colSum));
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 1) {
					if (colSum[j] <= 1 && rowSum[i] <= 1)
						ans++;
				}
			}
		}
		System.out.println("ans "+ans);
		return ans;


	}
}
