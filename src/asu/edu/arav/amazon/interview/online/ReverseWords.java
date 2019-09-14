package asu.edu.arav.amazon.interview.online;

import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class ReverseWords {

    static char[] reverseWords(char[] arr) {
        Stack<String> words = new Stack<String>();
        int previousWordIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                words.push(new String(arr, previousWordIndex + 1, i - previousWordIndex - 1));
                previousWordIndex = i;
            }
        }
        if (previousWordIndex < arr.length-1) {
            words.push(new String(arr,previousWordIndex+1, arr.length-previousWordIndex-1));
        }
        char[] result = new char[arr.length];
        int nextCharIndex = 0;
        while (!words.isEmpty()) {
            char[] temp = words.pop().toCharArray();
            for (int i = 0; i < temp.length; i++) {
                result[nextCharIndex++] = temp[i];
            }
            if(!words.isEmpty() || temp.length == 0){
                result[nextCharIndex++] = ' ';
            }
        }
        return result;
    }

    public static void main(String[] args) {
        reverseWords(new char[]{' ', ' '});
    }
}
