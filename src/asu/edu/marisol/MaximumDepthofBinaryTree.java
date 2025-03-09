package asu.edu.marisol;

import java.util.LinkedList;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MaximumDepthofBinaryTree {

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
     * Trying depth first search
     *
     * @time-complexity - O (n), n-> no. of nodes in the Tree.
     * @space-complexity - O (h) - height of the tree.
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }


    /**
     * Trying depth first search, iterative method
     *
     * @time-complexity - O (n), n-> no. of nodes in the Tree.
     * @space-complexity - O (h) - height of the tree.
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> treeStack = new LinkedList<>();
        LinkedList<Integer> depths = new LinkedList<>();
        treeStack.add(root);
        depths.add(1);

        int depth = 0, curr_dep = 0;
        while (!treeStack.isEmpty()) {
            root = treeStack.pollLast();
            curr_dep = depths.pollLast();
            if (root != null) {
                depth = Math.max(depth, curr_dep);
                treeStack.add(root.left);
                treeStack.add(root.right);
                depths.add(curr_dep + 1);
                depths.add(curr_dep + 1);
            }
        }

        return depth;
    }
}
