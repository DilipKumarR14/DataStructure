package com.test.two.pointer;

public class IsSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean subsequence = isSubsequence("axc", "ahbgdc");

		System.out.println(subsequence);
	}

	public static boolean isSubsequence(String s, String t) {
		int indexS = 0, indexT = 0;

		if (s.length() == 0) {
			return true;
		}

		while (indexT < t.length()) {

			if (s.charAt(indexS) == t.charAt(indexT)) {
				indexS++;

				if (indexS == s.length()) {
					return true;
				}
			}
			indexT++;

		}

		return false;
	}
}
