package com.recursion;

public class PalindromeRecursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean palindrome = palindrome("KAYAK");
		System.out.println(palindrome);

	}

	private static boolean palindrome(String string) {
		if (string.length() == 1 || string.length() == 0) {
			return true;
		}

		if (string.charAt(0) == string.charAt(string.length() - 1)) {
			return palindrome(string.substring(1, string.length() - 1));
		}

		return false;
	}

}
