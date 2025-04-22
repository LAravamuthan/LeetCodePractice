package asu.edu.marisol;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class SparseVector {

    private Map<Integer, Integer> mapping;

    SparseVector(int[] nums) {
        mapping = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) mapping.put(i, nums[i]);
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int dotProduct = 0;
        for (int idx : this.mapping.keySet()) {
            dotProduct += this.mapping.get(idx) * vec.mapping.getOrDefault(idx, 0);
        }
        return dotProduct;
    }




}
