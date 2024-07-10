package com.dp;

import java.util.Arrays;

public class EditDistance {
	public static void main(String[] args) {
		Solutiosan solution = new Solutiosan();

		// Example 1
		String word1 = "horse";
		String word2 = "ros";
		int result1 = solution.minDistance(word1, word2);
		System.out.println("The minimum edit distance between \"" + word1 + "\" and \"" + word2 + "\" is " + result1);

		// Example 2
		String word1b = "intention";
		String word2b = "execution";
		int result2 = solution.minDistance(word1b, word2b);
		System.out.println("The minimum edit distance between \"" + word1b + "\" and \"" + word2b + "\" is " + result2);

		// You can add more examples to test other cases
	}
}

class Solutiosan {
	public int minDistance(String word1, String word2) {
		// /https://leetcode.com/problems/edit-distance/solutions/3230662/clean-codes-full-explanation-dynamic-programming-c-java-python3
		// N7_BLACKHAT
		final int m = word1.length();// first word length
		final int n = word2.length();/// second word length
		// dp[i][j] := min # of operations to convert word1[0..i) to word2[0..j)
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 1; i <= m; ++i) {
			dp[i][0] = i;
		}

		for (int j = 1; j <= n; ++j) {
			dp[0][j] = j;
		}
		
		printArr(dp);

		for (int i = 1; i <= m; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {// same characters
					dp[i][j] = dp[i - 1][j - 1];// no operation
				} else {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				} // replace //delete //insert
			}
		}
		return dp[m][n];

	}
	
	private void printArr(int[][] dp) {
		System.out.println("--------------------");
		for (int[] is : dp) {
			System.out.println(Arrays.toString(is));
		}
	}

	/**
	 * 
	 * The matrix is built iteratively using the following recurrence relation: If
	 * word1[i-1] == word2[j-1], then dp[i][j] = dp[i-1][j-1]. That is, no operation
	 * is required because the characters at positions i-1 and j-1 are already the
	 * same.
	 * 
	 * Otherwise, dp[i][j] is the minimum of the following three values:
	 * 
	 * dp[i-1][j-1] + 1: replace the character at position i-1 in word1 with the
	 * character at position j-1 in word2.
	 * 
	 * dp[i-1][j] + 1: delete the character at position i-1 in word1.
	 * 
	 * dp[i][j-1] + 1: insert the character at position j-1 in word2 into word1 at
	 * position i.
	 * 
	 * The base cases are: dp[i][0] = i: transforming word1[0...i-1] into an empty
	 * string requires i deletions. dp[0][j] = j: transforming an empty string into
	 * word2[0...j-1] requires j insertions.
	 * 
	 * Final Step : Finally, return dp[m][n], which represents the minimum number of
	 * operations required to transform word1 into word2, where m is the length of
	 * word1 and n is the length of word2. Complexity Time complexity : O(mn) Space
	 * complexity : O(mn)
	 */
}