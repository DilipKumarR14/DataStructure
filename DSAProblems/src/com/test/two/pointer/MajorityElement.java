package com.test.two.pointer;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	public static void main(String[] args) {
		extracted();

	}

	private static int extracted() {
		int[] nums = { 6, 5, 5 };

		HashMap<Integer, Integer> hmap = new HashMap();
//		Integer maxKey;

		int n = nums.length;
		for (int i = 0; i < n; i++) {
			System.out.println(">>> " + nums[i]);
			if (!hmap.containsKey(nums[i])) {
				hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
			}
			Integer integer = hmap.get(nums[i]);
			hmap.put(nums[i], integer + 1);
			System.out.println(Math.floor(n / 2));
			if (integer >= Math.ceil(n / 2)) {
				System.out.println("--- " + nums[i]);
				return nums[i];
			}
		}
		return n;

//		int maxValue = 0;
//		for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
//			if (entry.getValue() > maxValue) {
//				maxValue = entry.getValue();
//				maxKey = entry.getKey();
//			}
//		}
//		System.out.println(maxValue);
	}

}
