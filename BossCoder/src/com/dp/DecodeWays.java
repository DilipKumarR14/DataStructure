package com.dp;

import java.util.Arrays;

public class DecodeWays {

	public static void main(String[] args) {

		int numDecodings = DecodeWays.numDecodings("226");

		System.out.println(numDecodings);

	}

	public static int numDecodings(String s) {
		int[] memo = new int[s.length()];
		Arrays.fill(memo, -1);
		int result = topDownDecode(s, 0, memo);
		System.out.println("Final result: " + result);
		return result;
	}

	private static int topDownDecode(String s, int index, int[] memo) {
		// Print the current index and substring being processed
		System.out.println("Processing index: " + index + ", substring: " + s.substring(index));

		// Base case: if the index reaches the end of the string
		if (index == s.length()) {
			System.out.println("Reached the end of the string at index: " + index + ", returning 1");
			return 1; // This is a valid decoding
		}

		// Check memoization table
		if (memo[index] != -1) {
			System.out.println("Memoized result found at index: " + index + ", returning: " + memo[index]);
			return memo[index];
		}

		// Check for leading zero
		if (s.charAt(index) == '0') {
			System.out.println("Leading zero found at index: " + index + ", returning 0");
			return 0; // This decoding is invalid
		}

		// Decode single digit
		System.out.println("Decoding single digit at index: " + index);
		int ways = topDownDecode(s, index + 1, memo);

		// Decode two digits if possible
		if (index + 1 < s.length() && Integer.parseInt(s.substring(index, index + 2)) <= 26) {
			System.out.println("Decoding two digits at index: " + index);
			ways += topDownDecode(s, index + 2, memo);
		}

		// Memoize the result
		memo[index] = ways;
		System.out.println("Memoizing result at index: " + index + ", ways: " + ways);

		return ways;
	}

}
