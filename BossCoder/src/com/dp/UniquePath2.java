package com.dp;

import java.util.ArrayList;
import java.util.List;

public class UniquePath2 {

	public static void main(String[] args) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();

		list.add(List.of(0, 0, 0));
		list.add(List.of(0, 1, 0));
		list.add(List.of(0, 0, 0));

		int solve = Codefile.solve(list);
		System.out.println(solve);

	}

}

class Codefile {
	static int solve(List<List<Integer>> input) {
		if (input == null || input.size() == 0) {
			return 0;
		}

		int m = input.size();
		int n = input.get(0).size();
		if (input.get(0).get(0) == 1 || input.get(m - 1).get(n - 1) == 1) {
			return 0;
		}
		int[][] dp = new int[m][n];

		dp[0][0] = 1;

		// first column
		for (int i = 1; i < m; i++) {
			if (input.get(i).get(0) == 1) {
				dp[i][0] = 0;
			} else {
				dp[i][0] = dp[i - 1][0];
			}
		}

		// first row
		for (int i = 1; i < n; i++) {
			if (input.get(0).get(i) == 1) {
				dp[0][i] = 0;
			} else {
				dp[0][i] = dp[0][i - 1];
			}
		}

		// fill remaning row
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (input.get(i).get(j) == 1) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}

		return dp[m - 1][n - 1];

	}
}