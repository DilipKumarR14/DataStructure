package com.dp;

import java.util.Arrays;

public class LongestCommonSeq {

	public static void main(String[] args) {

		Solution solution = new Solution();

		solution.longestCommonSubsequence("abcde", "ace");

	}

}

class Solution {
	public int longestCommonSubsequence(String text1, String text2) {
		int a = text1.length();
		int b = text2.length();
		int[][] dp = new int[a + 1][b + 1];
		extracted(dp);
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				if (text1.charAt(i) == text2.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j] + 1;
					extracted(dp);
				} else {
					dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
					extracted(dp);
				}
			}

		}
		return dp[a][b];
	}

	private void extracted(int[][] dp) {
		System.out.println();
		for(int[] l: dp) {
			System.out.println(Arrays.toString(l));
		}
	}
}
