package asu.edu.arav.amazon.interview.online;

import asu.edu.aravl.utility.ListNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class MergeSortedLinkedList {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if (l2 == l1){
            return l1;
        }
        if(l1 == null && l2 == null){
            return null;
        }
        ListNode first = l1.val <= l2.val ? l1 : l2;
        ListNode second = l1.val <= l2.val ? l2 : l1;
        ListNode temp = first.next;
        ListNode prev = first;
        while (temp != null && second != null) {
            if (temp.val <= second.val) {
                prev = temp;
                temp = temp.next;
                continue;
            } else {
                ListNode temp2 = second;
                second = second.next;
                temp2.next = temp;
                prev.next = temp2;
                prev = prev.next;
            }
        }
        while (second != null) {
            ListNode temp2 = second;
            second = second.next;
            temp2.next = prev.next;
            prev.next = temp2;
            prev = prev.next;
        }
        return first;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        mergeTwoLists(l1, l2);
    }
}
