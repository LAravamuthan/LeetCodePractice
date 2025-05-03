package asu.edu.marisol;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class CheckCompletenessofaBinaryTree {

    public class TreeNode {
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
     * DFS approach mostly.
     *
     * @time-complexity - O(N).
     * @space-complexity - O(N).
     */
    public boolean isCompleteTree(TreeNode root) {
        return dfs(root, 0, countNodes(root));
    }

    private int countNodes(TreeNode node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    private boolean dfs(TreeNode node, int index, int n) {
        if (node == null) return true;
        if (index >= n) return false;
        return dfs(node.left, 2 * index + 1, n) && dfs(node.right, 2 * index + 2, n);
    }


    /**
     * BFS approach mostly.
     *
     * @time-complexity - O(N).
     * @space-complexity - O(N).
     */
    public boolean isCompleteTree2(TreeNode root) {

        boolean nullSeen = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                nullSeen = true;
            } else {
                if (nullSeen) return false;

                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return true;
    }

}
