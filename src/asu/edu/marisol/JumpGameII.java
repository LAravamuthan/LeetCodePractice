package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class JumpGameII {

    /**
     * Greedy approach.
     *
     * @time-complexity - O(n) - one pass.
     * @space-complexity - O(1).
     */
    public int jump(int[] nums) {
        int curFar = 0;
        int curEnd = 0;
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFar = Math.max(curFar, nums[i] + i);
            if (i == curEnd) {
                ans++;
                curEnd = curFar;
            }
        }
        return ans;
    }

    /**
     * Dp bottom-up approach.
     *
     * @time-complexity - O(n^2) - two pass, outerloop and its extreme jumps.
     * @space-complexity - O(1).
     */
    public int jump2(int[] nums) {
        int [] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int maxJumpablePoint = Math.min(nums[i] + i, nums.length - 1);
            for (int j = i + 1; j <= maxJumpablePoint; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[nums.length - 1];
    }
}
