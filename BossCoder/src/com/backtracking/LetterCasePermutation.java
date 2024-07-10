package com.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class LetterCasePermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> letterCasePermutation = letterCasePermutation("O9");

		System.out.println(letterCasePermutation);
	}

	public static List<String> letterCasePermutation(String s) {
		List<String> res = new ArrayList<String>();

		if (s.length() == 1) {
			res.add(s);
			char charAt = s.charAt(0);
			if (Character.isAlphabetic(charAt)) {
				String sec = "";
				if (Character.isLowerCase(charAt)) {
					sec = s.toUpperCase();
				} else {
					sec = s.toLowerCase();
				}
				res.add(sec);
			} else if (Character.isDigit(charAt)) {
				return res;
			}
			return res;
		}

		Set<String> solve = solve(res, s, 0, s);
//		System.out.println("method return  " + solve);

		res.addAll(solve);

		res.add(s);
		String sec = s.toUpperCase();
		res.add(sec);

		Set<String> set2 = solve(res, s, 0, s);
		set2.addAll(res);

		res = new ArrayList<>();

		res.addAll(set2);

//		System.out.println("list from solve " + res);

		return res;

	}

	public static Set<String> solve(List<String> list, String s, int index, String main) {
		Set<String> set = new HashSet<>();

		if (s.isEmpty()) {
			return set;
		}

		for (int i = index; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isAlphabetic(c)) {
				String replace = "";
				if (Character.isUpperCase(c)) {
					replace = main.replace(c, Character.toLowerCase(c));
				} else {
					replace = main.replace(c, Character.toUpperCase(c));
				}

				set.add(replace);
//				System.out.println("list " + list);
				solve(list, s.substring(i + 1, s.length()), i + 1, main);
			}
		}

		set.addAll(list);
//		System.out.println("set from emthod" + set);
		return set;
	}
}