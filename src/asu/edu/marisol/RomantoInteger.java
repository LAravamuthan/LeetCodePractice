package asu.edu.marisol;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class RomantoInteger {

    /**
     * Simple conversion from back.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (1).
     */
    public int romanToInt(String s) {
        Map<Character, Integer> mapping = new HashMap<>();
        mapping.put('I', 1);
        mapping.put('V', 5);
        mapping.put('X', 10);
        mapping.put('L', 50);
        mapping.put('C', 100);
        mapping.put('D', 500);
        mapping.put('M', 1000);

        int result = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            result += mapping.get(ch);
            if (i - 1 >= 0) {
                char chPrev = s.charAt(i - 1);
                if (mapping.get(chPrev) < mapping.get(ch)) {
                    result -= mapping.get(chPrev);
                    i--;
                }
            }
        }

        return result;
    }
}
