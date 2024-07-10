package com.tree;

import java.util.LinkedList;
import java.util.List;

public class RightViewTree {

	public static void main(String[] args) {
		List<Integer> arr = new LinkedList<Integer>();

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(4);

		System.out.println(root);

		traverse(root, 0, arr);

		System.out.println(arr);

	}

	static void traverse(TreeNode root, int level, List<Integer> arr) {
		if (root == null) {
			return;
		}

		if (level == arr.size()) {
			arr.add(root.val);
		}

		// Adding print statement to observe the traversal
		System.out.println("Node: " + root.val + " at level: " + level);
		System.out.println("arr "+arr);

		traverse(root.right, level + 1, arr);
		traverse(root.left, level + 1, arr);
	}

}
