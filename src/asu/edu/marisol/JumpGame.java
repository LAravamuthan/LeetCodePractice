package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class JumpGame {


    /**
     * Trying all jumps possible with slight optimizing by trying the highest jump first.
     *
     * @time-complexity - O(2^n) - work it out pls
     * @space-complexity - O(N) - max recursion level will N depth long only.
     */
    public boolean canJump(int[] nums) {
        return reached(nums, 0);
    }

    public boolean reached(int[] nums, int position) {
        if (position == nums.length - 1) return true;

        int currentMaxJumpPosition = Math.min(nums.length - 1, position + nums[position]);

        for (int currPosition = currentMaxJumpPosition; currPosition > position; currPosition--) {
            if (reached(nums, currPosition)) return true;
        }
        return false;
    }

    /**
     * Trying top-down approach with memoization.
     *
     * @time-complexity - O(n^2) - for every index i we can at max n times recursions or jumps making it square jumps.
     * @space-complexity - O(n) - max recursion level will n depth long only.
     */
    public boolean canJump2(int[] nums) {
        memo = new Status[nums.length];
        for (int i = 0; i < nums.length; i++)
            memo[i] = Status.NA;
        memo[nums.length - 1] = Status.YES;
        reachedMemo(nums, 0);
        return memo[0] == Status.YES;
    }

    enum Status {
        YES, NO, NA;
    }

    Status[] memo;

    public void reachedMemo(int[] nums, int position) {
        if (memo[position] == Status.NA) {
            int currentMaxJumpPosition = Math.min(nums.length - 1, position + nums[position]);
            for (int currPosition = currentMaxJumpPosition; currPosition > position; currPosition--) {
                reachedMemo(nums, currPosition);
                if(memo[currPosition] == Status.YES) {
                    memo[position] = Status.YES;
                    return;
                }
            }
            memo[position] = Status.NO;
        }
    }

    /**
     * Trying Bottom-up approach with 1D array.
     *
     * @time-complexity - O(n^2) - for every index i we can at max n times recursions or jumps making it square jumps.
     * @space-complexity - O(n) - 1-D DP array .
     */
    public boolean canJump3(int[] nums) {
        memo = new Status[nums.length];
        for (int i = 0; i < nums.length; i++)
            memo[i] = Status.NA;
        memo[nums.length - 1] = Status.YES;

        for (int i = nums.length - 2; i >= 0; i--) {
            int maxJumpPosition = Math.min(nums[i] + i, nums.length - 1);
            for (int j = i + 1; j <= maxJumpPosition; j++) {
                if (memo[j] == Status.YES) {
                    memo[i] = Status.YES;
                    break;
                }
            }
        }
        return memo[0] == Status.YES;
    }

    /**
     * Trying greedy approach.
     *
     * @time-complexity - O(n) - one traversal.
     * @space-complexity - O(1) - no extra space.
     */
    public boolean canJump4(int[] nums) {
        int furtherestPosition = 0;
        for (int i = 0; i < nums.length; i++) {
            if (furtherestPosition < i) return false;
            furtherestPosition = Math.max(nums[i] + i, furtherestPosition);
            if (furtherestPosition >= nums.length - 1) return true;
        }
        return false;
    }


    /**
     * Trying DP approach and practicing.
     *
     * @time-complexity - O(n^2) - loop inside loop.
     * @space-complexity - O(n)
     */
    public boolean canJump5(int[] nums) {
        boolean [] dp = new boolean[nums.length];
        dp[0] = true;

        for (int i = 0; i < nums.length; i++) {
            if (!dp[i]) return false;
            int maxJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= maxJump; j++)
                dp[j] = true;
        }
        return true;
    }



}
