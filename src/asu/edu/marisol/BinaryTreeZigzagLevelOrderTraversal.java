package asu.edu.marisol;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class BinaryTreeZigzagLevelOrderTraversal {

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
     * DFS, way of getting level wise level order. with int value for which way to traverse.
     *
     * @time-complexity - O(n) - going to each node.
     * @space-complexity - O(h) - height of the tree.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        levelDFS(root, 0);
        return levelElements;
    }

    List<List<Integer>> levelElements = new ArrayList<>();

    public void levelDFS(TreeNode node, int level) {
        if (node == null) return;
        if (level == levelElements.size()) {
            levelElements.add(new ArrayList<>());
        }
        if (level % 2 == 0) {
            levelElements.get(level).add(node.val);
        } else {
            levelElements.get(level).add(0, node.val);
        }
        levelDFS(node.left, level + 1);
        levelDFS(node.right, level + 1);
    }

    /**
     * BFS, way of getting level wise level order, with boolean to traversal direction.
     *
     * @time-complexity - O(n) - going to each node.
     * @space-complexity - O(h) - height of the tree.
     */
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> levelElements = new ArrayList<>();

        if (root == null) return levelElements;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean left = true; // left to start with.

        while (!queue.isEmpty()) {
            List<Integer> elements = new ArrayList<>();
            int curLength = queue.size();
            for (int i = 0; i < curLength; i++) {
                TreeNode node = queue.poll();
                if (left)
                    elements.add(node.val);
                else
                    elements.add(0, node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            levelElements.add(elements);
            left = !left;
        }

        return levelElements;
    }
}
