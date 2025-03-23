package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class HouseRobber {

    /**
     * DP with constant space, awesome right.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (1).
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int profitWithRobbingCurHouse = nums[0];
        int profitWithRobbingPrevHouse = 0;
        int maxProfit = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = profitWithRobbingCurHouse;
            profitWithRobbingCurHouse = profitWithRobbingPrevHouse + nums[i];
            profitWithRobbingPrevHouse = Math.max(temp, profitWithRobbingPrevHouse);
            maxProfit = Math.max(profitWithRobbingCurHouse, profitWithRobbingPrevHouse);
        }

        return maxProfit;
    }
}
