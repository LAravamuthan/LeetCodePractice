package asu.edu.arav.impfacebook;

import asu.edu.aravl.utility.ListNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class ReverseList {

    public ListNode head;

    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        recursive(head);
        head.next = null;
        return this.head;

    }

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

}
