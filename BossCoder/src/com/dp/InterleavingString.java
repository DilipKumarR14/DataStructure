package com.dp;

public class InterleavingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution5 solution5 = new Solution5();

		boolean interleave = solution5.isInterleave("aabcc", "dbbca", "aadbbcbcac");

		System.out.println(interleave);
	}

}

class Solution5 {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return Boolean.FALSE;

		boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = Boolean.TRUE;
				} else if (i == 0) {
					dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
					System.out.println(
							"Comparing " + s2.charAt(j - 1) + " from s2 with " + s3.charAt(i + j - 1) + " from s3");

				} else if (j == 0) {
					dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
					System.out.println(
							"Comparing " + s1.charAt(i - 1) + " from s1 with " + s3.charAt(i + j - 1) + " from s3");

				} else {
					boolean b = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
					boolean a = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);

					dp[i][j] = b || a;
					System.out.println("Comparing Both ");
					System.out.println(
							"Comparing " + s1.charAt(i - 1) + " from s1 with " + s3.charAt(i + j - 1) + " from s3");
					System.out.println(
							"Comparing " + s2.charAt(j - 1) + " from s2 with " + s3.charAt(i + j - 1) + " from s3");

				}
				// Debugging: Print dp array at each iteration
				System.out.println("dp[" + i + "][" + j + "] = " + dp[i][j]);
			}
		}
		System.out.println("DP Table:");
		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				System.out.print(dp[i][j] + " | ");
			}
			System.out.println();
		}
		return dp[s1.length()][s2.length()];
	}
}
