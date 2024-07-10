package com.test.two.pointer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiffArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		findDifference(new int[] { 1, 2, 3 }, new int[] { 2, 4, 6 });

	}

	public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
		List<List<Integer>> res = new ArrayList<>();
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		for (int n : nums1) {
			set1.add(n);
		}

		for (int n : nums2) {
			set2.add(n);
		}
		List<Integer> ans1 = new ArrayList<>(set1);
		List<Integer> ans2 = new ArrayList<>(set2);

		ans1.removeAll(set2);
		ans2.removeAll(set1);

		res.add(ans1);
		res.add(ans2);
		
		System.out.println(res);
		return res;
	}

}
