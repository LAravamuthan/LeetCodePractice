package asu.edu.marisol;

import apple.laf.JRSUIUtils;
import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class BinaryTreeVerticalOrderTraversal {

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
     * Trying depth first search.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (h).
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        columnTable = new HashMap<>();
        minCol = Integer.MAX_VALUE;
        maxCol = Integer.MIN_VALUE;

        dfs(root, 0, 0);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = minCol; i <= maxCol; i++) {
            Collections.sort(columnTable.get(i), Comparator.comparingInt(Pair::getKey));

            List<Integer> rowSortedCols = new ArrayList<>();
            for (Pair<Integer, Integer> value : columnTable.get(i)) {
                rowSortedCols.add(value.getValue());
            }

            result.add(rowSortedCols);
        }

        return result;
    }

    private Map<Integer, List<Pair<Integer, Integer>>> columnTable;
    private int minCol;
    private int maxCol;

    private void dfs(TreeNode node, int row, int col) {
        if (node == null) return;

        columnTable.computeIfAbsent(col, k -> new ArrayList<>()).add(new Pair<>(row, node.val));

        minCol = Math.min(minCol, col);
        maxCol = Math.max(maxCol, col);

        dfs(node.left, row + 1, col - 1);
        dfs(node.right, row + 1, col + 1);
    }

    
    /**
     * Trying breadth first search.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (n).
     */
    public List<List<Integer>> verticalOrder2(TreeNode root) {

        if (root == null) return new ArrayList<>();

        Map<Integer, List<Integer>> columnTable = new HashMap<>();
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;

        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();

        queue.offer(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> nodePair = queue.poll();
            TreeNode node = nodePair.getKey();
            int col = nodePair.getValue();

            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);

            columnTable.computeIfAbsent(col, k -> new ArrayList<>()).add(node.val);

            if (node.left != null)
                queue.offer(new Pair<>(node.left, col - 1));
            if (node.right != null)
                queue.offer(new Pair<>(node.right, col + 1));
        }

        for (int i = minCol; i <= maxCol; i++) {
            result.add(columnTable.get(i));
        }

        return result;
    }
}
