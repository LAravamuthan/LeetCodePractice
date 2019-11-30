package asu.edu.arav.impgoogle.linkedlist;

import asu.edu.aravl.utility.ListNode;

public class MergeKList2 {

	public static ListNode mergeTwoSortedLinkedList(ListNode a, ListNode b) {
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}
		ListNode head = null;
		ListNode tail = null;
		ListNode tailA = a;
		ListNode tailB = b;

		while (tailA != null && tailB != null) {
			if (tailA.val < tailB.val) {
				if (head == null) {
					head = tail = tailA;
					tailA = tailA.next;
				}else {
					tail.next = tailA;
					tail = tail.next;
					tailA = tailA.next;
				}
			} else {
				if (head == null) {
					head = tail = tailB;
					tailB = tailB.next;
				}else {
					tail.next = tailB;
					tail = tail.next;
					tailB = tailB.next;
				}
			}
		}
		if (tailA != null) {
			tail.next = tailA;
		}
		if (tailB != null) {
			tail.next = tailB;
		}
		return head;
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		int last = lists.length - 1;
		while (last > 0) {
			int i = 0;
			int j = last;
			while (i < j) {
				lists[i] = mergeTwoSortedLinkedList(lists[i], lists[j]);
				i++;
				j--;
				if (i >= j) {
					last = j;
				}
			}
		}

		return lists[0];
	}
}
