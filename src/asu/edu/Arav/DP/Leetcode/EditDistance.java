package asu.edu.Arav.DP.Leetcode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        int[][] costMatrix = new int[word1.length() + 1][word2.length() + 1];
        costMatrix[0][0] = 0;
        for (int i = 1; i <= word1.length(); i++) {
            costMatrix[i][0] = i;
        }
        for (int i = 1; i <= word2.length(); i++) {
            costMatrix[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                int replaceMentCost = word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1;
                costMatrix[i][j] = Math.min(replaceMentCost + costMatrix[i - 1][j - 1],
                        Math.min(1 + costMatrix[i - 1][j], 1 + costMatrix[i][j - 1]));
            }
        }
        return costMatrix[word1.length()][word2.length()];
    }
}
