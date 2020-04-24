package asu.edu.arav.amazon.interview.arraystring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3289/
 */
public class CountingElements {

    /**
     * @algo hashMap usage
     * @time-complexity - O(n)
     * @space-complexity - O(n)
     */

    public int countElements(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int count = 0;
        Map<Integer, Integer> eleCount = new HashMap<>();
        for (int a : arr) eleCount.put(a, eleCount.getOrDefault(a, 0) + 1);
        for (int a : arr) {
            if (eleCount.getOrDefault(a - 1, 0) > 0) {
                count += eleCount.getOrDefault(a - 1, 0);
                eleCount.remove(a - 1);
            }
        }
        return count;
    }
}
