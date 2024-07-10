package com.recusrion;

import java.util.Scanner;

public class Permutation {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter string to generate its permutations: ");
		String str = scn.next();
		solve("", str);

	}

	public static void solve(String curr, String rem) {
		if (rem.length() == 0) { // Base condition for recursion
			System.out.print(curr + " ");
			return;
		}
		for (int i = 0; i < rem.length(); i++) {
			String first = rem.substring(0, i);
			String next = rem.substring(i + 1);

			String ros = first + next;

			char charAt = rem.charAt(i);
			solve(curr + charAt, ros);

		}
	}
}
