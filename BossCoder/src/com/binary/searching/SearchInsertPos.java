package com.binary.searching;

public class SearchInsertPos {

	public static void main(String[] args) {
		int[] nu = { 1 };
		int target = 2;
		int searchInsert = searchInsert(nu, target);
		
		System.out.println(searchInsert);
	}

	public static int searchInsert(int[] nums, int target) {
		int n = nums.length;
		int l = 0, r = n;
		for (int i = 0; i < n-1; i++) {
			int mid = (l + r) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[mid] < target) {
				l = mid - 1;
			} else {
				r = mid + 1;
			}
		}

		return l;
	}

}
