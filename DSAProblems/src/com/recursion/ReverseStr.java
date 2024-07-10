package com.recursion;

public class ReverseStr {

	public static void main(String[] args) {
		reverseString("HELLO");

		System.out.println();

	}

	private static void reverseString(String string) {

		if ((string == null) || (string.length() <= 1)) {
			System.out.println(string);

		} else {
			int index = string.length() - 1;

			System.out.print(string.charAt(index));

			reverseString(string.substring(0, index));
		}
	}

}
