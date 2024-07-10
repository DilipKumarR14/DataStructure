package com.two.pointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 1, 2, 3 };
		int k = 3;
		int subarraySum = subarray(nums, 2);

//		int subarraySum = subarraySum(nums, k);

		System.out.println(subarraySum);
	}

	public static int subarray(int[] nums, int k) {
		int sum = 0, result = 0;
		Map<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, 1);

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			System.out.println("sum "+sum);
			if (preSum.containsKey(sum - k)) {
				result += preSum.get(sum - k);
				System.out.println("result "+result);
			}
			preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
			System.out.println("preSum "+preSum);
		}

		return result;

	}

	public static int subarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> hm = new HashMap<>();

		// Do one run to store count of prefix sums in hashmap.
		// Then do another run counting the subarrays.
		System.out.println("before counting " + Arrays.toString(nums));

		hm.put(nums[0], 1);
		for (int i = 1; i < nums.length; i++) {
			nums[i] += nums[i - 1];
			hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
		}

		System.out.println(hm);

		int out = 0;

		out += hm.getOrDefault(k, 0);

		System.out.println("after counting " + Arrays.toString(nums));

		for (int i = 0; i < nums.length; i++) {
			// reduce own count
			int count = hm.getOrDefault(nums[i], 0);
			hm.put(nums[i], count - 1);

			System.out.println("looping, hm : " + hm);

			int key = k + nums[i];
			out += hm.getOrDefault(key, 0);
			
			System.out.println("looping, out : " + out);
		}

		return out;
	}

}
