package asu.edu.arav.amazon.interview.divideConquer;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleinHistogram {


    /**
     * @algo - brute
     * @time-complexity - O(n^2)
     * @space-complexity - O(1)
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int min = heights[i];
            for (int j = i; j < heights.length; j++) {
                min = Math.min(heights[j], min);
                int area = min * (j - i + 1);
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    /**
     * @algo - Divide and conquer
     * @time-complexity - Average Case - O(nlogn), Worst case - O(n^2)
     * @space-complexity - O(n) worst depth
     */

    int[] heights = null;

    public int largestRectangleArea1(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        this.heights = heights;
        return recur(0, heights.length - 1);
    }

    public int recur(int s, int l) {
        if (s == l) return heights[s];
        int minIndex = findMin(s, l);
        int maxLArea = minIndex > s ? recur(s, minIndex - 1) : 0;
        int maxRArea = minIndex < l ? recur(minIndex + 1, l) : 0;
        int middleArea = heights[minIndex] * (l - s + 1);
        return Math.max(maxLArea, Math.max(maxRArea, middleArea));
    }

    public int findMin(int s, int l) {
        int minIndex = s;
        for (int i = s; i <= l; i++) {
            if (heights[minIndex] > heights[i]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}
