package com.test.two.pointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class SortColors {

	public static void main(String[] args) {

		int[] arr = new int[] { 2, 0, 2, 1, 1, 0 };
//		sortColors(arr);
		sortColorsTesting(arr);
	}

	public static void sortColors(int[] nums) {
		int l = 0;
		int r = nums.length - 1;
		System.out.println(Arrays.toString(nums));

		for (int i = 0; i <= r;) {

			if (nums[i] == 0) {
				swap(nums, i++, l++);
			} else if (nums[i] == 1) {
				++i;
			} else {
				swap(nums, i, r--);
			}
			System.out.println(Arrays.toString(nums));
		}
	}

	private static void swap(int[] nums, int i, int j) {
		final int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void sortColorsTesting(int[] nums) {
		int n = nums.length;
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			if (!hmap.containsKey(nums[i])) {
				hmap.put(nums[i], hmap.getOrDefault(nums[i], 0));
			}
			hmap.put(nums[i], hmap.get(nums[i]) + 1);
		}
		System.out.println(hmap);

		int[] nu = new int[n];
		Arrays.fill(nu, -1);
		int i = 0;
		int count = 0;
		for (Entry<Integer, Integer> entrySet : hmap.entrySet()) {

			Integer value = entrySet.getValue();
			while (i < value) {
				Integer key = entrySet.getKey();
				nu[count++] = key;
//				System.out.println(Arrays.toString(nu));
				i++;
			}
			i = 0;

		}
		int k = 0;
		for (int ele : nu) {
			nums[k++] = ele;
		}
		
		System.out.println(Arrays.toString(nu));
		System.out.println(Arrays.toString(nums));

//		for()

	}

}
