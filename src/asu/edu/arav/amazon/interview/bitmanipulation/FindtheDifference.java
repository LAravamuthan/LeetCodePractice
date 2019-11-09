package asu.edu.arav.amazon.interview.bitmanipulation;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/find-the-difference/
 */
public class FindtheDifference {
    public char findTheDifference(String s, String t) {
        int largerSize = t.length();
        char ans = t.charAt(t.length()-1);
        for(int i =0; i< largerSize - 1; i++){
            ans ^= s.charAt(i);
            ans ^= t.charAt(i);
        }
        return ans;
    }
}
