package asu.edu.marisol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DP problem.
 *
 * @time-complexity - O (amount * coins).
 * @space-complexity - O (amount).
 */
public class LongestIncreasingSubsequence {

    /**
     * DP problem first, then think about binary search approach.
     *
     * @time-complexity - O (N^2).
     * @space-complexity - O (N).
     */
    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        int maxLength = 1;

        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLength = Math.max(dp[i], maxLength);
                }
            }
        }

        return maxLength;
    }

    /**
     * binary search problem.
     *
     * @time-complexity - O (N Log N).
     * @space-complexity - O (N).
     */
    public int lengthOfLIS2(int[] nums) {
        List<Integer> s = new ArrayList<>();
        s.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > s.get(s.size()) - 1) s.add(nums[i]);
            else {
                int insertionIndex = binarySearch(nums[i], s);
                s.set(insertionIndex, nums[i]);
            }
        }
        return s.size();
    }

    private int binarySearch(int target, List<Integer> arr) {
        int l = 0;
        int r = arr.size() - 1;

        while (l < r) {
            int mid = l + (r - l)/2;
            if (arr.get(mid) == target) return mid;
            else if (target < arr.get(mid)) r = mid;
            else l = mid + 1;
        }

        return l;
    }





}
