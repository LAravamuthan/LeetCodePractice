package asu.edu.arav.amazon.interview.arraystring;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class ShortestWordDistance {

    /**
     * @algo - ArrayString
     * @time-complexity - O(n), n - words
     * @space-complexity - O(1)
     */

    public int shortestDistance(String[] words, String word1, String word2) {
        int minDistance = Integer.MAX_VALUE;
        int firstIdx = -1, secondIdx = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                firstIdx = i;
            }
            if (words[i].equals(word2)) {
                secondIdx = i;
            }
            if (firstIdx != -1 && secondIdx != -1) {
                minDistance = Math.min(Math.abs(firstIdx - secondIdx), minDistance);
            }
        }
        return minDistance;
    }
}
