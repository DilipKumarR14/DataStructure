package com.heap;

import java.util.PriorityQueue;

public class MinCostRopes {

	public static void main(String[] args) {
		long[] arr = { 4, 2, 7, 6, 9 };
//		int n = arr.length;
		PriorityQueue<Long> q = new PriorityQueue<>();
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			q.offer(arr[i]);
		}

		while (q.size() >= 2) {
			long a = q.poll();
			long b = q.poll();

			long c = a + b;
			sum += c;
			q.offer(c);
		}

		System.out.println(sum);
	}

}
