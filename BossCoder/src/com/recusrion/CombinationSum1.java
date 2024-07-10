package com.recusrion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum1 {

	public static void main(String[] args) {

		List<List<Integer>> combinationSum = combinationSum(new int[] { 2, 3, 6, 7 }, 7);

		System.out.println(combinationSum);

	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		helper(result, new ArrayList<>(), candidates, target, 0);
		return result;
	}

	public static void helper(List<List<Integer>> result, List<Integer> currentList, int[] candidates, int target,
			int start) {
		if (target == 0) {
			result.add(new ArrayList<>(currentList));
			return;
		}
		for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
			currentList.add(candidates[i]);
			helper(result, currentList, candidates, target - candidates[i], i);// i can be resued
			currentList.remove(currentList.size() - 1);
		}
	}

}