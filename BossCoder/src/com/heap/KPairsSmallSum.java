package com.heap;

import java.util.ArrayList;
import java.util.List;

public class KPairsSmallSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 1, 7, 11 };
		int[] nums2 = { 2, 4, 6 };
		int k = 3;
		kSmallestPairs(nums1, nums2, k);
	}

	public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

		int len1 = nums1.length;
		int len2 = nums2.length;
		int i = 0, j = 0;
		List<List<Integer>> main = new ArrayList<List<Integer>>();
		int count = 0;
		for (i = 0; i < len1; i++) {
			for (j = 0; j < len2; j++) {
//				if (count < k) {
//					count++;
				List<Integer> list = new ArrayList<Integer>();
				list.add(nums1[i]);
				list.add(nums2[j]);
				main.add(list);
//				}

			}
		}

		System.out.println(main);
		int min = Integer.MAX_VALUE;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int a = 0; a < main.size(); a++) {
			List<Integer> list = main.get(a);
			System.out.println("list " + list);
			int sum = 0;
			for (int b = 0; b < list.size(); b++) {
				sum += list.get(b);
			}
			if (sum < min) {
				min = sum;
				res.add(list);
			}

		}
		System.out.println(res);
		return main;

	}

}
