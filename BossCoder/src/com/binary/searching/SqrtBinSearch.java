package com.binary.searching;

public class SqrtBinSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mySqrt(8);
	}

	public static int mySqrt(int x) {

		if (x == 0) {
			return 0;
		}
		// long r = x;
		// while (r*r > x)
		// r = (r + x/r) / 2;
		// return (int) r;
		
		int start = 1, end = x;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			System.out.println("mid 1" + mid);

			if (mid == x / mid) {
				// System.out.println("mid "+mid);
				return mid;
			} else if (mid > x / mid) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		System.out.println("end " + end);
		return end;
	}

}
