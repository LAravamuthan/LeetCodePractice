package asu.edu.arav.amazon.interview.bitmanipulation;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/single-number/
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int n : nums){
            ans ^= n;
        }
        return ans;
    }
}
