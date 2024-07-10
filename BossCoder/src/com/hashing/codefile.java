package com.hashing;

import java.util.HashSet;

public class codefile {
	static int solve(int[] nums) {
		// Step 1: Create a HashSet and insert all elements from the array
		HashSet<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}

		// Step 2: Initialize the variable to store the length of the longest
		// consecutive subsequence
		int longest = 0;

		// Step 3: Iterate through each unique element in the set
		for (int num : set) {
			// Step 4: Check if the current element has a predecessor, if yes, skip to the
			// next iteration
			/**
			 * This part of the code checks whether the current element num has a
			 * predecessor (i.e., num - 1) in the set. If it does, it means that num is part
			 * of an existing consecutive sequence, and we don't want to consider it as the
			 * starting point of a new sequence.
			 * https://chat.openai.com/c/04c094e0-5a4a-4ea1-8985-d3ebde6dab70
			 */
			if (set.contains(num - 1)) {
				continue;
			}

			// Step 5: If no predecessor, start counting consecutive elements in the forward
			// direction
			int j = 1;
			while (set.contains(num + j)) {
				j++;
			}

			// Step 6: Update the longest length if the current sequence is longer
			longest = Math.max(longest, j);
		}

		// Step 7: Return the length of the longest consecutive subsequence
		return longest;
	}
}
