package com.heap;

import java.util.Iterator;
import java.util.PriorityQueue;

public class MaxSumArrKNegation {

	public static void main(String[] args) {

		Solution solution = new Solution();
		solution.largestSumAfterKNegations(new int[] { 4, 2, 3 }, 1);

	}

}

class Solution {
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
		while (k-- > 0) {
			pq.add(pq.poll() * -1);
		}
		
		return findSum(pq);
		// k even smallest value negative

		// k odd smallest value negative

		// k even smallest value positive

		// k odd smallest value positive
	}
}