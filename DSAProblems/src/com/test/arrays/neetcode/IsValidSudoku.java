package com.test.arrays.neetcode;

import java.util.HashSet;
import java.util.Set;

public class IsValidSudoku {

	public static void main(String[] args) {

		boolean sudo = isSudo();

		System.out.println(sudo);
	}

	private static boolean isSudo() {
		char[][] board = {
	            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
	            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
	            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
	            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
	            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
	            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
	            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
	            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
	            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
	        };

		Set<String> hset = new HashSet();

		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				char num = board[row][col];
				if ( num!= '.') {
					

					if (	   !hset.add(num + "row" + row)
							|| !hset.add(num + "col" + col)
							|| !hset.add(num + "box" + (row/3) + (col / 3))) {
						return false;
					}
				}
			}
		}
		return true;
	}

}
