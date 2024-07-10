package com.basic;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(1, 1);
		hashMap.put(2, 2);

		long start = System.currentTimeMillis();
		double fibo = fibo(10, hashMap);
		long end = System.currentTimeMillis();
		float sec = (end - start) / 1000F;
		System.out.println(sec + " seconds");

		System.out.println("fibo " + fibo);
	}

	public static int fibo(int n, Map<Integer, Integer> hashMap) {

		int i = 1;
		if (hashMap.containsKey(n)) {
			return hashMap.get(n);
		}
		if (n <= 2) {
			i = 1;
		} else {
			i = fibo(n - 1, hashMap) + fibo(n - 2, hashMap);
		}
		hashMap.put(n, i);
		return i;
	}

}
