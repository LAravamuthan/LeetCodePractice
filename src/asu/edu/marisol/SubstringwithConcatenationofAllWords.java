package asu.edu.marisol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class SubstringwithConcatenationofAllWords {

    /**
     * Using approach checking all indexes for a possible substring match.
     *
     * @time-complexity - O (n.a.b - (a-b)^2) a >- no.of elements in words and b -> workLength.
     * @space-complexity - O (a + b).
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        wordLength = words[0].length();
        subStringLength = words.length * wordLength;
        n = s.length();
        k = words.length;

        for (int i = 0; i < n - subStringLength + 1; i++) {
            if (check(i, s)) ans.add(i);
        }

        return ans;
    }

    private Map<String, Integer> wordCount = new HashMap<>();
    private int wordLength;
    private int subStringLength;
    private int n;
    private int k;

    private boolean check(int i, String s) {

        Map<String, Integer> remainWords = new HashMap<>(wordCount);
        int wordsUsed = 0;

        for (int j = i; j < i + subStringLength; j += wordLength) {
            String sub = s.substring(j, j + wordLength);
            if (remainWords.getOrDefault(sub, 0) > 0) {
                remainWords.put(sub, remainWords.getOrDefault(sub, 0) - 1);
                wordsUsed++;
            } else break;

        }

        return wordsUsed == k;
    }

    /**
     * Using sliding window here we need not check for indexes from the main method but only wordLength of each word.
     *
     * @time-complexity - O (a + nb) a >- no.of elements in words and b -> workLength.
     * @space-complexity - O (a + b).
     */
    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        wordLength = words[0].length();
        subStringLength = words.length * wordLength;
        n = s.length();
        k = words.length;

        for (int i = 0; i < wordLength; i++) {
            slidingWindow(i, s, ans);
        }

        return ans;
    }

    private void slidingWindow(int left, String s, List<Integer> answer) {
        int wordsUsed = 0;
        Map<String, Integer> wordFound = new HashMap<>();
        boolean excessWord = false;
        for (int right = left; right < n - wordLength + 1; right += wordLength) {
            String sub = s.substring(right, right + wordLength);
            if (!wordCount.containsKey(sub)) {
                wordsUsed = 0;
                wordFound.clear();
                left = right + wordLength;
                excessWord = false;
            } else {
                while (right - left == subStringLength || excessWord) {
                    String leftMostWord = s.substring(left, left + wordLength);
                    wordFound.put(leftMostWord, wordFound.getOrDefault(leftMostWord, 0) - 1);
                    if (wordFound.get(leftMostWord).equals(wordCount.get(leftMostWord))) excessWord = false;
                    else wordsUsed--;
                    left += wordLength;
                }

                wordFound.put(sub, wordFound.getOrDefault(sub, 0) + 1);
                if (wordFound.get(sub) <= wordCount.get(sub)) wordsUsed++;
                else excessWord = true;
                if (wordsUsed == k) answer.add(left);
            }
        }
    }


}
