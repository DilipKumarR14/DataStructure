package com.binary.searching;

public class PeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int findPeakElement = findPeakElement(new int[] {1,2,3,1});
		
		System.out.println(findPeakElement);
	}

	public static int findPeakElement(int[] nums) {
		if (nums.length == 1)
			return 0;
		int l = 0;
		int r = nums.length - 1;

		while (l <= r) {
			int m = l + (r - l) / 2;
			// left bigger
			int i = nums[m - 1];
			int j = nums[m];
			if (m > 0 && i > j) {
				r = m - 1;
			}
			// right bigger
			else if (m < nums.length - 1 && j < nums[m + 1]) {
				l = m + 1;
			}
			// found the peak
			else {
				return m;
			}
		}
		return -1;
	}
}
