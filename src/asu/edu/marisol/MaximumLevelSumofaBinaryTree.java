package asu.edu.marisol;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MaximumLevelSumofaBinaryTree {

    /**
     * Trying depth first search
     *
     * @time-complexity - O (n), n-> no. of nodes in the Tree.
     * @space-complexity - O (h) - height of the tree.
     */
    public int maxLevelSum(TreeNode root) {
        List<Integer> levelSum = new ArrayList<>();
        dfsSum(root, levelSum, 1);

        int maxSum = Integer.MIN_VALUE;
        int level = 0;
        for (int i = 0; i < levelSum.size(); i++) {
            if (levelSum.get(i) > maxSum) {
                maxSum = levelSum.get(i);
                level = i;
            }
        }
        return level + 1;
    }

    private void dfsSum(TreeNode node, List<Integer> levelSum, int level) {
        if (node == null) return;
        if (levelSum.size() == level - 1) levelSum.add(node.val);
        else levelSum.set(level - 1, levelSum.get(level - 1) + node.val);
        dfsSum(node.left, levelSum, level + 1);
        dfsSum(node.right, levelSum, level + 1);
    }

    /**
     * Trying breadth first search
     *
     * @time-complexity - O (n), n-> no. of nodes in the Tree.
     * @space-complexity - O (b ~ n) - breadth of the tree.
     */
    public int maxLevelSum2(TreeNode root) {

        if (root == null) return 1;
        int maxSum = Integer.MIN_VALUE;
        int level = 0;
        int maxLevel = level;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            ++level;
            int levelSum = 0;
            for (int i = q.size(); i > 0; i--) {
                TreeNode node = q.poll();
                levelSum += node.val;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            if (levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = level;
            }
        }

        return maxLevel;
    }

}
