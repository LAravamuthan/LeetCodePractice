package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ClimbingStairs {

    /**
     * DP with constant space.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (1).
     */
    public int climbStairs(int n) {
        if (n < 2) return 1;
        int oneStepBehind = 1; // for i == 1
        int twoStepBehind = 1; // for i == 1

        for (int i = 2; i <= n; i++) {
            int temp = oneStepBehind;
            oneStepBehind = oneStepBehind + twoStepBehind;
            twoStepBehind = temp;
        }

        return oneStepBehind;
    }
}
