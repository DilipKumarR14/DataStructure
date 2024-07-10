package com.maths1;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class LongestSubsString {

	public static void main(String[] args) {
		String s = "abcabcbb";
		lengthOfLongestSubstring(s);
	}

	public static int lengthOfLongestSubstring(String s) {
		HashSet<Character> hashSet = new LinkedHashSet<>();
		int left = 0, maxLength = 0;

		for (int right = 0; right < s.length(); right++) {
			char charAtRight = s.charAt(right);
			if (!hashSet.contains(charAtRight)) {
				hashSet.add(charAtRight);
				maxLength = Math.max(maxLength, right - left +1);
			} else {
				while(hashSet.contains(charAtRight)) {
					hashSet.remove(s.charAt(left));
					left++;
				}
				hashSet.add(charAtRight);
			}
		}
		System.out.println(maxLength);
		return maxLength;
	}
}
