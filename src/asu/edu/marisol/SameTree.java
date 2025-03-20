package asu.edu.marisol;

import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class SameTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * DFS, way for checking similarity.
     *
     * @time-complexity - O(n) - going to each node.
     * @space-complexity - O(h) - height of the tree.
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * DFS but iterative way.
     *
     * @time-complexity - O(n) - going to each node.
     * @space-complexity - O(h) - height of the tree.
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (!check(p, q)) return false;
        Stack<TreeNode> stP = new Stack<>();
        Stack<TreeNode> stQ = new Stack<>();
        stP.push(p);stQ.push(q);

        while (!stP.isEmpty()) {
            p = stP.pop();
            q = stQ.pop();
            if (!check(p, q)) return false;
            if (p != null) {
                stP.push(p.left);stQ.push(q.left);
                stP.push(p.right);stQ.push(q.right);
            }
        }
        return true;
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val;
    }
}
