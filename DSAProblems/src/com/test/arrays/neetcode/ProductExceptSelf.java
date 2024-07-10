package com.test.arrays.neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ProductExceptSelf {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		// productExceptSelf(nums);

		proSol1(nums);
	}

	public static int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int ans[] = new int[n];
		Arrays.fill(ans, 1);
		int curr = 1;
		for (int i = 0; i < n; i++) {
			ans[i] = ans[i] * curr;
			curr = curr * nums[i];
		}
		curr = 1;
		for (int i = n - 1; i >= 0; i--) {
			ans[i] *= curr;
			curr *= nums[i];
		}
		return ans;
	}

	public static int[] proSol1(int[] nums) {

		int[] prefixArr = new int[nums.length];
		int prefix = 1;
		Arrays.fill(prefixArr, 1);
		System.out.println(Arrays.toString(prefixArr));
		for (int i = 0; i < prefixArr.length; i++) {
			prefixArr[i] = prefixArr[i] * prefix;
			prefix = prefix * nums[i];
			System.out.println("prefix loop " + Arrays.toString(prefixArr));
		}

		int postfix = 1;
		for (int i = prefixArr.length - 1; i >= 0; i--) {
			prefixArr[i] = prefixArr[i] * postfix;
			postfix = postfix * nums[i];
			System.out.println("postfix loop " + Arrays.toString(prefixArr));
		}

		System.out.println(Arrays.toString(prefixArr));

		return null;

	}

}
