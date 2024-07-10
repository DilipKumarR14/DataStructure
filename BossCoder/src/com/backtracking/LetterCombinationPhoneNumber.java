package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationPhoneNumber {

	public static void main(String[] args) {
		List<String> letterCombinations = letterCombinations("");

		System.out.println(letterCombinations);
	}

	public static List<String> letterCombinations(String digits) {
		String[] phoneMap = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		ArrayList<String> output = new ArrayList<>();
		helper("", digits, phoneMap, output);

		return output;
	}

	private static void helper(String comb, String digits, String[] phoneMap, ArrayList<String> output) {

		boolean empty = digits.isEmpty();
		if (empty) {
			output.add(comb);
		} else {
			String character = phoneMap[Character.getNumericValue(digits.charAt(0))];
			for (char letter : character.toCharArray()) {
				helper(comb + letter, digits.substring(1), phoneMap, output);
			}
		}

	}
}
