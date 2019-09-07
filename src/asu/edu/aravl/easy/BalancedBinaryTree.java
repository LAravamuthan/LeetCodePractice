package asu.edu.aravl.easy;

import asu.edu.aravl.utility.TreeNode;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftTreeHeight = 0;
        int rightTreeHeight = 0;
        boolean isLeftTreeFine = true;
        boolean isrightTreeFine = true;

        if (root.left != null) {
            isLeftTreeFine = isBalanced(root.left);

        }
        if(isLeftTreeFine){
            leftTreeHeight = maxDepth(root.left);
        }else{
            return false;
        }
        if (root.right != null) {
            isrightTreeFine = isBalanced(root.right);
        }
        if(isrightTreeFine){
            rightTreeHeight = maxDepth(root.right);
        }else{
            return false;
        }
        return Math.abs(leftTreeHeight - rightTreeHeight) < 2 ? true : false;
    }

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
