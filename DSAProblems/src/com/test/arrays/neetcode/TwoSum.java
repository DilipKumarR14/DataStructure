package com.test.arrays.neetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		
		int[] twoSum = twoSum(nums,9);
		
		System.out.println(Arrays.toString(twoSum));
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> numMap = new HashMap<>();
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			int complement = target - nums[i];
			if (numMap.containsKey(complement)) {
				return new int[] { numMap.get(complement), i };
			}
			numMap.put(nums[i], i);
		}

		return new int[] {}; // No solution found

	}

}
