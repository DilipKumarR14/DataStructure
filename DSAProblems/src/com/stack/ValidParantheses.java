package com.stack;

import java.util.Stack;

public class ValidParantheses {

	public static void main(String[] args) {
		String s = "()";
		boolean valid = isValid(s);
		System.out.println(valid);
	}

	public static boolean isValid(String s) {

		char[] arr = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();

		if (arr.length == 1) {
			return false;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println("stack " + stack);
			System.out.println("arr[i] " + arr[i]);
			if (arr[i] == '(' || arr[i] == '[' || arr[i] == '{') {

				stack.push(arr[i]);

			} else {
				if (!stack.isEmpty()) {
					Character peek = stack.peek();
					if (arr[i] == ')' && peek.equals('(')) {
						stack.pop();
					} else if (arr[i] == ']' && peek.equals('[')) {
						stack.pop();
					} else if (arr[i] == '}' && peek.equals('{')) {
						stack.pop();
					} else {
						return false;
					}
				} else {
					return false;
				}
			}

		}
		return stack.isEmpty();
	}
}
