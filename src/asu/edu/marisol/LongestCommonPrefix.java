package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class LongestCommonPrefix {

    /**
     * Horizontal scan.
     *
     * @time-complexity - O (S).
     * @space-complexity - O (1).
     */
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }

    /**
     * Vertical scan.
     *
     * @time-complexity - O (S) all characters in strs.
     * @space-complexity - O (1).
     */
    public String longestCommonPrefix2(String[] strs) {

        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == i || ch != strs[j].charAt(i)) return strs[0].substring(0, i);
            }
        }

        return strs[0];
    }


    /**
     * Divide and conquer approach.
     *
     * @time-complexity - O (S) TODO: recursion formula pls, check that
     * @space-complexity - O (mlogn) n -> no.of strings.
     */
    public String longestCommonPrefix3(String[] strs) {

        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {

        if (l == r) return strs[l];
        else {
            int mid = (l + r) / 2;
            String leftPrefix = longestCommonPrefix(strs, l, mid);
            String rightPrefix = longestCommonPrefix(strs, mid + 1, r);
            return commonPrefix(leftPrefix, rightPrefix);
        }
    }

    private String commonPrefix(String left, String right) {
        int minLength = Math.min(left.length(), right.length());

        for (int i = 0; i < minLength; i++) {
            if (left.charAt(i) != right.charAt(i)) return left.substring(0, i);
        }

        return left.substring(0, minLength);
    }


    /**
     * Binary Search approach.
     *
     * @time-complexity - O (Slogm) TODO: recursion formula pls, check that
     * @space-complexity - O (1).
     */
    public String longestCommonPrefix4(String[] strs) {

        if (strs == null || strs.length == 0) return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) minLen = Math.min(minLen, str.length());

        int l = 1;
        int r = minLen;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (isCommonPrefix(strs, mid)) l = mid + 1;
            else r = mid - 1;
        }

        return strs[0].substring(0, r);
    }

    private boolean isCommonPrefix(String [] strs, int length) {
        String prefix = strs[0].substring(0, length);

        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(prefix)) return false;
        }

        return true;
    }


}
