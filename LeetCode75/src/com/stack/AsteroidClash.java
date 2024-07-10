package com.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class AsteroidClash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> asteroidCollision = asteroidCollision(new int[] { -1, 3, 2, -3 });
		System.out.println(asteroidCollision);
	}

	public static ArrayList<Integer> asteroidCollision(int[] asteroids) {
		/**
		 * Find out the state of the asteroids after all collisions. If two asteroids
		 * meet, the smaller one will explode. If both are the same size, both will
		 * explode. Two asteroids moving in the same direction will never meet.
		 */
		Stack<Integer> stack = new Stack<Integer>();
		for (int i : asteroids) {
			while (!stack.isEmpty() && i < 0 && stack.peek() > 0) {
				int diff = i - stack.peek();
				if (diff < 0) {
					stack.pop();
				} else if (diff > 0) {
					i = 0;
				} else {
					i = 0;
					stack.pop();
				}

			}
			if (i != 0) {
				stack.push(i);
			}
		}

		System.out.println("stack " + stack);

		return new ArrayList<Integer>(stack);
	}

}
