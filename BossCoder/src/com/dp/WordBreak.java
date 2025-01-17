package com.dp;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Sample string
		String s = "leetcode";

		// Sample word dictionary
		List<String> wordDict = Arrays.asList("leet", "code");

		// Create an instance of the Sodsution class
		Sodsution solution = new Sodsution();

		// Call the wordBreak method and print the result
		boolean result = solution.wordBreak(s, wordDict);
		System.out.println("Can the word \"" + s + "\" be segmented? " + result);
	}

}

class Sodsution {
	private String s;
	private List<String> wordDict;
	private int[] memo;

	public boolean wordBreak(String s, List<String> wordDict) {
		// Initialize member variables
		this.s = s;
		this.wordDict = wordDict;
		// Initialize memo array with -1 indicating uncomputed states
		this.memo = new int[s.length()];
		Arrays.fill(this.memo, -1);
		// Start the dynamic programming from the end of the string
		return dp(s.length() - 1);
	}

	private boolean dp(int i) {
		// Base case: if index is less than 0, we've successfully segmented the string
		if (i < 0) {
			return true;
		}

		// If result for this index is already computed, return the cached result
		if (memo[i] != -1) {
			return memo[i] == 1;
		}

		// Loop through each word in the dictionary
		for (String word : wordDict) {
			// Check if the word can fit into the current position
			int beginIndex = i - word.length() + 1;
			if (beginIndex < 0) {
				continue;
			}
			// Check if the substring matches the word and the remaining part can be
			// segmented
			String substring = s.substring(beginIndex, i + 1);
			if (substring.equals(word) && dp(i - word.length())) {
				// Update memo array to indicate successful segmentation
				memo[i] = 1;
				return true;
			}
		}
		// Update memo array to indicate failed segmentation
		memo[i] = 0;
		return false;
	}
}