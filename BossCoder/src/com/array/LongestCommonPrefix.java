package com.array;

import java.util.Arrays;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] str = { "flower", "flow", "flight" };

		findStr(str);

	}

	private static String findStr(String[] strings) {
		if (strings == null || strings.length == 0 && strings.length < 2) {
			return "";
		}

		// Find the common prefix between the first and last strings
		String commonPrefix = strings[0];
		
		for (int i = 1; i < strings.length; i++) {
			int j = 0;

			String string = strings[i];
			while (j < commonPrefix.length() && j < string.length()
					&& commonPrefix.charAt(j) == string.charAt(j)) {
				j++;
			}

			commonPrefix = commonPrefix.substring(0, j);
		}
		
		String string = commonPrefix.toString();
		System.out.println(string);
		
		return commonPrefix.toString();

	}

}
