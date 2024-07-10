package com.maths1;

public class Gcd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 45;
		int y = 27;
		int gcd = gcd(x, y) ;
		System.out.println("gcd "+gcd);

		
		while(gcd(x, y) != 1) {
			x = x / gcd(x,y);
		}
		
		System.out.println("x : "+x);
		
		
	}
	
	private static int gcd(int x, int y) {
		while(y!=0) {
			int temp = y;
			y = x % y;
			x=temp;
		}
		return x;
		
		
	}

}
