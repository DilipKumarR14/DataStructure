package com.sorting;

import java.util.PriorityQueue;

public class KClosestPoint {

	public static void main(String[] args) {
		kClosest(new int[][] { { 1, 3 }, { -2, 2 } }, 1);
	}

	public static int[][] kClosest(int[][] points, int K) {
//		int N = points.length;
//		int[] dists = new int[N];
//		for (int i = 0; i < N; ++i)
//			dists[i] = dist(points[i]);
//
//		Arrays.sort(dists);
//		int distK = dists[K - 1];
//
//		int[][] ans = new int[K][2];
//		int t = 0;
//		for (int i = 0; i < N; ++i) {
//			if (dist(points[i]) <= distK) {
//				ans[t++] = points[i];
//			}
//		}
//		System.out.println(Arrays.toString(ans[0]));
//		return ans;

		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

		for (int[] point : points) {
			int diff = point[0] * point[0] + point[1] * point[1];
			minHeap.offer(new int[] { diff, point[0], point[1] });
		}
		
		System.out.println(minHeap.poll()[0]);

		int[][] ans = new int[K][2];
		int index = 0;
		while (K > 0) {
			int[] point = minHeap.poll();
			ans[index++] = new int[] { point[1], point[2] };
			K--;
		}

		return ans;
	}

	public static int dist(int[] point) {
		return point[0] * point[0] + point[1] * point[1];
	}
}
