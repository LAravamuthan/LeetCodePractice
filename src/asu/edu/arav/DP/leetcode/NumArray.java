package asu.edu.arav.DP.leetcode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class NumArray {

    public int[] nums;
    public int[][] sumsWithRanges;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.sumsWithRanges = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i == j) {
                    sumsWithRanges[i][j] = nums[j];
                } else {
                    sumsWithRanges[i][j] = sumsWithRanges[i][j - 1] + nums[j];
                }
            }
        }
    }

    public int sumRange(int i, int j) {
        return this.sumsWithRanges[i][j];
    }
}
