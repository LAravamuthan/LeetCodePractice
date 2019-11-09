package asu.edu.arav.amazon.interview.easy;

import asu.edu.aravl.utility.ListNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

    /*ListNode headG = null;*/
    public ListNode reverseList(ListNode head){
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }


    /*public ListNode reverseList(ListNode head){
        rLR(null, head);
        return headG;
    }

    public void rLR(ListNode prev, ListNode head){
        if(head == null)return;
        if(head.next == null){
            headG = head;
        }
        rLR(head, head.next);
        head.next = prev;
    }*/
}
