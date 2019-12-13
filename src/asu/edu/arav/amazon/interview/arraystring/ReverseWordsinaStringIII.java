package asu.edu.arav.amazon.interview.arraystring;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/reverse-words-in-a-string-iii/
 */
public class ReverseWordsinaStringIII {
    public String reverseWords(String s) {
        String[] individualwords = s.split(" ");
        for (int i = 0; i < individualwords.length; i++) {
            individualwords[i] = reverseStr(individualwords[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (String word : individualwords) {
            sb.append(" ");
            sb.append(word);
        }
        return sb.toString().substring(1);
    }


    public String reverseStr(String strIn) {
        char[] ot = strIn.toCharArray();
        for (int i = 0; i < ot.length / 2; i++) {
            char temp = ot[i];
            ot[i] = ot[ot.length - i - 1];
            ot[ot.length - i - 1] = temp;
        }
        return new String(ot);
    }


}
