package com.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int firstUniqChar = firstUniqChar("aabb");
		System.out.println(firstUniqChar);
	}

	public static int firstUniqChar(String s) {
		Map<Character, Integer> hmap = new LinkedHashMap<Character, Integer>();

		for (Character c : s.toCharArray()) {
			if (!hmap.containsKey(c)) {
				hmap.put(c, 1);
			} else {
				hmap.put(c, hmap.getOrDefault(c, 0) + 1);
			}
		}
//		System.out.println(hmap);
		for (Map.Entry<Character, Integer> entry : hmap.entrySet()) {
			Integer j = entry.getValue();
			if (j == 1) {
//				System.out.println(entry);
//				System.out.println(entry.getKey());
				int indexOf = s.indexOf(entry.getKey());
				return indexOf;

			}
		}

		return -1;

	}
}
