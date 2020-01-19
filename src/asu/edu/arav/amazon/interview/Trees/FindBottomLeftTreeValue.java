package asu.edu.arav.amazon.interview.Trees;

import asu.edu.aravl.utility.TreeNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/find-bottom-left-tree-value/
 */
public class FindBottomLeftTreeValue {

    /**
     * @algo - Dfs
     * @time-complexity - O(n)
     * @space-complexity - O(lgn) - stack recursion or O(1)
     */

    public int maxDepth = -1;
    public int bottomLeft = -1;


    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return bottomLeft;
    }

    public void dfs(TreeNode node, int depth) {
        if (depth > maxDepth) {
            maxDepth = depth;
            bottomLeft = node.val;
        }

        if (node.left != null) {
            dfs(node.left, depth + 1);
        }

        if (node.right != null) {
            dfs(node.right, depth + 1);
        }

    }
}
