package com.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
	List<List<Integer>> main = new ArrayList<List<Integer>>();
	List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PathSum2 pathSum2 = new PathSum2();

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		List<List<Integer>> pathSum = pathSum2.pathSum(root, 22);
		System.out.println(pathSum);
	}

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		helper(root, targetSum, list);
		return main;
	}

	private void helper(TreeNode root, int targetSum, List<Integer> list) {
		if (root == null) {
			return;
		}
		if (root.val < targetSum) {
			list.add(root.val);
		}
		if (root.left == null && root.right == null && targetSum == list.stream().reduce(0, (a, b) -> a + b)) {

			main.add(new ArrayList<>(list));

//			list = new ArrayList<>();
		}

		helper(root.left, targetSum, list);
		helper(root.right, targetSum, list);
		list.remove(list.size() - 1);
	}
}