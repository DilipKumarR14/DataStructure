package com.graph;

import java.util.Arrays;
import java.util.HashMap;

public class LongestAritemticSubseq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solutresn solutresn = new Solutresn();

		int longestArithSeqLength = solutresn.longestArithSeqLength(new int[] { 9, 4, 7, 2, 10 });

	}

}

class Solutresn {
	public int longestArithSeqLength(int[] nums) {
		int n = nums.length;
		int maxLength = 2;

		// dp[i][diff] stores the length of the longest arithmetic subsequence ending at
		// index i with difference diff
		HashMap<Integer, Integer>[] dp = new HashMap[n];

		for (int i = 0; i < n; i++) {
			dp[i] = new HashMap<>();
			for (int j = 0; j < i; j++) {
				int diff = nums[i] - nums[j];
				
				dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
				
				System.out.println(Arrays.toString(dp));
				
				maxLength = Math.max(maxLength, dp[i].get(diff));
			}
		}

		System.out.println(Arrays.toString(dp));

		return maxLength;
	}
}