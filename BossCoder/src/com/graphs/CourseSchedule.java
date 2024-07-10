package com.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

	public static void main(String[] args) {

		Solution1 solution = new Solution1();

		// Test case 1
		int numCourses1 = 4;
		int[][] prerequisites1 = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		System.out.println("Test case 1:");
		System.out.println("Is it possible to finish all courses? " + solution.canFinish(numCourses1, prerequisites1));
		System.out.println();

		// Test case 2
		int numCourses2 = 2;
		int[][] prerequisites2 = { { 1, 0 }, { 0, 1 } };
		System.out.println("Test case 2:");
		System.out.println("Is it possible to finish all courses? " + solution.canFinish(numCourses2, prerequisites2));
		System.out.println();

		// Test case 3
		int numCourses3 = 3;
		int[][] prerequisites3 = { { 1, 0 }, { 2, 1 }, { 0, 2 } };
		System.out.println("Test case 3:");
		System.out.println("Is it possible to finish all courses? " + solution.canFinish(numCourses3, prerequisites3));

	}

}

/*
 * Intuition Modeling as a Graph: Visualize the courses as nodes in a directed
 * graph, where edges represent prerequisites.
 * 
 * Topological Sorting : Arr ange courses in a valid sequence where each course
 * is taken before its prerequisites.
 * 
 * Detecting Cycles : If a cycle exists (e.g., Course A requires Course B, but
 * Course B also requires Course A), it's impossible to complete all courses.
 * 
 * BFS Algorithm: Explore the graph breadth-first, starting from courses with no
 * prerequisites, and gradually adding courses as their prerequisites are
 * fulfilled. Approach
 * 
 * Edge Case Handling: Check for the single-course scenario.
 * 
 * Graph Creation: Build the adjacency list and calculate in-degrees.
 * 
 * BFS Initialization: Enqueue courses with in-degree 0. Topological Order
 * Construction: Dequeue a course from the queue. Add it to the topological
 * order. Decrement in-degrees of its dependent courses. Enqueue courses that
 * become free of prerequisites (in-degree 0).
 * 
 * Cycle Detection and Result: If the topological order contains all courses,
 * return true; otherwise, return false (indicating a cycle).
 * 
 * Complexity Time complexity: O(V + E) .
 * 
 * Space complexity:
 */

class Solution1 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {

		// Create adjacency list to represent course dependencies
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			adj.add(new ArrayList<>());
		}
		
		System.out.println("adj list "+adj);

		// Build adjacency list and calculate in-degrees
		int[] inDegree = new int[numCourses];
		for (int[] pre : prerequisites) {
			// Add edge from prerequisite to course
			adj.get(pre[1]).add(pre[0]);
			// Increment in-degree of course
			inDegree[pre[0]]++;
			
			System.out.println("After adding to adj list "+adj);
			System.out.println("inDegree "+Arrays.toString(inDegree));
		}

		// Perform topological sorting using BFS
		Queue<Integer> q = new LinkedList<>();
		// Enqueue courses with in-degree 0 (no prerequisites)
		for (int i = 0; i < numCourses; i++) {
			if (inDegree[i] == 0) {
				q.add(i);
			}
		}
		
		System.out.println("queue "+q);

		
		

		ArrayList<Integer> topoSeries = new ArrayList<>(); // Store topological order
		while (!q.isEmpty()) {
			int node = q.remove();
			topoSeries.add(node);
			// Update in-degrees of dependent courses
			for (int neighbor : adj.get(node)) {
				inDegree[neighbor]--;
				if (inDegree[neighbor] == 0) {
					// Enqueue course if it has no more prerequisites
					q.add(neighbor);
				}
			}
		}

		// If topological order contains all courses, then it's possible to complete
		// them
		return topoSeries.size() == numCourses;
	}
}