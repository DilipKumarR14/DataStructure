package com.recursion;

import java.util.*;

public class ReversePairs {

	public static void main(String[] args) {
		ReversePairs solution = new ReversePairs();
		int[] nums = {2,4,3,5,1 };
		System.out.println(solution.reversePairs(nums)); // Example usage
	}

	public int reversePairs(int[] nums) {
		int[] reversePairsCount = { 0 };
		mergeSort(nums, 0, nums.length - 1, reversePairsCount);
		return reversePairsCount[0];
	}

	private void mergeSort(int[] nums, int low, int high, int[] reversePairsCount) {
		if (low >= high) {
			return;
		}

		int mid = (low + high) >>> 1;
		mergeSort(nums, low, mid, reversePairsCount);
		mergeSort(nums, mid + 1, high, reversePairsCount);
		merge(nums, low, mid, high, reversePairsCount);
	}

	private void merge(int[] nums, int low, int mid, int high, int[] reversePairsCount) {
		int j = mid + 1;
		for (int i = low; i <= mid; i++) {
			while (j <= high && (long) nums[i] > 2 * (long) nums[j]) {
				j++;
			}
			reversePairsCount[0] += j - (mid + 1);
		}

		int size = high - low + 1;
		int[] temp = new int[size];
		int left = low, right = mid + 1, k = 0;

		while (left <= mid && right <= high) {
			if (nums[left] < nums[right]) {
				temp[k++] = nums[left++];
			} else {
				temp[k++] = nums[right++];
			}
		}

		while (left <= mid) {
			temp[k++] = nums[left++];
		}

		while (right <= high) {
			temp[k++] = nums[right++];
		}

		int m = 0;
		for (int i = low; i <= high; i++) {
			nums[i] = temp[m++];
		}
	}

}
