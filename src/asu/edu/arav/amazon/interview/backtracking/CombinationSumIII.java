package asu.edu.arav.amazon.interview.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/combination-sum-iii/
 */
public class CombinationSumIII {

    List<List<Integer>> ansList = new ArrayList<>();
    int k = -1;
    int n = -1;


    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n;
        backTrack(new ArrayList<>(), 0, 1);
        return ansList;
    }

    public void backTrack(List<Integer> elements, int  currrentSum, int indexStart){
        if(indexStart == 9 || elements.size() == this.k || currrentSum >= this.n){
            if(elements.size() == this.k && currrentSum == this.n){
                ansList.add(new ArrayList<>(elements));
            }
        }
        for(int i = indexStart; i<=9; i++){
            elements.add(i);
            backTrack(elements, currrentSum + i, i+1);
            elements.remove(elements.size() - 1);
        }
    }


}
