package asu.edu.arav.amazon.interview.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class CombinationSumII {

    List<List<Integer>> ansList = new ArrayList<>();
    int[] candidates = null;
    int target = -1;


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        // so as to prune the search space
        Arrays.sort(this.candidates);
        backtrack(0, 0, new ArrayList<Integer>());
        return ansList;
    }

    public void backtrack(int indexToStart, int currentSum, List<Integer> currentElements) {
        // if the current Sum is grateer or equal to  the target sum or  the indexTostart crosees the limit
        // stop the recursion

        if (indexToStart == this.candidates.length || currentSum >= this.target) {
            // if the sum is the equal it is one of the answers
            if (currentSum == this.target) {
                ansList.add(new ArrayList<>(currentElements));
            }
            return;
        }


        // recur all the options
        for (int i = indexToStart; i < this.candidates.length; i++) {
            // this is the step where we make the unique combinations
            // once we use one character in the current recursion
            // dont use it again as the subsequent recursion we make use of the
            // repetition of characters
            if (i > indexToStart && this.candidates[i] == this.candidates[i - 1]) {
                continue;
            }
            currentElements.add(this.candidates[i]);
            // here to the next recurence is i + 1 because of the fact that we cant use the
            // same element more than once
            backtrack(i + 1, currentSum + this.candidates[i], currentElements);
            // this step the backtracking step once all the other possible sums are recurred
            // backtrak
            currentElements.remove(currentElements.size() - 1);
        }
    }


}
