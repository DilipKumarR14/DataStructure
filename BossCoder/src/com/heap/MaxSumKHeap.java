package com.heap;

import java.util.PriorityQueue;

public class MaxSumKHeap {

	public static void main(String[] args) {

		Solution3121 solution = new Solution3121();
		int largestSumAfterKNegations = solution.largestSumAfterKNegations(new int[] { 4, 2, 3 }, 1);
		
		System.out.println(largestSumAfterKNegations);
	}

}

class Solution3121 {
	private int findSum(PriorityQueue<Integer> pq) {
		int sum = 0;
		for (int x : pq) {
			sum += x;
		}

		return sum;
	}

	public int largestSumAfterKNegations(int[] nums, int k) {
		// pq == minHeap;

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int x : nums) {
			pq.add(x);
		}

		while(!pq.isEmpty()) {
			System.out.print("start "+pq.peek() + " ");
		}
		while (k-- > 0) {
			pq.add(pq.poll() * -1);
		}
		
		while(!pq.isEmpty()) {
			System.out.print("negate "+pq.peek() + " ");
		}
		pq.stream().forEach(System.out::println);

		return findSum(pq);
		// k even smallest value negative

		// k odd smallest value negative

		// k even smallest value positive

		// k odd smallest value positive
	}
}