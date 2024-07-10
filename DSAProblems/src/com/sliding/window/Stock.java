package com.sliding.window;

import java.util.Arrays;
import java.util.OptionalInt;

public class Stock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] prices = { 7, 1, 5, 3, 6, 4 };

		maxProfit1(prices);

	}

	public static int maxProfit(int[] prices) {

		int finalMax = 0;
		int min_price = prices[0];

		for (int i = 1; i < prices.length; i++) {

			finalMax = Math.max(finalMax, prices[i] - min_price);

			min_price = Math.min(min_price, prices[i]);

		}

		System.out.println(finalMax);
		return finalMax;
	}

	public static int maxProfit1(int[] prices) {

		// { 7, 1, 5, 3, 6, 4 };
		// prices = new int[] {7,6,4,3,1};
		int finalMax = 0;
		int min_price = prices[0];

		for (int i = 1; i < prices.length; i++) {
			min_price = Math.min(min_price, prices[i]);

			finalMax = Math.max(finalMax, prices[i] - min_price);

		}
		System.out.println(finalMax);

		return finalMax;

	}
}
