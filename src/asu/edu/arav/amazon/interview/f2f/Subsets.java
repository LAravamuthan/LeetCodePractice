package asu.edu.arav.amazon.interview.f2f;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/subsets/
 */
public class Subsets {
    List<List<Integer>> resultantList = new ArrayList<List<Integer>>();
    int[] inputNums;

    public List<List<Integer>> subsets(int[] nums) {
        // this problem uses backtracking which is use one element and search for it
        // and then remove it and another element and then search for it
        // lets try this out and see whether I can get it done in first trial
        // -- awesome actually did it in the first go enjoy dude

        if (nums == null || nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        inputNums = nums;
        dfsBT(new ArrayList<Integer>(), 0);
        return resultantList;
    }

    // this is going to be like dfs style backtracking method lets see how it goes
    // first parameter is one of the subset pls take note of that
    // second element keeps track of what in the nums array will be
    // candidate to go for making new set
    public void dfsBT(List<Integer> candidateSet, int startElement) {

        // making one entry with set state
        resultantList.add(new ArrayList<>(candidateSet));
        for (int i = startElement; i < inputNums.length; i++){
            // making a new set of elements by adding current element
            candidateSet.add(inputNums[i]);
            // making dfs to mark new candidates using current element
            dfsBT(new ArrayList<>(candidateSet), i + 1);
            // why this lets think about this.... now it makes sense by making a new Array List
            // in the above step lets validate our results
            // removes the used element form candidates with other elements
            candidateSet.remove(candidateSet.size() - 1);
        }
    }

}
