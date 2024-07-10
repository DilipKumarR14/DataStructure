package com.test.arrays.neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] str = { "eat", "tea", "tan", "ate", "nat", "bat" };

//		groupAna1(str);

//		List<List<String>> groupAnagrams = groupAnagrams(str);

//		System.out.println(groupAnagrams);

//		List<List<String>> groupAnagramsSolution2 = groupAnagramsSolution2(str);
//
//		System.out.println(groupAnagramsSolution2);

		List<List<String>> solution3 = solution3(str);

	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) {
			return new ArrayList<>();
		}
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String keyStr = String.valueOf(ca);
			if (!map.containsKey(keyStr)) {
				map.put(keyStr, new ArrayList<>());
			}
			map.get(keyStr).add(s);
		}
		return new ArrayList<>(map.values());
	}

	public static List<List<String>> groupAnagramsSolution2(String[] strs) {

		if (strs == null || strs.length == 0) {
			return new ArrayList<>();
		}
		Map<String, ArrayList<String>> map = new HashMap<>();

		for (String ele : strs) {

			char[] charArray = ele.toCharArray();

			Arrays.sort(charArray);

			String valueOf = String.valueOf(charArray);

			if (!map.containsKey(valueOf)) {
				map.put(valueOf, new ArrayList<>());
			}
			map.get(valueOf).add(ele);
		}

		return new ArrayList<>(map.values());

	}

	public static List<List<String>> groupAna1(String[] strs) {

		if (strs == null || strs.length == 0) {
			return new ArrayList<>();
		}

		Map<String, List<String>> map = new HashMap<>();

		for (String str : strs) {
			char[] charArray = str.toCharArray();
			Arrays.sort(charArray);

			String sortedStr = String.valueOf(charArray);

			if (!map.containsKey(sortedStr)) {
				map.put(sortedStr, new ArrayList<>());
			}

			map.get(sortedStr).add(str);

		}
		System.out.println(map.values());
		return new ArrayList<>(map.values());

	}

	public static List<List<String>> solution3(String[] strs) {

		Map<String, List<String>> hasMap = new HashMap<>();

		for (String s: strs) {

			char[] charArray = s.toCharArray();

			Arrays.sort(charArray);
			String valueOf = String.valueOf(charArray);
			if (!hasMap.containsKey(valueOf)) {
//				List<String> arrayList = ;
//				arrayList.add(strs[i]);
				hasMap.put(valueOf, new ArrayList<>());
			} 
			hasMap.get(valueOf).add(s);

		}
		System.out.println(hasMap.values());

		return new ArrayList<List<String>>(hasMap.values());

	}

}
