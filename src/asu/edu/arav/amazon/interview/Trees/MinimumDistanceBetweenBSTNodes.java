package asu.edu.arav.amazon.interview.Trees;

import asu.edu.aravl.utility.TreeNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 */


public class MinimumDistanceBetweenBSTNodes {


    int minDiff = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return minDiff;
    }

    /**
     * @algo - dfs Tree
     * @time-complexity - O(n)
     * @space-complexity - O(log n)
     */

    public int[] dfs(TreeNode node) {
        int[] l = null;
        int[] r = null;
        if (node.left != null)
            l = dfs(node.left);
        if (node.right != null)
            r = dfs(node.right);
        int min = l == null ? node.val : l[0];
        int max = r == null ? node.val : r[1];
        int leftMinDist = l == null ? Integer.MAX_VALUE : node.val - l[1];
        int rightMinDist = r == null ? Integer.MAX_VALUE : r[0] - node.val;
        minDiff = Math.min(minDiff, Math.min(leftMinDist, rightMinDist));
        return new int[]{min, max};
    }

    /**
     * @algo - dfs Tree - easier one
     * @time-complexity - O(n)
     * @space-complexity - O(log n)
     */
    int ans = Integer.MAX_VALUE;
    TreeNode prev = null;

    public int minDiffInBST1(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return ans;
    }

    public void helper(TreeNode node) {
        if (node.left != null) helper(node.left);
        if (prev != null) {
            ans = Math.min(ans, node.val - prev.val);
        }
        prev = node;
        if (node.right != null) helper(node.right);
    }

}
