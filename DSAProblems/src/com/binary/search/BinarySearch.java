package com.binary.search;

import java.util.Arrays;
import java.util.Iterator;

public class BinarySearch {

	public static void main(String[] args) {
		int[] num = { -1, 0, 3, 5, 9, 12 };
		int target = 2;

		System.out.println(search(num, target));

	}

	public static int search(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}
		System.out.println(Arrays.toString(nums));

		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (nums[mid] < target) {
				low = mid+1;
			} else if (nums[mid] > target) {
				high = mid-1;
			} else if (nums[mid] == target) {
				return mid;
			}
			
			System.gc();
		}
		return -1;

	}

}
