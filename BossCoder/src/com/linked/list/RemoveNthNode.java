package com.linked.list;

public class RemoveNthNode {

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		solution.removeNthFromEnd(head, 2);
		System.out.println(head);
	}
}

class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode temp = head;

		int counter = 0;

		while (temp != null) {
			counter++;
			temp = temp.next;
		}

		int k = counter - n;
		temp = head;
		counter = 0;
		while (temp != null) {
			if (k == counter) {
				temp.next = temp.next.next;
				break;
			}
			temp = temp.next;
			counter++;
		}

		return head;

	}
}
