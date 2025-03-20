package asu.edu.marisol;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class BinaryTreeLevelOrderTraversal {

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
     * DFS, way of getting level wise level order.
     *
     * @time-complexity - O(n) - going to each node.
     * @space-complexity - O(h) - height of the tree.
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrderDFS(root, 0);
        return levelElements;
    }
    List<List<Integer>> levelElements = new ArrayList<>();

    public void levelOrderDFS(TreeNode node, int level) {
        if (node == null) return;
        if (level >= levelElements.size()) {
            levelElements.add(new ArrayList<>());
        }
        levelElements.get(level).add(node.val);
        levelOrderDFS(node.left, level + 1);
        levelOrderDFS(node.right, level + 1);
    }

    /**
     * BFS level order.
     *
     * @time-complexity - O(n) - going to each node.
     * @space-complexity - O(B) - breadth of the tree.
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> levelElements = new ArrayList<>();
        if (root == null) return levelElements;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> elements = new ArrayList<>();
            int cur_level_size = queue.size();
            for (int i = 0; i < cur_level_size; i++) {
                TreeNode node = queue.poll();
                elements.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            levelElements.add(elements);
        }

        return levelElements;
    }
}
