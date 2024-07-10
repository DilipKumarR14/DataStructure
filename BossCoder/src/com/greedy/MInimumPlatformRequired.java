package com.greedy;

import java.util.Arrays;

public class MInimumPlatformRequired {

	public static void main(String[] args) {
		int[] arrival = { 900, 940 };
		int[] departure = { 910, 1200 };

		int platFormRequired = 1;
		int min = 1;

		Arrays.sort(arrival);
		Arrays.sort(departure);

		int start = 1, end = 0;
		int len = arrival.length;
		while (start < len && end < len) {
			if (arrival[start] < departure[end]) {
				platFormRequired++;
				start++;
			} else {
				platFormRequired--;
				end++;
			}
			min = Math.max(min, platFormRequired);
		}
		
		System.out.println("min platform "+min);

	}

}
