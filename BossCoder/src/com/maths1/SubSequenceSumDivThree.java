package com.maths1;

public class SubSequenceSumDivThree {

	public static void main(String[] args) {

		extracted();

	}

	private static int extracted() {
		int[] arr = { 1, 2, 4, 3, 6 };
		int len = arr.length;
		int m = 3;
//		int count = 0;
//
//		for (int i = 0; i < len; i++) {
//			for (int j = i + i; j < len; j++) {
//				for (int k = j + 1; k < len; k++) {
//					int sum = arr[i] + arr[j] + arr[k];
//					if (sum % m == 0) {
//						count++;
//					}
//				}
//			}
//		}
//
//		System.out.println(count);

		if (arr.length < 3) {
			return 0;
		}

		int sum = 0;
		int count = 0;

		for (int i = 0; i < len; i++) {
			int j = i + 1;
			int k = j + 1;

			while (k < len) {
				int k2 = arr[i];
				int l = arr[j];
				int l2 = arr[k];
				sum += k2 + l + l2;
				if (sum % m == 0) {
					count++;
				}else {
					sum = 0;
				}
				j++;
				k++;
			}

		}

		System.out.println("count " + count);
		return count;
	}

}
