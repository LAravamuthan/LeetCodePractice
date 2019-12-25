package asu.edu.arav.amazon.interview.linkedlist;

import asu.edu.aravl.utility.ListNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/odd-even-linked-list/
 */
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        ListNode sHead = head.next;
        ListNode evenNode = temp.next;
        while (temp.next != null && evenNode.next != null) {
            temp.next = temp.next.next;
            evenNode.next = evenNode.next.next;
            temp = temp.next;
            evenNode = evenNode.next;
        }
        temp.next = sHead;
        return head;
    }
}
