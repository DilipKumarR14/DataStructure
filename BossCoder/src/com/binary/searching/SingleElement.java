package com.binary.searching;

public class SingleElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
		int singleNonDuplicate = singleNonDuplicate(nums);
	}

	public static int singleNonDuplicate(int[] nums) {
		// int ele = 0;
		// for(int i: nums){
		// ele^=i;
		// }
		// return ele;

		int L = 0, R = nums.length - 1, mid = 0;
		/**
		 * nums = [1,2,2,3,3,4,4,8,8]
		 * 
		 * 1. [L = 0, R = 8] => mid = 4 and nums[mid] == nums[mid-1] The left half
		 * length is even and 1 element is equal to nums[mid]. This tells us that left
		 * half is left with odd elements to pair up with each other One element will be
		 * left out which is our answer. So search in left half - [0, 2] We decremented
		 * R by 2 to keep remaining search space of odd length so we can repeat same
		 * process
		 * 
		 * 2. [L = 0, R = 2] => mid = 1 and nums[mid] == nums[mid+1] The left half is of
		 * odd length and one element cant be paired with another. So our answer exist
		 * in left half. So search in left half - [0, 0]
		 * 
		 * 3. [L = 0, R = 0] => mid = 1 and nums[mid] != nums[mid-1] and nums[mid] !=
		 * nums[mid+1] This means nums[mid] is our final answer since it is not equal to
		 * either of its neighbours
		 */
		while (L <= R) {
			mid = (L + R) >>> 1; // Using >>> for unsigned right shift in Java
			boolean isHalfEven = (mid - L) % 2 == 0;

			if (mid + 1 < nums.length && nums[mid] == nums[mid + 1]) {
				if (isHalfEven) {
					L = mid + 2;
				} else {
					R = mid - 1;
				}
			} else if (mid > 0 && nums[mid] == nums[mid - 1]) {
				if (isHalfEven) {
					R = mid - 2;
				} else {
					L = mid + 1;
				}
			} else {
				return nums[mid];
			}
		}

		return -1;
	}
}
