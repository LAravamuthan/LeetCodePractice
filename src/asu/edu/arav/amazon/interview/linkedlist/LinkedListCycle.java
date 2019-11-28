package asu.edu.arav.amazon.interview.linkedlist;

import asu.edu.aravl.utility.ListNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head.next == null){
            return true;
        }

        while(slow != null && fast.next != null && slow != fast){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow == fast;
    }
}
