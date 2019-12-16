package asu.edu.arav.amazon.interview.arraystring;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {

    public int reverse(int x) {
        boolean isNegative = x < 0 ? true : false;
        StringBuilder sb = new StringBuilder(new Integer(Math.abs(x)).toString());
        sb.reverse();
        if(isNegative){
            sb.insert(0, "-");
        }
        int ans = 0;
        try {
            ans = Integer.parseInt(sb.toString());
        }catch (Exception ex){

        }
        return ans;
    }

}
