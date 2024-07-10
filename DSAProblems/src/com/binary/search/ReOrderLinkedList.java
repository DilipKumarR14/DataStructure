package com.binary.search;

public class ReOrderLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String gcdOfStrings(String str1, String str2) {

		if ((str1 + str2).equals(str2 + str1)) {
			int gcd = gcd(str1.length(), str2.length());
			return str1.substring(0, gcd);
		} else {
			return "";
		}

	}

	private int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
}
