package com.test.arrays.neetcode;

public class SecondSmallAndSecLarge {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 6, 7, 5 };
		int n = arr.length;

		int small = Integer.MAX_VALUE;
		int second_small = Integer.MAX_VALUE;

		for (int ele : arr) {
			small = Math.min(small, ele);
		}

		System.out.println(small);

		for (int ele : arr) {
			if (ele < second_small && ele != small) {
				second_small = ele;
			}
			System.out.println(second_small); 
		}

	}

}
