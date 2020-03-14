package asu.edu.arav.amazon.interview.arraystring;

import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
 */
public class LongestWordinDictionarythroughDeleting {

    /**
     * @algo - arraysString
     * @time-complexity - O(n*M)
     * @space-complexity - O(1)
     */

    public String findLongestWord(String s, List<String> d) {
        String ans = "";
        if (d == null || s == null || d.size() == 0 || s.length() == 0) return ans;
        for (String to : d) {
            if (to.length() >= ans.length() && isPossibleToMake(to, s))
                ans = ans.length() == to.length() ? (ans.compareTo(to) < 0 ? ans : to) : to;
        }
        return ans;
    }

    public boolean isPossibleToMake(String to, String from) {
        if (from.length() < to.length()) return false;
        int j = 0;
        for (int i = 0; i < from.length() && j < to.length(); i++) {
            if (from.charAt(i) == to.charAt(j)) j++;
        }
        return j == to.length();
    }
}
