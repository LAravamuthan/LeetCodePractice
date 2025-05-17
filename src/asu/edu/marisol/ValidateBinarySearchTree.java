package asu.edu.marisol;

import apple.laf.JRSUIUtils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

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

    /**
     * DFS approach, using prev element to check the validity, slightly different than traditional approach.
     *
     * @time-complexity - O (N), number of nodes in the tree.
     * @space-complexity - O (N) - height of the tree.
     */
    public boolean isValidBST4(TreeNode root) {
        return inOrder4(root);
    }

    private Integer prev;
    private boolean inOrder4(TreeNode node) {
        if (node == null) return true;
        if (!inOrder4(node.left)) return false;
        if (prev != null && prev >= node.val) return false;
        prev = node.val;
        return inOrder4(node.right);
    }


    /**
     * Iterative approach with previous element.
     *
     * @time-complexity - O (N), number of nodes in the tree.
     * @space-complexity - O (N) - height of the tree.
     */
    public boolean isValidBST5(TreeNode root) {

        Integer prev = null;
        Stack<TreeNode> st = new Stack<>();

        while (!st.isEmpty() || root != null) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if (prev != null && prev >= root.val) return false;
            prev = root.val;
            root = root.right;
        }
        return true;
    }

    /**
     * Recursive limits approach.
     * Practice.
     *
     * @time-complexity - O (N), number of nodes in the tree.
     * @space-complexity - O (N) - height of the tree.
     */
    public boolean isValidBST6(TreeNode root) {
        return dfsCheck(root, null, null);
    }

    private boolean dfsCheck(TreeNode node, Integer low, Integer high) {
        if (node == null) return true;
        if ((low != null && node.val <= low) || (high != null && node.val >= high)) return false;

        return dfsCheck(node.left, low, node.val) && dfsCheck(node.right, node.val, high);
    }


    /**
     * Iterative limits approach.
     * Practice.
     *
     * @time-complexity - O (N), number of nodes in the tree.
     * @space-complexity - O (N) - height of the tree.
     */
    public boolean isValidBST7(TreeNode root) {
        if (root == null) return true;

        this.st = new Stack<>();
        this.lows = new Stack<>();
        this.highs = new Stack<>();

        updateStacks(root, null,null);

        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            Integer low = lows.pop();
            Integer high = highs.pop();

            if ((low != null && node.val <= low) || (high != null && node.val >= high)) return false;
            if (node.left != null) updateStacks(node.left, low, node.val);
            if (node.right != null) updateStacks(node.right, node.val, high);
        }

        return true;
    }

    private void updateStacks(TreeNode node, Integer low, Integer high) {
        st.push(node);
        lows.push(low);
        highs.push(high);
    }

    private Stack<TreeNode> st;
    private Stack<Integer> lows;
    private Stack<Integer> highs;


    /**
     * DFS approach, using prev element to check the validity, slightly different than traditional approach.
     * Practice.
     *
     * @time-complexity - O (N), number of nodes in the tree.
     * @space-complexity - O (N) - height of the tree.
     */
    public boolean isValidBST8(TreeNode root) {
        return inOrderCheck(root);
    }

    private boolean inOrderCheck(TreeNode node) {
        if (node == null) return true;
        if (!inOrderCheck(node.left)) return false;
        if (prev != null || node.val <= prev) return false;
        prev = node.val;
        return inOrderCheck(node.right);
    }


}
