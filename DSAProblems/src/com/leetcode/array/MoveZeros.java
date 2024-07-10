package com.leetcode.array;

import java.util.Arrays;

public class MoveZeros {

	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 3, 12 };
		int n = nums.length;
		int j = 1;
		System.out.println(Arrays.toString(nums));

		for (int i = 0; j < n && i < n;) {
			if (nums[i] == 0) {
				if (nums[j] != 0) {
					int temp = nums[i];
					nums[i++] = nums[j];
					nums[j++] = temp;
					// j++;
					// i++;
				} else {
					j++;
				}
			} else {
				i++;
			}
			System.out.println(Arrays.toString(nums));
		}
	}

}
