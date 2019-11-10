package asu.edu.arav.amazon.interview.leetcode.module.dynamicprogramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/word-break/
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordsDictionary = new HashSet<String>();

        for (String word : wordDict) {
            wordsDictionary.add(word);
        }
        // boolean array to tell how to the status of the values at each index
        boolean[] isWordFromWordDict = new boolean[s.length() + 1];
        // String of size 0 is always present
        isWordFromWordDict[0] = true;
        for (int i = 1; i < isWordFromWordDict.length; i++) {
            for (int j = 0; j < i; j++) {
                // if the curent substring ending at i and all the elements
                // before can be part of the string then vola
                // the current index i can be formed
                if (isWordFromWordDict[j] && wordsDictionary.contains(s.substring(j, i))) {
                    isWordFromWordDict[i] = true;
                }
            }
        }
        return isWordFromWordDict[s.length()];
    }

}
