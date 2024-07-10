package com.linked.list;

public class ReverseLLByKthPos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		// Define the value of k
		int k = 2;

		// Create an instance of Solution12
		Solution12 solution = new Solution12();

		// Reverse the linked list in groups of k
		ListNode reversedList = solution.reverseKGroup(head, k);

		// Print the reversed list
		while (reversedList != null) {
			System.out.print(reversedList.val + " ");
			reversedList = reversedList.next;
		}
	}

}

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution12 {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;

		while (head != null) {
			ListNode start = head;
			ListNode end = getGroupEnd(head, k);
			if (end == null) {
				break;
			}
			prev.next = reverseList(start, end.next);
			prev = start;
			head = prev.next;
		}

		return dummy.next;

	}

	private ListNode getGroupEnd(ListNode head, int k) {
		while (head != null && --k > 0) {
			head = head.next;
		}
		return head;
	}

	private ListNode reverseList(ListNode head, ListNode stop) {
		ListNode prev = stop;
		while (head != stop) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
}