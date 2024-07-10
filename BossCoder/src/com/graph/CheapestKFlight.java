package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestKFlight {

	public static void main(String[] args) {
		Solution solution = new Solution();

		// Example usage:
		int n = 5; // Number of nodes
		int[][] flights = { { 0, 1, 100 }, // [source, destination, price]
				{ 1, 2, 100 }, { 2,0,100 }, { 1,3,600}, { 2,3,200 }
				// Add more flights as needed
		};
		int src = 0; // Source node
		int dst = 3; // Destination node
		int k = 1; // Maximum number of stops allowed

		int cheapestPrice = solution.findCheapestPrice(n, flights, src, dst, k);
		System.out.println(
				"Cheapest price from " + src + " to " + dst + " with at most " + k + " stops: " + cheapestPrice);

	}

}

class Solution {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		HashMap<Integer, ArrayList<int[]>> adj = new HashMap<>();

		for (int[] flight : flights) {
			adj.computeIfAbsent(flight[0], key -> new ArrayList<>()).add(new int[] { flight[1], flight[2] });
		}
		
		extracted(adj);

		int visited[] = new int[n];
		Arrays.fill(visited, Integer.MAX_VALUE);
		visited[src] = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { src, 0 });
		k++;
		while (!queue.isEmpty() && k-- > 0) {
			int size = queue.size();
			while (size-- > 0) {
				int[] curr = queue.poll();
				int currNode = curr[0];
				int currPrice = curr[1];
				if (adj.containsKey(currNode)) {
					for (int[] neighbours : adj.get(currNode)) {
						int newPrice = currPrice + neighbours[1];
						if (newPrice < visited[neighbours[0]]) {
							visited[neighbours[0]] = newPrice;
							queue.offer(new int[] { neighbours[0], newPrice });
						}
					}
				}
			}
		}
		if (visited[dst] == Integer.MAX_VALUE)
			return -1;
		return visited[dst];
	}

	private void extracted(HashMap<Integer, ArrayList<int[]>> adj) {
		System.out.println("Contents of adj HashMap:");
        for (int key : adj.keySet()) {
            System.out.print(key + ": ");
            ArrayList<int[]> neighbours = adj.get(key);
            for (int[] neighbour : neighbours) {
                System.out.print(Arrays.toString(neighbour) + " ");
            }
            System.out.println();
        }
	}
}
