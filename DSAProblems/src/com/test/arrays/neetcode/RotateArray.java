package com.test.arrays.neetcode;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {

		int[] arr = { -1, -100, 3, 99 };
		int k = 2;
		rotate(arr, k);
	}

	public static void rotate(int[] nums, int k) {
		System.out.println(Arrays.toString(nums));

		int length = nums.length;
		int[] arr = new int[length];
		int j = 0;
		for (int i = length - k; i < length; i++) {
			arr[j++] = nums[i];
		}

		System.out.println("j " + j);
		int l = 0;
		for (int a = j; a < arr.length; a++) {
			arr[j++] = nums[l++];
		}
		
		nums = arr;

		System.out.println(Arrays.toString(nums));
	}
}
