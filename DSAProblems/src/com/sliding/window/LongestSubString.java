package com.sliding.window;

import java.util.HashSet;

public class LongestSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lengthOfLongestSubstring("bacabcbb");
	}

	public static int lengthOfLongestSubstring(String s) {
		System.out.println(s);
		HashSet<Character> set = new HashSet<Character>();
		int maxLength = 0;
		int left = 0;
		for (int right = 0; right < s.length(); right++) {
			if (!set.contains(s.charAt(right))) {
				set.add(s.charAt(right));
				maxLength = Math.max(maxLength, right - left + 1);
			} else {
				while (set.contains(s.charAt(right))) {
					set.remove(s.charAt(left));
					left++;
				}
				set.add(s.charAt(right));
			}
		}

		return maxLength;

	}
}
