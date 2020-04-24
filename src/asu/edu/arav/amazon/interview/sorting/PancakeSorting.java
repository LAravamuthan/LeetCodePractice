package asu.edu.arav.amazon.interview.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/pancake-sorting/
 */
public class PancakeSorting {

    /**
     * @algo - Pancake sorting
     * @time-complexity - O(N^2)
     * @space-complexity - O(N)
     */

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<>();
        if (A == null || A.length == 0) return result;
        int N = A.length;
        Integer[] indexes = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            indexes[i] = i + 1;
        }
        Arrays.sort(indexes, (i, j) -> A[j - 1] - A[i - 1]);
        for (int i : indexes) {
            for (int r : result) {
                if(i <= r)
                    i = r + 1 - i;
            }
            result.add(i);
            result.add(N--);
        }
        return result;
    }


    /**
     * @algo - pancake sorting
     * @time-complexity - O(N^2)
     * @space-complexity - O(N)
     */

    public List<Integer> pancakeSort1(int[] A) {
        List<Integer> res = new ArrayList<>();
        for (int x = A.length, i; x > 0; --x) {
            for (i = 0; A[i] != x; ++i);
            reverse(A, i + 1);
            res.add(i + 1);
            reverse(A, x);
            res.add(x);
        }
        return res;
    }

    public void reverse(int[] A, int k) {
        for (int i = 0, j = k - 1; i < j; i++, j--) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }
}
