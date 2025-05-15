package asu.edu.marisol;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class RecoveraTreeFromPreorderTraversal {


    /**
     * DFS approach, has its own problems lets fix them as we see.
     *
     * @time-complexity - O (N) - nodes in input string.
     * @space-complexity - O (N) - if its a long chain of skewed tree.
     */
    public TreeNode recoverFromPreorder(String traversal) {
        if (traversal == null || traversal.length() == 0) return null;
        this.idx = 0;
        this.traversal = traversal;

        return dfsBuildTree(0);
    }

    private int idx;
    private String traversal;

    private TreeNode dfsBuildTree(int pDash) {
        if (idx >= traversal.length()) return null;

        int nodeVal = 0;
        while (idx < traversal.length() && Character.isDigit(traversal.charAt(idx)))
            nodeVal = nodeVal * 10 + traversal.charAt(idx++) - '0';

        TreeNode node = new TreeNode(nodeVal);

        int leftDash = 0;
        while (idx < traversal.length() && traversal.charAt(idx) == '-') {
            leftDash++;
            idx++;
        }

        if (leftDash == pDash + 1)
            node.left = dfsBuildTree(leftDash);
        else
            idx -= leftDash;

        int rightDash = 0;
        while (idx < traversal.length() && traversal.charAt(idx) == '-') {
            rightDash++;
            idx++;
        }

        if (rightDash == pDash + 1)
            node.right = dfsBuildTree(rightDash);
        else
            idx -= rightDash;

        return node;
    }


    /**
     * DFS approach, fixed minor fixes.
     *
     * @time-complexity - O (N) - nodes in input string.
     * @space-complexity - O (N) - if its a long chain of skewed tree.
     */
    public TreeNode recoverFromPreorder2(String traversal) {
        if (traversal == null || traversal.length() == 0) return null;
        this.idx = 0;
        this.chars = traversal.toCharArray();

        return dfsOptimized(0);
    }

    private char[] chars;

    private TreeNode dfsOptimized(int expectedDepth) {
        int currId = idx;
        int dashCount = 0;

        while (idx < chars.length && chars[idx] == '-') {
            dashCount++;
            idx++;
        }

        if (dashCount != expectedDepth) {
            idx = currId;
            return null;
        }

        int nodeVal = 0;

        while (idx < chars.length && Character.isDigit(chars[idx])) {
            nodeVal = nodeVal * 10 + chars[idx++] - '0';
        }

        TreeNode node = new TreeNode(nodeVal);
        node.left = dfsOptimized(expectedDepth + 1);
        node.right = dfsOptimized(expectedDepth + 1);

        return node;
    }


    /**
     * BFS approach, this one would be using arrays for buffer and stitching things together and level traversal.
     *
     * @time-complexity - O (N) - nodes in input string.
     * @space-complexity - O (N) - if its a long chain of skewed tree.
     */
    public TreeNode recoverFromPreorder3(String traversal) {
        int index = 0;
        char[] chars = traversal.toCharArray();

        // stores the last Node in each level
        List<TreeNode> levels = new ArrayList<>();

        while (index < chars.length) {
            int depth = 0;
            while (index < chars.length && chars[index] == '-') {
                depth++;
                index++;
            }

            int nodeVal = 0;
            while (index < chars.length && Character.isDigit(chars[index]))
                nodeVal = nodeVal * 10 + chars[index++] - '0';

            TreeNode node = new TreeNode(nodeVal);

            if (levels.size() > depth)
                levels.set(depth, node);
            else
                levels.add(node);

            // for depth == 0, need not be taken care of given it is root, only one node possible.
            if (depth > 0) {
                TreeNode parent = levels.get(depth - 1);
                if (parent.left == null)
                    parent.left = node;
                else
                    parent.right = node;
            }
        }
        return levels.get(0);
    }


    /**
     * BFS approach, this one would be using stack for buffer and stitching things together and level traversal.
     *
     * @time-complexity - O (N) - nodes in input string.
     * @space-complexity - O (N) - if its a long chain of skewed tree.
     */
    public TreeNode recoverFromPreorder4(String traversal) {
        int index = 0;
        char[] chars = traversal.toCharArray();
        Stack<TreeNode> st = new Stack<>();

        while (index < chars.length) {
            int depth = 0;
            while (index < chars.length && chars[index] == '-') {
                depth++;
                index++;
            }

            int nodeVal = 0;
            while (index < chars.length && Character.isDigit(chars[index]))
                nodeVal = nodeVal * 10 + chars[index++] - '0';

            TreeNode node = new TreeNode(nodeVal);

            while (st.size() > depth) st.pop();

            if (!st.isEmpty()){
                if (st.peek().left == null)
                    st.peek().left = node;
                else
                    st.peek().right = node;
            }

            st.push(node);
        }

        while (st.size() > 1) st.pop();
        return st.pop();
    }


}
