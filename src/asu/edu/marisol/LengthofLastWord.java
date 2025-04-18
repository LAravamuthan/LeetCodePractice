package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class LengthofLastWord {

    /**
     * Simple method of finding the last word length.
     *
     * @time-complexity - O (N), number of nodes in the tree.
     * @space-complexity - O (1)
     */
    public int lengthOfLastWord(String s) {

        int i = s.length() - 1;
        int length = 0;

        while (i >= 0 && ' ' == s.charAt(i)) {
            i--;
        }

        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
            length++;
        }

        return length;
    }
}
