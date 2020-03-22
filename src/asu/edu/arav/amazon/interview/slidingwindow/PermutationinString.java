package asu.edu.arav.amazon.interview.slidingwindow;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/permutation-in-string/
 */
public class PermutationinString {

    /**
     *
     * @algo - HashMaps
     * @time-complexity - O(n + m)
     * @space-complexity - O(n + m)
     */
    public boolean checkInclusion1(String s1, String s2) {
        if(s1 == null || s1.isEmpty()) return true;
        if(s2 == null || s2.isEmpty() || s2.length() < s1.length()) return false;
        char [] s1Count = new char[26];
        char [] s2Count = new char[26];

        for(int i = 0; i < s1.length(); i++){
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int countMatch = 0;
        for(int i =0; i < s1Count.length; i++){
            if(s1Count[i] == s2Count[i]) countMatch++;
        }
        int offset = s1.length();
        for(int i = 0; i < s2.length() - s1.length(); i++){
            if(countMatch == 26) return true;

            int l = s2.charAt(i) - 'a';
            int r = s2.charAt(i + offset)   - 'a';

            s2Count[r]++;
            if(s2Count[r] == s1Count[r]) countMatch++;
            if(s2Count[r] == s1Count[r] + 1) countMatch--;

            s1Count[l]--;
            if(s2Count[l] == s1Count[l]) countMatch++;
            if(s2Count[l] == s1Count[r] - 1) countMatch--;
        }
        return false;
    }


    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s1.isEmpty()) return true;
        if(s2 == null || s2.isEmpty() || s2.length() < s1.length()) return false;

        char [] s1Count = new char[26];
        char [] s2Count = new char[26];

        int uniqueCharacters = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1Count[s1.charAt(i) - 'a'] == 0) uniqueCharacters++;
            s1Count[s1.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s2.length(); i++){
            s2Count[s2.charAt(i) - 'a']++;
            if(s2Count[s2.charAt(i) - 'a'] == s1Count[s1.charAt(i) - 'a']) uniqueCharacters--;
            if(uniqueCharacters == 0) return true;
        }

        return false;
    }
}
