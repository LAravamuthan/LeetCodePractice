package asu.edu.marisol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class IsSubsequence {

    /**
     * From the cuff. (2 pointer solution I got)
     *
     * @time-complexity - O (T)
     * @space-complexity - O (1)
     */
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        if (s.length() == 0) return true;
        int idxToCheck = 0;
        for (int i = 0; i < t.length() && idxToCheck < s.length(); i++) {
            if (s.charAt(idxToCheck) == t.charAt(i)) idxToCheck++;
        }

        return idxToCheck == s.length();
    }

    /**
     * Greedy with hashMap for cases where we get stream of source string.
     *
     * @time-complexity - O (T + S*Log(T) (iterating over source and binary search on index))
     * @space-complexity - O (T) - size of the hashMap
     */
    public boolean isSubsequence2(String s, String t) {
        if (s.length() > t.length()) return false;

        Map<Character, List<Integer>> targetMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            targetMap.computeIfAbsent(t.charAt(i), k -> new ArrayList<>()).add(i);
        }

        int currentMatchedIndexFromTarget = -1;
        for (char ch : s.toCharArray()) {

            if (!targetMap.containsKey(ch)) return false;

            final List<Integer> indexes = targetMap.get(ch);
            boolean matched = false;
            for (int idx : indexes) {
                if (idx > currentMatchedIndexFromTarget) {
                    matched = true;
                    currentMatchedIndexFromTarget = idx;
                    break;
                }
            }

            if (!matched) return false;
        }

        return true;
    }

    /**
     * DP solution for this useCase.
     *
     * @time-complexity - O (T * S)
     * @space-complexity - O (T * S)
     */
    public boolean isSubsequence3(String s, String t) {

        if (s.length() == 0) return true;
        if (s.length() > t.length()) return false;
        int sLength = s.length(), tLength = t.length();
        int[][] dp = new int[sLength + 1][tLength + 1];

        for (int col = 1; col <= tLength; col++) {
            for (int row = 1; row <= sLength; row++) {
                if (s.charAt(row - 1) == t.charAt(col - 1))
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                else
                    dp[row][col] = Math.max(dp[row][col - 1], dp[row - 1][col]);
                if (dp[sLength][col] == sLength)
                    return true;
            }
        }

        return false;
    }
}
