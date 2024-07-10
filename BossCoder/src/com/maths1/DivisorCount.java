package com.maths1;

public class DivisorCount {

	public static void main(String[] args) {

		int n = 24;
		countDivisor(n);

	}

	private static int countDivisor(int n) {

		int count = 0;
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				if (i * i == n) {
					count++;
				} else {
					count += 2;
				}
			}
		}
		System.out.println(count);
		return count;
	}

}
