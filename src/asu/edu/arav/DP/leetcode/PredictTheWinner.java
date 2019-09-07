package asu.edu.arav.DP.leetcode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        if (nums.length == 1 || nums.length == 2) {
            return true;
        }

        int[][] firstPlayerProfit = new int[nums.length][nums.length];

        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                firstPlayerProfit[i][j] = Math.max(nums[i] - firstPlayerProfit[i+1][j], nums[j] - firstPlayerProfit[i][j-1]);
            }
        }

        return firstPlayerProfit[0][nums.length - 1] > 0 ? true : false;
    }
}
