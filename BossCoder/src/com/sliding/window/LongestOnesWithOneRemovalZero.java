//package com.sliding.window;
//
//public class LongestOnesWithOneRemovalZero {
//
//	public static void main(String[] args) {
//		Solution solution = new Solution();
//
//		solution.longestSubarray(new int[] { 1,1,0,1 });
//
//	}
//
//}
//
//class Solution {
//	public int longestSubarray(int[] nums) {
//		int i = 0, j = 0;
//		int len = nums.length;
//		int zerosCount = 1;
//		int oneCount=0;
//		int max = 0;
//		while (j < len) {
//			if (nums[j] == 1) {
//				oneCount++;
//				max = Math.max(max, oneCount);
//			} else {
//				zerosCount--;
//				if(zerosCount == 0) {
//					i=
//				}
//				max = Math.max(max, j-i+1);
//				i++;
//			}
//			j++;
//		}
//		return max;
//	}
//}
