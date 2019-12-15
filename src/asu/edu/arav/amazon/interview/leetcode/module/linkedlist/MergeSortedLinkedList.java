package asu.edu.arav.amazon.interview.leetcode.module.linkedlist;

import asu.edu.aravl.utility.ListNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeSortedLinkedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        preHead.next = prev;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return l1;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode itrNode = dummyHead;
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val){
                itrNode.next = l1;
                l1 = l1.next;
            }else{
                itrNode.next = l2;
                l2 = l2.next;
            }
            itrNode = itrNode.next;
        }
        itrNode.next = l1 == null ? l2 : l1;

        return dummyHead.next;
    }
}
