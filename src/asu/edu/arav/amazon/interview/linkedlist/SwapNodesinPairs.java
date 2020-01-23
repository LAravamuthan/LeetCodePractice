package asu.edu.arav.amazon.interview.linkedlist;

import asu.edu.aravl.utility.ListNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode next = temp.next;
        temp.next = swapPairs(next.next);
        next.next = temp;
        return next;
    }

    public static void main(String args[]){
        SwapNodesinPairs snip = new SwapNodesinPairs();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        snip.swapPairs(head);
    }
}
