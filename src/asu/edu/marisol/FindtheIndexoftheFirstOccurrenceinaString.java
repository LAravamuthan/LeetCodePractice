package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class FindtheIndexoftheFirstOccurrenceinaString {

    /**
     * Sliding window approach.
     *
     * TODO: Biggest todo ever, all the string matching algorithm are here you better you do it.
     * @time-complexity - O (mn).
     * @space-complexity - O (1).
     */
    public int strStr(String haystack, String needle) {

        if (needle.isEmpty()) return 0;
        int m = haystack.length();
        int n = needle.length();

        for (int i = 0; i <= m - n; i++) {
            int j = 0;
            while (j < n && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) return i;
        }

        return -1;
    }
}
