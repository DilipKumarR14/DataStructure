package com.array;

import java.util.Arrays;

public class TrappingRainWater {

	public static void main(String[] args) {
		int[] height = {4,2,0,3,2,5 };
		int trap = trap(height);

		// System.out.println(trap);
	}

	public static int trap(int[] height) {
		int len = height.length;
		int[] maxLeft = new int[len];
		int[] maxRight = new int[len];
		//System.out.println("Height " + Arrays.toString(height));

		int maxi = 0;
		

		for (int i = 0; i <= len-1; i++) {
			maxi = Math.max(maxi, Math.max(maxLeft[i], height[i]));
			maxLeft[i] = maxi;
		}
		System.out.println("MaX Length lEFT " + Arrays.toString(maxLeft));

		maxi = 0;

		for (int i = len - 1; i >= 0; i--) {
			maxi = Math.max(maxi, Math.max(maxRight[i], height[i]));
			maxRight[i] = maxi;
		}

		System.out.println("MaX Length rIGHT " + Arrays.toString(maxRight));

		int waterLevel = 0;
		for (int i = 0; i < len; i++) {
			int min = Math.min(maxLeft[i], maxRight[i]);
			int a = min - height[i];
			waterLevel+= Math.max(a, 0);
		}

		System.out.println(waterLevel);

		return waterLevel;

	}

}
