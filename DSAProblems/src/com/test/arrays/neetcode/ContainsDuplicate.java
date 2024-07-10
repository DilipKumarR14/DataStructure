package com.test.arrays.neetcode;

import java.util.Arrays;

public class ContainsDuplicate {

	public static void main(String[] args) {
		boolean extracted = extracted();

		System.out.println(extracted);

	}

	private static boolean extracted() {
		int[] nums = { 1,2,3,1 };
		System.out.println(Arrays.toString(nums));

		for (int i = 1; i < nums.length; i++) {
			int j = i - 1;
			int t=nums[i];
			
			while (j >= 0 &&  t< nums[j]) {
				nums[j + 1] = nums[j];
				System.out.println("while "+Arrays.toString(nums));
				j--;
			}
			if (j >= 0 && nums[j] == t) {
				return true;
			}
			nums[j + 1] = t;
			
			System.out.println(Arrays.toString(nums));

		}
		return false;
	}

}
