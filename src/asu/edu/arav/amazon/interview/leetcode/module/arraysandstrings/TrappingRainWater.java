package asu.edu.arav.amazon.interview.leetcode.module.arraysandstrings;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left_max = 0; // current left max for current index
        int right_max = 0; // current right max for current index

        int left = 0; // left pointer position
        int right = height.length - 1; // right pointer position

        int amount_of_water_captured = 0;
        // while loop to calculate the contibution of each index towards storing
        //water
        while (left < right) {
            if (height[left] < height[right]) { // if left buliding lesser than
                // for current  right index index building that means that the right_max or
                // height[right] is obviously bigger than left_max,
                if (height[left] >= left_max) { // hence we have to check whether current left
                    // building is bigger or equal to left_max, even if it is big
                    // it is less than then height[right]
                    left_max = height[left];
                    left++;
                } else {
                    amount_of_water_captured += left_max - height[left];
                    left++;
                }
            } else { // same logic applies on the right buildings
                if (height[right] >= right_max) {
                    right_max = height[right];
                    right--;
                } else {
                    amount_of_water_captured += right_max - height[right];
                    right--;
                }
            }
        }
        return amount_of_water_captured;
    }

    // point to be noted here is we can do the same having leftmax array and right max
    // array
}
