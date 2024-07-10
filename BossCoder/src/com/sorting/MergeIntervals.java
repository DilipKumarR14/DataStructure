package com.sorting;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] merge = merge(new int[][] { { 1, 3 }, { 8, 10 }, { 2, 6 }, { 15, 18 } });
		
		for (int[] is : merge) {
			System.out.println(Arrays.toString(is));
		}
	}

	public static int[][] merge(int[][] intervals) {
		if (intervals.length <= 1)
			return intervals;

		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		List<int[]> result = new LinkedList<int[]>();
		int[] newInterval = intervals[0];
		result.add(newInterval);

		for (int[] interval : intervals) {
		
			if (interval[0] <= newInterval[1]) {
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			} else {
				newInterval = interval;
				result.add(newInterval);
			}
		}

		return result.toArray(new int[result.size()][]);

	}
}