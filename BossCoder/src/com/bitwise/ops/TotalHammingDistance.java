package com.bitwise.ops;

import java.util.Arrays;

public class TotalHammingDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 4, 14, 2 };
		totalHammingDistance(nums);
	}

	public static int totalHammingDistance(int[] nums) {
		int n = 4;
		int len = nums.length;
		int[] countOfOnes = new int[n];
		for (int i = 0; i < len; i++) {
			int k = nums[i];
			System.out.println("k: " + k);
			for (int j = 0; j < n; j++) {

				int j2 = k >> j;
				countOfOnes[j] += j2 & 1;
				System.out.println(Arrays.toString(countOfOnes));
			}
		}
		int sum = 0;
		System.out.println(Arrays.toString(countOfOnes));
		for (int count : countOfOnes) {
			sum += count * (len - count);
		}
		return sum;
	}

}
