package asu.edu.arav.amazon.interview.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/permutations/
 */
public class Permutations {
    List<List<Integer>> ansList = new ArrayList<List<Integer>>();
    int[]  inputNums;

    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<List<Integer>>();
        }

        inputNums = nums;
        dfsStyleBackTrack(new ArrayList<Integer>());

        return ansList;
    }

    public void dfsStyleBackTrack(List<Integer> candidatePermutation){
        if(candidatePermutation.size() == inputNums.length){
            ansList.add(new ArrayList<Integer>(candidatePermutation));
            return;
        }
        for(int i : inputNums){
            if(candidatePermutation.contains(i)){
                continue;
            }
            candidatePermutation.add(i);
            dfsStyleBackTrack(candidatePermutation);
            candidatePermutation.remove(candidatePermutation.size()-1);
        }
    }
}
