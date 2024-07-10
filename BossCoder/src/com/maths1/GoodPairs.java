package com.maths1;

public class GoodPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		extracted();
	}

	private static int extracted() {
		int pairs = 0;
		int[] nums = { 1, 1, 2, 3, 1, 5, 3 };
		int[] count = new int[100];
		for (int i = 0; i < nums.length; i++) {
			int currentNumIdx = nums[i] - 1;
			count[currentNumIdx]++;
			if (count[currentNumIdx] > 1) {
				pairs += count[currentNumIdx] - 1;
			}
		}
		System.out.println(pairs);
		return pairs;
	}

}
