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

    // to store all the permutations with size same as nums length
    List<List<Integer>> ansList = new ArrayList<List<Integer>>();
    int[]  inputNums; // copied the input in this so that recursion can be bigger.



    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<List<Integer>>();
        }

        inputNums = nums;
        // dfs style BackTracking
        dfsStyleBackTrack(new ArrayList<Integer>());

        return ansList;
    }

    public void dfsStyleBackTrack(List<Integer> candidatePermutation){

        // if the current candidate size is equal to input size , this will be one result
        if(candidatePermutation.size() == inputNums.length){
            ansList.add(new ArrayList<Integer>(candidatePermutation));
            return;
        }


        // iterate through all the possbile nums important as we not forming subsets but permutations
        for(int i : inputNums){
            //
            if(candidatePermutation.contains(i)){
                continue;
            }
            candidatePermutation.add(i);
            dfsStyleBackTrack(candidatePermutation);
            candidatePermutation.remove(candidatePermutation.size()-1);
        }
    }
}
