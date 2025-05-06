package asu.edu.marisol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class RandomPickIndex {

    private Map<Integer, List<Integer>> numberStorage;
    private Random random;

    /**
     * Storing the number and is occurrence indexes.
     *
     * @time-complexity - O (N).
     * @space-complexity - O (N).
     */
    public RandomPickIndex(int[] nums) {
        this.numberStorage = new HashMap<>();
        this.random = new Random();
        for (int i = 0; i < nums.length; i++) numberStorage.computeIfAbsent(nums[i], k-> new ArrayList<>()).add(i);
    }

    /**
     * Rand function pick of index from number storage.
     *
     * @time-complexity - O (1).
     * @space-complexity - O (1).
     */
    public int pick(int target) {
        int length = numberStorage.get(target).size();
        return numberStorage.get(target).get(random.nextInt(length));
    }

    /**
     * Storing the numbers..
     *
     * @time-complexity - O (1).
     * @space-complexity - O (1).
     */
    public void randomPickIndex(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    private int[] nums;

    /**
     * Reservoir sampling.
     *
     * TODO: Read theory of Reservoir sampling.
     *
     * @time-complexity - O (N).
     * @space-complexity - O (1).
     */
    public int pick2(int target) {
        int count = 0, idx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if (random.nextInt(count) == 0) idx = i;
            }
        }

        return idx;
    }

}
