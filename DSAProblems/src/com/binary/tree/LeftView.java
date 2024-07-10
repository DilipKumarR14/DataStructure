package com.binary.tree;

import java.util.ArrayList;

public class LeftView {

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.right = new Node(8);

//		System.out.println(root);
		ArrayList<Integer> leftView = leftView(root);
		System.out.println(leftView);

	}

	static ArrayList<Integer> arrayList = new ArrayList<Integer>();

	public static ArrayList<Integer> leftView(Node root) {
		arrayList.add(root.data);

		while (root.left != null) {

			Node temp = root.left;

			arrayList.add(temp.data);

			root = root.left;

			if (root.left == null) {
				if (root.right != null) {
					arrayList.add(root.right.data);
				}
			}
		}

		return arrayList;
	}

}

//A Binary Tree node
class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
	}

}
