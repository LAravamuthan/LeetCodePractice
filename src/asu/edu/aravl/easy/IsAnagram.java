package asu.edu.aravl.easy;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class IsAnagram {
    // for an characters
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

    public boolean isAnagram1(String s, String t) {

        int[] chCounter = new int[26];
        if (s.length() != t.length())
            return false;
        for (char ch : s.toCharArray()) {
            chCounter[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            chCounter[ch - 'a']--;
            if (chCounter[ch] < 0) {
                return false;
            }
        }
        return true;
    }


}
