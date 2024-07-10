package com.binary.searching;

import java.util.Arrays;

public class MagneticBalls {

	public static void main(String[] args) {
		maxDistance(new int[] {1,2,3,4,7}, 3);
	}

	public static int maxDistance(int[] position, int m) {

		Arrays.sort(position);

		int l = 0;
		int h = position[position.length - 1];

		int optimal = 0;

		while (l <= h) {
			int mid = l + (h - l) / 2;
			if (canPut(position, mid, m)) {
				optimal = mid;
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}

		return optimal;
	}

	private static boolean canPut(int[] position, int mid, int m) {
		int count = 1;
		int last = position[0];
		for (int i = 1; i < position.length; i++) {
			int j2 = position[i];
			int j = j2 - last;
			if (j >= mid) {
				last = j2;
				count++;
			}
		}
		return count >= m;
	}
}
