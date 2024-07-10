package com.graph;

public class Provinces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] isConnected = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

		Solusatiqw solusatiqw = new Solusatiqw();
		int provinces = solusatiqw.findCircleNum(isConnected);
		System.out.println("Total number of provinces: " + provinces);

	}

}

class Solusatiqw {
	public int findCircleNum(int[][] isConnected) {
		int n = isConnected.length;
		int[] visited = new int[n];
		int count = 0;

		for (int i = 0; i < n; i++) {
			if (visited[i] == 0) {
				System.out.println("Starting DFS from city " + i);
				dfs(isConnected, visited, i);
				count++;
			}
		}

		return count;
	}

	public void dfs(int[][] isConnected, int[] visited, int i) {
		System.out.println("Visiting city " + i);
		visited[i] = 1;
		for (int j = 0; j < isConnected.length; j++) {
			if (isConnected[i][j] == 1 && visited[j] == 0) {
				System.out.println("City " + i + " is connected to city " + j + ". Starting DFS from city " + j);
				dfs(isConnected, visited, j);
			}
		}
	}
}
