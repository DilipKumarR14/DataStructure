package com.graph.bellman;

import java.util.*;

class Edge {
	int source, destination, weight;

	public Edge(int source, int destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}
}

public class BellmanFord {
	int vertices, edges;
	List<Edge> edgeList;

	public BellmanFord(int vertices, int edges) {
		this.vertices = vertices;
		this.edges = edges;
		edgeList = new ArrayList<>();
	}

	public void addEdge(int source, int destination, int weight) {
		edgeList.add(new Edge(source, destination, weight));
	}

	public void bellmanFord(int source) {
		int[] distance = new int[vertices];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[source] = 0;

		for (int i = 1; i <= vertices - 1; i++) {
			for (Edge edge : edgeList) {
				if (distance[edge.source] != Integer.MAX_VALUE
						&& distance[edge.source] + edge.weight < distance[edge.destination]) {
					distance[edge.destination] = distance[edge.source] + edge.weight;
				}
			}
		}

		// Check for negative cycles
		for (Edge edge : edgeList) {
			if (distance[edge.source] != Integer.MAX_VALUE
					&& distance[edge.source] + edge.weight < distance[edge.destination]) {
				System.out.println("Graph contains negative cycle");
				return;
			}
		}

		// Print shortest distances
		System.out.println("Vertex Distance from Source:");
		for (int i = 0; i < vertices; ++i) {
			System.out.println(i + "\t\t" + distance[i]);
		}
	}

	public static void main(String[] args) {
		int vertices = 5;
		int edges = 8;
		BellmanFord graph = new BellmanFord(vertices, edges);

		graph.addEdge(0, 1, -1);
		graph.addEdge(0, 2, 4);
		graph.addEdge(1, 2, 3);
		graph.addEdge(1, 3, 2);
		graph.addEdge(1, 4, 2);
		graph.addEdge(3, 2, 5);
		graph.addEdge(3, 1, 1);
		graph.addEdge(4, 3, -3);

		graph.bellmanFord(0);
	}
}
