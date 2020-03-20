package asu.edu.arav.amazon.interview.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/continuous-subarray-sum/
 */

public class ContinuousSubarraySum {

    /**
     * @algo - DP programming
     * @time-complexity - O(n^2)
     * @space-complexity - O(n)
     */


    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;

        int[] dpsum = new int[nums.length + 1];
        dpsum[1] = nums[0];

        for (int i = 1; i < nums.length; i++) dpsum[i + 1] = dpsum[i] + nums[i];
        for (int i = 2; i <= nums.length; i++) {
            for (int j = 0; j < i - 1; j++) {
                if (k == 0) {
                    if ((dpsum[i] - dpsum[j]) == 0) return true;
                } else {
                    if ((dpsum[i] - dpsum[j]) % k == 0) return true;
                }

            }
        }
        return false;
    }

    /**
     * @algo - DP programming with HashMap
     * @time-complexity - O(n)
     * @space-complexity - O(min(n, k))
     */

    public boolean checkSubarraySum1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;

        Map<Integer, Integer> remainderIndex = new HashMap<>();
        remainderIndex.put(0, -1);
        int sum = 0;
        for (int i = 0; i <= nums.length; i++) {
            sum += nums[i];
            if (k != 0) sum = sum % k;
            if (remainderIndex.containsKey(sum)) {
                if (i - remainderIndex.get(sum) > 1) return true;
            } else
                remainderIndex.put(sum, i);
        }
        return false;
    }

}
