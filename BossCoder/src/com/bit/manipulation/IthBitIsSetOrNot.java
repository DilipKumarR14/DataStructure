package com.bit.manipulation;

public class IthBitIsSetOrNot {

	public static void main(String[] args) {
		int n = 4;
		//for (int i = 3; i >= 0; i--) {
		//0100 - 1 is the 2nd bit
			if ((n & (1 << 2)) != 0) {
				//System.out.print((n >> i) & 1);
				System.out.println(true);
			} else {
				//System.out.print((n >> i) & 1);
				System.out.println(false);
			}
		//}
	}
}