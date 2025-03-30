package asu.edu.marisol;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class Permutations {

    /**
     * Permute using backtracking.
     *
     * @time-complexity - O (n!).
     * @space-complexity - O (n) -> given max stack frames would be n i.e size of result permutations
     */
    public List<List<Integer>> permute(int[] nums) {
        this.res = new ArrayList<>();
        this.nums = nums;
        permutations(new HashSet<>(), new ArrayList<>());
        return this.res;
    }

    private List<List<Integer>> res;
    private int[] nums;

    private void permutations(Set<Integer> idsToSkip, List<Integer> curAus) {
        if (curAus.size() == this.nums.length) {
            this.res.add(new ArrayList<>(curAus));
            return;
        }

        for (int i = 0; i < this.nums.length; i++) {
            if (idsToSkip.contains(i)) continue;
            curAus.add(this.nums[i]);
            idsToSkip.add(i);
            permutations(idsToSkip, curAus);
            curAus.remove(curAus.size() - 1);
            idsToSkip.remove(i);
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        this.res = new ArrayList<>();
        this.nums = nums;
        permutations2(new ArrayList<>());
        return this.res;
    }

    private void permutations2(List<Integer> curAus) {
        if (curAus.size() == this.nums.length) {
            this.res.add(new ArrayList<>(curAus));
            return;
        }

        for (int i = 0; i < this.nums.length; i++) {
            if (curAus.contains(nums[i])) continue;
            curAus.add(this.nums[i]);
            permutations2(curAus);
            curAus.remove(curAus.size() - 1);
        }
    }

}
