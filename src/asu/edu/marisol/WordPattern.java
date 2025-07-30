package asu.edu.marisol;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class WordPattern {

    /**
     * HashMap approach with 2 hashmaps.
     *
     * @time-complexity - O(n).
     * @space-complexity - O(2n).
     */
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> charString = new HashMap<>();
        Map<String, Character> stringChar = new HashMap<>();

        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        for (int i = 0; i < words.length; i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if (!charString.containsKey(ch)) {
                if (stringChar.containsKey(word)) return false;
                charString.put(ch, word);
                stringChar.put(word, ch);
            } else {
                if(!charString.get(ch).equals(word)) return false;
            }
        }
        return true;
    }

    /**
     * HashMap approach with 1 hashmap. Not a safe optimization, not a fan of this.
     *
     * @time-complexity - O(n).
     * @space-complexity - O(n)
     */
    public boolean wordPattern2(String pattern, String s) {
        Map map = new HashMap<>();
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char ch = pattern.charAt(i);
            if (!map.containsKey(ch)) {
                if (map.containsKey(word)) return false;
                map.put(ch, i);
                map.put(word, i);
            } else {
                if (!map.get(ch).equals( map.get(word))) return false;
            }
        }

        return true;
    }


    /**
     * HashMap approach with 1 hashmap. Not a safe optimization, not a fan of this.
     * But practice away buddy.
     *
     * @time-complexity - O(n).
     * @space-complexity - O(n)
     */
    public boolean wordPattern3(String pattern, String s) {
        Map map = new HashMap<>();
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;

        for (int i = 0; i < words.length; i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if (!map.containsKey(ch)) map.put(ch, i);
            if (!map.containsKey(word)) map.put(word, i);

            if (!map.get(ch).equals(map.get(word))) return false;
        }

        return true;
    }
}
