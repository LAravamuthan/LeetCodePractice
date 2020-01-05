package asu.edu.arav.amazon.interview.arraystring;

import java.util.Random;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/shuffle-an-array/
 */
public class ShuffleanArray {

    int[] arrays = null;
    int[] original = null;

    Random random = new Random();

    public int getRandRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    public ShuffleanArray(int[] nums) {
        this.arrays = nums;
        this.original = nums.clone();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        this.arrays = this.original;
        this.original = original.clone();
        return this.arrays;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {

        for (int i = 0; i < arrays.length; i++) {
            int randIndex = getRandRange(i, arrays.length);
            int temp = arrays[randIndex];
            arrays[randIndex] = arrays[i];
            arrays[i] = temp;
        }

        return this.arrays;
    }
}
