package com.maths1;

public class DiffSubMul {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		subtractProductAndSum(4421);
	}

	public static int subtractProductAndSum(int n) {
		int mul = 1;
		int sum = 0;

		int temp = n;

		while (temp > 0) {
			int digit = temp % 10;
			mul = digit * mul;
			sum = digit + sum;
			temp/= 10;
		}

		int i = mul - sum;
		System.out.println(i);
		return i;

	}

}
