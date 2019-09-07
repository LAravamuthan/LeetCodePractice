package asu.edu.arav.DP.leetcode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class TargetSum {
    public static int findTargetSumWays(int[] nums, int S) {
        int maxSum = 0;
        for (int i = 0; i < nums.length; i++)
            maxSum += nums[i];
        if (maxSum + S > 2 * maxSum || maxSum + S < 0) {
            return 0;
        }
        int[][] dpSum = new int[nums.length][2 * maxSum + 1];
        for (int i = -maxSum; i <= maxSum; i++) {
            if (Math.abs(i) == nums[0])
                dpSum[0][maxSum + i] = 1;
        }
        for (int j = 1; j < nums.length; j++) {
            for (int i = -maxSum; i <= maxSum; i++) {
                if (maxSum + i + nums[j] < 2 * maxSum + 1) {
                    dpSum[j][maxSum + i] = dpSum[j][maxSum + i] + dpSum[j-1][maxSum + i + nums[j]];
                }
                if (maxSum + i - nums[j] >= 0) {
                    dpSum[j][maxSum + i] = dpSum[j][maxSum + i] + dpSum[j-1][maxSum + i - nums[j]];
                }
            }
        }
        return dpSum[nums.length - 1][maxSum + S];
    }

    public static void main(String[] args) {
        int [] in = {1,1,1,1,2};
        System.out.println(findTargetSumWays(in, 2));
    }
}
