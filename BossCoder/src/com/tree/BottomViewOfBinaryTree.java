package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;



public class BottomViewOfBinaryTree {

    static List<Integer> bottomView(Node root) {
        List<Integer> bottomViewNodes = new ArrayList<>();
        if (root == null)
            return bottomViewNodes;

        Map<Integer, Integer> hdNodeMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        System.out.println("Starting BFS traversal...");
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            Node node = pair.node;
            int hd = pair.hd;

            System.out.println("Processing pair: " + pair);
            System.out.println("Current node: " + node);

            // Update the horizontal distance to always store the last encountered node
            hdNodeMap.put(hd, node.data);

            System.out.println("Map after adding node: " + hdNodeMap);

            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
                System.out.println("Enqueued left child: " + node.left);
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
                System.out.println("Enqueued right child: " + node.right);
            }
            System.out.println("Queue after adding children: " + queue);
        }

        // Populate the list with nodes visible from the bottom view
        for (int nodeVal : hdNodeMap.values()) {
            bottomViewNodes.add(nodeVal);
        }

        return bottomViewNodes;
    }

    public static void main(String[] args) {
        // Creating a binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);

        // Finding bottom view nodes
        List<Integer> result = bottomView(root);

        // Printing the result
        System.out.println("Nodes visible from bottom view:");
        for (int nodeVal : result) {
            System.out.print(nodeVal + " ");
        }
    }
}
