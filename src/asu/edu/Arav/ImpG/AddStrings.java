package asu.edu.Arav.ImpG;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class AddStrings {

    public static String addStrings(String num1, String num2) {
        boolean first = false;
        int len1 = num1.length();
        int len2 = num2.length();

        if (len1 >= len2) {
            first = true;
        }

        char[] char1;
        char[] char2;
        char[] ansDigits = new char[(Math.max(len1, len2)) + 1];
        for (int i = 0; i < ansDigits.length; i++) {
            ansDigits[i] = '0';
        }


        if (first) {
            char1 = num1.toCharArray();
            char2 = num2.toCharArray();
        } else {
            char2 = num1.toCharArray();
            char1 = num2.toCharArray();
        }

        int differenceInLength = char1.length - char2.length;

        boolean isCarry = false;
        for (int i = char1.length - 1; i >= 0; i--) {
            int num1d = 0;
            int num2d = 0;
            num1d = Character.getNumericValue(char1[i]);
            if (i - differenceInLength >= 0) {
                num2d = Character.getNumericValue(char2[i - differenceInLength]);
            }
            int dAns = isCarry ? num1d + num2d + 1 : num1d + num2d;
            if (dAns / 10 > 0) {
                isCarry = true;
            } else {
                isCarry = false;
            }
            dAns = dAns % 10;
            ansDigits[i+1] = Character.forDigit(dAns, 10);
        }
        if(isCarry){
            ansDigits[0] = '1';
        }
        String ans = new String(ansDigits);
        if(!isCarry){
            ans = ans.substring(1);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(addStrings("25695", "234"));
    }


}
