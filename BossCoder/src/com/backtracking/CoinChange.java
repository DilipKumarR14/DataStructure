package com.backtracking;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int coinChange = coinChange(new int[] { 1, 2, 5 }, 11);
		
		System.out.println(coinChange);
	}

	public static int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		System.out.println(Arrays.toString(dp));

		// initialize i to maximum value
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0; // set dp[0] to 0 since no coins are needed to make an amount of 0
		System.out.println(Arrays.toString(dp));
		// iterate through each coin
		for (int coin : coins) {
			// iterate through the dp array starting from the coin value
			for (int i = coin; i < dp.length; i++) {
				// check on possible overflow problem
				// checks if value in dp array at index i - coin is not already at
				// Integer.MAX_VALUE
				// If you were to add 1 to Integer.MAX_VALUE, it would result in an overflow
				System.out.println(dp[i - coin]);
				System.out.println(dp[i]);
				if (dp[i - coin] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
				System.out.println("after calculation "+Arrays.toString(dp));

			}
		}

		// if final value is still Integer.MAX_VALUE, it's not possible to make given
		// amount w/ provided coins. Return -1 in this case.
		// Otherwise, return the minimum number of coins needed to make the target
		// amount.
		// if dp[amount] > amount, return -1, otherwise return dp[amount] (amount)
		return dp[amount] > amount ? -1 : dp[amount];
	}

}
