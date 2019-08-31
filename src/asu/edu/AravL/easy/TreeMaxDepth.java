package asu.edu.AravL.easy;

import asu.edu.AravL.utility.TreeNode;

public class TreeMaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftTreeHeight = 0;
        int rightTreeHeight = 0;
        if (root.left != null) {
            leftTreeHeight = maxDepth(root.left);
        }
        if (root.right != null) {
            rightTreeHeight = maxDepth(root.right);
        }
        return 1 + Math.max(leftTreeHeight, rightTreeHeight);
    }
}
