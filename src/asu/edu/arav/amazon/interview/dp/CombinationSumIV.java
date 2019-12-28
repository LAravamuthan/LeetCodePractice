package asu.edu.arav.amazon.interview.dp;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/combination-sum-iv/
 */
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }
        if (nums.length == 1) {
            if (target % nums[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        /* dp array to store possible combinations for making the sum equal to index */
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }

        return dp[target];
    }

    public int combinationSum5(int[] nums, int target) {
        int dp[] = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return dfs(dp, target, nums);
    }

    public int dfs(int[] dp, int target, int[] nums) {
        if (target < 0) {
            return 0;
        }
        if (dp[target] != -1) {
            return dp[target];
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += dfs(dp, target - nums[i], nums);
        }
        dp[target] = res;
        return dp[target];
    }
}
