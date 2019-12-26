package asu.edu.arav.amazon.interview.arraystring;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/intersection-of-two-arrays/
 */
public class IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersection(nums2, nums1);
        }

        Set<Integer> num1Unique = new HashSet<Integer>();
        for (int i : nums1) {
            if (!num1Unique.contains(i)) num1Unique.add(i);
        }

        Set<Integer> intersection = new HashSet<Integer>();

        for (int i : nums2) {
            if (num1Unique.contains(i)) intersection.add(i);
        }

        int i = 0;

        for (int inter : intersection) {
            nums1[i] = inter;
            i++;
        }
        return Arrays.copyOfRange(nums1, 0, intersection.size());
    }
}
