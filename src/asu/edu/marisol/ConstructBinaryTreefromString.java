package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ConstructBinaryTreefromString {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Recursive building approach.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (n).
     */
    public TreeNode str2tree(String s) {
        this.stringIdx = 0;
        this.s = s;
        return dfsBuildTree();
    }

    private int stringIdx;
    private String s;

    private TreeNode dfsBuildTree() {
        if (stringIdx >= s.length()) return null;
        int intVal = parseInteger();

        TreeNode node = new TreeNode(intVal);

        // first open bracket if present.
        if (stringIdx < s.length() && s.charAt(stringIdx) == '(') {
            stringIdx++;
            node.left = dfsBuildTree();
        }

        // second open bracket if present, note that the stringIdx would have moved in the recursion call before
        if (stringIdx < s.length() && s.charAt(stringIdx) == '(') {
            stringIdx++;
            node.right = dfsBuildTree();
        }

        // skip closing bracket
        if (stringIdx < s.length() && s.charAt(stringIdx) == ')') stringIdx++;

        return node;
    }

    private int parseInteger() {
        boolean isNegative = false;
        if (s.charAt(stringIdx) == '-') {
            isNegative = true;
            stringIdx++;
        }

        int num = 0;
        while (stringIdx < s.length() && Character.isDigit(s.charAt(stringIdx))) num = num * 10 + s.charAt(stringIdx++) - '0';

        return isNegative ? -num : num;
    }

}
