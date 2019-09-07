package asu.edu.arav.ImpG;

import asu.edu.AravL.utility.ListNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
@SuppressWarnings("Duplicates")
public class MergeSLinkedList {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode first = null;
        ListNode temp = null;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (first == null) {
                    first = l1;
                    temp = first;
                } else {
                    temp.next = l1;
                    temp = temp.next;
                }
                l1 = l1.next;
            } else {
                if (first == null) {
                    first = l2;
                    temp = first;
                } else {
                    temp.next = l2;
                    temp = temp.next;
                }
                l2 = l2.next;
            }
        }
        if (l1 != null) {

            if (first == null) {
                first = l1;
                temp = first;
            } else {
                temp.next = l1;
            }
        }

        if (l2 != null) {
            if (first == null) {
                first = l2;
                temp = first;
            } else {
                temp.next = l2;
            }
        }
        return first;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(4);

        ListNode second = new ListNode(1);
        second.next = new ListNode(3);
        second.next.next = new ListNode(4);

        mergeTwoLists(null, second);


    }

}
