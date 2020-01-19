package asu.edu.arav.amazon.interview.arraystring;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/missing-ranges/
 */
public class MissingRanges {

    /**
     * @algo - Arrays
     * @time-complexity - O(n)
     * @space-complexity - O(1)
     */


    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            res.add(getRangeString(lower, upper));
            return res;
        }
        int next = lower;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < next) {
                continue;
            }
            if (nums[i] == next) {
                next++;
                continue;
            }
            res.add(getRangeString(next, nums[i] - 1));
            next = nums[i] + 1;
        }
        if (next <= upper) {
            res.add(getRangeString(next, upper));
        }
        return res;
    }

    public String getRangeString(int l1, int l2) {
        return l1 == l2 ? String.valueOf(l1) : String.format("%d->%d", l1, l2);
    }
}
