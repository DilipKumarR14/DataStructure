package com.sliding.window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SubStringSizeThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int countGoodSubstrings = countGoodSubstrings("xyzzaz");

		System.out.println(countGoodSubstrings);
	}

	public static int countGoodSubstrings(String s) {

		int j = 0;
		String str = "";
		int k = 3;
		int count = 0;
		while (j < k) {
			str = str + String.valueOf(s.charAt(j));
			j++;
		}

		int length = str.length();
		int size = Set.of(str.toCharArray()).size();
		count = length == size ? count++ : 0;

		for (int i = k; i < s.length(); i++) {

			str = str.substring(1) + String.valueOf(s.charAt(i));
			length = str.length();
			size = Set.of(str).size();

			if (length == size) {
				count++;
			}
		}

		return count;

	}

	public static boolean hasRepeatedCharacters(String str) {
		Set<Character> set = new HashSet<>();
		for (char c : str.toCharArray()) {
			if (!set.add(c)) {
				return true; // Found a repeated character
			}
		}
		return false; // No repeated characters found
	}
}
