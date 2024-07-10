package com.string;

import java.util.Arrays;

public class ReverseWords {

	public static void main(String[] args) {
		String reverseWords = reverseWords("a good   example");

		System.out.println("result : " + reverseWords);
	}

	public static String reverseWords(String s) {
		String[] spli = s.trim().split("\\s+");
		StringBuilder str = new StringBuilder();

		for (int i = spli.length - 1; i >= 0; i--) {
//			String temp = spli[i].trim();

			if (!spli[i].isEmpty()) {
				str.append(spli[i]);
			}
			if (!spli[i].isEmpty() && i != 0) {
				str.append(" ");
			}
		}
		return str.toString();
	}
}
