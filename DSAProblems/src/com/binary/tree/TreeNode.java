package com.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

public class TreeNode {

	public TreeNode left;
	public TreeNode right;
	public int val;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return "TreeNode [left=" + left + ", right=" + right + ", val=" + val + "]";
	}

}

class BinaryTree {

	private TreeNode root;

	public BinaryTree() {
		root = null;
	}

	public void setValues(int[] values) {
		for (int value : values) {
			insert(value);
		}
	}

	private void insert(int value) {
		TreeNode newNode = new TreeNode(value);
		if (root == null) {
			root = newNode;
			return;
		}

		TreeNode currentNode = root;
		while (true) {
			if (value < currentNode.val) {
				if (currentNode.left == null) {
					currentNode.left = newNode;
					break;
				} else {
					currentNode = currentNode.left;
				}
			} else {
				if (currentNode.right == null) {
					currentNode.right = newNode;
					break;
				} else {
					currentNode = currentNode.right;
				}
			}
		}
	}

	public TreeNode printTree() {
		if (root == null) {
			System.out.println("Tree is empty");
			return root;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode currentNode = queue.remove();
			System.out.print(currentNode.val + " ");

			if (currentNode.left != null) {
				queue.add(currentNode.left);
			}

			if (currentNode.right != null) {
				queue.add(currentNode.right);
			}
		}
		
		TreeNode treeNode = getTreeNode(root);
		
		return treeNode;
		
	}

	public TreeNode getTreeNode(TreeNode node) {
		return node;
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		int[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		tree.setValues(values);

		tree.printTree();
	}
}
