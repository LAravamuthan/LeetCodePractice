package asu.edu.arav.impfacebook.linkedlist;

import asu.edu.aravl.utility.ListNode;

import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseList {

    public ListNode head;
    public ListNode headG;

    public void recursive(ListNode node){
        if(node.next == null){
            this.head = node;
            return;
        }
        recursive(node.next);
        node.next.next = node;
    }

    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseList3(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode previous = null;
        ListNode current = head;
        ListNode next = head.next;

        while(next!=null){
            current.next = previous;
            previous = current;
            current = next;
            next = next.next;
        }

        head = current;
        return head;
    }

    public void rLR(ListNode prev, ListNode head){
        if(head == null)return;
        if(head.next == null){
            headG = head;
        }
        rLR(head, head.next);
        head.next = prev;
    }


}
