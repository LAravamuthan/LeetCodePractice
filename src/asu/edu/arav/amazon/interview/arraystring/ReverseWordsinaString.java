package asu.edu.arav.amazon.interview.arraystring;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class ReverseWordsinaString {

    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        List<String> res =  Arrays.asList(words);
        Collections.reverse(res);
        StringBuilder sb = new StringBuilder();
        sb.append(res.get(0));
        for(int i = 1; i < res.size(); i++){
            sb.append(" ");
            sb.append(res.get(i));
        }
        return sb.toString();
    }

    public static void main(String [] args){
        ReverseWordsinaString rws = new ReverseWordsinaString();
        rws.reverseWords("  hello world!  ");
    }

}
