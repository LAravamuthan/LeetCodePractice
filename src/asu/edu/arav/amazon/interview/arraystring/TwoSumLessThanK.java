package asu.edu.arav.amazon.interview.arraystring;

import java.util.Arrays;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/two-sum-less-than-k/
 */
public class TwoSumLessThanK {
    /**
     * @algo - Array Sort
     * @time-complexity - O(nlgn)
     * @space-complexity - O(1)
     */
    public int twoSumLessThanK(int[] A, int K) {

        if (A == null || A.length == 0) {
            return 0;
        }
        Arrays.sort(A);
        int ans = Integer.MIN_VALUE;
        int i = 0, j = A.length - 1;
        while(i < j){
            if(A[i] + A[j] < K){
                ans = A[i] + A[j] > ans ? A[i] + A[j] : ans;
                i++;
            }else{
                j--;
            }
        }

        return ans;
    }

    public static void main(String [] args){
        int[] in = {254,914,110,900,147,441,209,122,571,942,136,350,160,127,178,839,201,386,462,45,735,467,153,415,
                875,282,204,534,639,994,284,320,865,468,1,838,275,370,295,574,309,268,415,385,786,62,359,78,854,944};
        TwoSumLessThanK tstk = new TwoSumLessThanK();
        tstk.twoSumLessThanK(in, 200);

    }
}
