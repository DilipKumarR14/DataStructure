package com.maths1;

import java.util.ArrayList;
import java.util.List;

public class SelfDivdingNumber {

	public static void main(String[] args) {

		selfDividingNumbers(1, 22);
	}

	public static List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> arr = new ArrayList<Integer>();
		for (int i = left; i <= right; i++) {

			String valueOf = String.valueOf(i);

			char[] charArray = valueOf.toCharArray();
			boolean temp = false;
			for (char ele : charArray) {
				int numericValue = Character.getNumericValue(ele);
				if (numericValue != 0) {
					int j = i % numericValue;
					if (j == 0) {
						temp = true;
					} else {
						temp = false;
						break;
					}
				} else if (numericValue == 0) {
					temp = false;
					break;
				} else {
					temp = false;
					break;
				}
			}
			if (temp && !arr.contains(i)) {
				arr.add(i);
			}

		}
		System.out.println(arr);

		return arr;
	}

	public static boolean helper(int x) {
		int temp = x;
		while (x > 0) {
			int lastdigit = x % 10;
			if ((lastdigit == 0) || (temp % lastdigit != 0)) {
				return false;
			}
			x = x / 10;
		}

		return true;

	}

	public List<Integer> selfDividingNumbersSolution1(int left, int right) {
		List<Integer> ans = new ArrayList<>();
		for (int i = left; i <= right; i++) {
			if (helper(i)) {
				ans.add(i);
			}
		}
		return ans;
	}

}
