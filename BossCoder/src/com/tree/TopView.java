package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
}

class Pair {
	Node node;
	int hd; // Horizontal distance from the root

	public Pair(Node node, int hd) {
		this.node = node;
		this.hd = hd;
	}

	public Pair(TreeNode root, int hd2) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Pair [node=" + node.data + ", hd=" + hd + "]";
	}
}

class Solution2 {
	// Function to return a list of nodes visible from the top view
	// from left to right in Binary Tree.
	static ArrayList<Integer> topViews(Node root) {
		ArrayList<Integer> ans = new ArrayList<>();
		if (root == null)
			return ans;

		Map<Integer, Integer> map = new TreeMap<>();
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(root, 0));

//        System.out.println("Starting BFS traversal...");
		while (!q.isEmpty()) {
			Pair it = q.poll();
//            System.out.println("Processing pair: " + it);
			int hd = it.hd;
			Node temp = it.node;
//            System.out.println("Current node: " + temp);
//            System.out.println("Map before adding node: " + map);

			if (!map.containsKey(hd)) {
				map.put(hd, temp.data);
//                System.out.println("Added node to map: " + hd + " -> " + temp.data);
			} else {
//                System.out.println("Node at hd " + hd + " already exists, ignoring...");
			}

//            System.out.println("Map after adding node: " + map);

			if (temp.left != null) {
				q.add(new Pair(temp.left, hd - 1));
//                System.out.println("Enqueued left child: " + temp.left);
			}
			if (temp.right != null) {
				q.add(new Pair(temp.right, hd + 1));
//                System.out.println("Enqueued right child: " + temp.right);
			}

//            System.out.println("Queue after adding children: " + q);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			ans.add(entry.getValue());
		}
		System.out.println("ArrayList: " + ans);

		return ans;
	}
}

public class TopView {
	public static void main(String[] args) {
		// Creating a binary tree
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.left.right.right = new Node(5);
		root.left.right.right.right = new Node(6);

		// Calling the topView method
		ArrayList<Integer> result = Solution2.topViews(root);

		// Printing the result
		System.out.println("Nodes visible from top view:");
		for (Integer nodeValue : result) {
			System.out.print(nodeValue + " ");
		}
	}
}
