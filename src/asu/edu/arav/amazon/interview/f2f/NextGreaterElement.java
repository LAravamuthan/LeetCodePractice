package asu.edu.arav.amazon.interview.f2f;

import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class NextGreaterElement {
    public int[][] nextGreaterElement(int[] input) {
        if (input == null || input.length == 0) {
            return null;
        }
        Stack<Integer> unMatchedNumber = new Stack<Integer>();
        unMatchedNumber.add(input[0]);
        int[][] ans = new int[input.length][2];
        int ansCount = 0;
        for (int i = 1; i < input.length; i++) {
            if(input[i] <= unMatchedNumber.peek()){
                unMatchedNumber.add(input[i]);
            }
            else{
                while(!unMatchedNumber.isEmpty() || unMatchedNumber.peek()<input[i]){
                    ans[ansCount][0] = unMatchedNumber.pop();
                    ans[ansCount][1] = input[i];
                    ansCount++;
                }
            }
        }
        while (!unMatchedNumber.isEmpty()){
            ans[ansCount][0] = unMatchedNumber.pop();
            ans[ansCount][1] = -1;
            ansCount++;
        }
        return ans;
    }
}
