package com.tree;

import java.util.ArrayList;

public class SumRoottoLeafNumbers {
	int total = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumRoottoLeafNumbers sumRoottoLeafNumbers = new SumRoottoLeafNumbers();

		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(9);
		root.right = new TreeNode(0);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(1);

		int sumNumbers = sumRoottoLeafNumbers.sumNumbers(root);

		System.out.println(sumNumbers);
	}

	public int sumNumbers(TreeNode root) {
		helper(root, 0);
		return total;
	}

	private void helper(TreeNode root, int sum) {
		if (root == null) {
			return;
		}

		sum = sum * 10 + root.val;
		System.out.println("Current node value: " + root.val);
		System.out.println("Updated sum: " + sum);

		if (root.left == null && root.right == null) {
			total += sum;
			System.out.println("Leaf node reached. Adding sum to total: " + sum);
			return;
		}

		System.out.println("Traversing left child...");
		helper(root.left, sum);
		System.out.println("Traversing right child...");
		helper(root.right, sum);
	}
}
