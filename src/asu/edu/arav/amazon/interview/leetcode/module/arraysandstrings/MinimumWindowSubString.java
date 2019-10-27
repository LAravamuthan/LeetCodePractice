package asu.edu.arav.amazon.interview.leetcode.module.arraysandstrings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubString {
    public static String minWindow(String s, String t) {

        if (s == null || t == null) {
            return "";
        }
        /*character of String T and count Map
        */
        Map<Character, Integer> charToCount = new HashMap<>();
        for (char ch : t.toCharArray()) {
            charToCount.put(ch, charToCount.getOrDefault(ch, 0) + 1);
        }

        // the size of the hashmap tells us the unique elements and
        // that is the required elements we need in oue slliding window
        int requiredCharCounts = charToCount.size();
        int strIdx = 0, endIdx = 0;
        // This Map is holding the character required as requirement from t
        // in the present window
        Map<Character, Integer> windowCharToCount = new HashMap<>();
        // the best substring so far
        int [] subStringAns = {Integer.MAX_VALUE, 0, 0};
        // the unique characters of T that String S' current window holds
        int windowCharacterFormed = 0;
        while(endIdx < s.length() && s.length() - strIdx >= requiredCharCounts){

            Character sChar = s.charAt(endIdx);
            // if the character element is avaiable in the T string
            // increase its count in the current windowMap
            // after increase check whether it has reached the quota of counts
            // every time it reaches quota (==) only then increase
            // character formed Count for this window count
            if(charToCount.containsKey(sChar)){
                windowCharToCount.put(sChar,
                        windowCharToCount.getOrDefault(sChar, 0) + 1);
                // I am perplexed as to why to use the equals method here, may be for larger
                // int value the is way bigger for int and hence Integer class is to be used I guess
                // investigate further on this
                if(charToCount.get(sChar).equals(windowCharToCount.get(sChar)) ){
                    windowCharacterFormed++;
                }
            }

            while(windowCharacterFormed == requiredCharCounts){
                // while current character count is equal to required amount increase the start index

                if(endIdx + 1 - strIdx < subStringAns[0]){
                    // every time window Character count is the required count
                    // check whether current sliding window is the count
                    subStringAns[0] = endIdx + 1 - strIdx;
                    subStringAns[1] = strIdx;
                    subStringAns[2] = endIdx + 1;
                }
                char strIdxChar = s.charAt(strIdx);
                // if charcter at the strIdx is in T char count map
                // then decresae its count from current window Map
                // post which check whether current map loses the count
                // required for this character if yes decrease the windowCharacters formed
                if(charToCount.containsKey(strIdxChar)){
                    windowCharToCount.put(strIdxChar, windowCharToCount.get(strIdxChar) - 1);
                    if(charToCount.get(strIdxChar) > windowCharToCount.get(strIdxChar)){
                        windowCharacterFormed--;
                    }
                }
                strIdx++;
            }
            endIdx++;
        }
        return s.substring(subStringAns[1], subStringAns[2]);
    }

    public static void main(String [] args){
        minWindow("ADOBECODEBANC", "ABC");
    }


}
