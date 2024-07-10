package com.dp;

public class PerfectSquare {

	public static void main(String[] args) {
		Soluti soluti = new Soluti();

		int numSquares = soluti.numSquares(12);

		System.out.println(numSquares);
	}
}

class Soluti {
	public int numSquares(int n) {
		int[] dp = new int[n + 1];

		for (int target = 1; target <= n; target++) {
			dp[target] = target;
			for (int square = 1; square * square <= target; square++) {
				int sq = square * square;
				System.out.println("target: " + target + ", square: " + square + ", sq: " + sq + ", dp[target]: "
						+ dp[target] + ", dp[target - sq]: " + dp[target - sq]);
				dp[target] = Math.min(dp[target], 1 + dp[target - sq]);
				System.out.println("Updated dp[target]: " + dp[target]);
			}
		}

		return dp[n];
	}
}
