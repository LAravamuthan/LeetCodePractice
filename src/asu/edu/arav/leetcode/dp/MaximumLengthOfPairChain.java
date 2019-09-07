package asu.edu.arav.leetcode.dp;

import java.util.Arrays;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int[] ans = new int[pairs.length];
        Arrays.fill(ans, 1);
        for (int i = 1; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][1] < pairs[j][0]) {
                    ans[i] = Math.max(ans[i], ans[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] > max) {
                max = ans[i];
            }
        }
        return max;
    }

    public int findLongestChain1(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int ans = 1;
        int ref = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {
            if(pairs[i][0] > ref){
                ans++;
                ref = pairs[i][1];
            }
        }

        return ans;
    }
}
