package asu.edu.marisol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class PermutationsII {

    /**
     * Permute using backtracking.
     *
     * @time-complexity - O (n!).
     * @space-complexity - O (n) -> given max stack frames would be n i.e size of result permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.res = new ArrayList<>();
        this.nums = nums;
        this.counter = new HashMap<>();
        for (int num : nums) {
            this.counter.put(num, this.counter.getOrDefault(num, 0) + 1);
        }
        permutations(new ArrayList<>());
        return this.res;
    }

    private List<List<Integer>> res;
    private int[] nums;
    private Map<Integer, Integer> counter;

    private void permutations(List<Integer> curAns) {
        if (curAns.size() == this.nums.length) {
            this.res.add(new ArrayList<>(curAns));
        } else {
            for (Map.Entry<Integer, Integer> entry : this.counter.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                if (value == 0) continue;
                this.counter.put(key, this.counter.get(key) - 1);
                curAns.add(key);
                permutations(curAns);
                this.counter.put(key, this.counter.get(key) + 1);
                curAns.remove(curAns.size() - 1);
            }
        }
    }
}
