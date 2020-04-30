package asu.edu.arav.amazon.interview.arraystring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/contiguous-array/
 */
public class ContiguousArray {


    /**
     *
     * @algo - HashTable usage
     * @time-complexity - O(n)
     * @space-complexity - O(n)
     */
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int runningSum = 0;
        int maxLength = 0;
        for(int i = 0; i < nums.length; i++){
            runningSum += nums[i] == 0 ? -1 : 1;
            if(sumToIndex.containsKey(runningSum)){
                int curLen = i - sumToIndex.get(runningSum);
                maxLength = Math.max(curLen, maxLength);
            }else
                sumToIndex.put(runningSum, i);
        }
        return maxLength;
    }
}
