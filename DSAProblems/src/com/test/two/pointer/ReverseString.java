package com.test.two.pointer;

import java.util.Arrays;

public class ReverseString {

	public static void main(String[] args) {

		char[] s= {'H','a','n','n','a','h'};
		
		int start=0, end=s.length-1;
		
		while(start <= end) {
			char temp = s[start];
			s[start]=s[end];
			s[end]=temp;
			start++;
			end--;

			
			System.out.println("After "+Arrays.toString(s));

		}
	}

}
