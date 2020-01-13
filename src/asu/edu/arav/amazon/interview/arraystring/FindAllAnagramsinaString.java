package asu.edu.arav.amazon.interview.arraystring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
public class FindAllAnagramsinaString {

    /**
     * @algo - sliding window approach
     * @time-complexity O(n) where n - no. of characters in string s
     * @space-complexity O(m) where m - no. of unique characters in string p
     */

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0) {
            return res;
        }

        int strIndex = 0;
        int endIndex = 0;

        int [] charCount = new int[26];
        for (char ch : p.toCharArray()) {
            charCount[ch - 'a']++;
        }
        int matches = 0;
        while (endIndex < s.length()) {
            char endCh = s.charAt(endIndex);
            if(charCount[endCh - 'a'] > 0){
                charCount[endCh - 'a']--;
                matches++;
                endIndex++;
            }else{
                char strCh = s.charAt(strIndex);
                charCount[strCh - 'a']++;
                strIndex++;
                matches--;
            }
            if(matches == p.length()){
                res.add(strIndex);
            }
        }
        return res;
    }
}
