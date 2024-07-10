package com.stack;

import java.util.Stack;

public class ReversePolishNotation {

	public static void main(String[] args) {

		int solve = solve(new String[] { "5", "2", "1", "+", "3", "*" });
		
		System.out.println(solve);

	}

	static int solve(String[] input) {
		Stack<Integer> stack = new Stack<Integer>();
		for (String s : input) {
			if (s.equals("+")) {
				int n1 = (int) stack.pop();
				int n2 = (int) stack.pop();
				stack.push(n1 + n2);
			} else if (s.equals("-")) {
				int a = (int) stack.pop();
				int b = (int) stack.pop();
				int c = b - a;
				stack.push(c);
			} else if (s.equals("*")) {
				int n1 = (int) stack.pop();
				int n2 = (int) stack.pop();
				stack.push(n1 * n2);
			} else if (s.equals("/")) {
				int a = (int) stack.pop();
				int b = (int) stack.pop();
				int c = 0;
				if (a != 0) {
					c = b / a;
				}

				stack.push(c);
			} else {
				stack.push(Integer.parseInt(s));
			}
		}
		return (int) stack.pop();

	}

}
