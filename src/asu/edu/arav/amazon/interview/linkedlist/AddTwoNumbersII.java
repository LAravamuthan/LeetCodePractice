package asu.edu.arav.amazon.interview.linkedlist;

import asu.edu.aravl.utility.ListNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/add-two-numbers-ii/
 */
public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l2;
        }

        l1 = reverseLL(l1);
        l2 = reverseLL(l2);

        ListNode dummy = new ListNode(-1);
        ListNode itrSum = dummy;
        boolean isCarry = true;
        int sum = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            sum = isCarry ? val1 + val2 + 1 : val1 + val2;
            itrSum.next = new ListNode(sum % 10);
            isCarry = sum / 10 > 0 ? true : false;
            itrSum = itrSum.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        if (isCarry) {
            itrSum.next = new ListNode(1);
        }

        return reverseLL(dummy.next);
    }

    public ListNode reverseLL(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = null;
        ListNode pre = null;
        ListNode itr = head;

        while (itr != null) {
            next = itr.next;
            itr.next = pre;
            pre = itr;
            itr = next;
        }
        return pre;
    }
}
