package asu.edu.arav.amazon.interview.leetcode.module.linkedlist;

import asu.edu.aravl.utility.ListNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(0);
        ListNode itrNode = dummy;

        boolean isCarry = false;
        int sum = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            sum = isCarry ? val1 + val2 + 1 : val1 + val2;
            itrNode.next = new ListNode(sum % 10);
            isCarry = sum / 10 > 0 ? true : false;
            itrNode = itrNode.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (isCarry) {
            itrNode.next = new ListNode(1);
        }
        return dummy.next;
    }

}
