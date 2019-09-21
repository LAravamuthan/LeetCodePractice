package asu.edu.arav.amazon.interview.online;

import asu.edu.aravl.utility.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class IsAnotherTreeSubTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }

        if (isEqual(s, t)) {
            return true;
        }

        return isEqual(s.left, t) || isEqual(s.right, t);
    }

    public boolean isEqual(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return isEqual(a.left, b.left) && isEqual(a.right, b.right);
    }
}
