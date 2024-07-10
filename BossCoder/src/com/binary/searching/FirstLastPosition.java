package com.binary.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class FirstLastPosition {

	public static void main(String[] args) {

		int[] arr = { 5, 7, 7, 8, 8, 10 };
		// searchRange(arr, 0);

		int[] sol2 = sol2(arr, 8);
		System.out.println("sol2 : " + Arrays.toString(sol2));

	}

	public static int[] searchRange(int[] nums, int target) {

		int low = 0;
		int high = nums.length - 1;
		HashSet<Integer> res = new HashSet<Integer>();

		while (low < high && high > low) {
			int mid = (low + high) / 2;
			if (nums[mid] == target) {
				res.add(mid);
				if (nums[mid] == nums[mid + 1]) {
					high = mid - 1;
					res.add(mid + 1);

				} else if (nums[mid] == nums[mid - 1]) {
					high = mid - 1;
					res.add(mid - 1);

				}
			} else if (nums[mid] < target) {
				low = mid;
			} else {
				high = mid - 1;
			}
		}

		int[] arr = new int[res.size()];
		int j = 0;
		for (Integer i : res) {
			arr[j++] = i;
		}
		System.out.println("arr : " + Arrays.toString(arr));
		System.out.println("res : " + res);

		if (arr.length > 1) {
			return arr;
		} else {
			return new int[] { -1, -1 };

		}
	}

	public static int[] sol2(int[] nums, int target) {
		int first = findFirst(nums, target);
		int last = findLast(nums, target);
		return new int[] { first, last };
	}

	private static int findFirst(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		int first = -1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				first = mid;
				right = mid - 1;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return first;
	}

	private static int findLast(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		int last = -1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				last = mid;
				left = mid + 1;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return last;
	}

}
