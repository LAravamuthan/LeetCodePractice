package asu.edu.marisol;


/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class AddBinary {

    /**
     * Normal addition as strings.
     *
     * @time-complexity - O (max(n,m)).
     * @space-complexity - O (max(n,m))
     */
    // TODO: Bit manipulation version of this problem.
    public String addBinary(String a, String b) {
        int n = a.length(), m = b.length();
        if (n < m) return addBinary(b, a);

        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (a.charAt(i) == '1') carry++;
            if(j > -1 && b.charAt(j--) == '1') carry++;
            sb.append(carry % 2);
            carry /= 2;
        }
        if (carry == 1) sb.append('1');
        return sb.reverse().toString();
    }
}
