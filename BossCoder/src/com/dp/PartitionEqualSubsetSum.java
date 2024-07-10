package com.dp;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

	public static void main(String[] args) {

		Solution11 solution11 = new Solution11();

		boolean canPartition = solution11.canPartition(new int[] { 1, 5,11,5 });
		System.out.println(canPartition);

	}

}

class Solution11 {
	public boolean canPartition(int[] nums) {
		int N = nums.length;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += nums[i];
		}

		// Check if the total sum is odd, then it cannot be partitioned into two equal
		// subsets
		if (sum % 2 != 0) {
			return false;
		}

		// Check if there exists a subset with sum equal to sum/2
		return subSetSum(nums, sum / 2, N);
	}

	static boolean subSetSum(int[] nums, int sum, int n) {
		boolean[][] dp = new boolean[n + 1][sum + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0)
					dp[i][j] = false;
				if (j == 0)
					dp[i][j] = true;
			}
		}

		extracted(dp);

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				System.out.println("current number "+nums[i - 1]+", sum " +j + ", index "+i);
				if (nums[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
					System.out.println("can include or not ");
					extracted(dp);

				} else {
					dp[i][j] = dp[i - 1][j];
					System.out.println("cannottt include ");
					extracted(dp);
				}
			}
		}
		System.out.println("--------------");
		extracted(dp);
		return dp[n][sum];
	}

	private static void extracted(boolean[][] dp) {
System.out.println();
		for (boolean[] l : dp) {
			System.out.println(Arrays.toString(l));
		}
	}
}