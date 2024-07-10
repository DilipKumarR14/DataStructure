package com.array;

import java.util.Arrays;

public class RunningSumof1dArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 1, 2, 3, 4 };

		int[] runningSum = runningSum(arr);

	}

	public static int[] runningSum(int[] nums) {
		// int[] sum = new int[nums.length];
		// sum[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			nums[i] = nums[i - 1] + nums[i];
		}

		System.out.println(Arrays.toString(nums));

		return nums;
	}
}
