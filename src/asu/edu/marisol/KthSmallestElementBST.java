package asu.edu.marisol;

import java.util.LinkedList;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class KthSmallestElementBST {

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
     * DFS inorder traversal, iterative model.
     *
     * @time-complexity - O (N), number of nodes in the tree.
     * @space-complexity - O (1)
     */
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }
        return -1;
    }
}
