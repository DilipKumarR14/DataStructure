package com.maths1;

public class ArrayPair {

	public static void main(String[] args) {
		int[] arr ={2, 4, 6, 8, 10, 12};

		boolean canArrange = canArrange(arr, 3);

		System.out.println(canArrange);
	}

	public static boolean canArrange(int[] arr, int k) {
		int[] remainderArr = new int[k];

		// can it form a pair
		for (int i : arr) {
			int idx = ((i % k) + k) % k;
			remainderArr[idx]++;
		}

		if (remainderArr[0] % 2 != 0) {
			return false;
		}

		for (int i = 1; i < k; i++) {
			if (remainderArr[i] != remainderArr[k - i]) {
				return false;
			}
		}

		return true;

	}

}
