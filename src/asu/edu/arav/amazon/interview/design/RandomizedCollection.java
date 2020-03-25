package asu.edu.arav.amazon.interview.design;

import java.util.*;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 */
public class RandomizedCollection {


    List<Integer> values;
    Map<Integer, Set<Integer>> hm;
    Random random;

    public RandomizedCollection() {
        values = new ArrayList<>();
        hm = new HashMap<>();
        random = new Random();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        Set<Integer> indexes = hm.getOrDefault(val, new LinkedHashSet<>());
        indexes.add(values.size());
        hm.put(val, indexes);
        values.add(val);
        return indexes.size() == 1;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (!hm.containsKey(val)) return false;
        Set<Integer> valIndexes = hm.get(val);
        int indxToBeDeleted = valIndexes.iterator().next();
        valIndexes.remove(indxToBeDeleted);
        if (valIndexes.size() == 0) hm.remove(val);
        else hm.put(val, valIndexes);
        int valAtLastIdx = values.get(values.size() - 1);
        values.set(indxToBeDeleted, valAtLastIdx);
        Set<Integer> newOne = hm.getOrDefault(valAtLastIdx, new LinkedHashSet<>());
        newOne.add(indxToBeDeleted);
        newOne.remove(values.size()-1);
        if (newOne.size() == 0) hm.remove(valAtLastIdx);
        else hm.put(valAtLastIdx, newOne);
        values.remove(values.size() - 1);
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return values.get(random.nextInt(values.size()));
    }

    public static void main(String[] args){
        RandomizedCollection rc = new RandomizedCollection();
        rc.insert(4);
        rc.insert(3);
        rc.insert(4);
        rc.insert(2);
        rc.insert(4);
        rc.remove(4);
        rc.remove(3);
        rc.remove(4);
        rc.remove(4);
    }

}
