package asu.edu.marisol;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class TrappingRainWater {

    /**
     * Lets see a solution, this is using the concept of area using Stack to store lower height and popping two taller
     * bounded heights to add enclosing are.
     *
     * @time-complexity - O(N).
     * @space-complexity - O(N).
     */
    public int trap(int[] height) {
        int current = 0;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int currentTop = stack.pop();
                int distance = current - stack.peek() - 1;
                int curHeight = Math.min(height[current], height[stack.peek()]) - height[currentTop];
                ans += distance * curHeight;
            }
            stack.add(current++);
        }

        return ans;
    }

    /**
     * Dynamic programming with two arrays implementation for storing left maxes and right maxes.
     *
     * @time-complexity - O(3N).
     * @space-complexity - O(2N).
     */
    public int trap2(int[] height) {

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int ans = 0;

        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i], leftMax[i - 1]);
        }

        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i], rightMax[i + 1]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return ans;
    }

    /**
     * 2 Pointer approach.
     *
     * @time-complexity - O(N).
     * @space-complexity - O(1).
     */
    public int trap3(int[] height) {

        int left = 0, right = height.length - 1;
        int left_max = 0, right_max = 0;
        int ans = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                left_max = Math.max(left_max, height[left]);
                ans += left_max - height[left++];
            } else {
                right_max = Math.max(right_max, height[right]);
                ans += right_max - height[right--];
            }
        }

        return ans;
    }
}
