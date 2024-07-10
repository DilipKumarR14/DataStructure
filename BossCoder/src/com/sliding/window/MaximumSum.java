package com.sliding.window;

import java.util.ArrayList;

public class MaximumSum {

	public static void main(String[] args) {

		int S = 12;
		int arr[] = {1, 2, 3, 7, 5 };

//		int len = arr.length;
//		for (int i = 0; i < len-1; i++) {
//			for (int j = i + 1; j < len-1; j++) {
//				int sum = 0;
//				for (int k = i; k < j; k++) {
//					sum += arr[k];
//					if (sum == S) {
//						System.out.println("i: " + i + ", j: " + k);
//						return;
//					}
//				}
//			}
//		}
		int i = 0, j = 0;

		int sum = 0;
		ArrayList<Integer> arrayList = new ArrayList<>();
		while (j < arr.length) {
			sum = sum + arr[j];

			while (sum > S) {
				sum = sum - arr[i];
				i++;
			}

			if (sum == S) {
				arrayList.add(i+1);
				arrayList.add(j+1);
				System.out.println(arrayList);
				return;
			}
			j++;

		}
		

		
	}

}
