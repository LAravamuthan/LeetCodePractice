package asu.edu.AravL.easy;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        int[] chCounter = new int[256];
        if (s.length() != t.length())
            return false;
        for (char ch : s.toCharArray()) {
            chCounter[ch]++;
        }
        for (char ch : t.toCharArray()) {
            chCounter[ch]--;
            if (chCounter[ch] < 0) {
                return false;
            }
        }
        return true;
    }
}
