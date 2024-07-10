package com.bit.manipulation;

public class CountSetBits {

	public static void main(String[] args) {
		int count = 0, num = 7;
		for (int i = 4; i >= 0; --i) {
			if ((num & (1 << i)) != 0) {
				count++;
			}
		}

		System.out.println(count);
	}

}
