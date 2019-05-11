package asu.edu.Arav.ImpG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ReverseVowels {
    public static boolean isVowel(Character ch) {
        if (ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O'
                || ch == 'u' || ch == 'U') {
            return true;
        }
        return false;
    }

    public static String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        List<Character> vowels = new ArrayList<Character>();
        List<Integer> positions = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                vowels.add(s.charAt(i));
                positions.add(i);
            }
        }
        Collections.reverse(positions);
        for (int i = 0; i < vowels.size(); i++) {
            sb.setCharAt(positions.get(i), vowels.get(i));
        }
        return sb.toString();
    }


    public static String reverseVowels1(String s) {
        StringBuilder sb = new StringBuilder(s);
        List<Integer> positions = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                positions.add(i);
            }
        }
        for (int i = 0; i < positions.size() / 2; i++) {
            sb.setCharAt(positions.get(i), s.charAt(positions.get(positions.size() - 1 - i)));
            sb.setCharAt(positions.get(positions.size() - 1 - i), s.charAt(positions.get(i)));
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(reverseVowels1("Hello"));
    }
}
