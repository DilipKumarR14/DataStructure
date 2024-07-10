package com.test.arrays.neetcode;

import java.util.Arrays;

public class LongestConsNum {

	public static void main(String[] args) {
		int[] num = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };

//		int hasConse = hasConse(num);
//		System.out.println(hasConse);
		int hasConseSolPrac = hasConseSolPrac(num);
		System.out.println(hasConseSolPrac);

	}

	private static int hasConse(int[] num) {
		if (num.length == 0) {
			return 0;
		}
		Arrays.sort(num);
		int count = 1;
		int diff = 1;
		int maxCount = 1;
		System.out.println(Arrays.toString(num));
		for (int i = 1; i < num.length; i++) {
			int fi = num[i];
			int se = num[i - 1];
			if (fi - se == diff) {
				count++;
			} else if (fi - se != 0) {
				maxCount = Math.max(count, maxCount);
				count = 1;
			}
			maxCount = Math.max(count, maxCount);

		}

		System.gc();
		return maxCount;
	}

	private static int hasConseSolPrac(int[] nums) {
		if (nums.length == 0) {
			return nums.length;
		}
		Arrays.sort(nums);

		int count = 1;
		int diff = 1;
		int maxCount = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] - nums[i - 1] == diff) {
				count++;
			} else if (nums[i] - nums[i - 1] != 0) {
				maxCount = Math.max(count, maxCount);
				count = 1;
			}
			maxCount = Math.max(count, maxCount);
		}

		return maxCount;

	}

}
