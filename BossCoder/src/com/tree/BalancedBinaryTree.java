package com.tree;

public class BalancedBinaryTree {

	public static void main(String[] args) {

		Solution solution = new Solution();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		boolean balanced = solution.isBalanced(root);
		System.out.println(balanced);
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
	}
	
	
}

class Solution {
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			System.out.println("Node is null. Returning true.");
			return true;
		}

		int height = Height(root);
		System.out.println("Height of tree: " + height);

		return height == -1 ? false : true;
	}

	public int Height(TreeNode root) {
		if (root == null) {
			System.out.println("Node is null. Returning height 0.");
			return 0;
		}

		int leftHeight = Height(root.left);
		int rightHeight = Height(root.right);

		System.out.println("Left Height: " + leftHeight + ", Right Height: " + rightHeight);

		if (leftHeight == -1 || rightHeight == -1) {
			System.out.println("Left or right subtree is unbalanced. Returning -1.");
			return -1;
		}

		if (Math.abs(leftHeight - rightHeight) > 1) {
			System.out.println("Subtrees are unbalanced. Returning -1.");
			return -1;
		}

		int currentHeight = Math.max(leftHeight, rightHeight) + 1;
		System.out.println("Current Height: " + currentHeight);
		return currentHeight;
	}
}
