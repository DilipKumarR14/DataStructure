package com.recusrion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationInteger {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };

		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> ds = new ArrayList<>();
		boolean[] freq = new boolean[nums.length];

		recursionPerm(nums, ans, ds, freq);

	}

	private static void recursionPerm(int[] nums, List<List<Integer>> ans, List<Integer> ds, boolean[] freq) {
		if (ds.size() == nums.length) {
			ans.add(new ArrayList<>(ds));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
//			System.out.println("Adding to i: " + i);

			if (!freq[i]) {
				freq[i] = true;

				ds.add(nums[i]);
//				System.out.println("Adding to ds: " + ds);
//				System.out.println("Array after adding: " + Arrays.toString(ds.toArray()));
//				System.out.println("Adding to freq: " + Arrays.toString(freq));

				recursionPerm(nums, ans, ds, freq);

				ds.remove(ds.size() - 1);
//				System.out.println("Removing from ds: " + ds);
//				System.out.println("Array after removing: " + Arrays.toString(ds.toArray()));
//				System.out.println("Removing from freq: " + Arrays.toString(freq));

				freq[i] = false;

			}
		}

	}

}
