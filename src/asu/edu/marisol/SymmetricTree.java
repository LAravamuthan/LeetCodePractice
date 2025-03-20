package asu.edu.marisol;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class SymmetricTree {

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
     * DFS, way for checking Symmetry.
     *
     * @time-complexity - O(n) - going to each node.
     * @space-complexity - O(h) - height of the tree.
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return p.val == q.val && isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }


    /**
     * BFS, way for checking Symmetry noice it is.
     *
     * @time-complexity - O(n) - going to each node.
     * @space-complexity - O(b) - breadth of the tree.
     */
    public boolean isSymmetric2(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null) return false;
            if (node1.val != node2.val) return false;
            queue.add(node1.left); queue.add(node2.right);
            queue.add(node1.right); queue.add(node2.left);
        }
        return true;
    }
}
