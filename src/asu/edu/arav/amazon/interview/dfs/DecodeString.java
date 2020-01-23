package asu.edu.arav.amazon.interview.dfs;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/decode-string/
 */
public class DecodeString {

    /**
     * @algo - Depth First Search
     * @time-complexity - O(n)
     * @space-complexity - O(n)
     */


    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
                String[] dfsResult = dfsProcess(i, s);
                ans.append(dfsResult[0]);
                i = Integer.parseInt(dfsResult[1]);
            } else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    public String[] dfsProcess(int idx, String s) {
        StringBuilder baseString = new StringBuilder();
        StringBuilder repetionCount = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        int count = 0;
        int lastIndex = 0;
        boolean isForwardFound = false;
        for (int i = idx; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                count = Integer.parseInt(repetionCount.toString());
                isForwardFound = true;
            } else if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
                if (isForwardFound) {
                    String[] dfsResult = dfsProcess(i, s);
                    baseString.append(dfsResult[0]);
                    i = Integer.parseInt(dfsResult[1]);
                } else {
                    repetionCount.append(s.charAt(i));
                }
            } else if (s.charAt(i) == ']') {
                lastIndex = i;
                break;
            } else {
                baseString.append(s.charAt(i));
            }
        }
        for (int i = 0; i < count; i++) {
            ans.append(baseString);
        }
        return new String[]{ans.toString(), String.valueOf(lastIndex)};
    }

    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        ds.decodeString("3[a]2[bc]");
    }
}
