package asu.edu.arav.amazon.interview.stack;

import asu.edu.aravl.utility.ListNode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/next-greater-node-in-linked-list/
 */
public class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        int [] input = new int[10000];
        int size = 0;
        ArrayList<Integer> llList = new ArrayList<>();
        while (head != null) {
            input[size++] = head.val;
            head = head.next;
        }
        int[] res = new int[size];
        Arrays.fill(res, 0);
        Deque<Integer> st = new ArrayDeque<Integer>();
        for (int i = 0; i < size; i++) {
            while (!st.isEmpty() && input[i] > input[st.peek()]) {
                res[st.pop()] = input[i];
            }
            st.push(i);
        }
        return res;
    }
}
