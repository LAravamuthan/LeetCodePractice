package asu.edu.arav.amazon.interview.arraystring;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/add-binary/
 */
public class AddBinary {

    /**
     *
     * @algo - Bit addition
     * @time-complexity - O(max(n,m))
     * @space-complexity - O(max(n,m) + 1)
     */

    public String addBinary(String a, String b) {
        if(a  == null && b == null) return a;
        if(a.isEmpty() && b.isEmpty()) return a;
        if(a == null || a.isEmpty()) return b;
        if(b == null || b.isEmpty()) return a;
        int n = a.length();
        int m = b.length();
        if(n < m) return addBinary(b, a);
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        for(int i = n - 1, j = m-1; i >= 0; i--, j--){
            if(a.charAt(i) == '1') carry++;
            if(j >=0 && b.charAt(j) == '1') carry++;

            if(carry % 2 == 0) ans.append('0');
            else ans.append('1');
            carry /=2;
        }
        if (carry == 1) ans.append('1');
        return ans.reverse().toString();
    }
}
