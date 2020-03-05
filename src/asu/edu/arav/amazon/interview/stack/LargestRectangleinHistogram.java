package asu.edu.arav.amazon.interview.stack;

import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleinHistogram {


    /**
     * @algo stack
     * @time-complexity - O(n)
     * @space-complexity - O(n)
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> st = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            /* if the stack is empty
             * just push, if not then check element
             * if peak element is greater just push again */
            /* if the above cases done happen then the area is till
             * previous element from current index to smaller to
             * element at the top of the */
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int area = heights[st.pop()] * (i - 1 - (st.isEmpty() ? -1 : st.peek()));
                maxArea = Math.max(maxArea, area);
            }
            st.push(i);
        }

        while (!st.isEmpty()){
            int area = heights[st.pop()] * (heights.length - 1 - (st.isEmpty() ? -1 : st.peek()));
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
