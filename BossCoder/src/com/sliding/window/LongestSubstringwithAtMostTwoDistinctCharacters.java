package com.sliding.window;

import java.util.HashMap;

public class LongestSubstringwithAtMostTwoDistinctCharacters {

	public static void main(String[] args) {

		String str = "aabbcc";
		int k = 2;
		int helper = helper(str, k);
		System.out.println(helper);

	}

	private static int helper(String str, int k) {
		int maxLen = 0;

		char[] ch = str.toCharArray();

		int len = str.length();

		int L = 0, R = 0;

		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();

		while (R < len) {

			hmap.put(ch[R], hmap.getOrDefault(ch[R], 0) + 1);

			while (hmap.size() > k) {
				hmap.put(ch[L], hmap.get(ch[L]) - 1);
				if (hmap.get(ch[L]) == 0) {
					hmap.remove(ch[L]);
				}
				L++;
			}
			maxLen = Math.max(maxLen, R - L + 1);
			R++;
		}
		return maxLen;
	}
}
