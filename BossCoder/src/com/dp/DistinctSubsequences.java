package com.dp;

import java.util.Arrays;
import java.util.Iterator;

public class DistinctSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solutisdn solutisdn = new Solutisdn();
		
		
		int numDistinct = solutisdn.numDistinct("rabbbit", "rabbit");

		System.out.println(numDistinct);
	
	}

}
class Solutisdn {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        // Create a 2D array to store the number of distinct subsequences
        int[][] dp = new int[m + 1][n + 1];

        // Base case: An empty string t has one subsequence in s (where all characters
        // are ignored)
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        
        printArr(dp);

        // Fill the dp array using dynamic programming
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // If characters match,
                    // 1. add the number of subsequences without considering both characters
                    // 2. and the number of subsequences considering both characters
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    System.out.println("Matching-----------");
                    printArr(dp);

                } else {
                    // If characters don't match, proceed with only considering the character in s
                    dp[i][j] = dp[i - 1][j];
                    System.out.println("Didnt Matching-----------");
                    printArr(dp);

                }
            }
        }
        System.out.println("Final-----------");
        printArr(dp);

        // Return the result stored in the bottom-right cell of the dp array
        return dp[m][n];
    }

	private void printArr(int[][] dp) {
		System.out.println("--------------------");
		for (int[] is : dp) {
			System.out.println(Arrays.toString(is));
		}
	}
}