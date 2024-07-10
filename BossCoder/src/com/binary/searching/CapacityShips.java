package com.binary.searching;

public class CapacityShips {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 1, 1 };
		int days = 4;

		int shipWithinDays = shipWithinDays(arr, days);
		System.out.println(shipWithinDays);

	}

	private static int shipWithinDays(int[] arr, int days) {
		int maxWeight = -1;
		int totalWeight = 0;

		for (int wt : arr) {
			maxWeight = Math.max(maxWeight, wt);
			totalWeight += wt;
		}

		System.out.println(maxWeight);
		System.out.println(totalWeight);
		int left = maxWeight;
		int right = totalWeight;

		while (left < right) {
			int mid = (left + right) / 2;
			int daysNeeded = 1, currWeight = 0;
			for (int weight : arr) {
				if (weight + currWeight > mid) {
					daysNeeded++;
					currWeight = 0;
				}
				currWeight = currWeight + weight;
			}

			if (daysNeeded > days) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return left;
	}

	private static boolean canShipWithinCapacity(int[] weights, int capacity, int D) {
		int daysNeeded = 1;
		int currentWeight = 0;

		for (int weight : weights) {
			if (currentWeight + weight > capacity) {
				daysNeeded++;
				currentWeight = 0;
			}

			currentWeight += weight;
		}

		return daysNeeded <= D;
	}

	private static int shipWithinDaysSol2(int[] weights, int D) {
		int left = 0;
		int right = 0;

		for (int weight : weights) {
			left = Math.max(left, weight);
			right += weight;
		}

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (canShipWithinCapacity(weights, mid, D)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return left;
	}

}
