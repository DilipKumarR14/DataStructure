package com.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class LevelOrderTraversal {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		printLevelOrder(root);
	}

	static void printLevelOrder(TreeNode root) {
		if (root == null) {
			return;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);

		List<List<Integer>> wrap = new ArrayList<>();

		while (!queue.isEmpty()) {

			int levelNum = queue.size();
			List<Integer> list = new LinkedList<Integer>();

			for (int i = 0; i < levelNum; i++) {
				if (queue.peek().left != null) {
					queue.offer(queue.peek().left);
				}
				if (queue.peek().right != null) {
					queue.offer(queue.peek().right);
				}

				list.add(queue.poll().val);
			}
			wrap.add(list);

		}
		System.out.println(wrap);

		for (int i = 0; i < wrap.size(); i++) {
			if (i % 2 != 0) {
				List<Integer> l = wrap.get(i);
				List<Integer> collect = l.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
				wrap.set(i, collect);
			}
		}
		System.out.println(wrap);


	}

}
