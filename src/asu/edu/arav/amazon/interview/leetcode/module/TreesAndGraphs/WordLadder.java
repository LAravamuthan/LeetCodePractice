package asu.edu.arav.amazon.interview.leetcode.module.TreesAndGraphs;

import java.util.*;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/word-ladder/
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // if begin and end word are null are of different size just return
        if (beginWord == null || endWord == null || beginWord.length() != endWord.length()) {
            return 0;
        }

        // Make a word Set for easy retrival and access I guess
        Set<String> wordSet = new HashSet<String>();
        Set<String> seenWords = new HashSet<String>();

        for (String word : wordList) {
            wordSet.add(word);
        }

        // If the endword is not present in dictionary we can use then there is no use
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        // This queue will maintain the contour of elements to be seen
        Deque<String> queue = new ArrayDeque<>();

        queue.add(beginWord);

        // consider the root element that is the beginNode to be counted as 1
        int distanceTravelled = 1;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            // this for loop is very important as this makes sure that we process all the childs
            // at the same time if  they are at same level
            for (int i = 0; i < queueSize; i++) {
                String node = queue.poll();
                if (node.equals(endWord)) { // current node is the target word return the steps travelled so far
                    return distanceTravelled;
                }

                for (int k = 0; k < node.length(); k++) {
                    char[] charNode = node.toCharArray();
                    // changing each character of the word at a time to form new words
                    for (int j = 'a'; j < 'a' + 26; j++) {
                        if (node.charAt(k) == (char) j) { // making the sure the new child word is not same as the
                            // current node word
                            continue;
                        } else {
                            charNode[k] = (char) j;
                            String child = new String(charNode);
                            // the word we want to be the child of the current node  is the one which is not
                            // already seen and should be present in the overall dictionary
                            if (!seenWords.contains(child) && wordSet.contains(child)) {
                                queue.add(child);
                                seenWords.add(child);
                            }
                        }
                    }
                }
            }
            distanceTravelled++;
        }
        return 0;
    }

    // method to check whether two strings are only 1 distance
    public boolean isDiffWords(String s, String t) {
        int diffCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                continue;
            }
            diffCount++;
        }
        return diffCount == 1 ? true : false;
    }
}
