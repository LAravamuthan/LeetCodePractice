package asu.edu.arav.amazon.interview.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/permutations-ii/
 */
public class PermutationsII {

    List<List<Integer>> ansList = new ArrayList<>();
    int[] input = null;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ansList;
        }
        this.input = nums;
        Arrays.sort(input);
        backtrack(new ArrayList<>(), new boolean[nums.length]);
        return ansList;
    }

    public void backtrack(List<Integer> permutation, boolean[] visited) {
        if (permutation.size() == input.length) {
            ansList.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < input.length; i++) {

            if (!visited[i] && !(i > 0 && input[i] == input[i - 1] && !visited[i - 1])) {
                visited[i] = true;
                permutation.add(input[i]);
                backtrack(permutation, visited);
                visited[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        PermutationsII p = new PermutationsII();
        p.permuteUnique(new int[]{1, 1, 2});
    }

}
