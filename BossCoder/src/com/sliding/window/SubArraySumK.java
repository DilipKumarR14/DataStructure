package com.sliding.window;

import java.util.HashMap;

public class SubArraySumK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SubArraySumK subArraySumK = new SubArraySumK();

		int subarraySum = subArraySumK.subarraySum(new int[] { 1, 1, 1 }, 2);
		System.out.println(subarraySum);
	}

	public int subarraySum(int[] nums, int k) {
		int count = 0, sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			int key = sum - k;
			if (map.containsKey(key)) {
				count += map.get(key);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
			// Print statements for debugging
			System.out.println("Map: " + map);

			System.out.println("i=" + i + ", sum=" + sum + ", count=" + count);
		}
		return count;
	}
}
