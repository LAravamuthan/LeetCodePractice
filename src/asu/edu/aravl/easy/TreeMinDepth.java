package asu.edu.aravl.easy;

import asu.edu.aravl.utility.TreeNode;

public class TreeMinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if(root.right == null && root.left == null){
            return 1;
        }
        int leftTreeHeight = Integer.MAX_VALUE;
        int rightTreeHeight = Integer.MAX_VALUE;
        if (root.left != null) {
            leftTreeHeight = minDepth(root.left);
        }
        if (root.right != null) {
            rightTreeHeight = minDepth(root.right);
        }

        return 1 + Math.min(leftTreeHeight, rightTreeHeight);
    }
}
