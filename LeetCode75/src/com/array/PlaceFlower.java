package com.array;

public class PlaceFlower {

	public static void main(String[] args) {
		int[] bed = { 1, 0, 0, 0, 1, 0, 0 };
		int flow = 2;

		boolean canPlaceFlowers = canPlaceFlowers(bed, flow);
		
		System.out.println(canPlaceFlowers);
	}
	

	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		int len = flowerbed.length;
		for (int i = 0; i < len - 1; i++) {
			if (flowerbed[i] == 1) {
				int j = i + 2;
				while (j < len - 1) {
					if (flowerbed[j] == 0 && flowerbed[j + 1] != 1) {
						n--;
						if (n == 0) {
							break;
						}
					}
					j += 2;
				}
			} else {
				if (flowerbed[i + 1] != 1) {
					n--;
					if (n == 0) {
						break;
					}
				}
			}
			break;
		}
		return n == 0;
	}

}
