package com.recusrion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3 };
		SubSet.subsets(nums);
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
		list.add(new ArrayList<>(tempList));
		System.out.println("Main List : " + list);

		System.out.println("Subset added: " + tempList);

		for (int i = start; i < nums.length; i++) {
			System.out.println("i: " + i);

			tempList.add(nums[i]);
			System.out.println("Element added to subset: " + nums[i]);
			System.out.println("Calling backtrack recursively with tempList: " + tempList);
			backtrack(list, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
			System.out.println("Backtracking - Removed last element from tempList: " + tempList);
		}
	}

}
