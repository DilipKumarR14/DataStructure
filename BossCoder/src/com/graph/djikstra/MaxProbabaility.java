package com.graph.djikstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxProbabaility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3; // Number of nodes
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 0, 2 } }; // Edges
		double[] succProb = { 0.5, 0.5, 0.2 }; // Success probabilities for each edge
		int start = 0; // Start node
		int end = 2; // End node

		Soludstion solution = new Soludstion();
		double maxProb = solution.maxProbability(n, edges, succProb, start, end);

		System.out.println("Maximum probability of reaching node " + end + " from node " + start + " is: " + maxProb);

	}

}

class Soludstion {
	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
		// Create a graph represented as an adjacency list
		Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();
		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0], v = edges[i][1];
			double pathProb = succProb[i];
			// Add edges to the graph
			graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair<>(v, pathProb));
			graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair<>(u, pathProb));
		}

		// Array to store the maximum probability of reaching each node
		double[] maxProb = new double[n];
		maxProb[start] = 1d; // Starting node has probability 1

		// Priority queue to process nodes with highest probability first
		PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>(
				(a, b) -> -Double.compare(a.getKey(), b.getKey())); // Max-heap based on probability
		pq.add(new Pair<>(1.0, start)); // Add start node with probability 1

		// Dijkstra's algorithm to find the maximum probability path
		while (!pq.isEmpty()) {
			Pair<Double, Integer> cur = pq.poll();
			double curProb = cur.getKey(); // Current probability
			int curNode = cur.getValue(); // Current node
			if (curNode == end) {
				return curProb; // If reached end node, return the maximum probability
			}
			// Iterate through neighbors of current node
			for (Pair<Integer, Double> nxt : graph.getOrDefault(curNode, new ArrayList<>())) {
				int nxtNode = nxt.getKey(); // Next node
				double pathProb = nxt.getValue(); // Probability of the edge to next node
				// Update the maximum probability of reaching the next node
				if (curProb * pathProb > maxProb[nxtNode]) {
					maxProb[nxtNode] = curProb * pathProb;
					// Add the next node to the priority queue with updated probability
					pq.add(new Pair<>(maxProb[nxtNode], nxtNode));
				}
			}
		}

		return 0d; // If end node is unreachable, return 0
	}
}
