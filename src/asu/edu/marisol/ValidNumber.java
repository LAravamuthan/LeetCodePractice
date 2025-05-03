package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ValidNumber {

    /**
     * Simulating the rules.
     *
     * @time-complexity - O (N).
     * @space-complexity - O (1).
     */
    public boolean isNumber(String s) {
        boolean digitsSeen = false;
        boolean dotSeen = false;
        boolean exponentSeen = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                digitsSeen = true;
            } else if (ch == '+' || ch == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
            } else if (ch == 'e' || ch == 'E') {
                if (exponentSeen || !digitsSeen) return false;
                exponentSeen = true;
                digitsSeen = false;
            } else if (ch == '.') {
                if (exponentSeen || dotSeen) return false;
                dotSeen = true;
            } else {
                return false;
            }

        }

        return digitsSeen;
    }
}
