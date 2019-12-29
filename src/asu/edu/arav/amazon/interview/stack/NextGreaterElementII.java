package asu.edu.arav.amazon.interview.stack;

import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/next-greater-element-ii/
 */
public class NextGreaterElementII {

    /*The time and space complexity - O(n) */
    public int[] nextGreaterElements(int[] nums) {

        /* The key here is to iterate 2 two times from the last element
         * in the the nums array keep popping the smaller and equal elements
         * once pruned the answer is the stack top element or -1 */
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] res  = new int[nums.length];

        Stack<Integer> st = new Stack<Integer>();
        for (int i = 2 * nums.length - 1; i >= 0; i++) {
            while (!st.isEmpty() && nums[i % nums.length] >= nums[st.peek()]) {
                st.pop();
            }
            res[i % nums.length] = st.isEmpty() ? -1 : nums[st.peek()];
            st.push(i % nums.length);
        }

        return res;
    }
}
