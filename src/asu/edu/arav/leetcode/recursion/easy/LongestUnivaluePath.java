package asu.edu.arav.leetcode.recursion.easy;

import asu.edu.aravl.utility.TreeNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class LongestUnivaluePath {

    int maxPathLength = 0;

    public int longestUnivaluePath(TreeNode root) {
        maxPathFromThisNode(root);
        return maxPathLength;
    }

    public int maxPathFromThisNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxPathFromThisNode(root.left);
        int right = maxPathFromThisNode(root.right);
        int lpr = 0, rpr = 0;
        if (root.left != null && root.left.val == root.val) {
            lpr = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            rpr = right + 1;
        }
        maxPathLength = Math.max(maxPathLength, lpr + rpr);
        return Math.max(lpr, rpr);
    }
}
