package asu.edu.marisol;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class GoatLatin {

    /**
     * Goat Latin conversion straight forward.
     *
     * @time-complexity - O (n^2).
     * @space-complexity - O (n^2)
     */
    public String toGoatLatin(String sentence) {
        StringBuilder sb = new StringBuilder();
        String suf = "";
        String ma = "ma";

        for (String word : sentence.split(" ")) {
            suf += 'a';
            if (!vowels.contains(word.charAt(0))) word = word.substring(1) + word.charAt(0);
            sb.append(word).append(ma).append(suf).append(' ');
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static Set<Character> vowels =
            new HashSet<Character>() {
                {
                    add('a');
                    add('e');
                    add('i');
                    add('o');
                    add('u');
                    add('A');
                    add('E');
                    add('I');
                    add('O');
                    add('U');
                }
            };
}
