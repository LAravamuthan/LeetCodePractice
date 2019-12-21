package asu.edu.arav.amazon.interview.linkedlist;

import asu.edu.aravl.utility.ListNode;

import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class DeleteNodeinaLinkedList {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
