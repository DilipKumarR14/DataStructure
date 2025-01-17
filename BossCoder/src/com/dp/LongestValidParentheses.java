package com.dp;

import java.util.Stack;

public class LongestValidParentheses {

	public static void main(String[] args) {

		lvp("())");
	}

	private static int count;

	public static int lvp(String par) {

		Stack<Character> st = new Stack<>();

		char[] arr = par.toCharArray();

		st.push(arr[0]);

		for (int i = 1; i < arr.length; i++) {

			if (!st.isEmpty() && st.peek() == '(' && arr[i] == ')') {
				count += 2;
				st.pop();
			} else if (arr[i] == '(') {
				st.push(arr[i]);
			}
		}
		System.out.println(count);
		return count;
	}

}
