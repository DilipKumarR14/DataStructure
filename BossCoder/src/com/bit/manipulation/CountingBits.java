package com.bit.manipulation;

import java.util.Arrays;

public class CountingBits {

	public static void main(String[] args) {

		int n = 5;
		int[] res = new int[n + 1];
		char bit = '1';
		extracted(n, res, bit);

	}

	private static int[] extracted(int n, int[] res, char bit) {
//		for (int i = 0; i <= n; i++) {
//
//			String binaryString = Integer.toBinaryString(i);
//			char[] charArray = binaryString.toCharArray();
//
//			for (int j = 0; j < charArray.length; j++) {
//				if (charArray[j] == bit) {
//					res[i] = res[i] + 1;
//				} else {
//					if (res[i] == 0) {
//						res[i] = 0;
//					}
//				}
//			}
//			System.out.println(Arrays.toString(res));
//			System.out.println(binaryString);
//
//		}

		int[] ans = new int[n + 1];

		for (int i = 0; i <= n; ++i) {
			int j = i >> 1;
			int j2 = i & 1;
			ans[i] = ans[j] + j2;
			System.out.println(Arrays.toString(ans));

		}

		return ans;
	}

}

class codefile {
	static int find(int[]  input){
        int ones = 0;
        int twos = 0;

        for(final int nu : input){
            ones = ones ^ nu & ~twos;
            twos = twos ^ nu & ~ones;
        }
        return ones;
    }
}
