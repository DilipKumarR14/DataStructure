package com.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWinMax {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
//		List<Integer> maxSlidingWindow = maxSlidingWindow(nums, k);
		int[] maxSlidingWindowSolution2 = maxSlidingWindowSolution2(nums, k);

		System.out.println(Arrays.toString(maxSlidingWindowSolution2));
	}

	public static List<Integer> maxSlidingWindow(int[] nums, int k) {
		int len = nums.length;
		List<Integer> list = new LinkedList<Integer>();

		int start = 0, end = k;

		while (end <= len) {
			int maxi = slidingWindows(nums, start, end);
			if (maxi == 0) {
				maxi = 0;
			}
			list.add(maxi);
			start = start + 1;
			end = end + 1;
		}

		int[] arr = new int[list.size()];

		for (int a = 0; a < arr.length; a++) {
			arr[a] = list.get(a);
		}

		System.out.println(Arrays.toString(arr));

		return list;
	}

	private static int slidingWindows(int[] nums, int a, int b) {
		int max = -1;

		for (int i = a; i < b; i++) {
			max = Math.max(max, nums[i]);
		}
		return max;
	}

	public static int[] maxSlidingWindowSolution2(int[] nums, int k) {
		System.out.println("nums " + Arrays.toString(nums));
		List<Integer> res = new ArrayList<>();
		int left = 0;
		int right = 0;
		Deque<Integer> q = new ArrayDeque<>();

		while (right < nums.length) {
			System.out.println("While start " + q);
			// peekLast Retrieves, but does not remove, the last element of this deque,or
			// returns null if this deque is empty.

			// pollLast Retrieves and removes the last element of this deque,or returns null
			// if this deque is empty.
			// offerLast Inserts the specified element at the end of this deque

			// peekFirst Retrieves, but does not remove, the first element of this deque,or returns null if this deque is empty.

			// pollFirst Retrieves and removes the first element of this deque,or returns null if this deque is empty.

			while (!q.isEmpty() && nums[right] > nums[q.peekLast()]) {
				Integer pollLast = q.pollLast();
			}
			System.out.println("After PollLast " + q);

			boolean offerLast = q.offerLast(right);

			System.out.println("OfferLast  " + q);

			if (left > q.peekFirst()) {
				Integer pollFirst = q.pollFirst();
			}

			if (right + 1 >= k) {
				res.add(nums[q.peekFirst()]);
				left++;
			}
			right++;
		}

		return res.stream().mapToInt(Integer::intValue).toArray();
	}

}
