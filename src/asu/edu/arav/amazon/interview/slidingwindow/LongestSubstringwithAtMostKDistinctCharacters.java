package asu.edu.arav.amazon.interview.slidingwindow;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 */
public class LongestSubstringwithAtMostKDistinctCharacters {

    /**
     *
     * @algo - sliding window
     * @time-complexity - O(n)
     * @space-complexity - O(1)
     */

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0 || k == 0) return 0;

        int left = 0;
        int right = 0;
        char[] charCount = new char[26];
        int maxlen = 1;
        int uniqueInWindow = 0;
        while(right < s.length()){
            if(charCount[s.charAt(right++) - 'a']++ == 0){
                uniqueInWindow++;
            }
            while(uniqueInWindow == k + 1){
                if(--charCount[s.charAt(left++) - 'a'] == 0)
                    uniqueInWindow--;
            }

            maxlen = Math.max(right - left, maxlen);
        }
        return maxlen;
    }
}
