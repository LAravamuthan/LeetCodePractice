package asu.edu.arav.ImpG;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class HouseRobber {
    public int rob(int[] nums) {

        int profit = 0;

        if(nums == null || nums.length == 0){
            return profit;
        }
        int[] profitList = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            int oneHouseBeforeProfit = 0;
            int twoHouseBeforeProfit = 0;
            if(i-1  >= 0){
                oneHouseBeforeProfit = profitList[i-1];
            }if(i-2  >= 0){
                twoHouseBeforeProfit = profitList[i-2];
            }
            profitList[i] = Math.max(oneHouseBeforeProfit, twoHouseBeforeProfit + nums[i]);
        }
        return profitList[nums.length-1];
    }
}
