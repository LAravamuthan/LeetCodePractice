package asu.edu.arav.amazon.interview.leetcode.module.arraysandstrings;

import java.util.Arrays;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumCloset {
    public int threeSumClosest(int[] nums, int target) {

        // in this problem what we have to see the fact that
        // we sort the whole array
        // then for each num we consider the other elements which
        // form the left and right pointer
        // right pointer always starts from the last element of the sorted array
        // but the the left pointer comes from next element considered from the current
        // element .. this is so because the lower elements form the current idx would heve been already considered
        // that is why
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int ans = nums[0] + nums[1] + nums[2]; // select some random sum initially then we optimize it further as and when we need
        Arrays.sort(nums);
        // here it is -2 because to accomodate two pointers left and right
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int currentSum = nums[i] + nums[start] + nums[end];
                if (Math.abs(currentSum - target) < Math.abs(ans - target)) {
                    ans = currentSum;
                }
                if (currentSum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return ans;
    }
}
