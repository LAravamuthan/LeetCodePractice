package asu.edu.marisol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class LetterCombinationsofaPhoneNumber {

    /**
     * Try a combination lets, see what happens.
     *
     * @time-complexity - O (4^N).
     * @space-complexity - O (N).
     */
    public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) return ansList;
        phoneDigits = digits;
        char [] chars = new char[] {'a', 'b', 'c'};
        digitCharMap.put('2', chars);
        chars = new char[] {'d', 'e', 'f'};
        digitCharMap.put('3', chars);
        chars = new char[] {'g', 'h', 'i'};
        digitCharMap.put('4', chars);
        chars = new char[] {'j', 'k', 'l'};
        digitCharMap.put('5', chars);
        chars = new char[] {'m', 'n', 'o'};
        digitCharMap.put('6', chars);
        chars = new char[] {'p', 'q', 'r', 's'};
        digitCharMap.put('7', chars);
        chars = new char[] {'t', 'u', 'v'};
        digitCharMap.put('8', chars);
        chars = new char[] {'w', 'x', 'y', 'z'};
        digitCharMap.put('9', chars);
        letterCombinations(0, new StringBuilder());
        return ansList;
    }
    List<String> ansList = new ArrayList<>();
    String phoneDigits;
    Map<Character, char[]> digitCharMap = new HashMap<>();

    private void letterCombinations(int index, StringBuilder curAns) {
        if (curAns.length() == phoneDigits.length()) {
            ansList.add(curAns.toString());
            return;
        }

        for (char ch : digitCharMap.get(phoneDigits.charAt(index))) {
            curAns.append(ch);
            letterCombinations(index + 1, curAns);
            curAns.deleteCharAt(curAns.length() - 1);
        }
    }

}
