package asu.edu.arav.amazon.interview.leetcode.module.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParenthesis {

    List<String> ans = new ArrayList<>();
    int n = -1;

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return ans;
        }
        this.n = n;
        dfs(new char[n * 2], 0, 0, 0);
        return ans;
    }

    public void dfs(char[] s, int curPos, int forwardBrackerts, int backwordBrackets) {
        if (curPos == n * 2) {
            ans.add(new String(s));
            return;
        }
        if (forwardBrackerts > backwordBrackets) {
            s[curPos] = ')';
            dfs(s, curPos + 1, forwardBrackerts, backwordBrackets + 1);
        }
        if (forwardBrackerts < this.n) {
            s[curPos] = '(';
            dfs(s, curPos + 1, forwardBrackerts + 1, backwordBrackets);
        }
    }
    public static void main(String[] args){
        GenerateParenthesis gp = new GenerateParenthesis();
        gp.generateParenthesis(3);
    }
}
