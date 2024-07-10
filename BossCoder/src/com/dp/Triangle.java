package com.dp;

import java.util.Arrays;
import java.util.List;

public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution3 solution3 = new Solution3();

		int minimumTotal = solution3
				.minimumTotal(List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3)));
		System.out.println(minimumTotal);
	}

}

class Solution3 {
	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[][] dp = new int[n + 1][n + 1];

		for (int level = n - 1; level >= 0; level--) {
			for (int i = 0; i <= level; i++) {
				dp[level][i] = triangle.get(level).get(i) + 
						Math.min(dp[level + 1][i], dp[level + 1][i + 1]);

				printArr(dp);

			}
		}
		return dp[0][0];
	}

	private void printArr(int[][] dp) {
		System.out.println("--------------==");
		for (int[] l : dp) {
			System.out.println(Arrays.toString(l));
		}

	}
}