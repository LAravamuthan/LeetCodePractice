package asu.edu.marisol;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class RansomNote {

    /**
     * Approach with HashMap.
     *
     * @time-complexity - O (m) - magazine size
     * @space-complexity - O (1) - given only 26 characters
     */
    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        Map<Character, Integer> magazineCharFre = new HashMap<>();

        for (char ch : magazine.toCharArray()) {
            magazineCharFre.put(ch, magazineCharFre.getOrDefault(ch, 0) + 1);
        }

        for (char ch : ransomNote.toCharArray()) {
            if (magazineCharFre.containsKey(ch) && magazineCharFre.get(ch) > 0) {
                magazineCharFre.put(ch, magazineCharFre.get(ch) - 1);
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * Approach with int array.
     *
     * @time-complexity - O (m) - magazine size
     * @space-complexity - O (1) - given only 26 characters
     */
    public boolean canConstruct2(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) return false;
        int [] charCount = new int[26];

        for (char ch : magazine.toCharArray()) charCount[ch - 'a']++;

        for (char ch : ransomNote.toCharArray()) {
            if (charCount[ch - 'a'] == 0) return false;
            charCount[ch - 'a']--;
        }

        return true;
    }
}
