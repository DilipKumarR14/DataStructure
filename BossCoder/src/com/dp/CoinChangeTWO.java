package com.dp;

import java.util.Arrays;

public class CoinChangeTWO {

	public static void main(String[] args) {

		Solutionsas solutionsas = new Solutionsas();

		int change = solutionsas.change(5, new int[] { 1, 2, 5 });

		System.out.println(change);

	}

}

class Solutionsas {
	public int change(int amount, int[] coins) {
		int[] dp = new int[amount + 1];

		dp[0] = 1;
		printArr(dp);
		for (int c : coins) {
			System.out.println("current coin "+c);
			for (int i = c; i <= amount; i++) {
				dp[i] += dp[i - c];
				printArr(dp);
			}
			printArr(dp);
		}
		return dp[amount];
	}

	private void printArr(int[] dp) {
		System.out.println();
		System.out.println(Arrays.toString(dp));
		
	}
}