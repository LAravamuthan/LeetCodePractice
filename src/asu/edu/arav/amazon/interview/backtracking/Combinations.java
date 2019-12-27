package asu.edu.arav.amazon.interview.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/combinations/
 */
public class Combinations {
    int size = -1;
    int maxEle = -1;
    List<List<Integer>> ansList = new ArrayList<>();


    // Time complexity - O(combination of n picking  - nCk) Space complexity - O(nCk)
    public List<List<Integer>> combine(int n, int k) {
        this.maxEle = n;
        this.size = k;
        backtracking(new ArrayList<>(), 1);
        return ansList;
    }

    // Start - will let you know which element the current recursion should add to the candidateArray
    // candidateArray  - possible combination of numbers that can be part of the final Answer
    public void backtracking(List<Integer> candidateArray, int start) {
        if (candidateArray.size() == size) {
            ansList.add(new ArrayList<Integer>(candidateArray));// why are we creating new object
            // this is to make sure that the current arrayList object is not manipulated once marked
            // as a valid combination
        }
        // we start from index start so as to make sure we make combination, but not permutation
        // here 1,2 and 2,1 are the same combinations, so once we we can have seen all possible values of say
        // index 'i' then next recursion should be for "i + 1" making sure i + 1 doest not i as its combination
        for (int i = start; i <= maxEle; i++) {
            candidateArray.add(i);
            backtracking(candidateArray, i + 1);
            candidateArray.remove(candidateArray.size() - 1); // the following recursion would have removed themselves too
            // hence the i wiil be at the last index --- > this is the backtracking step
        }
    }


}
