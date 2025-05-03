package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class AddStrings {

    /**
     * Normal addition as strings.
     *
     * @time-complexity - O (max(n,m)).
     * @space-complexity - O (max(n,m))
     */
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();

        int n = num1.length() - 1;
        int m = num2.length() - 1;
        int carry = 0;

        while (n >= 0 || m >= 0 || carry > 0) {
            int x = n >= 0 ? num1.charAt(n) - '0' : 0;
            int y = m >= 0 ? num2.charAt(m) - '0' : 0;
            res.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
            n--; m--;
        }

        return res.reverse().toString();
    }
}
