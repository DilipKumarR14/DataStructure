package com.sliding.window;

import java.util.Arrays;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean checkInclusion = checkInclusion("ab", "cba");

		System.out.println(checkInclusion);
	}

	public static boolean checkInclusion(String s1, String s2) {
		int len1 = s1.length(), len2 = s2.length();
		if (len1 > len2)
			return false;

		int[] count = new int[26];
		for (int i = 0; i < len1; i++) {
			count[s1.charAt(i) - 'a']++;
			count[s2.charAt(i) - 'a']--;
		}
		System.out.println("count 1 " + Arrays.toString(count));
		if (allZero(count)) {
			return true;
		}

		for (int i = len1; i < len2; i++) {
			count[s2.charAt(i) - 'a']--;
			System.out.println("count 2 " + Arrays.toString(count));

			count[s2.charAt(i - len1) - 'a']++;
			System.out.println("count 3 " + Arrays.toString(count));

			if (allZero(count))
				return true;
		}

		return false;

	}

	private static boolean allZero(int[] count) {
		for (int i = 0; i < 26; i++) {
			if (count[i] != 0)
				return false;
		}
		return true;
	}
}
