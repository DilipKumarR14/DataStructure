package com.assesement;

public class FourDividor {
	public static void main(String[] args) {
		int[] nums = { 21, 4, 7 };
		System.out.println("Sum of divisors of numbers with exactly four divisors: " + sumFourDivisors(nums));
	}

	public static int sumFourDivisors(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += getSumOfFourDivisors(num);
		}
		return sum;
	}

	public static int getSumOfFourDivisors(int num) {
		int count = 0;
		int sum = 0;
		for (int i = 1; i < Math.sqrt(num); i++) {
			if (num % i == 0) {
				count++;
				sum += i;
				if (i != num / i) {
					count++;
					sum += num / i;
				}
				if (count > 4) {
					return 0;
				}
			}
		}
		return count == 4 ? sum : 0;
	}

}
