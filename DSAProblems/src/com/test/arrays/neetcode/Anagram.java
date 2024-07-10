package com.test.arrays.neetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Anagram {

	public static void main(String[] args) {

		String str = "anagram";
		String t = "naarma";

		//System.out.println(isAnagramSolution2(str, t));
		isAnagramSol1(str, t);

	}

	public static boolean isAnagramSolution2(String s, String t) {
		HashMap<Character, Integer> hmap = new HashMap<>();

		if (s.length() != t.length()) {
			return false;
		}

		for (int i = 0; i < hmap.size(); i++) {
			hmap.put(s.charAt(i), hmap.getOrDefault(s.charAt(i), 0) + 1);
			hmap.put(t.charAt(i), hmap.getOrDefault(t.charAt(i), 0) - 1);
		}

		for (Map.Entry<Character, Integer> iterable_element : hmap.entrySet()) {
			if (iterable_element.getValue() != 0) {
				return false;
			}
		}

		return true;

	}

	public static boolean isAnagramSol1(String s, String t) {
		int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
			int j = s.charAt(i) - 'a';
			alphabet[j]++;
		}
        for (int i = 0; i < t.length(); i++) {
			int k = t.charAt(i) - 'a';
			alphabet[k]--;
		}
        for (int i : alphabet) if (i != 0) return false;
        return true;
	}

}
