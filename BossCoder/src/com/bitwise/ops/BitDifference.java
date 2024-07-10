package com.bitwise.ops;

public class BitDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] arr = { 1, 3, 5 };
		int countBits = countBits(arr.length, arr);
		System.out.println(countBits);
	}

	static int countBits(int N, long arr[]) {
		int ans = 0; // Initialize result
		// traverse over all bits
		for (int i = 0; i < 32; i++) {
			// count number of elements with i'th bit set
			int count = 0;
			for (int j = 0; j < N; j++)
				if ((arr[j] & (1 << i)) != 0)
					count++;
			// Add "count * (n - count) * 2"
			// to the answer...(n - count = unset bit count)
			ans += (count * (N - count) * 2);
		}
		return ans;
	}

	static int countSetBits(int n) {
		int count = 0; // `count` stores the total bits set in `n`

		while (n != 0) {
			n = n & (n - 1); // clear the least significant bit set
			count++;
		}

		return count;
	}
}
