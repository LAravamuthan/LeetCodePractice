package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MergeStringsAlternately {


    /**
     * merge alternately with one pointer.
     *
     * @time-complexity - O (Max(M, N))
     * @space-complexity - O (1 or M + N)
     */
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < Math.max(m, n); i++) {
            if (i < m) result.append(word1.charAt(i));
            if (i < n) result.append(word2.charAt(i));
        }

        return result.toString();
    }
}
