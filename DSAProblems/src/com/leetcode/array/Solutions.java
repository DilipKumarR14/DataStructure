package com.leetcode.array;

import java.util.Arrays;

public class Solutions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		duplicateZeros(new int[] { 1, 0, 2, 3, 0, 4, 5, 0 });
	}

	public static void duplicateZeros(int[] arr) {
		int[] temp = new int[arr.length];
		int j = 0;// pointing to arr array
//		Arrays.fill(temp, -1);
		for (int i = 0; i < arr.length - 1; i++) {
			int k = arr[i];
			if (k != 0) {
				temp[i] = arr[j];
				j++;
			} else {
//                temp[i]=0;
                temp[i+1]=0;
                
			}
			System.out.println(Arrays.toString(temp));
		}
		arr = temp;
	}

}
