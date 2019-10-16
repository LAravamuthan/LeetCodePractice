package asu.edu.arav.amazon.interview.leetcode.module.dynamicprogramming;

import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }

        // If the array has size only 1 then max sum possible will including only that
        if(nums.length == 1){
            return nums[0];
        }
        int maxSum = nums[0];
        int curSum = nums[0];
        for(int i = 1; i < nums.length; i ++){

            // if the sum by adding previous max does not have higher value than the current
            // idxed number than making max sum at this idx the same value
            if(curSum + nums[i] < nums[i]){
                curSum = nums[i];
            }else{
                //else increment the running sum to new sum max at current index.
                curSum += nums[i];
            }
            // if the max sum including index is the maximum so far then update the overall max
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}
