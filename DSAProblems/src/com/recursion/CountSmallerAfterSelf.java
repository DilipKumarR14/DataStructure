package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class CountSmallerAfterSelf {

	public static List<Integer> countSmaller(int[] nums) {
		int len = nums.length;
		int[] res = new int[len];
		int[] indexArray = new int[len];
		for (int i = 0; i < len; i++) {
			indexArray[i] = i;
		}

		mergeSort(nums, indexArray, res, 0, len - 1);

		List<Integer> result = new ArrayList<>();
		for (int count : res) {
			result.add(count);
		}
		return result;
	}

	private static void mergeSort(int[] nums, int[] indexes, int[] res, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(nums, indexes, res, low, mid);
			mergeSort(nums, indexes, res, mid + 1, high);
			merge(nums, indexes, res, low, mid, high);
		}
	}

	private static void merge(int[] nums, int[] indexes, int[] res, int low, int mid, int high) {
		int leftSize = mid - low + 1;
		int[] leftIndexes = new int[leftSize];
		int[] rightIndexes = new int[high - mid];

		for (int i = 0; i < leftSize; i++) {
			leftIndexes[i] = indexes[low + i];
		}

		for (int i = 0; i < rightIndexes.length; i++) {
			rightIndexes[i] = indexes[mid + 1 + i];
		}

		int i = 0, j = 0, k = low, rightCount = 0;

		while (i < leftSize && j < rightIndexes.length) {
			if (nums[leftIndexes[i]] <= nums[rightIndexes[j]]) {
				indexes[k++] = leftIndexes[i];
				res[leftIndexes[i]] += rightCount;
				i++;
			} else {
				indexes[k++] = rightIndexes[j++];
				rightCount++;
			}
		}

		while (i < leftSize) {
			indexes[k++] = leftIndexes[i];
			res[leftIndexes[i]] += rightCount;
			i++;
		}

		while (j < rightIndexes.length) {
			indexes[k++] = rightIndexes[j++];
		}
	}

	public static void main(String[] args) {
		int[] nums = { 5, 2, 6, 1 };
    	List<Integer> countSmaller = countSmaller(nums);
    	
    	System.out.println(countSmaller);
	}
}
