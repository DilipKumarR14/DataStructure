package com.array;

import java.util.Arrays;

public class MaxGap {

	public static void main(String[] args) {
		int[] arr = { 3,6,9,1};
		maximumGap(arr);

	}

	public static int maximumGap(int[] nums) {
		int length = nums.length;
		if (length < 2) {
			return 0;
		}

		int i = 0;
		int maxGap = 0;
		Arrays.sort(nums);
		while (i < length - 1) {

			maxGap = Math.max(maxGap, nums[i+1]-nums[i]);
			
			i++;
		}
		System.out.println(maxGap);
		return maxGap;
	}

}
