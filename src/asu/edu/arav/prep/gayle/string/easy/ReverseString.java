package asu.edu.arav.prep.gayle.string.easy;

import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class ReverseString {
    public String reverseStringStack(String s) {
        Stack<Character> k = new Stack();
        char[] chars = s.toCharArray();
        char[] chars1 = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            k.push(s.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            chars1[i] = k.pop();
        }
        return new String(chars1);
    }
    public String reverseString(String s) {
        char [] chars = s.toCharArray();
        for(int i = 0; i < chars.length/2; i++){
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        return new String(chars);
    }
}
