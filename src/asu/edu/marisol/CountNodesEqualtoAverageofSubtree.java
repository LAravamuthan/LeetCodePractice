package asu.edu.marisol;

import javafx.util.Pair;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class CountNodesEqualtoAverageofSubtree {

    /**
     * DFS approach first, lets go boys.
     *
     * @time-complexity - O (N).
     * @space-complexity - O (H).
     */
    public int averageOfSubtree(TreeNode root) {
        this.count = 0;
        dfs(root);
        return count;
    }

    private int count;

    // First integer of pair is number of nodes in the tree, second is sum of elements
    private Pair<Integer, Integer> dfs(TreeNode node) {
        if (node == null) return new Pair<>(0, 0);

        Pair<Integer, Integer> leftPair = dfs(node.left);
        Pair<Integer, Integer> rightPair = dfs(node.right);
        int nodes = leftPair.getKey() + rightPair.getKey() + 1;
        int totalSum = leftPair.getValue() + rightPair.getValue() + node.val;
        if (node.val == totalSum / nodes) count++;
        return new Pair<>(nodes, totalSum);
    }

}
