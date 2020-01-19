package asu.edu.arav.amazon.interview.sorting;

import java.util.Arrays;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/largest-number/
 */
public class LargestNumber {

    /**
     * @algo - custom sorting
     * @time-complexity - O(NlogN)
     * @space-complexity - O(N)
     */

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] strSorted = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strSorted[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strSorted, (a, b) -> (b + a).compareTo(a + b));
        if (strSorted[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strSorted.length; i++) {
            sb.append(strSorted[i]);
        }
        return sb.toString();
    }
}
