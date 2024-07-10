package com.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsSol2 {

	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> pairs = new ArrayList<>();

		// Step 2: Generate all possible pairs and calculate their sums
		for (int u : nums1) {
			for (int v : nums2) {
				List<Integer> pair = new ArrayList<>();
				pair.add(u);
				pair.add(v);
				pair.add(u + v);
				pairs.add(pair);
			}
		}

		System.out.println(pairs);

		// Step 4: Sort the list based on the sums
		pairs.sort((a, b) -> a.get(2) - b.get(2));

		System.out.println(pairs);

		// Step 5: Return the first k pairs
		List<List<Integer>> result = new ArrayList<>();
		int min = Math.min(k, pairs.size());
		for (int i = 0; i < min; i++) {
			List<Integer> subList = pairs.get(i).subList(0, 2);
			result.add(subList);
		}

		return result;
	}

	public static void main(String[] args) {
		KPairsSol2 solution = new KPairsSol2();

		// Example usage:
		int[] nums1_example1 = { 1, 7, 11 };
		int[] nums2_example1 = { 2, 4, 6 };
		int k_example1 = 3;

//		List<List<Integer>> result_example1 = solution.kSmallestPairs(nums1_example1, nums2_example1, k_example1);
//		System.out.println(result_example1);

		solution.kSmallestPairsSolution2(nums1_example1, nums2_example1, k_example1);

	}

	public List<List<Integer>> kSmallestPairsSolution2(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> resV = new ArrayList<>(); // Result list to store the pairs
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		// Priority queue to store pairs with smallest sums, sorted by the sum

		// Push the initial pairs into the priority queue
		for (int x : nums1) {
			pq.offer(new int[] { x + nums2[0], 0 }); // The sum and the index of the second element in nums2
		}

		while (!pq.isEmpty()) {
			System.out.println(Arrays.toString(pq.poll()));
		}

		// Pop the k smallest pairs from the priority queue
		while (k > 0 && !pq.isEmpty()) {
			int[] pair = pq.poll();
			int sum = pair[0]; // Get the smallest sum
			int pos = pair[1]; // Get the index of the second element in nums2

			List<Integer> currentPair = new ArrayList<>();
			currentPair.add(sum - nums2[pos]);
			currentPair.add(nums2[pos]);
			resV.add(currentPair); // Add the pair to the result list

			// If there are more elements in nums2, push the next pair into the priority
			// queue
			if (pos + 1 < nums2.length) {
				pq.offer(new int[] { sum - nums2[pos] + nums2[pos + 1], pos + 1 });
			}

			k--; // Decrement k
		}

		return resV; // Return the k smallest pairs
	}
}
