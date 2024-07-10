package com.maths1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GCDArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] nums = {2,5,6,9,10};

		int findGCD = findGCD(nums);
		
		System.out.println(findGCD);

	}

	public static int findGCD(int[] nums) {

		List<Integer> arrayList = Arrays.stream(nums).boxed() // Convert int to Integer
				.collect(Collectors.toCollection(ArrayList::new));

		int finalMax = Collections.max(arrayList);

		// Find the minimum value using Collections.min
		int finalMin = Collections.min(arrayList);

		return gcd(finalMin, finalMax);

	}

	private static int gcd(int min, int max) {
		if (max == 0) {
			return min;
		}
		return gcd(max, min % max);
	}

}
