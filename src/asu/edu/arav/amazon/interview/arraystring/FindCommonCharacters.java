package asu.edu.arav.amazon.interview.arraystring;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/find-common-characters/
 */
public class FindCommonCharacters {
    public List<String> commonChars(String[] A) {

        int[] charCountsCommonGlobal = new int[26];
        Arrays.fill(charCountsCommonGlobal, Integer.MAX_VALUE);
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < A.length; i++) {
            int[] charCounts = new int[26];
            for (char c : A[i].toCharArray()) {
                charCounts[c - 'a']++;
            }
            for (int j = 0; j < charCounts.length; j++) {
                charCountsCommonGlobal[j] = Math.min(charCounts[j], charCountsCommonGlobal[j]);
            }
        }
        for(int i = 0; i < charCountsCommonGlobal.length; i++){
            for(int j = 0; j < charCountsCommonGlobal[i]; j++){
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }
}
