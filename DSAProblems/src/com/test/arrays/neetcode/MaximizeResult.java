package com.test.arrays.neetcode;

public class MaximizeResult {

	public static void main(String[] args) {
		String s = "123";
		char digit = '3';
		// find the digit

		long count = s.chars().filter(ch-> ch == digit).count();

		// if only one digit then just the number by removing the digit
		if(count == 1) {
			int asInt = s.indexOf(digit);
			StringBuffer deleteCharAt = new StringBuffer(s).deleteCharAt(asInt);
			System.out.println(deleteCharAt);
		}
		// else remove first occurence of the digit and remove second occurence of that
		// digit and compare both the number
		
		

	}

}
