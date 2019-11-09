package asu.edu.arav.amazon.interview.medium;

import asu.edu.aravl.utility.ListNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // check if the head pointer is going to change
        if(head == null){
            return head;
        }
        if(m == n){
            return head;
        }
        boolean isHeadToBeChnaged = false;
        if(m == 1){
            isHeadToBeChnaged = true;
        }
        int idx = 1;
        ListNode prev = null, next = null, current = head;
        while(current != null && idx <= n){
            next = current.next;
            if(idx >= m){
                current.next = prev;
            }
            prev = current;
            current = next;
            if(isHeadToBeChnaged){
                if(idx == n){
                    head = prev;
                }
            }
        }
        return head;
    }
}
