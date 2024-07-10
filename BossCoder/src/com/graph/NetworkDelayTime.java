package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

public class NetworkDelayTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solutdfson solutdfson = new Solutdfson();
		int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
		int n = 4; // Total number of nodes
		int k = 2; // Starting node
		// Calling the method to calculate the network delay time
		int networkDelayTime = solutdfson.networkDelayTime(times, n, k);

		System.out.println(networkDelayTime);

	}

}

class Solutdfson {
	public int networkDelayTime(int[][] times, int n, int k) {

		// Creating an adjacency list to represent the graph
		Map<Integer, List<int[]>> graph = new HashMap<>();
		// Building the adjacency list from the given 'times' array
		for (int[] edge : times) {
			int source = edge[0];
			int target = edge[1];
			int weight = edge[2];
			// Adding the target node and its corresponding weight to the source node's list
			// of neighbors
			graph.putIfAbsent(source, new ArrayList<>());
			graph.get(source).add(new int[] { target, weight });
		}
		
		printArr(graph);

		// Initializing the distances array to store the shortest distance to each node
		// from the starting node
		int[] distances = new int[n + 1];
		Arrays.fill(distances, Integer.MAX_VALUE); // Initially set all distances to infinity
		distances[k] = 0; // Distance from the starting node to itself is 0

		// Using a priority queue (min heap) to keep track of nodes with minimum
		// distance
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		minHeap.offer(new int[] { k, 0 }); // Adding the starting node to the min heap

		// Dijkstra's algorithm to find the shortest path
		while (!minHeap.isEmpty()) {
			int[] currentNode = minHeap.poll(); // Extract the node with the shortest distance from the min heap
			int node = currentNode[0];
			int distance = currentNode[1];

			// If we've already processed this node with a shorter distance, skip
			if (distance > distances[node])
				continue;

			// Iterate through all neighbors of the current node
			if (graph.containsKey(node)) {
				for (int[] neighbor : graph.get(node)) {
					int nextNode = neighbor[0];
					int nextDistance = distance + neighbor[1];
					// Update distance if we found a shorter path
					if (nextDistance < distances[nextNode]) {
						distances[nextNode] = nextDistance;
						minHeap.offer(new int[] { nextNode, nextDistance });
					}
				}
			}
		}

		// Finding the maximum distance from the starting node to any other node
		int maxDistance = 0;
		for (int i = 1; i <= n; i++) {
			if (distances[i] == Integer.MAX_VALUE)
				return -1; // If any node is unreachable, return -1
			maxDistance = Math.max(maxDistance, distances[i]);
		}

		return maxDistance;
	}

	private void printArr(Map<Integer, List<int[]>> graph) {
		for (Map.Entry<Integer, List<int[]>> entry : graph.entrySet()) {
	        int node = entry.getKey();
	        List<int[]> neighbors = entry.getValue();
	        // Printing the node and its neighbors
	        System.out.print("Node " + node + " -> ");
	        for (int[] neighbor : neighbors) {
	            int target = neighbor[0];
	            int weight = neighbor[1];
	            System.out.print("(" + target + ", " + weight + ") ");
	        }
	        System.out.println();
	    }
		
	}
}