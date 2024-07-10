package com.leetcode.array;

public class StockBuying {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StockBuying.maxProfit(new int[] { 7,6,4,3,1 });
	}

	public static int maxProfit(int[] prices) {
		int len = prices.length;
		int max = 0;
		int min = prices[0];
		for (int i = 0; i < len; i++) {
			int profit = prices[i] - min;
			if (profit > 0) {
				max = Math.max(max, profit);
			} else {
				min = Math.min(min, prices[i]);
			}

		}
		 System.out.println(max);
		return max;
	}

}
