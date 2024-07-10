package com.bit.manipulation;

public class ConvertDecimalToBinary {

	public static void main(String[] args) {
		int n = 8;

		for (int i = 3; i >= 0; i--) {
			System.out.print((n >> i) & 1);
		}

	}

}
