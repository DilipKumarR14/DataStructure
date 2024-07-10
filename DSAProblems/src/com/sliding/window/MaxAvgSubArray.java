package com.sliding.window;

public class MaxAvgSubArray {

	public static void main(String[] args) {
		double findMaxAverage = findMaxAverage(new int[] { 1, 12, -5, -6, 50, 3 }, 4);

		System.out.println(findMaxAverage);
	}

	public static double findMaxAverage(int[] nums, int k) {
		long sum = 0;

		for (int i = 0; i < k; i++) {
			sum += nums[i];
		}

		long max = sum;

		for (int j = k; j < nums.length; j++) {
			int i = nums[j];
			int l = nums[j - k];
			sum = sum + i - l;
			max = Math.max(max, sum);
		}

		return max / 1.0 / k;
	}

}
