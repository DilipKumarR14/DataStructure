package com.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DialyTemperature {

	public static void main(String[] args) {
		int[] nums = { 73, 74, 75, 71, 69, 72, 76, 73 };
		dailyTemperatures(nums);

	}

	public static int[] dailyTemperatures(int[] temperatures) {
		System.out.println(Arrays.toString(temperatures));

		final int m = temperatures.length;
		final Map<Integer, Integer> hashMap = new HashMap<>();
		final Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < m; i++) {
			while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
				hashMap.put(stack.peek(), i - stack.pop());
			}
			stack.push(i);
		}
		
		System.out.println("HashMap : "+hashMap);
		System.out.println("Stack : "+stack);

		
		final int[] ans = new int[m];
		for (int i = 0; i < m; i++) {
			ans[i] = hashMap.getOrDefault(i, 0);
		}
		System.out.println("ans " + Arrays.toString(ans));

		return ans;
	}
}
