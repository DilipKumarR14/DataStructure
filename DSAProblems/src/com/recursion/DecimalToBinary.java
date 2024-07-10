package com.recursion;

public class DecimalToBinary {

	public static void main(String[] args) {
		int n = 4;
		String str = "";
		String conversion = conversion(n, str);

		System.out.println(conversion);

	}

	private static String conversion(int n, String result) {

		if (n == 0) {
			return result;
		}

		result = n % 2 + result;

		return conversion(n / 2, result);

	}

}
