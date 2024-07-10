package com.assesement;

public class DiffElementSumDigitSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = { 1, 2, 3, 4 };
		int ele = 0;
		int dig = 0;

		for (int n : num) {
			ele += n;

			while (n != 0) {
				dig += n % 10;
				n /= 10;
			}
		}

		System.out.println("ele " + ele);
		System.out.println("dig " + dig);

		System.out.println(Math.abs(ele - dig));

	}

}
