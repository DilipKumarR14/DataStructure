package com.array;

public class RichestCustomerWealth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] accounts = { { 6, 59, 64, 19, 30, 76, 71, 86, 90, 25, 56, 17, 19, 72, 61, 56, 24, 40, 35, 39, 67, 28,
				52, 11, 82, 72, 8, 82, 81, 47 } };

		maximumWealth(accounts);
	}

	public static int maximumWealth(int[][] accounts) {
		int finalMax = 0;
		for (int i = 0; i < accounts.length ; i++) {
			int sum = 0;
			for (int j = 0; j < accounts[0].length; j++) {
				sum = sum + accounts[i][j];
				finalMax = Math.max(sum, finalMax);
			}
		}
		return finalMax;
	}
}
