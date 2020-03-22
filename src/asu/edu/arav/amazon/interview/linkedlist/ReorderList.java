package asu.edu.arav.amazon.interview.linkedlist;

import asu.edu.aravl.utility.ListNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/reorder-list/
 */
public class ReorderList {

    /**
     *
     * @algo - slow and fast pointer, reverse ll
     * @time-complexity - O(n)
     * @space-complexity - O(1)
     */

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode next = null;
        ListNode itr = head;
        while (itr != null){
            next = itr.next;
            itr.next = prev;
            prev = itr;
            itr = next;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null ) return;
        ListNode s = head;
        ListNode f = head;
        while (f != null && f.next!=null){
            s = s.next;
            f = f.next.next;
        }
        ListNode itr1 = head;
        ListNode itr2 = reverse(s);
        while (itr1.next != s){
            ListNode tempItr1Next = itr1.next;
            ListNode tempItr2Next = itr2.next;
            itr1.next = itr2;
            itr2.next = tempItr1Next;
            itr1 = tempItr1Next;
            itr2 = tempItr2Next;
        }
        itr1.next = itr2;
    }

    public static void main(String [] args){
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);
        n.next.next.next.next.next = new ListNode(6);
        ReorderList rl = new ReorderList();
        rl.reorderList(n);

    }

}
