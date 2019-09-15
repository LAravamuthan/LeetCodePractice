package asu.edu.arav.amazon.interview.f2f;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class ReverseStringInPairs {

    public static String reverseParentheses(String s) {
        Stack<List<Character>> stk = new Stack<List<Character>>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stk.push(new ArrayList<Character>());
            } else if (s.charAt(i) == ')') {
                List<Character> temp = stk.pop();
                temp = reversedCharacterArray(temp);
                if(stk.size() > 0){
                    List<Character> temp2 = stk.pop();
                    temp2.addAll(temp);
                    stk.push(temp2);
                }else{
                    stk.push(temp);
                }
            } else {
                List<Character> temp = new ArrayList<Character>();
                if(!stk.isEmpty()){
                    temp = stk.pop();
                }
                temp.add(s.charAt(i));
                stk.push(temp);
            }
        }
        List<Character> result = stk.pop();
        char[] resultAns = new char[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultAns[i] = result.get(i);
        }

        return new String(resultAns);
    }

    public static List<Character> reversedCharacterArray(List<Character> s) {
        for (int i = 0; i < s.size() / 2; i++) {
            Character temp = s.get(i);
            s.set(i, s.get(s.size() - 1 - i));
            s.set(s.size() - 1 - i, temp);
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }
}
