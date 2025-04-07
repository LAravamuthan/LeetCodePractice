package asu.edu.marisol;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ValidAnagram {

    /**
     * HashMap approach to cater to all unicodes, also we can do this with constant space but at the cost of sorting.
     *
     * @time-complexity - O(2n).
     * @space-complexity - O(n).
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            if (map.get(ch) < 0) return false;
        }

        return true;
    }
}
