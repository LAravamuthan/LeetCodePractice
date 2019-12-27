package asu.edu.arav.amazon.interview.arraystring;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/backspace-string-compare/
 */
public class BackspaceStringCompare {
    //  T - O(M + N) S - O(M + N)
    public boolean backspaceCompare(String S, String T) {
        List<Character> sChars = new ArrayList<Character>();
        List<Character> tChars = new ArrayList<Character>();
        for (char c : S.toCharArray()) {
            if (c == '#' && sChars.size() > 0) {
                sChars.remove(sChars.size() - 1);
            } else if (c != '#') {
                sChars.add(c);
            } else {
                continue;
            }
        }

        for (char c : T.toCharArray()) {
            if (c == '#' && tChars.size() > 0) {
                tChars.remove(tChars.size() - 1);
                continue;
            } else if (c != '#') {
                tChars.add(c);
            } else {
                continue;
            }
        }


        char[] sCha = new char[sChars.size()];
        for (int i = 0; i < sCha.length; i++) {
            sCha[i] = sChars.get(i);
        }
        char[] tCha = new char[tChars.size()];
        for (int i = 0; i < tCha.length; i++) {
            tCha[i] = tChars.get(i);
        }
        return new String(sCha).equals(new String(tCha));
    }

    // Lets try the two pointer approach for this question
    // T - O(N + M),  S - O(1)
    public boolean backspaceCompare2(String S, String T) {

        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;
        while (i >= 0 || j >= 0) { // even if the one is empty dont it will taken care after this

            while (i >= 0) { // process all the skipped Characters
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else break; // the moment we find a character not to be skipped we break;
            }

            while (j >= 0) { // process all the skipped Characters
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else break; // the moment we find a character not to be skipped we break;
            }
            if (j >= 0 && i >= 0 && S.charAt(i) != T.charAt(j)) {
                return false;
            }
            if ((i >= 0) != (j >= 0)) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }


    public static void main(String[] args) {
        BackspaceStringCompare bsc = new BackspaceStringCompare();
        bsc.backspaceCompare2("y#fo##f", "y#f#o##f");
    }
}
