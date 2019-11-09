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
        // if start and last idx of the list to be reversed if its the same nothing to do
        if(m == n){
            return head;
        }
        // if m = 1  then remember head pointer has to be taken care of
        boolean isHeadToBeChnaged = false;
        if(m == 1){
            isHeadToBeChnaged = true;
        }
        // index to count the elements processed
        int idx = 1;
        // prev points the previous node , current  - present node and next will
        // help move ahead when we the severing the next pointers.
        ListNode prev = null, next = null, current = head;
        // rs the reversed list one but previous
        // rf first node to be reversed
        ListNode rs = null, rf = null;
        while(current != null && idx <= n){
            next = current.next;
            if(idx == m){
                // as discussed eariler
                rs = prev;
                rf = current;
            }
            if(idx >= m){
                current.next = prev;
            }
            prev = current;
            current = next;
            if(isHeadToBeChnaged){
                // over head if the head pointer has to be changed
                if(idx == n){
                    head = prev;
                }
            }
            idx++;
        }
        // remember rs.next to the point to the nth node in the original linked list
        if(rs != null){
            rs.next = prev;
        }
        // also it is important to note that the rf.next to point to n+1th node in the original  linked list
        rf.next = current;
        return head;
    }
}
