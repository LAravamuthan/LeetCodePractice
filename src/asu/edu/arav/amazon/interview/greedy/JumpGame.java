package asu.edu.arav.amazon.interview.greedy;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/jump-game/
 */
public class JumpGame {

    // Greedy algorithm T - O(n) S - O(1)
    public boolean canJump(int[] nums) {

        if (nums == null || nums.length < 2) {
            return true;
        }
        // furtherest you can reach
        int nextIdx = -1;


        for (int i = 0; i < nums.length; i++) {
            // if the next possible max index you can go is greater or equal to
            // last position possible we just return true
            if (nextIdx >= nums.length - 1) {
                return true;
            }
            nextIdx = Math.max(nums[i] + i, nextIdx);
            if (nextIdx <= i) {
                break; // this means that no matter what we cant beyond this point
                // all the jump from the previous indexes didnt cross current index
            }

        }
        return false;
    }
}
