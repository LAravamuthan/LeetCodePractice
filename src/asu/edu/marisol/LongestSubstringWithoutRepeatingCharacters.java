package asu.edu.marisol;

import asu.edu.arav.impgoogle.MergeInterval;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * Sliding window approach with hashMap as extra space and count as values.
     *
     * @time-complexity - O (2n), given we might move on idx twice.
     * @space-complexity - O (min(k, n)), where k no. of unique characters (max of 26) and n no. of characters.
     */
    public int lengthOfLongestSubstring(String s) {
        int right = 0, left = 0;
        int res = 0;
        // approach of storing the index, does not work since who will take care of clearing older idx(s)
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.get(ch) > 1) {
                char lch = s.charAt(left);
                map.put(lch, map.get(lch) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    /**
     * Sliding window approach with hashMap as extra space, in here we will use the index as values,
     * we will have clear lower idx apperances.
     *
     * @time-complexity - O (n), efficient sliding window.
     * @space-complexity - O (min(k, n)), where k no. of unique characters (max of 26) and n no. of characters.
     */
    public int lengthOfLongestSubstring2(String s) {
        int right = 0, left = 0;
        int res = 0;
        // approach of storing the index works now by making sure we dont go back to older idxes
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                left = Math.max(map.get(ch) + 1, left);
            }
            map.put(ch, right);
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }


    /**
     * Sliding window approach with hashMap as extra space, practice for index as values.
     *
     * @time-complexity - O (n), efficient sliding window.
     * @space-complexity - O (min(k, n)), where k no. of unique characters (max of 26) and n no. of characters.
     */
    public int lengthOfLongestSubstring3(String s) {
        int left = 0, right = 0, res = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) left = Math.max(left, map.get(ch) + 1);
            map.put(ch, right);
            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }


    /**
     * Sliding window approach with hashMap as extra space, practice for index as values.
     *
     * @time-complexity - O (n)
     * @space-complexity - O (min(k, n)), where k no. of unique characters (max of 26) and n no. of characters.
     */
    public int lengthOfLongestSubstring4(String s) {
        int l = 0, r = 0, maxLength = Integer.MIN_VALUE, n = s.length();
        Map<Character, Integer> charMap = new HashMap<>();

        while (r < n) {
            char ch = s.charAt(r);
            if (charMap.containsKey(ch))
                l = Math.max(l, charMap.get(ch) + 1);

            maxLength = Math.max(r - l + 1, maxLength);
            charMap.put(ch, r);
            r++;
        }

        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }


}
