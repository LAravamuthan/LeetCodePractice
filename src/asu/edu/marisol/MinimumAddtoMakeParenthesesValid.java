package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MinimumAddtoMakeParenthesesValid {

    /**
     * Normal traversal.
     *
     * @time-complexity - O (N), number of nodes in the tree.
     * @space-complexity - O (1)
     */
    public int minAddToMakeValid(String s) {
        int openBrackets = 0, minRequired = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                openBrackets++;
            } else if (ch == ')') {
                if (openBrackets > 0) {
                    openBrackets--;
                } else {
                    minRequired++;
                }
            }
        }

        return openBrackets + minRequired;
    }

}
