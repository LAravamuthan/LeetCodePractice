package asu.edu.marisol;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class Combinations {

    /**
     * Backtracking approach, O(n!)
     *
     * @time-complexity - O (n!).
     * @space-complexity - O (k) - number of the sie of answer.
     */
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        this.res = new ArrayList<>();
        combinations(0, new ArrayList<>());
        return res;
    }

    private int n;
    private int k;
    private List<List<Integer>> res;

    private void combinations(int idx, List<Integer> curAns) {
        if (this.n - idx + curAns.size() < k) return;
        if (curAns.size() == this.k) {
            res.add(new ArrayList<>(curAns));
            return;
        }

        for (int i = idx; i < this.n; i++) {
            curAns.add(i + 1);
            combinations(i + 1, curAns);
            curAns.remove(curAns.size() - 1);
        }
    }

}
