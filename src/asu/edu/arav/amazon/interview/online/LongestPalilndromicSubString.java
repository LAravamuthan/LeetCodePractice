package asu.edu.arav.amazon.interview.online;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @Link https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalilndromicSubString {
    // This one is by dynamic programming O(n^2) is both space and time
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        //substringFlagWithindexes
        boolean sFWI[][] = new boolean[s.length()][s.length()];
        int[] indexes = new int[2];
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            sFWI[i][i] = true;
            indexes[0] = indexes[1] = i;
        }
        int n = s.length();
        for (int length = 1; length < n; length++) {
            for (int i = 0; i + length < n; i++) {
                boolean isPalindrome = false;
                if (s.charAt(i) == s.charAt(i + length)) {
                    if(length == 1){
                        sFWI[i][i + length] = true;
                    }else{
                        sFWI[i][i + length] = sFWI[i+1][i+length-1];
                    }
                    isPalindrome = sFWI[i][i + length];
                }
                if(isPalindrome){
                    if(max <= length +1){
                        max = length +1;
                        indexes[0] = i;
                        indexes[1] = i + length;
                    }
                }
            }
        }
        return s.substring(indexes[0], indexes[1] + 1);
    }
}
