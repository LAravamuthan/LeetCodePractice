package asu.edu.arav.amazon.interview.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {


    List<List<Integer>> ansList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates); // this is optimise the the algorithm a little
        // since sorting will make sure the larger elements wont be used since
        // once the sum reaches beyond the limit the subsequent are never tried as they are also
        // bigger then the previous, hence we pruned the search space of the search we are doing currently

        backtrack(candidates, target, new ArrayList<Integer>(), 0, 0);
        return ansList;
    }

    public void backtrack(int[] candidats, int taraget, List<Integer> path, int sum, int index) {

        // if we have come to a point where the sum after recurring is
        // equal or greater to the given target then we should recur


        if (sum >= taraget) {
            if (sum == taraget) {
                ansList.add(new ArrayList<Integer>(path));
            }
            return;
        }

        /**
        *
         * This index parameter is a very important one it makes sure that duplicate combination does not happen
         * How ?? the previous on would make have already made combinations with the sebsequent elemenets we should not
         * make use of them in the newer elements it willl only cause repetiion
         *
         * Also one element can be used multiple times we can start from the same index in the subsequent recursion
         * but not the previous ones
         * */

        // else the sum is not made up full recur all candidates
        for (int i = index; i < candidats.length; i++) {
            path.add(i);
            backtrack(candidats, taraget, path, sum + candidats[i], i);
            // this below is the one on  which the whole algorithm depends on
            // what are we doing here removing the current element after its
            // recursion completes
            path.remove(path.size() - 1);
            // where does the current element be present at the last index
            // it is so because of the fact that its recurence woudl done the same
            // their recusion completed that is when they were backtracking
        }
    }

}

