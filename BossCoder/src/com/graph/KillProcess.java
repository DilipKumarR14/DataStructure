package com.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KillProcess {

	public static void main(String[] args) {
		Solhgftion solhgftion = new Solhgftion();

		List<Integer> pid = List.of(1, 3, 10, 5);

		List<Integer> ppid = List.of(3, 0, 5, 3);

		List<Integer> killProcess = solhgftion.killProcess(pid, ppid, 5);

		System.out.println(killProcess);

	}

}

class Solhgftion {
	private Map<Integer, List<Integer>> g = new HashMap<>();
	private List<Integer> ans = new ArrayList<>();

	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		int n = pid.size();
		for (int i = 0; i < n; ++i) {
			g.computeIfAbsent(ppid.get(i), k -> new ArrayList<>()).add(pid.get(i));
		}
		dfs(kill);
		return ans;
	}

	private void dfs(int i) {
		ans.add(i);
		for (int j : g.getOrDefault(i, Collections.emptyList())) {
			dfs(j);
		}
	}
}