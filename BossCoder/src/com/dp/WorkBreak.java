package com.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkBreak {

	public static void main(String[] args) {
		Solutasdaon solution = new Solutasdaon();
		List<String> wordDict1 = Arrays.asList("leet", "code");
		System.out.println("Result for 'leetcode': " + solution.wordBreak("leetcode", wordDict1));

		List<String> wordDict2 = Arrays.asList("apple", "pen");
		System.out.println("Result for 'applepenapple': " + solution.wordBreak("applepenapple", wordDict2));

		List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
		System.out.println("Result for 'catsandog': " + solution.wordBreak("catsandog", wordDict3));

	}

}

class Solutasdaon {
	private String s;
	private List<String> wordDict;
	private int[] memo;

	public boolean wordBreak(String s, List<String> wordDict) {
		this.s = s;
		this.wordDict = wordDict;
		this.memo = new int[s.length()];
		Arrays.fill(this.memo, -1);
		boolean result = dp(s.length() - 1);
		System.out.println("Final Result: " + result);
		System.out.println("Memo Array: " + Arrays.toString(memo));
		return result;
	}

	private boolean dp(int i) {
		System.out.println("Checking substring: " + s.substring(0, i + 1));

		if (i < 0) {
			System.out.println("Reached base case with i < 0, returning true.");
			return true;
		}

		if (memo[i] != -1) {
			System.out.println("Memoization hit for index " + i + ": " + memo[i]);
			return memo[i] == 1;
		}

		for (String word : wordDict) {
			if (i - word.length() + 1 < 0) {
				continue;
			}
			String substring = s.substring(i - word.length() + 1, i + 1);
			System.out.println("Trying word: " + word + " against substring: " + substring);

			if (substring.equals(word) && dp(i - word.length())) {
				System.out.println("Match found for word: " + word + " at position: " + i);
				memo[i] = 1;
				return true;
			}
		}
		System.out.println("No match found for position: " + i);
		memo[i] = 0;
		return false;
	}
}