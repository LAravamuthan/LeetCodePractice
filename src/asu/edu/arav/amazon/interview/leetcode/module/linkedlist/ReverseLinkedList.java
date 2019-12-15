package asu.edu.arav.amazon.interview.leetcode.module.linkedlist;

import asu.edu.aravl.utility.ListNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class ReverseLinkedList {

    public ListNode head = null;
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        recurReverse(head);
        head.next = null;
        return this.head;
    }

    public ListNode recurReverse(ListNode node){
        if(node.next == null){
            this.head = node;
            return node;
        }
        recurReverse(node.next).next = node;
        return node;
    }

    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = null;
        ListNode pre = null;
        ListNode itr = head;
        while(itr != null){
            next = itr.next;
            itr.next = pre;
            pre = itr;
            itr = next;
        }

        return pre;
    }


}
