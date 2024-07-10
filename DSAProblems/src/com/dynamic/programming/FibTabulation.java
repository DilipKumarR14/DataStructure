package com.dynamic.programming;

import java.util.Arrays;

public class FibTabulation {

	public static void main(String[] args) {

		int n = 50;
		long fibo[] = new long[n + 2];

		int i;
		fibo[1] = 1;

		for (i = 0; i < n; i++) {

			long current = fibo[i];
			fibo[i + 1] = fibo[i + 1] + current;
			fibo[i + 2] = fibo[i + 2] + current;
		}

		// Nth Fibonacci Number
		System.out.println(fibo[n]);

	}
}
