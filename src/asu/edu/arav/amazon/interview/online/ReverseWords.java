package asu.edu.arav.amazon.interview.online;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class ReverseWords {

    static char[] reverseWords(char[] arr) {
        Stack<String> words = new Stack<String>();
        List<Character> r = new ArrayList<Character>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == ' '){
                words.push(new String(r.toArray()));
                r.clear();
            }else{
                r.add(arr[i]);
            }
        }
        if(!r.isEmpty()){
            words.push(String.valueOf(r));
        }
        char[] result = new char[arr.length];
        int nextCharIndex = 0;
        if(!words.isEmpty()){
            char[] temp = words.pop().toCharArray();
            for(int i = 0; i < temp.length; i++){
                result[i] = temp[i];
            }
            nextCharIndex = temp.length;
        }
        while(!words.isEmpty()){
            char [] temp = words.pop().toCharArray();
            result[nextCharIndex++] = ' ';
            for(int i = 0; i < temp.length; i++){
                result[nextCharIndex++] = temp[i];
            }
        }
        return result;
    }

    public static void main(String[] args){
        reverseWords(new char[]{'a', ' ', ' ', ' ', 'b'});
    }
}
