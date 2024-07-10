package com.dp;

public class LongestPalindrome {

	public static void main(String[] args) {
		Solution32 solution32 = new Solution32();

		String longestPalindrome = solution32.longestPalindrome("babad");

		System.out.println(longestPalindrome);

	}

}

class Solution32 {
    public String longestPalindrome(String s) {
        for (int length = s.length(); length > 0; length--) {
            for (int start = 0; start <= s.length() - length; start++) {
				int x = start + length;
				System.out.println("len: " + length + ", start: " + start+", end : " + x);

				
                if (check(start, x, s)) {
                    return s.substring(start, x);
                }
            }
        }
        
        return "";
    }
    
    private boolean check(int i, int j, String s) {
        int left = i;
        int right = j - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
}