package com.tree;

import java.util.ArrayList;
import java.util.List;

public class BottomLeftTreeValue {
	static List<Integer> list = new ArrayList<Integer>();
	static int maxDepth = 0;

	public static void main(String[] args) {
		int currentDepth = 0;
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.left.left = new TreeNode(7);
		helper(root, currentDepth);

		System.out.println(list);
	}

	private static void helper(TreeNode root, int currentDepth) {

		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			if (currentDepth > maxDepth) {
				maxDepth = currentDepth;
				list.remove(list.size() - 1);

			}
			if (!list.isEmpty()) {
				list.add(root.val);
			}
		}

		helper(root.left, currentDepth + 1);
		helper(root.right, currentDepth + 1);
	}

}