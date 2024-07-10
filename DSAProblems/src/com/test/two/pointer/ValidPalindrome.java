package com.test.two.pointer;

public class ValidPalindrome {
	
	public static void main(String[] args) {
		boolean validPal = validPal();
		System.out.println(validPal);
	}

	private static boolean validPal() {
		String s = "A man, a plan, a canal: Panama";
		s=s.replaceAll("[^a-zA-Z0-9]","").trim().toLowerCase();
		
		int i=0;
		while(i<s.length()-1-i) {
			if (s.charAt(i) != s.charAt(s.length()-1-i)) {
				return false;
			}
			i++;
		}
		return true;
		
	}
}
