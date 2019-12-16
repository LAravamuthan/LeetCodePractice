package asu.edu.arav.amazon.interview.leetcode.module.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfaPhone {

    List<String> ans = new ArrayList<String>();
    List<Character>[] keyPad = new List[8];
    String digitsG;

    {
        List<Character> c = new ArrayList<Character>();
        c.add('a');
        c.add('b');
        c.add('c');
        keyPad[0] = c;
        c = new ArrayList<Character>();
        c.add('d');
        c.add('e');
        c.add('f');
        keyPad[1] = c;
        c = new ArrayList<Character>();
        c.add('g');
        c.add('h');
        c.add('i');
        keyPad[2] = c;
        c = new ArrayList<Character>();
        c.add('j');
        c.add('k');
        c.add('l');
        keyPad[3] = c;
        c = new ArrayList<Character>();
        c.add('m');
        c.add('n');
        c.add('o');
        keyPad[4] = c;
        c = new ArrayList<Character>();
        c.add('p');
        c.add('q');
        c.add('r');
        c.add('s');
        keyPad[5] = c;
        c = new ArrayList<Character>();
        c.add('t');
        c.add('u');
        c.add('v');
        keyPad[6] = c;
        c = new ArrayList<Character>();
        c.add('w');
        c.add('x');
        c.add('y');
        c.add('z');
        keyPad[6] = c;
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        digitsG = digits;
        List<Character> chList = keyPad[Character.getNumericValue(digitsG.charAt(0)) - 2];
        for (char ch : chList) {
            StringBuilder sbCh = new StringBuilder();
            sbCh.append(ch);
            dfs(sbCh);
        }
        return ans;
    }

    public void dfs(StringBuilder sb) {
        if (sb.length() == digitsG.length()) {
            ans.add(sb.toString());
            return;
        }
        List<Character> chList = keyPad[Character.getNumericValue(digitsG.charAt(sb.length())) - 2];
        for (char ch : chList) {
            StringBuilder sbCh = new StringBuilder(sb);
            sbCh.append(ch);
            dfs(sbCh);
        }
    }

    public List<String> letterCombinations1(String digits) {
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        digitsG = digits;
        dfs("");
        return ans;
    }


    public void dfs(String permutation) {
        if (permutation.length() == digitsG.length()) {
            ans.add(permutation);
            return;
        }
        List<Character> options = keyPad[digitsG.charAt(permutation.length()) - '0' - 2];
        for (char c : options) {
            dfs(permutation + c);
        }
    }


}
