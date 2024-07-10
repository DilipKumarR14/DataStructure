package com.bitwise.ops;

public class ReverseBits {
	// Method to reverse the bits of a 32-bit unsigned integer
	public static int reverseBits(int n) {
		// Initialize the result to 0
		int result = 0;

		// Iterate through each bit of the input integer (32 bits)
		for (int i = 0; i < 4; i++) {
			System.out.println("**************");

			System.out.println("i= " + i);
			System.out.println("n= " + Integer.toBinaryString(n));

			// Shift the result to the left to make room for the next bit
			System.out.println("result step 1: " + Integer.toBinaryString(result));

			result = (result << 1);
			System.out.println("result step 2: " + Integer.toBinaryString(result));

			// Bitwise OR the result with the least significant bit of the input integer
			// This extracts the current bit of the input integer and sets it in the result
			int j = n & 1;
			System.out.println("result step n & 1: " + Integer.toBinaryString(j));

			result = result | j;
			System.out.println("result step 3 :" + Integer.toBinaryString(result));


			// Right-shift the input integer by 1 to move to the next bit
			// Use the unsigned right shift operator (>>>) to fill the leftmost bit with
			// zero
			n >>>= 1;
			System.out.println("triple right shift n: " + Integer.toBinaryString(n));
			System.out.println("**************");


		}
		// The result now contains the reversed bits of the input integer
		return result;
	}

	// Main method for example usage
	public static void main(String[] args) {
		// Example usage:
		// Given input binary: 00000010100101000001111010011100
		// Corresponding decimal: 43261596
//		int inputInteger = 0b00000010100101000001111010011100;
		int inputInteger = 1011;

		System.out.println("inputInteger " + inputInteger);

		// Reverse the bits using the reverseBits method
		int outputInteger = reverseBits(inputInteger);

		// Print the result
		System.out.println(outputInteger);
	}
}
