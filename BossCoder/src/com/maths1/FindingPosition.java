package com.maths1;

import java.util.Scanner;

public class FindingPosition {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter the number of people in the original queue: ");
			int n = scanner.nextInt();

			int position = findLastPersonPosition(n);

			System.out.println("The position of the last person in the original queue is: " + position);
		}
    }

    static int findLastPersonPosition(int n) {
    	int m = 0;
        while (Math.pow(2, m) <= n) {
            m++;
        }

        return (int) Math.pow(2, m - 1) ;
    }
}

