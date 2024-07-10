package com.test.two.pointer;

import java.nio.file.attribute.AclEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumMedium {

	public static void main(String[] args) {
		int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };

//		List<List<Integer>> threeSum = threeSum(nums);
//		System.out.println(threeSum);

//		List<List<Integer>> threeSumPrac = threeSumPrac(nums);
//		System.out.println("res " + threeSumPrac);

		List<List<Integer>> threeSumPrac1 = threeSumPrac1(nums);
		System.out.println(threeSumPrac1);
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int n = nums.length;
		if (n < 3) {
			return result;
		}

		Arrays.sort(nums);

		for (int i = 0; i < n - 1; i++) {
			// if current element and prev are
			// same then we will have same scenario so we are skipping it
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int L = i + 1, R = n - 1;
			System.out.println(Arrays.toString(nums));

			while (L < R) {
				int cur = nums[i] + nums[L] + nums[R];
				if (cur == 0) {
					List<Integer> sub = new ArrayList<>();
					sub.add(nums[i]);
					sub.add(nums[L]);
					sub.add(nums[R]);
					result.add(sub);
					L++;
					R--;

					// if the current and prev element are same then move forward
					// and to avoid duplicate elemt in the array
					while (L < R && nums[L] == nums[L - 1]) {
						L++;
					}
//					if the current and next element are same then move backward
					while (L < R && nums[R] == nums[R + 1]) {
						R--;
					}

				} else if (cur < 0) {
					L++;
				} else {
					R--;
				}
			}
		}
		return result;

	}

	public static List<List<Integer>> threeSumPrac(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();

		int length = nums.length;

		if (length < 3) {
			return new ArrayList<>();
		}

		Arrays.sort(nums);

		System.out.println(Arrays.toString(nums));

		for (int i = 0; i < length - 1; i++) {

			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int L = i + 1, R = length - 1;

			while (L < R) {
				int cur = nums[i] + nums[L] + nums[R];

				if (cur == 0) {
					List<Integer> arr = new ArrayList<>();

					arr.add(nums[i]);
					arr.add(nums[L]);
					arr.add(nums[R]);
					res.add(arr);
					L++;
					R--;

					while (L < R && nums[L] == nums[L - 1]) {
						L++;
					}

					while (L < R && nums[R] == nums[R + 1]) {
						R--;
					}
				} else if (cur < 0) {
					L++;
				} else {
					R--;
				}
			}

		}
//		System.out.println(res);
		return res;

	}

	public static List<List<Integer>> threeSumPrac1(int[] nums) {

		List<List<Integer>> res = new ArrayList<>();
		
		Arrays.sort(nums);

		int length = nums.length;
		if (length < 3) {
			return new ArrayList<>();
		}

		for (int i = 0; i < length - 1; i++) {

			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int L = i+1, R = length-1;

			while (L < R) {
				int curr = nums[i] + nums[L] + nums[R];
				if (curr == 0) {
					ArrayList<Integer> arr = new ArrayList<>();
					arr.add(nums[i]);
					arr.add(nums[L]);
					arr.add(nums[R]);
					res.add(arr);
					
					L++;
					R--;

					while (L < R && nums[L] == nums[L - 1]) {
						L++;
					}
					while (L < R && nums[R] == nums[R + 1]) {
						R--;
					}

				} else if (curr < 0) {
					L++;
				} else {
					R--;
				}
			}

		}

		return res;
	}

}
