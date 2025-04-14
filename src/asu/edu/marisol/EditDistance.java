package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class EditDistance {

    /**
     * Top-down dynamic programming .
     *
     * @time-complexity - O (M * N).
     * @space-complexity - O (M * N).
     */
    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        this.cache = new Integer[word1.length() + 1][word2.length() + 1];
        return recursion(word1.length(), word2.length());
    }

    private String word1;
    private String word2;
    private Integer[][] cache;

    private int recursion(int wordIndex1, int wordIndex2) {
        if (wordIndex1 == 0) return wordIndex2;
        if (wordIndex2 == 0) return wordIndex1;
        if (cache[wordIndex1][wordIndex2] != null) return cache[wordIndex1][wordIndex2];
        int minDist = 0;

        if (word1.charAt(wordIndex1 - 1) == word2.charAt(wordIndex2 - 1)) {
            minDist = recursion(wordIndex1 - 1, wordIndex2 -1);
        }
        else {
            int replaceDistance = recursion(wordIndex1 - 1, wordIndex2 - 1);
            int insertDistance = recursion(wordIndex1, wordIndex2 - 1);
            int deleteDistance = recursion(wordIndex1 -1, wordIndex2);
            minDist = Math.min(replaceDistance, Math.min(insertDistance, deleteDistance)) + 1;
        }
        cache[wordIndex1][wordIndex2] = minDist;
        return minDist;
    }

    /**
     * Bottom-up dynamic programming .
     *
     * @time-complexity - O (M * N).
     * @space-complexity - O (M * N).
     */
    public int minDistance2(String word1, String word2) {

        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();

        int [][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word2.length(); i++) dp[0][i] = i;
        for (int i = 0; i <= word1.length(); i++) dp[i][0] = i;

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
