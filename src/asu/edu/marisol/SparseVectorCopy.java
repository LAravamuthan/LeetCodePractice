package asu.edu.marisol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class SparseVectorCopy {

    // index and value.
    private List<int[]> pairs;

    SparseVectorCopy(int[] nums) {
        pairs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) pairs.add(new int[] {i, nums[i]});
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVectorCopy vec) {
        int dotProduct = 0;

        SparseVectorCopy base = this.pairs.size() < vec.pairs.size() ? this : vec;
        SparseVectorCopy vecToSearch = base != this ? this : vec;

        for (int[] pair : base.pairs) {
            dotProduct += pair[1] * binarySearchIndex(vecToSearch, pair[0]);
        }

        return dotProduct;
    }


    private int binarySearchIndex(SparseVectorCopy vec, int idxToSearch) {
        int left = 0;
        int right = vec.pairs.size() - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (vec.pairs.get(mid)[0] < idxToSearch) left = mid + 1;
            else if (vec.pairs.get(mid)[0] > idxToSearch) right = mid - 1;
            else return vec.pairs.get(mid)[1];
        }

        return 0;
    }

}
