package asu.edu.arav.amazon.interview.arraystring;

import java.util.Arrays;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
 */
public class FindWords {
    public int countCharacters(String[] words, String chars) {
        int[] charsMap = new int[26];
        for (char c : chars.toCharArray()) {
            charsMap[c - 'a'] += 1;
        }
        int ansCount = 0;
        for(String word : words){
            int[] tempCharsMap = Arrays.copyOf(charsMap, charsMap.length);
            boolean isPossible = true;
            for(char c : word.toCharArray()){
                if(tempCharsMap[c - 'a'] < 1){
                    isPossible = false;
                    break;
                }
                tempCharsMap[c - 'a']--;
            }
            if(isPossible){
                ansCount += word.length();
            }
        }

        return ansCount;
    }
}
