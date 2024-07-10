package com.dp;

import java.util.Arrays;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;

		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (coin <= i) {
					int a = dp[i];
					dp[i] = Math.min(a, dp[i - coin] + 1);
				}
			}
			System.out.println("Iteration " + i + ": " + Arrays.toString(dp));
		}

		return dp[amount] > amount ? -1 : dp[amount];
	}

	public static void main(String[] args) {
		CoinChange cc = new CoinChange();
		int[] coins1 = { 1, 2, 5 };
		int amount1 = 11;
		System.out.println("Output for coins1 and amount1: " + cc.coinChange(coins1, amount1)); // Output: 3

		int[] coins2 = { 2 };
		int amount2 = 3;
		System.out.println("Output for coins2 and amount2: " + cc.coinChange(coins2, amount2)); // Output: -1

		int[] coins3 = { 1 };
		int amount3 = 0;
		System.out.println("Output for coins3 and amount3: " + cc.coinChange(coins3, amount3)); // Output: 0
	}
}
