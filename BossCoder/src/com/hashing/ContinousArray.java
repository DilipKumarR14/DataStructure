package com.hashing;

public class ContinousArray {

	public static void main(String[] args) {

		Solution121 solution = new Solution121();
		int[] nums = { 0, 1, 0, 1, 0, 1, 1 };
		int maxLength = solution.findMaxLength(nums);
		System.out.println("Maximum length of contiguous subarray with equal number of zeroes and ones: " + maxLength);

	}

}

class Solution121 {

	public int findMaxLength(int[] nums) {
		int maxlen = 0;
		for (int start = 0; start < nums.length; start++) {
			int zeroes = 0, ones = 0;
			for (int end = start; end < nums.length; end++) {
				if (nums[end] == 0) {
					zeroes++;
				} else {
					ones++;
				}
				if (zeroes == ones) {
					maxlen = Math.max(maxlen, end - start + 1);
					// Print the details for debugging
					System.out.println("Equal zeroes and ones found from index " + start + " to " + end);
					System.out.println("Current max length: " + maxlen);
				}
			}
		}
		return maxlen;
	}
}
