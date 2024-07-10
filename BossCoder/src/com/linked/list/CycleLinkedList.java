package com.linked.list;

public class CycleLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node = new ListNode(3);
		ListNode listNode = new ListNode(2);
		node.next = listNode;
		node.next.next = new ListNode(0);
		node.next.next.next = listNode;

		boolean hasCycle = hasCycle(node);
		System.out.println(hasCycle);

	}

	public static boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			System.out.println("fast " + fast.val);

			System.out.println("slow " + slow.val);

			if (slow == fast) {
				return true;
			}

		}

		return false;

	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}
	
	
}