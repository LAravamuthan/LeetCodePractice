package asu.edu.arav.amazon.interview.design;

import java.util.*;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/insert-delete-getrandom-o1/
 */
public class RandomizedSet {

    Map<Integer, Integer> valToIndexMap;
    List<Integer> values;
    Random rand = null;


    public RandomizedSet() {
        valToIndexMap = new HashMap<Integer, Integer>();
        values = new ArrayList<Integer>();
        rand = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (valToIndexMap.containsKey(val)) {
            return false;
        }
        valToIndexMap.put(val, values.size());
        values.add(values.size(), val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!valToIndexMap.containsKey(val)) {
            return false;
        }
        int indexOfToBeDeleted = valToIndexMap.get(val);
        int valAtLastIdx = values.get(values.size() - 1);
        values.set(indexOfToBeDeleted, valAtLastIdx);
        valToIndexMap.put(valAtLastIdx, indexOfToBeDeleted);
        valToIndexMap.remove(val);
        values.remove(values.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return values.get(rand.nextInt(values.size()));
    }
}