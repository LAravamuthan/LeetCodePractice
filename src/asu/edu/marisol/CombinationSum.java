package asu.edu.marisol;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class CombinationSum {

    /**
     * Backtracking approach.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (1).
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.ans = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;
        backTrack(0, 0, new ArrayList<>());
        return ans;
    }

    private List<List<Integer>> ans;
    private int[] candidates;
    private int target;

    private void backTrack(int sum, int start, List<Integer> combination) {
        if (sum >= this.target) {
            if (sum == this.target) this.ans.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i < this.candidates.length; i++) {
            int ele = this.candidates[i];
            combination.add(ele);
            backTrack(sum + ele, i, combination);
            combination.remove(combination.size() - 1);
        }
    }

}
