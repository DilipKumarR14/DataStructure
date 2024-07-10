package com.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumAbsDiff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> main = new ArrayList<>();

		int[] nums = { 4, 2, 1, 3 };

		minimumAbsDifference(nums);

		int n = nums.length;
		int min = Integer.MAX_VALUE;

		Arrays.sort(nums);

		for (int i = 0; i < n - 1; i++) {

			int diff = Math.abs(nums[i + 1] - nums[i]);
			ArrayList<Integer> arr = new ArrayList<>();
			if (diff < min) {

				main.clear();

				min = diff;

				extracted(main, nums, i, arr);

			} else if (diff == min) {
				extracted(main, nums, i, arr);
			}

		}

		System.out.println(main);
	}

	public static List<List<Integer>> minimumAbsDifference(int[] arr) {
		List<List<Integer>> result = new ArrayList<>();

		// Step 1: Find the minimum absolute difference
		int minAbsDiff = Integer.MAX_VALUE;
		System.out.println(Arrays.toString(arr));
		for (int i = 1; i < arr.length; i++) {
			int currentDiff = Math.abs(arr[i] - arr[i - 1]);
			minAbsDiff = Math.min(minAbsDiff, currentDiff);
		}

		// Step 2: Find all pairs with the minimum absolute difference using a Map
		for (int i = 1; i < arr.length; i++) {
			int currentDiff = Math.abs(arr[i] - arr[i - 1]);
			if (currentDiff == minAbsDiff) {
				List<Integer> pair = new ArrayList<>();
				pair.add(arr[i - 1]);
				pair.add(arr[i]);
				result.add(pair);
			}
		}
		System.out.println(result);
		System.exit(1);
		return result;
	}

	private static void extracted(List<List<Integer>> main, int[] nums, int i, ArrayList<Integer> arr) {
		arr.add(nums[i]);
		arr.add(nums[i + 1]);

		main.add(arr);
	}

}
