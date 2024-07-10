package com.test.arrays.neetcode;

public class HouseRobber {

	public static void main(String[] args) {
		int[] A = { 8,7,9,3,1};

		int rob = rob(A);

		System.out.println(rob);

	}

	private static int rob(int[] a) {
		//		int[] cache = new int[a.length + 1];
		//
		//		cache[0] = a[0];
		//		cache[1] = Math.max(a[0], a[1]);
		//
		//		for (int i = 2; i < a.length; i++) {
		//			int selected = cache[i - 2] + a[i];
		//			int notSelected = cache[i - 1];
		//
		//			cache[i] = Math.max(selected, notSelected);
		//		}
		//
		//		return cache[a.length-1];

//		int[] A = { 8,7,9,3,1};
		int prev2=a[0];
		int prev1=Math.max(a[0], a[1]);

		for (int i = 2; i < a.length; i++) {
			int temp=prev1;
			prev1=Math.max(prev2+a[i], prev1);
			prev2=temp;
		}
		return prev1;



	}

}
