package asu.edu.arav.amazon.interview.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link
 */

//['czvh', 'zczvh', 'zcpzvh', 'zczpzvh', 'zczpzvhx', 'zczpzvdhx', 'zczpzfvdhx']
public class LongestStringChain {
    public int longestStrChain(String[] words) {
        // max count of word chain using each word in the words list
        int dp[] = new int[words.length];
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        // We have sort the list words by there length ???
        // this is a trival matter because the solution at i
        // should be answer for solution at j for all j < i got it
        // the recurrence is for each i start check from all index before whether a chain can be made
        // if yes store the max length of chains at that index.
        dp[0] = 1;
        int globalMax = 1;
        for (int i = 1; i < words.length; i++) {
            // max chain count at idx i
            int maxChain = 1;
            for (int j = i - 1; j >= 0 && words[i].length() - words[j].length() < 2; j--) {
                if (checkWhetherCanBeChained(words[j], words[i])) {
                    maxChain = Math.max(maxChain, dp[j] + 1);
                }
            }
            dp[i] = maxChain;
            globalMax = Math.max(maxChain, globalMax);
        }
        return globalMax;
    }

    // problem specific logic not to worry much in here
    public boolean checkWhetherCanBeChained(String w1, String w2) {
        if (w2.length() != w1.length() + 1) {
            return false;
        }
        Set<Character> wordSet = new HashSet<Character>();
        for (char c : w2.toCharArray()) {
            wordSet.add(c);
        }

        for (char c : w1.toCharArray()) {
            if (!wordSet.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"ksqvsyq", "ks", "kss", "czvh", "zczpzvdhx", "zczpzvh", "zczpzvhx",
                "zcpzvh", "zczvh", "gr", "grukmj", "ksqvsq", "gruj", "kssq", "ksqsq", "grukkmj", "grukj", "zczpzfvdhx", "gru"};
        LongestStringChain lSC = new LongestStringChain();
        System.out.println(lSC.longestStrChain(words));
    }

}
