package com.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsSmallestSum {

	public static void main(String[] args) {
		int[] nums1 = { 1, 7, 11 };
		int[] nums2 = { 5, 4, 6 };
		int k = 3;
		List<List<Integer>> result = kSmallestPairs(nums1, nums2, k);

	}

	public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> result = new ArrayList<>();

		// Edge case: If any array is empty or k is 0, return empty result
		if (nums1.length == 0 || nums2.length == 0 || k == 0)
			return result;

		// Use a min heap to store pairs sorted by sum of elements
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

		// Initialize heap with first pair from nums1 and each element from nums2
		for (int i = 0; i < Math.min(nums1.length, k); i++) {
			pq.offer(new int[] { nums1[i], nums2[0], 0 }); // {num1, num2, index in nums2}
		}

		// Take the k smallest pairs from the heap and add them to result
		while (k-- > 0 && !pq.isEmpty()) {
			int[] pair = pq.poll();
			result.add(List.of(pair[0], pair[1])); // Add current pair to result
			// If there are more elements in nums2 for current nums1 element, add next pair
			if (pair[2] + 1 < nums2.length) {
				pq.offer(new int[] { pair[0], nums2[pair[2] + 1], pair[2] + 1 });
			}
		}

		return result;

	}

}
