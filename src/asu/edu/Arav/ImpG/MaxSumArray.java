package asu.edu.Arav.ImpG;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class MaxSumArray {
    public static int maxSubArray(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }

        int prevIndexProfit = 0;
        int maxProfit = Integer.MIN_VALUE;


        for(int i = 0; i < nums.length; i ++){
            prevIndexProfit = Math.max(prevIndexProfit + nums[i], nums[i]);
            maxProfit = Math.max(prevIndexProfit, maxProfit);
        }
        return maxProfit;
    }

    public static void main(String [] args){
        int [] input = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(input));
    }
}
