package com.maths1;

public class MaxConsecutiveOnes {

	public static void main(String[] args) {
		int[] nums = { 1,0,1,1,0,1};

		findMaxConsecutiveOnes(nums);
	}

	public static int findMaxConsecutiveOnes(int[] nums) {
		int count = 0;
		int finalMax = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				count++;
			} else {
				finalMax = Math.max(finalMax, count);
				count = 0;
			}
		}
		finalMax = Math.max(finalMax, count);

		System.out.println(finalMax);
		return finalMax;
	}
}
