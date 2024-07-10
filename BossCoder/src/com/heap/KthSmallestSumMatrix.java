package com.heap;

import java.util.PriorityQueue;

public class KthSmallestSumMatrix {

	public static void main(String[] args) {
		int[][] mat = new int[][] {{1,3,11}, {2,4,6}};
		 PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		    for (int i = 0; i < mat.length; i++) {
		        for (int j = 0; j < mat[0].length; j++) {
		        	int sum = mat[i][j];
		            pq.offer(sum);
		        }
		    }
	}

}
