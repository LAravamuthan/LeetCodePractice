package asu.edu.arav.amazon.interview.online;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @Link https://leetcode.com/problems/k-diff-pairs-in-an-array/
 */
public class KDiffPairsInAnArray {

    public int findPairs(int[] nums, int k) {

        if(nums == null || nums.length < 2 || k < 0){
            return 0;
        }

        Set<Integer> reserves = new HashSet<Integer>();
        Set<Integer> lowerElementOfaPair = new HashSet<Integer>();

        for(int num : nums){
            if(reserves.contains(num- k)){
                lowerElementOfaPair.add(num - k);
            }
            if(reserves.contains(num + k)){
                lowerElementOfaPair.add(num);
            }
            reserves.add(num);
        }
        return lowerElementOfaPair.size();
    }

}
