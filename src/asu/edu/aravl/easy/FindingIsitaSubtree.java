package asu.edu.aravl.easy;

import asu.edu.aravl.utility.TreeNode;

public class FindingIsitaSubtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        boolean leftTreePossible = false;
        boolean rightTreePossible = false;
        if (isEqualTrees(s, t)) {
            return true;
        }
        leftTreePossible = isSubtree(s.left, t);
        if (leftTreePossible) {
            return true;
        }
        rightTreePossible = isSubtree(s.right, t);
        return rightTreePossible;
    }

    public boolean isEqualTrees(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isEqualTrees(s.left, t.left) && isEqualTrees(s.right, t.right);
    }
}
