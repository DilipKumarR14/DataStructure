package com.heap;

import java.util.ArrayList;

public class ActivitySelection {

	public static void main(String[] args) {

		int i, j;
		i = 0;

		int s[] = { 10, 12, 20 };
		int f[] = { 20, 25, 30 };
		int n = s.length;

		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(i);
		for (j = 1; j < n; j++) {
			if (s[j] >= f[i]) {
				arrayList.add(j);
				i = j;
			}
		}

		System.out.println(arrayList);
		
		int[] array = arrayList.stream().mapToInt(Integer::intValue).toArray();

	}

}
