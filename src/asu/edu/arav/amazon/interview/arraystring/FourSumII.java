package asu.edu.arav.amazon.interview.arraystring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/4sum-ii/
 */
public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        if(A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0){
            return 0;
        }

        // this HashMap Stores all the combination of sums from values taken from A and B
        // for each sum it also keeps a count of each sum's frequency
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                hm.put(A[i] + B[j], hm.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }

        // Now in the List C and D find the conjugate of the sums from A and B ,
        // pair of these two sums should add up to sum 0 right ??
        int res = 0; // the no. pairs forming sum 0
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                res += hm.getOrDefault(-1 * (C[i] + D[j]), 0);
            }
        }

        return res;
    }

}
