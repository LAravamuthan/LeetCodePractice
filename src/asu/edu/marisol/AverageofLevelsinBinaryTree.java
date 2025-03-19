package asu.edu.marisol;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class AverageofLevelsinBinaryTree {

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
     * DFS, way of getting level wise avg.
     *
     * @time-complexity - O(n) - going to each node.
     * @space-complexity - O(h) - height of the tree.
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> sum = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        avg(root, 0, sum, count);
        List<Double> res = new ArrayList<>();
        for (int i = 0; i < count.size(); i++) {
            res.add(sum.get(i) / count.get(i));
        }
        return res;
    }

    public void avg(TreeNode node, int level, List<Double> sum, List<Integer> count) {
        if (node == null) return;
        if (level < sum.size()) {
            sum.set(level, sum.get(level) + node.val);
            count.set(level, count.get(level) + 1);
        } else {
            sum.add(node.val * 1.0);
            count.add(1);
        }
        avg(node.left, level + 1, sum, count);
        avg(node.right, level + 1, sum, count);
    }

    /**
     * BFS, level addition and avg.
     *
     * @time-complexity - O(n) - going to each node.
     * @space-complexity - O(b) - breadth of the tree.
     */
    public List<Double> averageOfLevels2(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            long sum = 0;
            long count = 0;
            Queue<TreeNode> levelQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                sum += node.val;
                count += 1;
                if (node.left != null) levelQueue.add(node.left);
                if (node.right != null) levelQueue.add(node.right);
            }
            res.add(sum * 1.0/count);
            queue = levelQueue;
        }
        return res;
    }
}
