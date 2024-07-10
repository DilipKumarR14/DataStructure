package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Candies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		kidsWithCandies(new int[] { 4, 2, 1, 1, 2 }, 1);

//		System.out.println(kidsWithCandies);

	}

	public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
//		boolean[] result = new boolean[candies.length];
		List<Boolean> rl = new ArrayList<>();

		List<Integer> list = Arrays.stream(candies).boxed().collect(Collectors.toList());

		int max = list.stream().mapToInt(i -> i).max().getAsInt();
//		max = max + extraCandies;

		for (int i = 0; i < candies.length; i++) {
			int j = candies[i] + extraCandies;
			if (j >= max) {
				rl.add(true);
			} else {
				rl.add(false);

			}
		}

		System.out.println(rl);
		return rl;
	}

}
