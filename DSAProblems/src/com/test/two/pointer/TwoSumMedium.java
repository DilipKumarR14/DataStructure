package com.test.two.pointer;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoSumMedium {

	public static void main(String[] args) {
		
		int[] number = {5,25,75};
		int target=100;
		
		int[] twoSum = twoSum(number, target);
		
		System.out.println(Arrays.toString(twoSum));

	}

	private static int[] twoSum(int[] number, int target) {
		int l=0, r=number.length-1;
		while (number[l] + number[r]!=target) {
			if (number[l] + number[r] < target) {
				l++;
			}else {
				r--;
			}
		}
		
		return new int[] {l+1, r+1};
	}

}
