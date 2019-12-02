package asu.edu.arav.amazon.interview.slidingwindow;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/subarray-product-less-than-k/
 */
public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        // in this we will use sliding window algorithm

        if(nums == null || nums.length == 0 || k <= 1){
            return 0;
        }
        int left = 0, right = 0;
        int count = 0;
        int product = 1;
        while(right < nums.length){
            product *= nums[right];
            while(product >= k){
                // we increas left when we want to discard elments
                product /= nums[left++];
            }
            // because if we have 1, 2 , then differnce would be 1, but subarrays would be [1, 2] and [2],
            // we are not count ing [1] because it would have been included when it is was added in the first place
            count += right - left + 1;
            // we keep on increasing right no matter what
            right++;
        }
        return count;
    }

}
