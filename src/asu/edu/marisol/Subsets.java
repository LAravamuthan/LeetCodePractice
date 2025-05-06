package asu.edu.marisol;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class Subsets {

    /**
     * Backtrack in recursion.
     *
     * @time-complexity - O (N * 2^N).
     * @space-complexity - O (N).
     */
    public List<List<Integer>> subsets(int[] nums) {
        this.ans = new ArrayList<>();
        this.nums = nums;

        backtrack(0, new ArrayList<>());
        return ans;
    }

    private int[] nums;
    private List<List<Integer>> ans;

    private void backtrack(int idx, List<Integer> list) {
        ans.add(new ArrayList<>(list));
        if (idx >= nums.length) return;

        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(i + 1, list);
            list.remove(list.size() - 1);
        }
    }

}
