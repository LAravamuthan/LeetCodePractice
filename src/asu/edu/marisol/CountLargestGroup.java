package asu.edu.marisol;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class CountLargestGroup {

    /**
     * Normal simulation.
     *
     * @time-complexity - O (nlogn).
     * @space-complexity - O (logn).
     */
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxNumbers = 0;

        for (int i = 1; i <= n; i++) {
            int key = 0, num = i;
            while (num > 0) {
                key += num % 10;
                num = num / 10;
            }

            map.put(key, map.getOrDefault(key, 0) + 1);
            maxNumbers = Math.max(maxNumbers, map.get(key));
        }
        int count = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == maxNumbers) count++;
        }

        return count;
    }
}
