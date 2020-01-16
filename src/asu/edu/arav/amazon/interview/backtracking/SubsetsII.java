package asu.edu.arav.amazon.interview.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/subsets-ii/
 */
public class SubsetsII {

    /**
     * @algo - bracktracking
     * @time-complexity - O(2^n)
     * @space-complexity - O(2^n)
     */

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrack(nums, 0, new ArrayList<Integer>());
        return res;
    }

    public void backTrack(int[] nums, int strIdx, List<Integer> numL) {
        res.add(new ArrayList<>(numL));
        for (int i = strIdx; i < nums.length; i++) {
            if (i == strIdx || nums[i - 1] != nums[i]) {
                numL.add(nums[i]);
                backTrack(nums, i + 1, numL);
                numL.remove(numL.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        SubsetsII sb = new SubsetsII();
        sb.subsetsWithDup(new int []{1,2,2});
    }
}
