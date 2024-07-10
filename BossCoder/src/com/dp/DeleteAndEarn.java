package com.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DeleteAndEarn {

	public static void main(String[] args) {
		Solusaion sol = new Solusaion();
		int[] nums = { 2, 2, 3, 3, 3, 4 };
		System.out.println("Result: " + sol.deleteAndEarn(nums));
	}

}

class Solusaion {
	public int deleteAndEarn(int[] nums) {
		int n = 10001;

		int[] values = new int[n];

		// Populate the values array
		for (int num : nums) {
			values[num] += num;
		}

		// Initialize variables to store the maximum points with the options to take or
		// skip a number
		int take = 0, skip = 0;

		// Debug: Print initial state
		System.out.println("Initial state:");
		System.out.println("values array: " + Arrays.toString(values));
		System.out.println("take: " + take + ", skip: " + skip);

		// Iterate through the values array to compute the maximum points
		for (int i = 0; i < n; i++) {
			int takei = skip + values[i];
			int skipi = Math.max(skip, take);

			// Debug: Print state at each step
			System.out.println("Step " + i + ":");
			System.out.println("i: " + i + ", values[i]: " + values[i]);
			System.out.println("takei (new take): " + takei + ", skipi (new skip): " + skipi);
			System.out.println("Previous take: " + take + ", Previous skip: " + skip);

			take = takei;
			skip = skipi;

			// Debug: Print updated state
			System.out.println("Updated take: " + take + ", Updated skip: " + skip);
			System.out.println();
		}

		// The result is the maximum points we can earn, either by taking or skipping
		// the last number
		int result = Math.max(take, skip);

		// Debug: Print final result
		System.out.println("Final result: " + result);

		return result;
	}

}
