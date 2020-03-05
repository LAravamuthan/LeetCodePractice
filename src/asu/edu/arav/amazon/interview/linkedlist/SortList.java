package asu.edu.arav.amazon.interview.linkedlist;

import asu.edu.aravl.utility.ListNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/sort-list/
 */
public class SortList {

    /**
     * @algo - merge sort on linkedList
     * @time-complexity - O(nlogn)
     * @space-complexity - O(logn)
     */

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return mergeSorted(l1, l2);
    }


    public ListNode mergeSorted(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode temp = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 != null ? l1 : l2;
        return preHead.next;
    }
}
