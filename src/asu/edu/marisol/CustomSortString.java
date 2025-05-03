package asu.edu.marisol;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class CustomSortString {

    /**
     * Sorting based on order String.
     *
     * @time-complexity - O (NLogN).
     * @space-complexity - O (N).
     */
    public String customSortString(String order, String s) {
        int n = s.length();

        Character[] result = new Character[n];
        for (int i = 0; i < n; i++) {
            result[i] = s.charAt(i);
        }

        Arrays.sort(result, Comparator.comparingInt(order::indexOf));

        StringBuilder sb = new StringBuilder();
        for (char ch : result) {
            sb.append(ch);
        }

        return sb.toString();
    }


    /**
     * Counting based algorithm.
     *
     * @time-complexity - O (N).
     * @space-complexity - O (N).
     */
    public String customSortString2(String order, String s) {
        int n = s.length();

        Map<Character, Integer> count = new HashMap<>();

        for (char ch : s.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        int k = order.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < k; i++) {
            char ch = order.charAt(i);
            while (count.getOrDefault(ch, 0) > 0) {
                result.append(ch);
                count.put(ch, count.get(ch) - 1);
            }
        }

        for (char key : count.keySet()) {
            while (count.get(key) > 0) {
                result.append(key);
                count.put(key, count.get(key) - 1);
            }
        }

        return result.toString();
    }
}
