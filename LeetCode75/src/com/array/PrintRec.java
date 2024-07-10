package com.array;

public class PrintRec {

    public static void main(String[] args) {
        int n = 2;

        if(n<3) {
        	System.out.println("shut up i wont code");
        	return;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
