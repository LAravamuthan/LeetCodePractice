package asu.edu.arav.leetcode.competition;

import java.util.*;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class LongestArithmeticSubSequenceofGivenDifference {

    public int longestSubsequence(int[] arr, int difference) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return 1;
        }
        int max = 1;
        Map<Integer, Integer> mapZ = new HashMap<Integer, Integer>();
        for(int a : arr){
            mapZ.put(a, mapZ.getOrDefault(a-difference, 0)+1);
            max = Math.max(mapZ.get(a), max);
        }
        return max;
    }


    public boolean hasGreaterIndex(List<Integer> l, int idx){

        for(int i : l){
            if(idx < i){
                return true;
            }
        }

        return false;
    }
}
