package com.test.dynamic.programming;

public class Knapsack {

	int cache[][];
	static int val[];
	static int wt[];

	public static void main(String[] args) {
		val = new int[] { 150, 300, 200 };
		wt = new int[] { 1, 4, 3 };
		int C = 4;
		int n = val.length;

		method1A1(n, C);
	}

	public static int solveKnapsackM1A1(int i, int C) {

		// Base Case
		if (i == 0 || C <= 0) {
			return 0;
		}

		// If weight of the ith item is more than Knapsack capacity, then
		// this item cannot be included in the optimal solution
		if (wt[i - 1] > C) {
			return solveKnapsackM1A1(i - 1, C);
		}

		// (1) ith item included/selected
		int ith_item_is_selected = val[i - 1] + solveKnapsackM1A1(i - 1, C - wt[i - 1]);

		// (2) not included
		int ith_item_is_not_selected = solveKnapsackM1A1(i - 1, C);

		// Return the maximum of two cases:
		// (1) ith item included/selected
		// (2) not included
		return Math.max(ith_item_is_selected, ith_item_is_not_selected);

	}

	public static void method1A1(int n, int C) {
		long startTime = 0, endTime = 0, executionTime = 0;
		startTime = System.nanoTime();
		System.out.println("recursive solution:solveKnapsackM1A1()");
		System.out.println("output :" + solveKnapsackM1A1(n, C));
		endTime = System.nanoTime();
		executionTime = endTime - startTime;
		System.out.println("executionTime :" + executionTime + " ns \n");

		double elapsedTimeInSecond = (double) executionTime / 1_000_000_000;

		System.out.println(elapsedTimeInSecond + " seconds");

	}
}
