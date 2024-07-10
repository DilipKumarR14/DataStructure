package com.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalTravsersal {
	static Map<Integer, List<Integer>> hmap = new HashMap<Integer, List<Integer>>();

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		traverse(root, 0);

		// Convert HashMap to TreeMap for sorting based on keys
		TreeMap<Integer, List<Integer>> sortedMap = new TreeMap<>(hmap);

		// Return values from the sorted map
		ArrayList<List<Integer>> arrayList = new ArrayList<>(sortedMap.values());
//			 arrayList;
		System.out.println(arrayList);
	}

	public static List<List<Integer>> traverse(TreeNode root, int level) {
		if (root == null) {
			return new ArrayList<>(hmap.values());
		}

		if (hmap.containsKey(level)) {
			hmap.get(level).add(root.val);
            Collections.sort(hmap.get(level)); // Sort the values within each list

		} else {
			List<Integer> subList = new ArrayList<>();
			subList.add(root.val);
			hmap.put(level, subList);
		}

		traverse(root.left, level - 1);
		traverse(root.right, level + 1);

		System.out.println(hmap);


		return new ArrayList<>(hmap.values());
	}
}