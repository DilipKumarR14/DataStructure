package com.bit.manipulation;

public class FactorialTrailingZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		trailingZeroes(13);
	}

	public static int trailingZeroes(int n) {
		long num = factorial(n);
		System.out.println(num);
		int count = 0;

		while (num > 0) {
			if (num % 10 == 0) {
				count++;
				num /= 10;
			} else {
				break;
			}
		}
		System.out.println(count);
		return (int) count;
	}

	public static long factorial(int n) {
		if (n == 0 || n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

}
