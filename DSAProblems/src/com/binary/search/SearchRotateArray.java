package com.binary.search;

import java.util.Arrays;

public class SearchRotateArray {

	public static void main(String[] args) {

		int[] num = { 4, 5, 6, 7, 0, 1, 2 };

		System.out.println(Arrays.toString(num));

		int target = 3;

		int searchArr = searchArr(num, target);

		System.out.println("searchArr " + searchArr);

	}

	private static int searchArr(int[] num, int target) {
		int low = 0;
		int high = num.length - 1;

		while (low < high) {
			int mid = low + (high - low) / 2;

			if (num[mid] == target) {
				return mid;
			}

			if (num[low] <= num[mid]) {
				if (target >= num[low]) {
					
				}
			}
		}

		return -1;
	}

}
