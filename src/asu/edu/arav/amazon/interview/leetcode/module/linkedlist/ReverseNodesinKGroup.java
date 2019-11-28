package asu.edu.arav.amazon.interview.leetcode.module.linkedlist;

import asu.edu.arav.amazon.interview.linkedlist.ReverseLinkedListII;
import asu.edu.aravl.utility.ListNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesinKGroup {

    // let us try the recursive one
    public ListNode reverseKGroupR(ListNode head, int k) {
        if(head == null || head.next == null || k == 1){
            return head;
        }
        ListNode cur = head, prev = null, next = null, testNode = head;
        // this below for does some thing very simple that is it
        // just tests whether k nodes are present are not
        for(int i = 0; i < k; i++){
            if(testNode == null){
                return head;
            }
            testNode = testNode.next;
        }
        int i = 0;
        // once tested whether k elements are present or not we do reversing
        //
        while(i < k){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            i++;
        }
        // below is the genious, the last element after reversing would be head
        // hence the next recursion call will find the element it has to point to
        head.next = reverseKGroupR(cur, k);

        // the pre element will first in the k group it has to be pointed by the previous
        // recustion callee, if this call is the first call then then the prev element here
        // would be the head
        return prev;
    }

    // using iterative method
    public int findSizeOfLinkedList(ListNode head){
        int count = 0;
        while(head != null){
            head = head.next;
            count++;
        }
        return count;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int sizeOfLL = findSizeOfLinkedList(head);
        // if the size or k is 1 no need to do anything
        if(head == null || k == 1 || head.next == null){
            return head;
        }
        int sIdx = 1;
        ReverseLinkedListII rll2 = new ReverseLinkedListII();
        // I already did the code for reverseBetween right
        // the algo becomes simple do reverse for n pairs of size k
        // till you reach the last pair where it is possible simple I guess
        while(sIdx + k - 1 <= sizeOfLL){
            head = rll2.reverseBetween(head, sIdx, sIdx + k - 1);
            sIdx+=k;
        }

        return head;
    }
}
