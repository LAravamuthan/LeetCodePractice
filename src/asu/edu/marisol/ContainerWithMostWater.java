package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ContainerWithMostWater {

    /**
     * Brute approach , O(n^2) aproach.
     *
     * @time-complexity - O (n^2).
     * @space-complexity - O (1).
     */
    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int width = j - i;
                int area = Math.min(height[i], height[j]) * width;
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    /**
     * Efficient approach, O(n) approach.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (1).
     */
    public int maxArea2(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(area, maxArea);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
