package com.linked.list;

public class DuplicateSortedLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next = new ListNode(5);

		ListNode result = DuplicateSortedLinkedList.deleteDuplicates(head);

		// Print the result
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode current = head;

		while (current != null) {
			boolean isDuplicate = false;
			while (current.next != null && current.val == current.next.val) {
				current = current.next;
				isDuplicate = true;
			}

			if (isDuplicate) {
				prev.next = current.next;
			} else {
				prev = prev.next;
			}
			current = current.next;
		}

		return dummy.next;
	}
}
