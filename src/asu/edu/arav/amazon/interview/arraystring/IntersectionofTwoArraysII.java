package asu.edu.arav.amazon.interview.arraystring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
public class IntersectionofTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> valueToCountMap = new HashMap<>();
        for (int i : nums1) {
            valueToCountMap.put(i, valueToCountMap.getOrDefault(i, 0) + 1);
        }

        int k = 0;
        for (int i : nums2) {
            if (valueToCountMap.getOrDefault(i, 0) > 0) {
                nums1[k++] = i;
                valueToCountMap.put(i, valueToCountMap.getOrDefault(i, 0) - 1);
            }
        }

        return Arrays.copyOfRange(nums1, 0, k);
    }
}
