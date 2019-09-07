package asu.edu.arav.impfacebook;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class MissingElement {
    public int missingNumber(int[] nums) {
        int sum = nums.length*(nums.length+1);
        sum /=2;

        for(int i =0 ; i < nums.length; i++){
            sum-=nums[i];
        }
        return sum;
    }
}
