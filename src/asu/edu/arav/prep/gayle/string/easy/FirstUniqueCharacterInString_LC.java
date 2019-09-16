package asu.edu.arav.prep.gayle.string.easy;

import java.util.HashMap;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class FirstUniqueCharacterInString_LC {
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!m.containsKey(s.charAt(i))) {
                m.put(s.charAt(i), 1);
            } else {
                Integer k = m.get(s.charAt(i));
                m.put(s.charAt(i), k + 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (m.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
