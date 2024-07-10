package com.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {

	public static void main(String[] args) {
		temperaturesSol(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 });
	}

	public static int[] dailyTemperatures(int[] temperatures) {
		int n = temperatures.length;
		int[] result = new int[n];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				int idx = stack.pop();
				result[idx] = i - idx;
				System.out.println(Arrays.toString(result));
			}
			// pushing the index of the element
			stack.push(i);
			System.out.println("stack" + stack);

		}

		return result;

	}

	static int[] temperaturesSol(int[] input) {
		Stack stack = new Stack();
		int len = input.length;
		int[] temp = new int[len];

		for (int i = 0; i < len; i++) {
			while (!stack.isEmpty() && input[i] > input[(int) stack.peek()]) {

				int index = (int) stack.pop();
				temp[index] = i - index;

			}
			stack.push(i);
		}
		System.out.println(Arrays.toString(temp));
		return temp;
	}
}
