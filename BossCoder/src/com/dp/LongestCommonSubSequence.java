package com.dp;

import java.util.Arrays;

public class LongestCommonSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution12 solution12 = new Solution12();

		solution12.longestCommonSubsequence("abcde", "ace");
	}

}

class Solution12 {
	public int longestCommonSubsequence(String text1, String text2) {
		// Lengths of the input strings
		int length1 = text1.length();
		int length2 = text2.length();

		// Create a 2D array to store the lengths of longest common subsequences
		// for all subproblems, initialized with zero
		int[][] dp = new int[length1 + 1][length2 + 1];

		// Build the dp array from the bottom up
		for (int i = 1; i <= length1; ++i) {
			for (int j = 1; j <= length2; ++j) {
				// If characters match, take diagonal value and add 1
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
				// If characters do not match, take the maximum value from
				// the left (dp[i][j-1]) or above (dp[i-1][j])
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
				printArr(dp, i, j);

			}
		}
		// The bottom-right cell contains the length of the longest
		// common subsequence of text1 and text2
		return dp[length1][length2];
	}

	private void printArr(int[][] dp, int i, int j) {
		System.out.println("--------------");
		System.out.println("i: " + i + " j:" + j);
		for (int[] l : dp) {
			System.out.println(Arrays.toString(l));
		}

	}
}
