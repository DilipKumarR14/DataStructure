package com.binary.search;

public class RotateArray {

	public static void main(String[] args) {

		int[] num = { 3, 4, 5, 2 };
		int findMin = findMin(num);
		System.out.println(findMin);

	}

	

	public static int findMin(int[] nums) {
		int low = 0;
		int high = nums.length - 1;

		while (low < high) {
			int mid = (low + (high - low) / 2);

			if (nums[mid] < nums[high]) {

				high = mid;

			} else {
				low = mid + 1;
			}
		}

		return low;

	}

//	int left = 0, right = nums.length -1;
//    while(left < right) {
//        // Prevent overflow
//        int middle = left + (right - left) / 2;
//        // If we find a value less than the right side, we can ignore the rest of the right side
//        if(nums[middle] < nums[right])
//            // We avoid middle - 1 as middle can be the smallest value
//            right = middle;
//        else
//        // Otherwise we can ignore the entirety of the left side
//            left = middle + 1;
//    }
//    // Return the leftmost value 
//    return nums[left];

}
