package asu.edu.arav.leetcode.dp;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */

public class NumArray2 {

    public int[] sums;

    public NumArray2(int[] nums) {
        this.sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                this.sums[i] = nums[i];
            } else {
                this.sums[i] = this.sums[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        return i == 0 ? this.sums[j] : this.sums[j] - this.sums[i - 1];
    }
}

