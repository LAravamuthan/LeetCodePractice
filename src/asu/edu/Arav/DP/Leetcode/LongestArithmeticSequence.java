package asu.edu.Arav.DP.Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class LongestArithmeticSequence {
    public int longestArithSeqLength(int[] A) {
        if(A == null || A.length ==0){
            return 0;
        }
        if(A.length == 1){
            return 1;
        }

        Map<Integer, Integer>[] dp = new HashMap[A.length];
        for(int i = 0; i < A.length; i++){
            dp[i] = new HashMap<Integer, Integer>();
        }

        int ansLength = 2;

        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < i; j++){
                int cd = A[j] - A[i];
                dp[i].put(cd, dp[j].getOrDefault(cd, 1)+1);
                ansLength = Math.max(ansLength, dp[i].get(cd));
            }
        }
        return ansLength;
    }

}
