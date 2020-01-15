package asu.edu.arav.amazon.interview.arraystring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/verifying-an-alien-dictionary/
 */
public class VerifyinganAlienDictionary {

    /**
     * @algo - words
     * @time-complexity - O(n)
     * @space-complexity - O(1)
     */

    public boolean isAlienSorted(String[] words, String order) {

        int[] index = new int[26];
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }

        block:
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    if (index[word1.charAt(j) - 'a'] > index[word2.charAt(j) - 'a']) {
                        return false;
                    } else {
                        continue block;
                    }
                }
            }
            if (word1.length() > word2.length()) {
                return false;
            }
        }
        return true;
    }
}
