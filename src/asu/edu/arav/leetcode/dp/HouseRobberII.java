package asu.edu.arav.leetcode.dp;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if(nums.length == 1){
            return nums[0];
        }
        return Math.max(maxMoneyInOneDirection(nums, 0, nums.length - 1),
                maxMoneyInOneDirection(nums, 1, nums.length));
    }

    public int maxMoneyInOneDirection(int[] nums, int startIndex, int endIndex) {
        int lastIndexMaxMoney = 0;
        int secondLastIndexMaxMoney = 0;
        for (int i = startIndex; i < endIndex; i++) {
            int tempMoney = lastIndexMaxMoney;
            if (i == startIndex) {
                secondLastIndexMaxMoney = lastIndexMaxMoney;
                lastIndexMaxMoney += nums[i];
            } else {
                lastIndexMaxMoney = Math.max(secondLastIndexMaxMoney + nums[i], lastIndexMaxMoney);
                secondLastIndexMaxMoney = tempMoney;
            }
        }
        return Math.max(lastIndexMaxMoney, secondLastIndexMaxMoney);
    }


}
