package asu.edu.arav.DP.Leetcode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class BurstBallons {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] nums_rf = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            nums_rf[i + 1] = nums[i];
        }
        nums_rf[0] = nums_rf[nums_rf.length - 1] = 1;
        int[][] dpCoins = new int[nums_rf.length][nums_rf.length];
        for (int left = nums_rf.length - 2; left > -1; left--) {
            for (int right = left + 2; right < nums_rf.length; right++) {
                for (int i = left + 1; i < right; i++) {
                    dpCoins[left][right] = Math.max(dpCoins[left][right],
                            nums_rf[left] * nums_rf[i] * nums_rf[right] + dpCoins[left][i]
                                    + dpCoins[i][right]);
                }
            }
        }
        return dpCoins[0][nums_rf.length - 1];
    }
}
