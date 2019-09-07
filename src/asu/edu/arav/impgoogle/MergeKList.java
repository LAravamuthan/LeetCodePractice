package asu.edu.arav.impgoogle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import asu.edu.aravl.utility.ListNode;

public class MergeKList {

	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		List<ListNode> l = new ArrayList<ListNode>(Arrays.asList(lists));
		ListNode head = null;
		ListNode tail = null;
		ListNode temp = null;
		l.removeAll(Collections.singleton(null));
		while (!l.isEmpty()) {
			int val = Integer.MAX_VALUE;
			int index = -1;
			for (int i = 0; i < l.size(); i++) {
				if (l.get(i) != null) {
					if (val > l.get(i).val) {
						temp = l.get(i);
						index = i;
						val = l.get(i).val;
					}
				}
			}
			if (l.get(index).next != null) {
				l.set(index, l.get(index).next);
			} else {
				l.remove(index);
			}
			if (head == null && tail == null) {
				head = tail = temp;
			} else {
				tail.next = temp;
				tail = tail.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
//		ListNode l1 = new ListNode(1);
//		ListNode l2 = new ListNode(1);

		ListNode[] test = new ListNode[2];
//		test[0] = l1;
//		test[1] = l2;
		test[0] = null;
		System.out.println(mergeKLists(test));
	}

}
