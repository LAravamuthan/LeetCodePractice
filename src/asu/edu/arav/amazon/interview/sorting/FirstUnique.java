package asu.edu.arav.amazon.interview.sorting;

import java.util.*;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class FirstUnique {

    Set<Integer> uniques = new LinkedHashSet<>();
    Set<Integer> seen = new LinkedHashSet<>();

    public FirstUnique(int[] nums) {
        for (int num : nums) {
            if (seen.contains(num)) {
                uniques.remove(num);
            } else {
                seen.add(num);
                uniques.add(num);
            }
        }
    }

    public int showFirstUnique() {
        return uniques.isEmpty() ? -1 : uniques.iterator().next();
    }

    public void add(int value) {
        if (seen.contains(value)) {
            uniques.remove(value);
        } else {
            seen.add(value);
            uniques.add(value);
        }
    }
}
