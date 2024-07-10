package com.dp;

import java.util.*;

public class SubSetSumK {

	public static void main(String args[]) {
		int arr[] = { 2, 3, 4 };
		int k = 5;
		int n = arr.length;

		// Check if there exists a subset with the given target sum
		if (TUF.subsetSumToK(n, k, arr))
			System.out.println("Subset with the given target found");
		else
			System.out.println("Subset with the given target not found");
	}

}

class TUF {
	// Function to check if there exists a subset with a given target sum
	static boolean subsetSumToK(int n, int k, int[] arr) {
		// Create a boolean DP table with dimensions [n][k+1]
		boolean dp[][] = new boolean[n][k + 1];

		// Initialize the first row of the DP table
		for (int i = 0; i < n; i++) {
			dp[i][0] = true;
		}
		/**
		 * int arr[] = { 1,2,3,4}; int k = 4;
		 */
		printDP(dp);

		// Initialize the first column of the DP table
		if (arr[0] <= k) {
			dp[0][arr[0]] = true;
		}
		printDP(dp);
//https://chat.openai.com/c/c8739036-b2e3-4d16-ae41-e01cab0c1407
		
		// Fill in the DP table using bottom-up approach
		for (int ind = 1; ind < n; ind++) {
			for (int target = 1; target <= k; target++) {
				// Calculate if the current target can be achieved without taking the current
				// element
				boolean notTaken = dp[ind - 1][target];

				// Calculate if the current target can be achieved by taking the current element
				boolean taken = false;
				if (arr[ind] <= target) {
					taken = dp[ind - 1][target - arr[ind]];
				}

				// Store the result in the DP table
				dp[ind][target] = notTaken || taken;
				System.out.println("notTaken: " + notTaken + ", taken: " + taken);

				System.out.println("index: " + ind + ", target: " + target);

				printDP(dp);
			}
		}

		printDP(dp);

		// The final result is stored in the bottom-right cell of the DP table
		return dp[n - 1][k];
	}

	private static void printArr(boolean[][] dp) {
		System.out.println();
		for (boolean[] l : dp) {
			System.out.println(Arrays.toString(l));
		}

	}

	static void printDP(boolean[][] dp) {
		System.out.println("DP Table:");
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
