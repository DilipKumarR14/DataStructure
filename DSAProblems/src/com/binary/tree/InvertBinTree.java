package com.binary.tree;

public class InvertBinTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 4,2,7,1,3,6,9
		BinaryTree tree = new BinaryTree();

		int[] values = { 4, 2, 7, 1, 3, 6, 9 };
		tree.setValues(values);

		InvertBinTree invertBinTree = new InvertBinTree();

		TreeNode printTree = tree.printTree();

		invertBinTree.invertTree(printTree);
		System.out.println();
		tree.printTree();

	}

	public TreeNode invertTree(TreeNode root) {

		if (root == null) {
			return root;
		}

		TreeNode temp = root.left;
		
//		System.out.println("temp left:  " + temp.left);
//		System.out.println("temp right:  " + temp.right);
		
		root.left = root.right;
		root.right = temp;

		invertTree(root.left);
		invertTree(root.right);

		return root;

	}

}
