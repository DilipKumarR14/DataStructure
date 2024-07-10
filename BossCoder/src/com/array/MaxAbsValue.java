package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaxAbsValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = { 1, 2, 3, 4 };
		int[] arr2 = { -1, 4, 5, 6 };
		maxAbsValExpr1(arr1, arr2);

	}

	public static int maxAbsValExpr1(int[] arr1, int[] arr2) {

		// 1. remove the modulas -
		// i & j are interchangable because they are inside the modulas
		// A[i] - A[j] + B[i] -B[j] + i-j
		// A[i] + B[i] + i - B[j] - A[j] - j
		// (A[i] + B[i] + i) ->X
		// (B[j] - A[j] - j) -> y
		// X - Y;
		// to get max value X should be max & Y should min

		// Possible cases (Since both arrays have same number of indexes, we can use
		// single for loop & i as index)
		// A[i] + B[i] + i ->1
		// A[i] - B[i] + i ->2
		// A[i] + B[i] - i ->3
		// A[i] - B[i] - i ->4

		// Find out max of all response

		int arrayLength = arr1.length;
		int v1[] = new int[arrayLength];
		int v2[] = new int[arrayLength];
		int v3[] = new int[arrayLength];
		int v4[] = new int[arrayLength];
		int res = 0;
		for (int i = 0; i < arrayLength; i++) {
			v1[i] = i + arr1[i] + arr2[i];
			v2[i] = i + arr1[i] - arr2[i];
			v3[i] = i - arr1[i] + arr2[i];
			v4[i] = i - arr1[i] - arr2[i];
		}
		System.out.println(Arrays.toString(v1));
		System.out.println(Arrays.toString(v2));
		System.out.println(Arrays.toString(v3));
		System.out.println(Arrays.toString(v4));
		
		res = Math.max(res, Arrays.stream(v1).max().getAsInt() - Arrays.stream(v1).min().getAsInt());
		res = Math.max(res, Arrays.stream(v2).max().getAsInt() - Arrays.stream(v2).min().getAsInt());
		res = Math.max(res, Arrays.stream(v3).max().getAsInt() - Arrays.stream(v3).min().getAsInt());
		int asInt = Arrays.stream(v4).max().getAsInt();
		int asInt2 = Arrays.stream(v4).min().getAsInt();
		res = Math.max(res, asInt - asInt2);
		return res;
	}

	public static int maxAbsValExpr(int[] arr1, int[] arr2) {
		if (arr1.length != arr2.length) {
			return 0;
		}
//		Given two arrays of integers with equal lengths, return the maximum value of:
//
//			|arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
//
//			where the maximum is taken over all 0 <= i, j < arr1.length.

		System.out.println("arr1 " + Arrays.toString(arr1));
		System.out.println("arr2 " + Arrays.toString(arr2));

		int maxi = 0;

		int i = 0;
		ArrayList<Integer> arrayList = new ArrayList<>();
		;
		Collections.fill(arrayList, 0);
		while (i < arr1.length) {

			int val1 = arr1[i] + arr2[i] + i;
			int val2 = arr1[i] + arr2[i] - i;
			int val3 = arr1[i] - arr2[i] + i;
			int val4 = arr1[i] - arr2[i] - i;

			System.out.println("aaraylist " + arrayList);
			i++;

		}

		Integer maximum = arrayList.stream().max(Integer::compareTo).orElse(0);
		Integer minimum = arrayList.stream().min(Integer::compareTo).orElse(0);

		maxi = Math.max(maximum, minimum);

		System.out.println("maxi " + maxi);
		return maxi;
	}

}
