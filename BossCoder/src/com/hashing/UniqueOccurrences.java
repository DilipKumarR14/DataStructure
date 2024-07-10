package com.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueOccurrences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 1, 1, 1, 2, 2, 3, 3, 3 };
		uniqueOccurrences(arr);
	}

	public static boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();

		for (int i : arr) {
			hmap.put(i, 1 + hmap.getOrDefault(i, 0));
		}
		System.out.println(hmap);

		int size = hmap.size();
		HashSet<Integer> hashSet = new HashSet<>(hmap.values());
		System.out.println("hashset " + hashSet);
		int newHashMapsize = hashSet.size();
		System.out.println("newHashMapsize " + newHashMapsize);

		/**
		 * {1=3, 2=2, 3=3} hashset [2, 3] newHashMapsize 2
		 */
		return size == newHashMapsize;

	}
}
