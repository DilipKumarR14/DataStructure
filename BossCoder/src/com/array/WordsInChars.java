package com.array;

import java.util.HashMap;
import java.util.Iterator;

public class WordsInChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] words = { "cat", "bt", "hat", "tree" };

		String chars = "atach";

		int countCharacters = countCharacters(words, chars);

		System.out.println(countCharacters);
	}

	public static int countCharacters(String[] words, String chars) {

		int finalCount = 0;
		HashMap<Character, Integer> hashmap = new HashMap<>();

		for (char ch : chars.toCharArray()) {
			if (!hashmap.containsKey(ch)) {
				hashmap.put(ch, hashmap.getOrDefault(ch, 0) + 1);
			} else {
				hashmap.put(ch, hashmap.get(ch) + 1);
			}
		}
		System.out.println(hashmap.entrySet());

		return finalCount;
	}

}
