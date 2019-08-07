package asu.edu.Arav.DP.Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class LengthofLongestFibSeq {
    public int lenLongestFibSubseq(int[] A) {

        if (A == null || A.length < 3) {
            return 0;
        }

        Map<Integer, Integer> valueToIndex = new HashMap<Integer, Integer>();

        for (int i = 0; i < A.length; i++) {
            valueToIndex.put(A[i], i);
        }

        Map<Integer, Integer> longestSequence = new HashMap<Integer, Integer>();

        int ans = Integer.MIN_VALUE;

        for (int c = 2; c < A.length; c++) {
            for (int b = 1; b < A.length; b++) {
                int a = valueToIndex.getOrDefault(A[c] - A[b], -1);
                if (a >= 0 && a < b) {
                    int temp = longestSequence.getOrDefault(a*A.length+b, 2)+1;
                    longestSequence.put(b*A.length+c, temp);
                    ans = Math.max(temp, ans);
                }
            }
        }


        return ans;
    }
}
