package asu.edu.AravL.easy;

import asu.edu.AravL.utility.TreeNode;

public class TreeEquivalence {

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
