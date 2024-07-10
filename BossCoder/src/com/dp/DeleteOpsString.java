package com.dp;

import java.util.Arrays;

public class DeleteOpsString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solusaon solusaon = new Solusaon();

		int minDistance = solusaon.minDistance("sea", "eat");
		
		
		System.out.println(minDistance);

	}

}

class Solusaon {
	public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();

		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		printArr(dp);
		return m + n - (2 * dp[m][n]);
	}
	
	private void printArr(int[][] dp) {

		for (int[] is : dp) {
			System.out.println(Arrays.toString(is));
		}
	}
}