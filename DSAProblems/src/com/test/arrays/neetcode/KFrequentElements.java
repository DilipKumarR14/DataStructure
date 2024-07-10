package com.test.arrays.neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class KFrequentElements {

	public static void main(String[] args) {

		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;

//		int[] solution1 = topKFrequent(nums, k);
//
//		System.out.println(solution1);

		topKFrequentFi(nums, k);

		topKFrequentSol2(nums, k);

	}

	public static int[] topKFrequent(int[] nums, int k) {

		@SuppressWarnings("unchecked")
		List<Integer>[] bucket = new List[nums.length + 1];

		// frequency counter
		Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

		for (int n : nums) {
			frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
		}

		System.out.println("frequencyMap " + frequencyMap);

		System.out.println("frequencyMap.keySet() " + frequencyMap.keySet());

		//
		for (int key : frequencyMap.keySet()) {
			int frequency = frequencyMap.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}

		System.out.println("bucket " + Arrays.toString(bucket));

		List<Integer> res = new ArrayList<>();

//		System.out.println(bucket.length);

		for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
			if (bucket[pos] != null) {
				res.addAll(bucket[pos]);
			}
		}

		System.out.println("res " + res);

		int[] arr = res.stream().mapToInt(i -> i).toArray();

		return arr;
	}

	public static List<Integer> topKFrequentFi(int[] nums, int k) {

		Map<Integer, Integer> freqCount = new HashMap<>();

		for (int i : nums) {
			freqCount.put(i, freqCount.getOrDefault(i, 0) + 1);
		}
		System.out.println(freqCount);

		// {4=1, 6=3, 10=2, 11=2}

		@SuppressWarnings("unchecked")
		List<Integer>[] list = new List[nums.length + 1];

		for (Integer key : freqCount.keySet()) {

			Integer value = freqCount.get(key);

			if (list[value] == null) {
				list[value] = new ArrayList<>();
			}
			list[value].add(key);

		}

		List<Integer> res = new ArrayList<>();
		System.out.println(list.length);

		for (int i = list.length - 1; i > 0 && res.size() < k; i--) {
			if (list[i] != null) {
				res.addAll(list[i]);
			}
		}
		System.out.println(res);

		return res;

	}

	public static int[] topKFrequentSol2(int[] nums, int k) {
//		System.out.println(Arrays.toString(nums));
//		System.out.println(" k =" + k);
		if (nums.length < 0 || nums.length == 1) {
			return nums;
		}

		Map<Integer, Integer> hashMap = new HashMap<>();

		for (int i : nums) {
			if (!hashMap.containsKey(i)) {
				hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
			} else {
				hashMap.put(i, hashMap.get(i) + 1);
			}
		}
//		System.out.println(hashMap);
//		System.out.println("00 " + arrayList);

		// hashmap -> key=num, value=count;

		@SuppressWarnings("unchecked")
		List<Integer>[] arrayList2 = new List[nums.length + 1];
		System.out.println("hashMap.entrySet() " + hashMap.entrySet());
		System.out.println("hashMap.keySet() " + hashMap.keySet());

		for (Integer ele : hashMap.keySet()) {
			Integer value = hashMap.get(ele);
			if (arrayList2[value] == null) {
				arrayList2[value] = new ArrayList<>();
			}
			arrayList2[value].add(ele);
		}
		
		ArrayList<Integer> arrayList3 = new ArrayList<>();

		for (int i = arrayList2.length-1; i>0 && arrayList3.size()<k ; i--) {
			if (arrayList2[i]!=null) {
				arrayList3.addAll(arrayList2[i]);
			}
		}
		
		
		
//		System.out.println("-- "+arrayList2);

//		Arrays.stream(nums).boxed().collect(Collectors.toList());

		int[] array = arrayList3.stream().mapToInt(Integer::intValue).toArray();
//		System.out.println("final arr " + Arrays.toString(array));
		return array;

	}

}
