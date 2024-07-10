package com.dp;

import java.util.Arrays;

public class NoLongestIncreasingSubSeq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solutidfsn solutidfsn = new Solutidfsn();
		// Test case 1
		int[] nums1 = { 1, 3, 5, 4, 7 };
		System.out.println("Result for nums1: " + solutidfsn.findNumberOfLIS(nums1));

		// Test case 2
		int[] nums2 = { 2, 2, 2, 2, 2 };
		System.out.println("Result for nums2: " + solutidfsn.findNumberOfLIS(nums2));

		// Test case 3
		int[] nums3 = { 1, 2, 4, 3, 5, 4, 7, 2 };
		System.out.println("Result for nums3: " + solutidfsn.findNumberOfLIS(nums3));

	}

}

class Solutidfsn {
	public int findNumberOfLIS(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return 0;

		int[] dp = new int[n];
		int[] count = new int[n];
		Arrays.fill(dp, 1);
		Arrays.fill(count, 1);

		int maxLength = 1;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					if (dp[j] + 1 > dp[i]) {
						dp[i] = dp[j] + 1;
						count[i] = count[j];
						// Debugging: Print statements
						System.out.println("Updating dp[" + i + "] = " + dp[i] + ", count[" + i + "] = " + count[i]);
						System.out.println(Arrays.toString(dp));
					} else if (dp[j] + 1 == dp[i]) {
						count[i] += count[j];
						// Debugging: Print statements
						System.out.println("Incrementing count[" + i + "] = " + count[i]);
					}
				}
			}
			maxLength = Math.max(maxLength, dp[i]);
			// Debugging: Print statements
			System.out.println("Current maxLength: " + maxLength);
		}

		int result = 0;
		for (int i = 0; i < n; i++) {
			if (dp[i] == maxLength) {
				result += count[i];
				// Debugging: Print statements
				System.out.println("Adding count[" + i + "] = " + count[i] + " to result");
			}
		}

		return result;
	}
}
