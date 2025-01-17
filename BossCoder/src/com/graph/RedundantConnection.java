package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RedundantConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solutiona solutiona = new Solutiona();

		int[] findRedundantConnection = solutiona.findRedundantConnection(new int[][] { { 1, 2} , { 1, 3 } , { 2, 3 }});
		
		System.out.println(Arrays.toString(findRedundantConnection));
		
	}

}

class Solutiona {
	Set<Integer> seen = new HashSet();
	int MAX_EDGE_VAL = 1000;

	public int[] findRedundantConnection(int[][] edges) {
		ArrayList<Integer>[] graph = new ArrayList[MAX_EDGE_VAL + 1];
		for (int i = 0; i <= MAX_EDGE_VAL; i++) {
			graph[i] = new ArrayList();
		}
		for (int[] edge : edges) {
			seen.clear();
			boolean fir = !graph[edge[0]].isEmpty();
			boolean sec = !graph[edge[1]].isEmpty();
			boolean dfs = dfs(graph, edge[0], edge[1]);
			if (fir && sec && dfs) {
				return edge;
			}
			graph[edge[0]].add(edge[1]);
			graph[edge[1]].add(edge[0]);
//			throw new AssertionError();
		}
		return null;
	}

	public boolean dfs(ArrayList<Integer>[] graph, int source, int target) {
		if (!seen.contains(source)) {
			seen.add(source);
			if (source == target)
				return true;
			for (int nei : graph[source]) {
				if (dfs(graph, nei, target))
					return true;
			}
		}
		return false;
	}
}