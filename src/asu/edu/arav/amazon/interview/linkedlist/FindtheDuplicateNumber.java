package asu.edu.arav.amazon.interview.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/find-the-duplicate-number/
 */
public class FindtheDuplicateNumber {

    // Flyod algorithm awesome use case - purely awesome
    public int findDuplicate(int[] nums) {
        int t = 0, h = 0;
        do {
            t = nums[t];
            h = nums[nums[h]];
        } while (t != h);

        int ptr1 = t;
        int ptr2 = 0;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }

    public int findDuplicate2(int[] nums) {
        Set<Integer> sI = new HashSet<Integer>();

        for (int n : nums) {
            if (sI.contains(n)) {
                return n;
            }
            sI.add(n);
        }
        return -1;
    }
}
