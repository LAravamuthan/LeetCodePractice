package asu.edu.arav.amazon.interview.arraystring;

import java.util.Arrays;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/maximum-width-ramp/
 */
public class MaximumWidthRamp {

    /**
     *
     * @algo - sort and enjoy
     * @time-complexity - O(NlogN)
     * @space-complexity - O(N)
     */

    public int maxWidthRamp(int[] A) {
        if (A == null || A.length == 0) return 0;
        Integer[] indexes = new Integer[A.length];
        for (int i = 0; i < indexes.length; i++) indexes[i] = i;
        Arrays.sort(indexes, (a, b) -> A[a] == A[b] ? a - b : A[a] - A[b]);
        int maxWidth = 0;
        int minIdx = A.length;
        for (int idx : indexes) {
            minIdx = Math.min(idx, minIdx);
            maxWidth = Math.max(idx - minIdx, maxWidth);
        }
        return maxWidth;
    }

}
