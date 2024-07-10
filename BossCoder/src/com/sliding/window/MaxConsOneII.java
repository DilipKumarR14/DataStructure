package com.sliding.window;

public class MaxConsOneII {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 0, 1, 1, 0, 1, 0 };

		int left = 0, right = 0;


		int zeroCount = 0;
		int maxOnesCount = 0;
		int k=1;

		while (right < arr.length) {
			if (arr[right] == 0) {
				zeroCount++;
			}
			// Shrink the window if zero count exceeds 1
			while (zeroCount > k) {
				if (arr[left] == 0) {
					zeroCount--;
				}
				left++;
			}
			maxOnesCount = Math.max(maxOnesCount, right - left + 1);
			right++;
		}
		System.out.println(maxOnesCount);
	}
}
