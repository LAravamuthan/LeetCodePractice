package asu.edu.marisol;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class InvertBinaryTree {

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
     * DFS way of inverting.
     *
     * @time-complexity - O(n) - going to each node.
     * @space-complexity - O(h) - height of the tree.
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * BFS way of inverting.
     *
     * @time-complexity - O(n) - going to each node.
     * @space-complexity - O(b) - breadth of the tree.
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if(curr.left != null) queue.add(curr.left);
            if(curr.right != null) queue.add(curr.right);
        }
        return root;
    }

    /**
     * DFS way of inverting Practice
     *
     * @time-complexity - O(n) - going to each node.
     * @space-complexity - O(h) - height of the tree.
     */
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) return null;

        TreeNode leftTree = invertTree3(root.left);
        TreeNode rightTree = invertTree3(root.right);

        root.left = rightTree;
        root.right = leftTree;

        return root;
    }


    /**
     * BFS way of inverting - practice.
     *
     * @time-complexity - O(n) - going to each node.
     * @space-complexity - O(b) - breadth of the tree.
     */
    public TreeNode invertTree4(TreeNode root) {

        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);

        }

        return root;
    }
}
