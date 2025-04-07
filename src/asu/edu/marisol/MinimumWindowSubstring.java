package asu.edu.marisol;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MinimumWindowSubstring {

    /**
     * Recursion and binary search concept
     *
     * @time-complexity - O (S + T).
     * @space-complexity - O (h).
     */
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        int [] ans = {-1, 0, 0};

        Map<Character, Integer> tMap = new HashMap<>();

        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> sMap = new HashMap<>();

        int left = 0, right = 0;
        int uniqueChars = tMap.size();
        int charFormed = 0;

        while (right < s.length()) {

            char chR = s.charAt(right);
            sMap.put(chR, sMap.getOrDefault(chR, 0) + 1);

            if (tMap.containsKey(chR) && sMap.get(chR).equals(tMap.get(chR))) charFormed++;

            while (left <= right && charFormed == uniqueChars) {
                if (ans[0] == -1 || ans[0] > right - left + 1) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                char chL = s.charAt(left);
                sMap.put(chL, sMap.getOrDefault(chL, 0) - 1);
                left++;

                if (tMap.containsKey(chL) &&  sMap.get(chL) < tMap.get(chL)) charFormed--;
            }
            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

}
