package com.recursion;

public class SumNatrualNumbers {

	public static void main(String[] args) {

		int n = 10;

		int sum = 0;
		int printNum = printNum(n, sum);

		System.out.println(printNum);

	}

	private static int printNum(int n, int sum) {

		if (n == 0) {
			return sum;
		}

		sum = sum + n;

		return printNum(n - 1, sum);

	}

}
