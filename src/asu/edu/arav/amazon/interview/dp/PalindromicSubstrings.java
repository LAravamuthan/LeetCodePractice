package asu.edu.arav.amazon.interview.dp;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/palindromic-substrings/
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        boolean[][] isPalindromic = new boolean[s.length()][s.length()];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            isPalindromic[i][i] = true;
        }
        res = s.length();
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j + i < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j + i)) {
                    if (i == 1) {
                        isPalindromic[j][j + i] = true;
                    } else {
                        isPalindromic[j][j + i] = isPalindromic[j + 1][j + i - 1];
                    }
                }
                res += isPalindromic[j][j + i] ? 1 : 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PalindromicSubstrings pss = new PalindromicSubstrings();
        pss.countSubstrings("aawdasa");
    }
}
