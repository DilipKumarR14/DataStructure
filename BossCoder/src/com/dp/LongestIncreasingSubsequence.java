package com.dp;
import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		Sosslution sosslution = new Sosslution();
		
		
		int lengthOfLIS = sosslution.lengthOfLIS(new int[] {10,9,2,5,3,7});
		
		System.out.println(lengthOfLIS);
		

	}

}


class Sosslution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];

        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        System.out.println(Arrays.toString(dp));

        return Arrays.stream(dp).max().getAsInt();

    }
}

