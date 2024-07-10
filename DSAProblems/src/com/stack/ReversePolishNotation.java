package com.stack;

import java.util.Stack;

public class ReversePolishNotation {

	public static void main(String[] args) {
		String[] s = new String[] { "2", "1", "+", "3", "*" };
		evalRPN(s);
	}

	@SuppressWarnings("unchecked")
	public static int evalRPN(String[] tokens) {
		Stack stack = new Stack();

		for (String s : tokens) {
			if (s.equals("+")) {
				int n1=(int) stack.pop();
				int n2= (int) stack.pop();
				stack.push(n1+n2);
			} else if (s.equals("-")) {
				int a = (int) stack.pop();
				int b = (int) stack.pop();
				int c = b - a;
				stack.push(c);
			} else if (s.equals("*")) {
				int n1=(int) stack.pop();
				int n2= (int) stack.pop();
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
