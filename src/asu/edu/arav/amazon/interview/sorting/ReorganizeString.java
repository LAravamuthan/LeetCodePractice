package asu.edu.arav.amazon.interview.sorting;

import java.util.Arrays;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/reorganize-string/
 */
public class ReorganizeString {

    public String reorganizeString(String S) {

        int[] charCount = new int[26];
        for (char ch : S.toCharArray()) {
            charCount[ch - 'a'] += 100;
        }

        for (int i = 0; i < charCount.length; i++) {
            charCount[i] += i;
        }
        Arrays.sort(charCount);

        int t = 1;
        int length = S.length();
        char[] ans = new char[length];
        for (int code : charCount) {
            int countOfChar = code / 100;
            char ch = (char) ('a' + (code % 100));
            if (countOfChar > (length + 1) / 2) {
                return "";
            }
            for (int i = 0; i < countOfChar; i++, t += 2) {
                if (t >= length) {
                    t = 0;
                }
                ans[t] = ch;
            }
        }
        return String.valueOf(ans);
    }
}
