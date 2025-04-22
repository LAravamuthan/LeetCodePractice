package asu.edu.marisol;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class VerticalOrderTraversalofaBinaryTree {

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
     * DFS approach.
     *
     * @time-complexity - O (NLogN)
     * @space-complexity - O (N)
     */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // row, col, value order of elements in single pq element.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                if (a[0] == b[0]) return a[2] - b[2];
                else return a[0] - b[0];
            } else return a[1] - b[1];
        });

        List<List<Integer>> result = new ArrayList<>();

        dfsHelper(root, 0, 0, pq);

        while (!pq.isEmpty()) {
            int curCol = pq.peek()[1];
            List<Integer> row = new ArrayList<>();
            int[] element = pq.poll();
            row.add(element[2]);

            while (!pq.isEmpty() && pq.peek()[1] == curCol) {
                int[] sameRowElement = pq.poll();
                row.add(sameRowElement[2]);
            }

            result.add(row);
        }

        return result;
    }

    private void dfsHelper(TreeNode node, int row, int col, PriorityQueue<int[]> pq) {
        if (node == null) return;

        dfsHelper(node.left, row + 1, col - 1, pq);
        pq.offer(new int[] {row, col, node.val});
        dfsHelper(node.right, row + 1, col + 1, pq);

    }


    /**
     * BFS approach.
     *
     * @time-complexity - O (NLogN)
     * @space-complexity - O (N)
     */
    public List<List<Integer>> verticalTraversal2(TreeNode root) {
        // row, col, value order of elements in single pq element.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                if (a[0] == b[0]) return a[2] - b[2];
                else return a[0] - b[0];
            } else return a[1] - b[1];
        });

        Queue<Pair<TreeNode, Pair<Integer, Integer>>> queue = new ArrayDeque<>();
        queue.offer(new Pair<>(root, new Pair<>(0, 0)));

        while (!queue.isEmpty()) {
            TreeNode node = queue.peek().getKey();
            int row = queue.peek().getValue().getKey();
            int col = queue.peek().getValue().getValue();
            queue.poll();
            pq.offer(new int[] {row, col, node.val});

            if (node.left != null) {
                queue.offer(new Pair<>(node.left, new Pair<>(row + 1, col - 1)));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, new Pair<>(row + 1, col + 1)));
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            int curCol = pq.peek()[1];
            List<Integer> row = new ArrayList<>();
            int[] element = pq.poll();
            row.add(element[2]);

            while (!pq.isEmpty() && pq.peek()[1] == curCol) {
                int[] sameRowElement = pq.poll();
                row.add(sameRowElement[2]);
            }

            result.add(row);
        }

        return result;
    }

}
