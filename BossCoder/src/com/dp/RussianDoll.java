package com.dp;

import java.util.Arrays;
import java.util.Iterator;

public class RussianDoll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution12121 sol = new Solution12121();

		int[][] doll = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
		int maxEnvelopes = sol.maxEnvelopes(doll);
		System.out.println(maxEnvelopes);

	}

}

class Solution12121 {
    public int maxEnvelopes(int[][] envelopes) {

        int max = 0;
        Arrays.sort(envelopes, (a, b) -> (a[0] - b[0]));
        int[] dp = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
                System.out.println("Comparing envelope " + Arrays.toString(envelopes[i]) + " with envelope " + Arrays.toString(envelopes[j]));
            }
            max = Math.max(max, dp[i]);
            // Print debug information
            System.out.println("Current envelope: " + Arrays.toString(envelopes[i]));
            System.out.println("Current dp[" + i + "]: " + dp[i]);
            System.out.println("Current max: " + max);
        }

        return max;
    }
}