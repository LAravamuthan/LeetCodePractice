package asu.edu.arav.amazon.interview.dp_dfs_imp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning {
    boolean[][] dpBoolean = null;
    List<List<String>> res = new ArrayList<>();
    String sG = null;

    /**
     * algo - Backtracking and Dynamic Progamming
     * Time complexity - O(n * 2^(n))
     * Space complexity - O(n * 2^(n))
     */

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return res;
        }
        /*2D boolean array which stores whether there are boolean between two
         * indexes */
        sG = s;
        dpBoolean = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dpBoolean[i][i] = true;
        }

        for (int len = 2; len <= s.length(); len++) {
            for (int i = 0; i + len <= s.length(); i++) {
                if (s.charAt(i) == s.charAt(i + len - 1)) {
                    if (len == 2) {
                        dpBoolean[i][i + len - 1] = true;
                    } else {
                        dpBoolean[i][i + len - 1] = dpBoolean[i + 1][i + len - 2];
                    }
                }
            }
        }

        /* we have stored combination of the
         * i and j substring for which palindrome are present
         */
        bfsBackTrack(new ArrayList<String>(), 0);
        return res;
    }

    public void bfsBackTrack(List<String> stringCombinations, int currentPosition) {
        /*if we have covered all the characters in the string */
        if (currentPosition == sG.length()) {
            res.add(new ArrayList<String>(stringCombinations));
        }

        for (int i = currentPosition; i < sG.length(); i++) {
            if (dpBoolean[currentPosition][i]) {
                stringCombinations.add(sG.substring(currentPosition, i + 1));
                bfsBackTrack(stringCombinations, i + 1);
                stringCombinations.remove(stringCombinations.size() - 1);
            }
        }
    }
}
