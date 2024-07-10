package com.bit.manipulation;

import java.util.Arrays;

public class BitManipulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] bin = new int[8];
		int n = 17;
		int i = 0;
		for (; i < bin.length; i++) {

			bin[i] = n % 2;
			n /= 2;

		}
		for (int j = i - 1; j >= 0; j--) {
            System.out.print(bin[j]); 

		}
//		System.out.println(Arrays.toString(bin));
	}

}
