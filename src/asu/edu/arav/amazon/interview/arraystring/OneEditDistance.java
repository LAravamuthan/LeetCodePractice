package asu.edu.arav.amazon.interview.arraystring;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/one-edit-distance/
 */
public class OneEditDistance {

    /**
     * @algo - String
     * @time-complexity - O(n)
     * @space-complexity - O(n)
     */

    public boolean isOneEditDistance(String s, String t) {
        if (s == null && t == null) return false;
        if (s == null || t == null) return false;
        if (s.length() > t.length()) return isOneEditDistance(t, s);
        if (t.length() - s.length() > 1) return false;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != t.charAt(i)) {
                if(s.length() == t.length()) return s.substring(i+1).equals(t.substring(i+1));
                else return s.substring(i).equals(t.substring(i+1));
            }
        }
        return s.length() + 1 == t.length();
    }

}
