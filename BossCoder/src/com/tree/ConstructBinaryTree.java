package com.tree;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ConstructBinaryTree {

	public static void main(String[] args) {

		int[] inorder = { 4, 2, 5, 1, 6, 3, 7 };
		int[] postorder = { 4, 5, 2, 6, 7, 3, 1 };

		int target = postorder[postorder.length - 1];

		System.out.println("target " + target);


		int collect = Arrays.stream(inorder)
				.boxed().collect(Collectors.toList()).indexOf(target);
		
			
		System.out.println("index " + collect);
		
	}
}
