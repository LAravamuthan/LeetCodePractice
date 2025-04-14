package asu.edu.marisol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class GenerateParentheses {

    /**
     * Backtracking solution,
     *
     * @time-complexity - O (2^2n).
     * @space-complexity - O (n)
     */
    public List<String> generateParenthesis(int n) {
        this.ans = new ArrayList<>();
        this.n = n;
        generateParenthesis(new StringBuilder(), 0, 0);
        return ans;
    }

    private List<String> ans;
    private int n;

    private void generateParenthesis(StringBuilder sb, int leftCount, int rightCount) {
        if (sb.length() == 2 * n) {
            ans.add(sb.toString());
            return;
        }

        if (leftCount < n) {
            sb.append("(");
            generateParenthesis(sb, leftCount + 1, rightCount);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (leftCount > rightCount) {
            sb.append(")");
            generateParenthesis(sb, leftCount + 1, rightCount);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    /**
     * Divide and conquer method.
     *
     * @time-complexity - O (2^2n).
     * @space-complexity - O (n)
     */
    public List<String> generateParenthesis2(int n) {
        if (n == 0) return Arrays.asList("");
        List<String> ans = new ArrayList<>();

        for (int leftCount = 0; leftCount < n; leftCount++) {
            for (String leftPrefix : generateParenthesis2(leftCount))
                for(String rightPrefix: generateParenthesis2(n - 1 - leftCount))
                    ans.add("(" + leftPrefix + ")" + rightPrefix);
        }

        return ans;
    }

}
