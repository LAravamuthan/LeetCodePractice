package asu.edu.marisol;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ValidateBinarySearchTree {

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
     * DFS approach with ranges.
     *
     * @time-complexity - O (N), number of nodes in the tree.
     * @space-complexity - O (N) - height of the tree.
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer lower, Integer higher) {
        if (node == null) return true;

        if((lower != null && node.val <= lower) || (higher != null && node.val >= higher)) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, higher);

    }


    /**
     * DFS approach with in order Traversal, with preNode to be checked.
     *
     * @time-complexity - O (N), number of nodes in the tree.
     * @space-complexity - O (N) - height of the tree.
     */
    TreeNode prevNode = null;

    public boolean isValidBST2(TreeNode root) {
        return inOrder(root);
    }

    private boolean inOrder(TreeNode node) {
        if (node == null) return true;

        if(!inOrder(node.left)) return false;
        if (prevNode != null && node.val <= prevNode.val) return false;
        prevNode = node;
        return inOrder(node.right);
    }

    public boolean isValidBST3(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Integer prev = null;

        while (!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && root.val <= prev) return false;
            prev = root.val;
            root = root.right;
        }
        return true;
    }

}
