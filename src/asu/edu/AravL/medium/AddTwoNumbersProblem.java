package asu.edu.AravL.medium;

import asu.edu.AravL.utility.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

/*
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 +
 * 465 = 807.
 */

public class AddTwoNumbersProblem {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		boolean isCarry = false;
		ListNode tempL1 = l1;
		ListNode tempL2 = l2;
		ListNode bufferNode = null;
		ListNode firstNode = null;
		for (; tempL1 != null || tempL2 != null;) {
			int sum1 = 0;
			int sum2 = 0;
			if (tempL1 != null)
				sum1 = tempL1.val;
			if (tempL2 != null)
				sum2 = tempL2.val;
			int sum = sum1 + sum2;
			int val = (isCarry) ? sum + 1 : sum;
			isCarry = val > 9 ? true : false;
			ListNode resultNode = new ListNode(val % 10);
			if (bufferNode != null) {
				bufferNode.next = resultNode;
			} else {
				firstNode = resultNode;
			}
			bufferNode = resultNode;
			if (tempL1 != null)
				tempL1 = tempL1.next;
			if (tempL2 != null)
				tempL2 = tempL2.next;
		}
		if (isCarry) {
			ListNode resultNode = new ListNode(1);
			bufferNode.next = resultNode;
		}
		return firstNode;
	}

}
