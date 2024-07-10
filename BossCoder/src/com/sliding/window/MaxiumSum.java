package com.sliding.window;

public class MaxiumSum {

	public static void main(String[] args) {

		int N = 5;
		int arr[] = { -1, -2, -3, -4 };

		int i = 0, j = 0, max = 0, sum = 0;

		while (j < N - 1) {
			sum += arr[j];
			if (sum > max) {
				max = Math.max(max, sum);
//				sum -= arr[i];
//				i++;
			}

//			if(max<sum) {
//				sum
//			}
			j++;
		}
		if (sum < 0) {
			max = -1;
		}
		System.out.println(max);
	}

}
