package asu.edu.aravl.easy;

import asu.edu.aravl.utility.TreeNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class IsSymmetricBinaryTree {
    public boolean isSymmetric(TreeNode root) {
        return isTreeMirror(root, root);
    }

    public boolean isTreeMirror(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isTreeMirror(s.left, t.right) && isTreeMirror(s.right, t.left);
    }
}
