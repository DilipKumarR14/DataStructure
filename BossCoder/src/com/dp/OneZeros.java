package com.dp;

import java.util.Arrays;

public class OneZeros {

	public static void main(String[] args) {

		Solution121 solution121 = new Solution121();

		int findMaxForm = solution121.findMaxForm(new String[] { "10", "0001", "111001", "1", "0" }, 5, 3);

		System.err.println(findMaxForm);

	}

}

/**
 * Complexity Time complexity:O(n∗(zero∗one))O(n*(zero*one))O(n∗(zero∗one))
 * Space complexity:O(n∗m)O(n*m)O(n∗m)
 */

class Solution121 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zero = 0, one = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0')
                    zero++;
                else
                    one++;
            }

            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    int previousCount = dp[i][j];
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                    System.out.println("Previous count at (" + i + ", " + j + "): " + previousCount);
                    System.out.println("Updated count at (" + i + ", " + j + "): " + dp[i][j]);
                    printDP(dp);

                }
            }
            System.out.println("DP array after processing string \"" + str + "\":");
            printDP(dp);
            System.out.println();
        }
        return dp[m][n];
    }

    private void printDP(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
