package asu.edu.aravl.easy;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @Link https://leetcode.com/problems/fibonacci-number/
 */
public class FibonacciSequence {
    public int fib(int N) {
        if(N <= 1){
            return N;
        }
        if(N == 2){
            return 1;
        }
        int current = 0;
        int p1 = 1;
        int p2 = 1;

        for(int i = 3; i <=N; i++){
            current = p1 + p2;
            p1 = p2;
            p2 = current;
        }
        return current;
    }


    public static String stringCount(String s){

        s = s.toLowerCase();

        Map<Character, Integer> t = new TreeMap<>();
        for(char c : s.toCharArray()){
            if(t.containsKey(c)){
                int count = t.get(c);
                t.put(c, ++count);
            }else{
                t.put(c, 1);
            }
        }
        StringBuilder ans = new StringBuilder();
        for(char c : t.keySet()){
            ans.append(c);
            ans.append(t.get(c));
        }
        return ans.toString();
    }
    public static void main(String args[]){
        System.out.println(stringCount("Leetcode"));
    }
}
