package com.hashing;

import java.util.Arrays;

public class LongestSubArrayZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 9, -3, 3, -1, 6, -5 };
		largestSubArray(arr);
	}

	public static int largestSubArray(int[] nums) {
		int length = nums.length;

		System.out.println(Arrays.toString(nums));

		int max = 0;
		for (int start = 0; start < length; start++) {
			int sum = 0;
			for (int end = start; end < length; end++) {
				sum += nums[end];
				if (sum == 0) {
					max = Math.max(max, end - start + 1);
				}

			}
		}
		System.out.println("max " + max);
		return max;
	}

}
