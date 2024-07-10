package com.dp;

import java.util.Arrays;

public class UniquePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution2 solution2 = new Solution2();

		int uniquePaths = solution2.uniquePaths(3, 7);

		System.out.println(uniquePaths);

	}

}

class Solution2 {
	public int uniquePaths(int m, int n) {
		int max[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					max[i][j] = 1;
				} else {
					max[i][j] = max[i - 1][j] + max[i][j - 1];
				}
			}
		}
		
		for(int[] l: max) {
			System.out.println(Arrays.toString(l));
		}

		return max[m - 1][n - 1];
	}
}