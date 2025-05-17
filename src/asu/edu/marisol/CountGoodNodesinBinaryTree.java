package asu.edu.marisol;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class CountGoodNodesinBinaryTree {

    /**
     * DFS approach first, lets go boys.
     *
     * @time-complexity - O (N).
     * @space-complexity - O (H).
     */
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        return dfsCount(root, null);
    }

    private int dfsCount(TreeNode node, Integer greatest) {
        if (node == null) return 0;
        int count = 0;

        if (greatest == null || node.val >= greatest) {
            count++;
            greatest = node.val;
        }

        count += dfsCount(node.left, greatest);
        count += dfsCount(node.right, greatest);

        return count;
    }

    /**
     * BFS approach first, lets go boys.
     *
     * @time-complexity - O (N).
     * @space-complexity - O (B).
     */
    public int goodNodes2(TreeNode root) {
        if (root == null) return 0;
        int count = 0;
        Queue<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        q.offer(new Pair<>(root, null));

        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> pair = q.poll();
            TreeNode node = pair.getKey();
            Integer greatest = pair.getValue();

            if (greatest == null || node.val >= greatest) {
                count++;
                greatest = node.val;
            }

            if (node.left != null) q.offer(new Pair<>(node.left, greatest));
            if (node.right != null) q.offer(new Pair<>(node.right, greatest));
        }

        return count;
    }
}
