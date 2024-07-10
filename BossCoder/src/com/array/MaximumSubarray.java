package com.array;

public class MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		maxSubArray(arr);

	}

	public static int maxSubArray(int[] nums) {

		int maxSum = Integer.MIN_VALUE;
		int cursum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (cursum < 0) {
				cursum = 0;
			}
			cursum = cursum + nums[i];
			maxSum = Math.max(maxSum, cursum);
		}
		System.out.println(maxSum);
		return maxSum;

	}
}
